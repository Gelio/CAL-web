package org.eclipse.sirius.web.services.validation.semantic.rules;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import eu.balticlsc.model.CAL.CALFactory;
import eu.balticlsc.model.CAL.DataBinding;

public class DataFlowDirectionTests {
    @Test
    public void testInvalidDirection() {
        var factory = CALFactory.eINSTANCE;
        var application = factory.createComputationApplicationRelease();
        var pins = application.getApplicationDataPins();

        var providedPin = factory.createApplicationDataPin();
        providedPin.setName("Provided (output)"); //$NON-NLS-1$
        providedPin.setBinding(DataBinding.PROVIDED);
        pins.add(providedPin);

        var requiredPin = factory.createApplicationDataPin();
        requiredPin.setName("Required (input)"); //$NON-NLS-1$
        requiredPin.setBinding(DataBinding.REQUIRED);
        pins.add(requiredPin);

        var dataFlow = factory.createDataFlow();
        dataFlow.setSource(requiredPin);
        dataFlow.setTarget(providedPin);
        application.getFlows().add(dataFlow);

        var rule = new DataFlowDirection();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).hasSize(2);
        // @formatter:off
        assertThat(diagnostics).satisfiesExactlyInAnyOrder(
                diagnostic -> assertThat(diagnostic.getMessage())
                    .contains("Data flow cannot start from required pin 'Required (input)'"), //$NON-NLS-1$
                diagnostic -> assertThat(diagnostic.getMessage())
                    .contains("Data flow cannot end in provided pin 'Provided (output)'") //$NON-NLS-1$
        );
        // @formatter:on
    }

    @Test
    public void testValidDirection() {
        var factory = CALFactory.eINSTANCE;
        var application = factory.createComputationApplicationRelease();
        var pins = application.getApplicationDataPins();

        var providedPin = factory.createApplicationDataPin();
        providedPin.setName("Provided (output)"); //$NON-NLS-1$
        providedPin.setBinding(DataBinding.PROVIDED);
        pins.add(providedPin);

        var requiredPin = factory.createApplicationDataPin();
        requiredPin.setName("Required (input)"); //$NON-NLS-1$
        requiredPin.setBinding(DataBinding.REQUIRED);
        pins.add(requiredPin);

        var dataFlow = factory.createDataFlow();
        dataFlow.setSource(providedPin);
        dataFlow.setTarget(requiredPin);
        application.getFlows().add(dataFlow);

        var rule = new DataFlowDirection();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).isEmpty();
    }
}
