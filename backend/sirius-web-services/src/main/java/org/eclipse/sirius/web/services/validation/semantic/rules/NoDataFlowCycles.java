package org.eclipse.sirius.web.services.validation.semantic.rules;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.sirius.web.services.validation.semantic.ISemanticCALValidationRule;
import org.springframework.stereotype.Service;

import eu.balticlsc.model.CAL.ComputationApplicationRelease;

@Service
public class NoDataFlowCycles implements ISemanticCALValidationRule {
    @Override
    public List<Diagnostic> validate(ComputationApplicationRelease applicationRelease) {
        throw new UnsupportedOperationException();
    }
}
