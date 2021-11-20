package org.eclipse.sirius.web.services.validation.semantic.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.web.services.validation.semantic.ISemanticCALValidationRule;
import org.springframework.stereotype.Service;

import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.ComputedDataPin;
import eu.balticlsc.model.CAL.ConnectableDataPin;
import eu.balticlsc.model.CAL.DataBinding;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.UnitCall;

@Service
public class NoDataFlowCycles implements ISemanticCALValidationRule {
    @Override
    public List<Diagnostic> validate(ComputationApplicationRelease applicationRelease) {
        // @formatter:off
        return this.findCycle(applicationRelease)
            .map(cycle -> new BasicDiagnostic(
                Diagnostic.ERROR,
                String.valueOf(cycle.hashCode()),
                1,
                String.format("Data flow must not form a cycle. Detected cycle: %s", this.formatCycle(cycle)), //$NON-NLS-1$
                new Object[0]
            ))
            .stream()
            .collect(Collectors.toList());
        // @formatter:on
    }

    /**
     * <p>
     * Finds any cycle in the graph of connections.
     * </p>
     *
     * <p>
     * It does not ensure that the shortest graphs is found.
     * </p>
     *
     * <p>
     * It does ensure the the found cycle does not contain any extra neighbors that do could be removed from the cycle.
     * </p>
     */
    private Optional<List<UnitCall>> findCycle(ComputationApplicationRelease applicationRelease) {
        // OBSERVATION:
        // ApplicationDataPins can be ignored, because they will not cause cycles.
        // They can only have a single output or a single input. No cycle can go through them.

        // NOTE: main idea for finding the cycle is similar to topological sorting:
        // Depth-first search starting from Unit Calls and following their DataPin flows.
        // Visited UnitCalls whose descendants form a directed acyclic graph are cached
        // for improved performance - the search does not need to recurse into them.

        /** Unit calls that do not start a cycle */
        var visitedUnitCalls = new HashSet<UnitCall>();
        var path = new Stack<UnitCall>();

        // NOTE: the type annotation here is needed for compilation to pass, surprisingly.
        for (UnitCall startingUnitCall : applicationRelease.getCalls()) {
            if (visitedUnitCalls.contains(startingUnitCall)) {
                continue;
            }

            var foundCycle = this.visitUnitCall(visitedUnitCalls, path, startingUnitCall);
            if (foundCycle.isPresent()) {
                return foundCycle;
            }

        }

        return Optional.empty();
    }

    /**
     * <p>
     * Performs a Depth-First Search trying to find a cycle.
     * </p>
     *
     * <p>
     * Assumes that `unitCall` has not been visited yet.
     * </p>
     */
    private Optional<List<UnitCall>> visitUnitCall(HashSet<UnitCall> visitedUnitCalls, Stack<UnitCall> path, UnitCall unitCall) {
        path.add(unitCall);

        var neighboringUnitCalls = this.getNeighbors(unitCall).collect(Collectors.toList());

        for (var neighboringUnitCall : neighboringUnitCalls) {
            // NOTE: the cycle may be only in the final part of the path
            // Need to find which node starts the cycle and report only
            // descendants of that node.
            var indexInPath = path.indexOf(neighboringUnitCall);
            var neighborFormsCycle = indexInPath > -1;
            if (neighborFormsCycle) {
                return Optional.of(path.subList(indexInPath, path.size()));
            } else {
                var foundCycle = this.visitUnitCall(visitedUnitCalls, path, neighboringUnitCall);
                if (foundCycle.isPresent()) {
                    return Optional.of(this.shortenConnectionsInCycle(foundCycle.get()));
                }
            }
        }

        path.remove(unitCall);
        return Optional.empty();
    }

    /**
     * <p>
     * Shortens the cycle if possible by removing sideways connections
     * </p>
     *
     * <p>
     * For example connection graph:
     * </p>
     *
     * <pre>
     *|     ┌──►2────►4
     *|     │   │
     *|  ┌►1│   │
     *|  │  │   ▼
     *|  │  └──►3 ───►5
     *|  │            │
     *|  └────────────┘
     * </pre>
     *
     * <p>
     * turns a cycle 1->2->3->5->1 into 1->3->5->1 (removes the unnecessary 2 in the cycle).
     * </p>
     */
    private List<UnitCall> shortenConnectionsInCycle(List<UnitCall> initialCycle) {
        var cycleWasShortened = true;
        var cycle = initialCycle;

        while (cycleWasShortened && cycle.size() > 2) {
            cycleWasShortened = false;

            for (var i = 2; i < cycle.size(); i++) {
                var currentPairAreNeighbors = this.areNeighbors(cycle.get(i - 2), cycle.get(i));
                if (currentPairAreNeighbors) {
                    // Can reduce path (i-2) -> (i-1) -> (i) to (i-2) -> (i)
                    var shortenedCycle = cycle.subList(0, i - 1);
                    shortenedCycle.addAll(cycle.subList(i, cycle.size()));
                    cycle = shortenedCycle;
                    cycleWasShortened = true;
                    break;
                }
            }

            if (cycleWasShortened) {
                continue;
            }

            // NOTE: try shortening the beginning of the path
            if (this.areNeighbors(cycle.get(cycle.size() - 2), cycle.get(0))) {
                // The last element is not necessary
                cycle = cycle.subList(0, cycle.size() - 1);
                cycleWasShortened = true;
                continue;
            }

            if (this.areNeighbors(cycle.get(cycle.size() - 1), cycle.get(1))) {
                // The first element is not necessary
                cycle = cycle.subList(1, cycle.size());
                cycleWasShortened = true;
                continue;
            }
        }

        return cycle;
    }

    private boolean areNeighbors(UnitCall a, UnitCall b) {
        return this.getNeighbors(a).filter(neighbor -> neighbor == b).findFirst().isPresent();
    }

    private Stream<UnitCall> getNeighbors(UnitCall unitCall) {
        // @formatter:off
        var providedPins = unitCall.getPins()
            .stream()
            .filter(pin -> Optional.ofNullable(pin.getDataPin())
                .map(declaredDataPin -> declaredDataPin.getBinding() == DataBinding.PROVIDED)
                .orElseGet(() -> false)
            );
        var outgoingFlows = providedPins.map(pin -> Optional.ofNullable(pin.getOutgoing()));
        var neighboringUnitCalls = outgoingFlows.map(flow ->
                flow.map(DataFlow::getTarget)
                    .filter(ComputedDataPin.class::isInstance)
                    .map(ConnectableDataPin.class::cast)
                    .map(EObject::eContainer)
                    // SAFETY: ConnectableDataPins can only be contained in UnitCalls
                    .map(UnitCall.class::cast)
            )
            .filter(Optional::isPresent)
            .map(Optional::get);
        // @formatter:on

        return neighboringUnitCalls;
    }

    private String formatCycle(List<UnitCall> cycle) {
        var delimiter = " -> "; //$NON-NLS-1$
        // NOTE: makes sure the cycle is closed by repeating the name of the first Unit Call
        var cycleWithDuplicatedFirstUnitCall = Stream.concat(cycle.stream(), Stream.of(cycle.get(0)));
        var unitCallNames = cycleWithDuplicatedFirstUnitCall.map(UnitCall::getName).collect(Collectors.toList());

        return String.join(delimiter, unitCallNames);
    }
}
