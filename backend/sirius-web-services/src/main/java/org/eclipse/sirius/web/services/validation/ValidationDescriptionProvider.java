/*******************************************************************************
 * Copyright (c) 2021 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.web.services.validation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.sirius.web.core.api.IEditingContext;
import org.eclipse.sirius.web.emf.services.EditingContext;
import org.eclipse.sirius.web.representations.VariableManager;
import org.eclipse.sirius.web.services.validation.semantic.ISemanticCALValidationRule;
import org.eclipse.sirius.web.spring.collaborative.validation.api.IValidationDescriptionProvider;
import org.eclipse.sirius.web.spring.collaborative.validation.api.IValidationService;
import org.eclipse.sirius.web.validation.description.ValidationDescription;
import org.springframework.stereotype.Service;

import eu.balticlsc.model.CAL.ComputationApplicationRelease;

/**
 * This class is used to provide the description of the validation representation.
 *
 * @author gcoutable
 */
@Service
public class ValidationDescriptionProvider implements IValidationDescriptionProvider {

    private final IValidationService validationService;

    private final List<ISemanticCALValidationRule> validationRules;

    public ValidationDescriptionProvider(IValidationService validationService, List<ISemanticCALValidationRule> validationRules) {
        this.validationService = validationService;
        this.validationRules = validationRules;
    }

    @Override
    public ValidationDescription getDescription() {
        // This predicate will NOT be used while creating the explorer but we don't want to see the description of the
        // explorer in the list of representations that can be created. Thus, we will return false all the time.
        Predicate<VariableManager> canCreatePredicate = variableManager -> false;

        // @formatter:off
        return ValidationDescription.newValidationDescription(UUID.nameUUIDFromBytes("validation_description".getBytes())) //$NON-NLS-1$
                .label("Validation") //$NON-NLS-1$
                .canCreatePredicate(canCreatePredicate)
                .diagnosticsProvider(this::getDiagnosticsProvider)
                .kindProvider(this::kindProvider)
                .messageProvider(this::messageProvider)
                .build();
        // @formatter:on
    }

    private List<Object> getDiagnosticsProvider(VariableManager variableManager) {
        var optionalEditingContext = variableManager.get(IEditingContext.EDITING_CONTEXT, IEditingContext.class);

        var emfDiagnostics = optionalEditingContext.map(this.validationService::validate).orElseGet(List::of);

        // @formatter:off
        var calDiagnostics = optionalEditingContext
                .flatMap(this::extractComputationApplicationRelease)
                .map(applicationRelease ->
                    this.validationRules.stream()
                        .flatMap(rule -> rule.validate(applicationRelease).stream())
                        .collect(Collectors.toList())
                )
                .orElseGet(List::of);
        // @formatter:on

        return Stream.concat(emfDiagnostics.stream(), calDiagnostics.stream()).collect(Collectors.toList());
    }

    private Optional<ComputationApplicationRelease> extractComputationApplicationRelease(IEditingContext editingContext) {
        // NOTE: need to cast to get the domain from IEditingContext
        // Similar to
        // https://github.com/eclipse-sirius/sirius-components/blob/ab8097c6c3593f10fdd16f9212762624a3639ccc/backend/sirius-web-emf/src/main/java/org/eclipse/sirius/web/emf/services/EMFValidationService.java#L56-L59

        // @formatter:off
        return Optional.of(editingContext)
            .filter(EditingContext.class::isInstance)
            .map(EditingContext.class::cast)
            .map(EditingContext::getDomain)
            .flatMap(this::extractComputationApplicationRelease);
        // @formatter:on
    }

    private Optional<ComputationApplicationRelease> extractComputationApplicationRelease(AdapterFactoryEditingDomain domain) {
        var resources = domain.getResourceSet().getResources().stream();
        var contents = resources.flatMap(resource -> resource.getContents().stream());

        // @formatter:off
        return contents
            .filter(ComputationApplicationRelease.class::isInstance)
            .map(ComputationApplicationRelease.class::cast)
            .findFirst();
        // @formatter:on
    }

    private String kindProvider(Object object) {
        String kind = "Unknown"; //$NON-NLS-1$
        if (object instanceof Diagnostic) {
            Diagnostic diagnostic = (Diagnostic) object;
            switch (diagnostic.getSeverity()) {
            case org.eclipse.emf.common.util.Diagnostic.ERROR:
                kind = "Error"; //$NON-NLS-1$
                break;
            case org.eclipse.emf.common.util.Diagnostic.WARNING:
                kind = "Warning"; //$NON-NLS-1$
                break;
            case org.eclipse.emf.common.util.Diagnostic.INFO:
                kind = "Info"; //$NON-NLS-1$
                break;
            default:
                kind = "Unknown"; //$NON-NLS-1$
                break;
            }
        }
        return kind;
    }

    private String messageProvider(Object object) {
        if (object instanceof Diagnostic) {
            Diagnostic diagnostic = (Diagnostic) object;
            return diagnostic.getMessage();
        }
        return ""; //$NON-NLS-1$
    }

}
