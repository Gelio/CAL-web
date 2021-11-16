package org.eclipse.sirius.web.services.validation.semantic;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;

import eu.balticlsc.model.CAL.ComputationApplicationRelease;

public interface ISemanticCALValidationRule {
    List<Diagnostic> validate(ComputationApplicationRelease applicationRelease);
}
