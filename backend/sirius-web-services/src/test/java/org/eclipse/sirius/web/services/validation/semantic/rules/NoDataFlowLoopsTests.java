package org.eclipse.sirius.web.services.validation.semantic.rules;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import eu.balticlsc.model.CAL.CALFactory;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.DataBinding;

public class NoDataFlowLoopsTests {
    @Test
    public void testLoop() {
        var factory = CALFactory.eINSTANCE;
        var application = factory.createComputationApplicationRelease();
        var unitRelease = this.getTestCaseUnitRelease();
        application.getUnits().add(unitRelease);

        var unitCall = factory.createUnitCall();
        unitCall.setName("Example Call"); //$NON-NLS-1$
        unitCall.setUnit(unitRelease);

        var unitCallPins = unitCall.getPins();

        assertThat(unitCallPins).hasSize(2);
        var inputPin = unitCallPins.stream().filter(pin -> pin.getDeclared().getBinding() == DataBinding.REQUIRED).findFirst().get();
        var outputPin = unitCallPins.stream().filter(pin -> pin.getDeclared().getBinding() == DataBinding.PROVIDED).findFirst().get();

        var dataFlow = factory.createDataFlow();
        dataFlow.setSource(outputPin);
        dataFlow.setTarget(inputPin);
        application.getFlows().add(dataFlow);

        var rule = new NoDataFlowLoops();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).hasSize(1);
        var diagnostic = diagnostics.get(0);
        assertThat(diagnostic.getMessage()).contains("Data cannot flow between pins on the same Unit Call 'Example Call'"); //$NON-NLS-1$
    }

    @Test
    public void testNoLoop() {
        var factory = CALFactory.eINSTANCE;
        var application = factory.createComputationApplicationRelease();
        var unitRelease = this.getTestCaseUnitRelease();
        application.getUnits().add(unitRelease);

        var unitCall1 = factory.createUnitCall();
        unitCall1.setName("Example Call"); //$NON-NLS-1$
        unitCall1.setUnit(unitRelease);

        var unitCall1Pins = unitCall1.getPins();
        assertThat(unitCall1Pins).hasSize(2);
        var outputPin = unitCall1Pins.stream().filter(pin -> pin.getDeclared().getBinding() == DataBinding.PROVIDED).findFirst().get();

        var unitCall2 = factory.createUnitCall();
        unitCall2.setName("Example Call 2"); //$NON-NLS-1$
        unitCall2.setUnit(unitRelease);

        var unitCall2Pins = unitCall2.getPins();
        assertThat(unitCall2Pins).hasSize(2);
        var inputPin = unitCall2Pins.stream().filter(pin -> pin.getDeclared().getBinding() == DataBinding.REQUIRED).findFirst().get();

        var dataFlow = factory.createDataFlow();
        dataFlow.setSource(outputPin);
        dataFlow.setTarget(inputPin);
        application.getFlows().add(dataFlow);

        var rule = new NoDataFlowLoops();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).isEmpty();
    }

    private ComputationUnitRelease getTestCaseUnitRelease() {
        var unitRelease = CALFactory.eINSTANCE.createComputationUnitRelease();
        unitRelease.setName("Example Unit"); //$NON-NLS-1$
        unitRelease.setVersion("v0.1"); //$NON-NLS-1$

        var inputPin = CALFactory.eINSTANCE.createDeclaredDataPin();
        inputPin.setName("Input"); //$NON-NLS-1$
        inputPin.setBinding(DataBinding.REQUIRED);

        var outputPin = CALFactory.eINSTANCE.createDeclaredDataPin();
        outputPin.setName("Output"); //$NON-NLS-1$
        outputPin.setBinding(DataBinding.PROVIDED);

        var pins = unitRelease.getDeclaredPins();
        pins.add(inputPin);
        pins.add(outputPin);

        return unitRelease;
    }
}
