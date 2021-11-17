package org.eclipse.sirius.web.services.validation.semantic.rules;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.sirius.web.services.validation.semantic.ISemanticCALValidationRule;
import org.springframework.stereotype.Service;

import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.DataBinding;

@Service
public class DataFlowDirection implements ISemanticCALValidationRule {

    @Override
    public List<Diagnostic> validate(ComputationApplicationRelease applicationRelease) {
        // @formatter:off
        return applicationRelease.getFlows()
            .stream()
            .flatMap(this::hasValidDirection)
            .collect(Collectors.toList());
        // @formatter:on
    }

    private Stream<Diagnostic> hasValidDirection(DataFlow flow) {
        var sourceDataPin = Optional.ofNullable(flow.getSource()).flatMap(source -> Optional.ofNullable(source.getDataPin()));
        // @formatter:off
        var sourceDiagnostic = sourceDataPin.flatMap(source -> source.getBinding() == DataBinding.PROVIDED
                ? Optional.empty()
                : Optional.of(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        String.valueOf(flow.hashCode()),
                        1,
                        String.format("Data flow cannot start from required pin '%s'", source.getName()), //$NON-NLS-1$
                        new Object[0]
                    )));
        // @formatter:on

        var targetDataPin = Optional.ofNullable(flow.getTarget()).flatMap(target -> Optional.ofNullable(target.getDataPin()));
        // @formatter:off
        var targetDiagnostic = targetDataPin.flatMap(target -> target.getBinding() == DataBinding.REQUIRED
                ? Optional.empty()
                : Optional.of(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        String.valueOf(flow.hashCode()),
                        1,
                        String.format("Data flow cannot end in provided pin '%s'", target.getName()), //$NON-NLS-1$
                        new Object[0]
                    )));
        // @formatter:on

        return Stream.of(sourceDiagnostic, targetDiagnostic).filter(Optional::isPresent).map(Optional::get);
    }
}
