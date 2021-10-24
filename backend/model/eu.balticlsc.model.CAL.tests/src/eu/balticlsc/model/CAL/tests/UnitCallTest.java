/**
 */
package eu.balticlsc.model.CAL.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import java.util.stream.IntStream;

import org.eclipse.emf.common.util.EList;
import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.junit.Test;

import eu.balticlsc.model.CAL.CALFactory;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.ComputedDataPin;
import eu.balticlsc.model.CAL.DataBinding;
import eu.balticlsc.model.CAL.DeclaredDataPin;
import eu.balticlsc.model.CAL.UnitCall;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Unit Call</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnitCallTest extends TestCase {

	/**
	 * The fixture for this Unit Call test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitCall fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UnitCallTest.class);
	}

	/**
	 * Constructs a new Unit Call test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitCallTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Unit Call test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(UnitCall fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Unit Call test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitCall getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CALFactory.eINSTANCE.createUnitCall());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	private ComputationUnitRelease getComputationUnitRelease(String baseName, int declaredDataPinsCount) {
		var unitRelease = CALFactory.eINSTANCE.createComputationUnitRelease();

		unitRelease.setName(baseName);
		unitRelease.setVersion("0.1.0");
		var pins = unitRelease.getDeclaredPins();

		for (int i=0; i < declaredDataPinsCount; i++) {
			var pin = CALFactory.eINSTANCE.createDeclaredDataPin();
			pin.setName(baseName + " " + " pin " + declaredDataPinsCount);
			pins.add(pin);
		}

		return unitRelease;
	}

	private void assertThatPinsMatchUnitRelease(UnitCall unitCall, ComputationUnitRelease unitRelease) {
		var computedPins = unitCall.getPins();

		var declaredPins = unitRelease.getDeclaredPins();
		assertThat(computedPins, hasSize(declaredPins.size()));
		for (var declaredPin : declaredPins) {
			assertThat(computedPins, hasItem(
					hasProperty("declared", equalTo(declaredPin))
			));
		}
	}

	public void testComputedDataPinAreCreatedAndRemovedAutomatically() {
		var firstUnitRelease = getComputationUnitRelease("first", 2);
		fixture.setUnit(firstUnitRelease);

		assertThatPinsMatchUnitRelease(fixture, firstUnitRelease);
		assertThat(fixture.getPins(), everyItem(allOf(
				hasProperty("incoming", equalTo(null)),
				hasProperty("outgoing", equalTo(null))
		)));

		var pinBeforeSet = fixture.getPins().get(0);

		var secondUnitRelease = getComputationUnitRelease("second", 5);
		fixture.setUnit(secondUnitRelease);

		assertThatPinsMatchUnitRelease(fixture, secondUnitRelease);
		assertThat(fixture.getPins().get(0), not(equalTo(pinBeforeSet)));
	}

	public void testDataFlowsAreRemovedWhenUnsettingUnitRelease() {
		// Arrange
		// Construct a simple model: input pin -> unit call -> output pin
		var computationApplication = CALFactory.eINSTANCE.createComputationApplicationRelease();

		// Unit release
		var declaredInputPin = CALFactory.eINSTANCE.createDeclaredDataPin();
		declaredInputPin.setName("Input");
		declaredInputPin.setBinding(DataBinding.REQUIRED);
		var declaredOutputPin = CALFactory.eINSTANCE.createDeclaredDataPin();
		declaredOutputPin.setName("Output");
		declaredOutputPin.setBinding(DataBinding.PROVIDED);
		var unitRelease = CALFactory.eINSTANCE.createComputationUnitRelease();
		unitRelease.setName("Unit Release");
		unitRelease.setVersion("0.1.0");
		computationApplication.getUnits().add(unitRelease);
		var declaredPins = unitRelease.getDeclaredPins();
		declaredPins.add(declaredInputPin);
		declaredPins.add(declaredOutputPin);

		// Unit call
		var unitCall = CALFactory.eINSTANCE.createUnitCall();
		unitCall.setUnit(unitRelease);
		computationApplication.getCalls().add(unitCall);

		// Application pins
		var applicationInputPin = CALFactory.eINSTANCE.createApplicationDataPin();
		applicationInputPin.setName("App input");
		applicationInputPin.setBinding(DataBinding.PROVIDED);
		computationApplication.getApplicationDataPins().add(applicationInputPin);

		var applicationOutputPin = CALFactory.eINSTANCE.createApplicationDataPin();
		applicationOutputPin.setName("App output");
		applicationOutputPin.setBinding(DataBinding.REQUIRED);
		computationApplication.getApplicationDataPins().add(applicationOutputPin);

		// Flow from application input to unit call input
		var computedInputPin = unitCall.getPins().stream()
				.filter(pin -> pin.getDeclared() == declaredInputPin)
				.findFirst()
				.orElseThrow();

		var flowToUnitCall = CALFactory.eINSTANCE.createDataFlow();
		flowToUnitCall.setSource(applicationInputPin);
		flowToUnitCall.setTarget(computedInputPin);
		computationApplication.getFlows().add(flowToUnitCall);

		// Flow from unit call output to application output
		var computedOutputPin = unitCall.getPins().stream()
				.filter(pin -> pin.getDeclared() == declaredOutputPin)
				.findFirst()
				.orElseThrow();

		var flowToApplicationOutput = CALFactory.eINSTANCE.createDataFlow();
		flowToApplicationOutput.setSource(computedOutputPin);
		flowToApplicationOutput.setTarget(applicationOutputPin);
		computationApplication.getFlows().add(flowToApplicationOutput);

		// Act
		unitCall.setUnit(null);

		// Assert
		assertThat(fixture.getPins(), hasSize(equalTo(0)));
		assertThat(computationApplication.getFlows(), hasSize(equalTo(0)));
	}

} //UnitCallTest
