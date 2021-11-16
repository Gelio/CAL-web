package org.eclipse.sirius.web.services.validation.semantic.rules;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.sirius.web.services.validation.semantic.ISemanticCALValidationRule;
import org.springframework.stereotype.Service;

import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.UnitCall;
import eu.balticlsc.model.CAL.ComputedDataPin;

@Service
public class NoDataFlowLoops implements ISemanticCALValidationRule {

    @Override
    public List<Diagnostic> validate(ComputationApplicationRelease applicationRelease) {
        // @formatter:off
        return applicationRelease.getFlows()
            .stream()
            .map(this::isOnSameUnitCall)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
        // @formatter:on
    }

    private Optional<Diagnostic> isOnSameUnitCall(DataFlow flow) {
        var source = flow.getSource();
        var target = flow.getTarget();
        if (source == null || target == null) {
            return Optional.empty();
        }

        if (!ComputedDataPin.class.isInstance(source) || !ComputedDataPin.class.isInstance(target)) {
            return Optional.empty();
        }

        if (source.eContainer() == target.eContainer()) {
            var unitCall = (UnitCall) source.eContainer();
            var message = String.format("Data cannot flow between pins on the same Unit Call '%s'", unitCall.getName()); //$NON-NLS-1$
            var diagnostic = new BasicDiagnostic(Diagnostic.ERROR, String.valueOf(flow.hashCode()), 1, message, new Object[0]);
            return Optional.of(diagnostic);
        }

        return Optional.empty();
    }

}
