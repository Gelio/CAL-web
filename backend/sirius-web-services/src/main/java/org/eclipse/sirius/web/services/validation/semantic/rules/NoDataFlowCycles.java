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
            .map(Optional::get)
            .collect(Collectors.toList());
        // @formatter:on

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
                    return foundCycle;
                }
            }
        }

        path.remove(unitCall);
        return Optional.empty();
    }

    private String formatCycle(List<UnitCall> cycle) {
        var delimiter = " -> "; //$NON-NLS-1$
        // NOTE: makes sure the cycle is closed by repeating the name of the first Unit Call
        var cycleWithDuplicatedFirstUnitCall = Stream.concat(cycle.stream(), Stream.of(cycle.get(0)));
        var unitCallNames = cycleWithDuplicatedFirstUnitCall.map(UnitCall::getName).collect(Collectors.toList());

        return String.join(delimiter, unitCallNames);
    }
}
