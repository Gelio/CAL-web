package org.eclipse.sirius.web.services.validation.semantic.rules;

import org.eclipse.emf.common.util.Diagnostic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import eu.balticlsc.model.CAL.CALFactory;
import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.ConnectableDataPin;
import eu.balticlsc.model.CAL.DataBinding;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.UnitCall;

public class NoDataFlowCyclesTests {
    private DataFlowFactory dataFlowFactory;

    private UnitCallFactory unitCallFactory;

    private SinglePinUnitReleaseFactory singlePinUnitReleaseFactory;

    private DoublePinUnitReleaseFactory doublePinUnitReleaseFactory;

    @BeforeEach
    public void init() {
        this.dataFlowFactory = new DataFlowFactory();
        this.unitCallFactory = new UnitCallFactory();
        this.singlePinUnitReleaseFactory = new SinglePinUnitReleaseFactory();
        this.doublePinUnitReleaseFactory = new DoublePinUnitReleaseFactory();
    }

    /**
     * <p>
     * The whole connection graph forms a cycle.
     * </p>
     * call 1 -> call 2 -> call 3 -> call 1
     */
    @Test
    public void testLoopOf3Calls() {
        var application = CALFactory.eINSTANCE.createComputationApplicationRelease();
        var unitRelease = this.singlePinUnitReleaseFactory.createUnitRelease(application);

        var call1 = this.unitCallFactory.createUnitCall(application, unitRelease, "Call 1"); //$NON-NLS-1$
        var call2 = this.unitCallFactory.createUnitCall(application, unitRelease, "Call 2"); //$NON-NLS-1$
        var call3 = this.unitCallFactory.createUnitCall(application, unitRelease, "Call 3"); //$NON-NLS-1$

        // @formatter:off
        // 1────►2────►3
        // ▲           │
        // └───────────┘
        // @formatter:on
        var flows = application.getFlows();
        flows.add(this.dataFlowFactory.connectUnitCalls(call1, call2));
        flows.add(this.dataFlowFactory.connectUnitCalls(call2, call3));
        flows.add(this.dataFlowFactory.connectUnitCalls(call3, call1));

        var rule = new NoDataFlowCycles();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).hasSize(1);
        assertThat(diagnostics.get(0).getSeverity()).isEqualTo(Diagnostic.WARNING);
        var expectedMessage = "Data flow forms a cycle. This could be (but does not have to be) a mistake. Detected cycle: Call 1 -> Call 2 -> Call 3 -> Call 1"; //$NON-NLS-1$
        assertThat(diagnostics.get(0).getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    public void testShortenedCycleAsPartOfGraph() {
        var application = CALFactory.eINSTANCE.createComputationApplicationRelease();
        var doublePinsUnitRelease = this.doublePinUnitReleaseFactory.createUnitRelease(application);

        var call1 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 1"); //$NON-NLS-1$
        var call2 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 2"); //$NON-NLS-1$
        var call3 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 3"); //$NON-NLS-1$
        var call4 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 4"); //$NON-NLS-1$
        var call5 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 5"); //$NON-NLS-1$

        // @formatter:off
        //    ┌──►2────►4
        //    │   │
        // ┌►1│   │
        // │  │   ▼
        // │  └──►3 ───►5
        // │            │
        // └────────────┘
        // @formatter:on
        var flows = application.getFlows();
        flows.add(this.dataFlowFactory.connectUnitCalls(call1, call2));
        flows.add(this.dataFlowFactory.connectUnitCalls(call1, call3));
        flows.add(this.dataFlowFactory.connectUnitCalls(call2, call3));
        flows.add(this.dataFlowFactory.connectUnitCalls(call2, call4));
        flows.add(this.dataFlowFactory.connectUnitCalls(call3, call5));
        flows.add(this.dataFlowFactory.connectUnitCalls(call5, call1));

        var rule = new NoDataFlowCycles();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).hasSize(1);
        // NOTE: this also makes sure that the reported cycle is shortened
        // This will not ensure the the shortest cycle is found. This only checks the if a cycle
        // is reported, it must be in its naively shortened representation (no extra immediate neighbors).
        var expectedMessage = "Data flow forms a cycle. This could be (but does not have to be) a mistake. Detected cycle: Call 1 -> Call 3 -> Call 5 -> Call 1"; //$NON-NLS-1$
        assertThat(diagnostics.get(0).getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    public void testLoopIncludingAppliationDataPins() {
        var application = CALFactory.eINSTANCE.createComputationApplicationRelease();
        var doublePinsUnitRelease = this.doublePinUnitReleaseFactory.createUnitRelease(application);

        // 1 and 2 are provided application data pins
        // 6 is a required application data pin
        // @formatter:off
        // 1──────┬─────4
        //        │     ▲
        //        ▼     │
        //        2────►3────►5
        // @formatter:on

        var applicationDataPin1 = CALFactory.eINSTANCE.createApplicationDataPin();
        application.getApplicationDataPins().add(applicationDataPin1);
        applicationDataPin1.setBinding(DataBinding.PROVIDED);
        applicationDataPin1.setName("Appliation data pin 1"); //$NON-NLS-1$

        var call2 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 2"); //$NON-NLS-1$
        var call3 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 3"); //$NON-NLS-1$
        var call4 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 4"); //$NON-NLS-1$

        var applicationDataPin5 = CALFactory.eINSTANCE.createApplicationDataPin();
        application.getApplicationDataPins().add(applicationDataPin5);
        applicationDataPin5.setBinding(DataBinding.REQUIRED);
        applicationDataPin5.setName("Appliation data pin 5"); //$NON-NLS-1$

        var flows = application.getFlows();
        flows.add(this.dataFlowFactory.connect(applicationDataPin1, this.dataFlowFactory.findDisconnectedRequiredPin(call2).get()));
        flows.add(this.dataFlowFactory.connectUnitCalls(call2, call3));
        flows.add(this.dataFlowFactory.connectUnitCalls(call3, call4));
        flows.add(this.dataFlowFactory.connectUnitCalls(call4, call2));
        flows.add(this.dataFlowFactory.connect(this.dataFlowFactory.findDisconnectedProvidedPin(call3).get(), applicationDataPin5));

        var rule = new NoDataFlowCycles();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).hasSize(1);
        var expectedMessage = "Data flow forms a cycle. This could be (but does not have to be) a mistake. Detected cycle: Call 2 -> Call 3 -> Call 4 -> Call 2"; //$NON-NLS-1$
        assertThat(diagnostics.get(0).getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    public void testAdvancedCycleShortening() {
        var application = CALFactory.eINSTANCE.createComputationApplicationRelease();
        var doublePinsUnitRelease = this.doublePinUnitReleaseFactory.createUnitRelease(application);

        // NOTE: Graph is based on the example graph in https://github.com/Gelio/CAL-web/issues/68

        // @formatter:off
        var calls = IntStream.rangeClosed(1, 7)
            .mapToObj(n -> this.unitCallFactory.createUnitCall(
                application,
                doublePinsUnitRelease,
                String.format("Call %d", n) //$NON-NLS-1$
            )).
            collect(Collectors.toList());
        // @formatter:on

        var flows = application.getFlows();
        /** Makes it easy to create connection graphs based on node numbers */
        class LocalFlowConnectionFactory {
            private DataFlowFactory dataFlowFactory;

            public LocalFlowConnectionFactory(DataFlowFactory dataFlowFactory) {
                this.dataFlowFactory = dataFlowFactory;
            }

            /**
             * <p>
             * Creates a connection between nodes i and j.
             * </p>
             * The parameters are node numbers (1, 2, ...), not indices (0, 1, ...)
             */
            public void connectCalls(int i, int j) {
                flows.add(this.dataFlowFactory.connectUnitCalls(calls.get(i - 1), calls.get(j - 1)));
            }
        }
        // NOTE: create connections for the longer cycle first, so the algorithm discovers it first
        var flowConnectionHelper = new LocalFlowConnectionFactory(this.dataFlowFactory);
        for (var i = 1; i < 7; i++) {
            flowConnectionHelper.connectCalls(i, i + 1);
        }
        flowConnectionHelper.connectCalls(7, 1);
        flowConnectionHelper.connectCalls(1, 5);
        flowConnectionHelper.connectCalls(2, 4);

        var rule = new NoDataFlowCycles();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).hasSize(1);
        // TODO: expect only the shortest cycle after https://github.com/Gelio/CAL-web/issues/68 is implemented
        var expectedCycle = "Call 1 -> Call 2 -> Call 4 -> Call 5 -> Call 6 -> Call 7 -> Call 1"; //$NON-NLS-1$
        assertThat(diagnostics.get(0).getMessage()).contains(expectedCycle);

        var expectedShortestCycle = "Call 1 -> Call 5 -> Call 6 -> Call 7 -> Call 1"; //$NON-NLS-1$
        assertThat(diagnostics.get(0).getMessage()).doesNotContain(expectedShortestCycle);
    }

    @Test
    public void testNoDiagnosticsInValidGraph() {
        var application = CALFactory.eINSTANCE.createComputationApplicationRelease();
        var doublePinsUnitRelease = this.doublePinUnitReleaseFactory.createUnitRelease(application);

        var call1 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 1"); //$NON-NLS-1$
        var call2 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 2"); //$NON-NLS-1$
        var call3 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 3"); //$NON-NLS-1$
        var call4 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 4"); //$NON-NLS-1$
        var call5 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 5"); //$NON-NLS-1$
        var call6 = this.unitCallFactory.createUnitCall(application, doublePinsUnitRelease, "Call 6"); //$NON-NLS-1$

        // @formatter:off
        //  ┌──────►2───────►4──────┐
        //  │       │        ▲      ▼
        //  1       │        │      6
        //  │       ▼        │      ▲
        //  └──────►3───────►5──────┘
        // @formatter:on
        var flows = application.getFlows();
        flows.add(this.dataFlowFactory.connectUnitCalls(call1, call2));
        flows.add(this.dataFlowFactory.connectUnitCalls(call1, call3));
        flows.add(this.dataFlowFactory.connectUnitCalls(call2, call3));
        flows.add(this.dataFlowFactory.connectUnitCalls(call2, call4));
        flows.add(this.dataFlowFactory.connectUnitCalls(call3, call5));
        flows.add(this.dataFlowFactory.connectUnitCalls(call5, call4));
        flows.add(this.dataFlowFactory.connectUnitCalls(call4, call6));
        flows.add(this.dataFlowFactory.connectUnitCalls(call5, call6));

        var rule = new NoDataFlowCycles();
        var diagnostics = rule.validate(application);

        assertThat(diagnostics).isEmpty();
    }

    private class DataFlowFactory {
        /**
         * Attempts to connect 2 unit calls. Chooses data pins automatically by finding unused ones.
         */
        public DataFlow connectUnitCalls(UnitCall source, UnitCall target) {
            var providedPin = this.findDisconnectedProvidedPin(source);
            assertThat(providedPin.isPresent()).isTrue();

            var requiredPin = this.findDisconnectedRequiredPin(target);
            assertThat(requiredPin.isPresent()).isTrue();

            return this.connect(providedPin.get(), requiredPin.get());
        }

        public DataFlow connect(ConnectableDataPin source, ConnectableDataPin target) {
            var dataFlow = CALFactory.eINSTANCE.createDataFlow();
            dataFlow.setSource(source);
            dataFlow.setTarget(target);

            return dataFlow;
        }

        public Optional<ConnectableDataPin> findDisconnectedProvidedPin(UnitCall call) {
            // @formatter:off
            return call.getPins()
                .stream()
                .filter(pin -> pin.getDataPin().getBinding() == DataBinding.PROVIDED && pin.getOutgoing() == null)
                .map(ConnectableDataPin.class::cast)
                .findFirst();
            // @formatter:on
        }

        public Optional<ConnectableDataPin> findDisconnectedRequiredPin(UnitCall call) {
            // @formatter:off
            return call.getPins()
                .stream()
                .filter(pin -> pin.getDataPin().getBinding() == DataBinding.REQUIRED && pin.getIncoming() == null)
                .map(ConnectableDataPin.class::cast)
                .findFirst();
            // @formatter:on
        }
    }

    private class UnitCallFactory {
        public UnitCall createUnitCall(ComputationApplicationRelease application, ComputationUnitRelease unitRelease, String name) {
            var call = CALFactory.eINSTANCE.createUnitCall();
            call.setUnit(unitRelease);

            var calls = application.getCalls();
            call.setName(name);
            calls.add(call);

            return call;
        }
    }

    private class SinglePinUnitReleaseFactory {
        /**
         * <p>
         * Returns a unit release with a single input and a single output data pin.
         * </p>
         */
        public ComputationUnitRelease createUnitRelease(ComputationApplicationRelease application) {
            var unitRelease = CALFactory.eINSTANCE.createComputationUnitRelease();
            unitRelease.setName("Single input/output pin"); //$NON-NLS-1$
            unitRelease.setVersion("0.1"); //$NON-NLS-1$
            var pins = unitRelease.getDeclaredPins();

            var inputPin = CALFactory.eINSTANCE.createDeclaredDataPin();
            inputPin.setName("Input"); //$NON-NLS-1$
            inputPin.setBinding(DataBinding.REQUIRED);
            pins.add(inputPin);

            var outputPin = CALFactory.eINSTANCE.createDeclaredDataPin();
            outputPin.setName("Output"); //$NON-NLS-1$
            outputPin.setBinding(DataBinding.PROVIDED);
            pins.add(outputPin);

            application.getUnits().add(unitRelease);

            return unitRelease;
        }
    }

    private class DoublePinUnitReleaseFactory {
        /**
         * <p>
         * Returns a unit release with two input and two output data pins.
         * </p>
         */
        public ComputationUnitRelease createUnitRelease(ComputationApplicationRelease application) {
            var unitRelease = CALFactory.eINSTANCE.createComputationUnitRelease();
            unitRelease.setName("Double input/output pin"); //$NON-NLS-1$
            unitRelease.setVersion("0.1"); //$NON-NLS-1$
            var pins = unitRelease.getDeclaredPins();

            var inputPin1 = CALFactory.eINSTANCE.createDeclaredDataPin();
            inputPin1.setName("Input 1"); //$NON-NLS-1$
            inputPin1.setBinding(DataBinding.REQUIRED);
            pins.add(inputPin1);

            var inputPin2 = CALFactory.eINSTANCE.createDeclaredDataPin();
            inputPin2.setName("Input 2"); //$NON-NLS-1$
            inputPin2.setBinding(DataBinding.REQUIRED);
            pins.add(inputPin2);

            var outputPin1 = CALFactory.eINSTANCE.createDeclaredDataPin();
            outputPin1.setName("Output 1"); //$NON-NLS-1$
            outputPin1.setBinding(DataBinding.PROVIDED);
            pins.add(outputPin1);

            var outputPin2 = CALFactory.eINSTANCE.createDeclaredDataPin();
            outputPin2.setName("Output 2"); //$NON-NLS-1$
            outputPin2.setBinding(DataBinding.PROVIDED);
            pins.add(outputPin2);

            application.getUnits().add(unitRelease);

            return unitRelease;
        }
    }
}
