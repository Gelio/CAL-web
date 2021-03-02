/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.CALFactory;
import eu.balticlsc.model.CAL.CALPackage;
import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.ComputationUnitStatus;
import eu.balticlsc.model.CAL.ComputedDataPin;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.DeclaredDataPin;
import eu.balticlsc.model.CAL.UnitCall;
import eu.balticlsc.model.CAL.UnitParamType;
import eu.balticlsc.model.CAL.UnitParameter;
import eu.balticlsc.model.CAL.UnitParameterValue;
import eu.balticlsc.model.CAL.UnitStrength;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CALPackageImpl extends EPackageImpl implements CALPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computedDataPinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationUnitReleaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitParameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declaredDataPinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationApplicationReleaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum computationUnitStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unitStrengthEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unitParamTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eu.balticlsc.model.CAL.CALPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CALPackageImpl() {
		super(eNS_URI, CALFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CALPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CALPackage init() {
		if (isInited)
			return (CALPackage) EPackage.Registry.INSTANCE.getEPackage(CALPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCALPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CALPackageImpl theCALPackage = registeredCALPackage instanceof CALPackageImpl
				? (CALPackageImpl) registeredCALPackage
				: new CALPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theCALPackage.createPackageContents();

		// Initialize created meta-data
		theCALPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCALPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CALPackage.eNS_URI, theCALPackage);
		return theCALPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnitCall() {
		return unitCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitCall_UnitName() {
		return (EAttribute) unitCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitCall_UnitVersion() {
		return (EAttribute) unitCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitCall_Name() {
		return (EAttribute) unitCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitCall_Strength() {
		return (EAttribute) unitCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnitCall_Pins() {
		return (EReference) unitCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnitCall_ParameterValues() {
		return (EReference) unitCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComputedDataPin() {
		return computedDataPinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputedDataPin_Call() {
		return (EReference) computedDataPinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputedDataPin_Incoming() {
		return (EReference) computedDataPinEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputedDataPin_Outgoing() {
		return (EReference) computedDataPinEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputedDataPin_Declared() {
		return (EReference) computedDataPinEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataFlow() {
		return dataFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataFlow_Target() {
		return (EReference) dataFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataFlow_Source() {
		return (EReference) dataFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComputationUnitRelease() {
		return computationUnitReleaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComputationUnitRelease_Name() {
		return (EAttribute) computationUnitReleaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComputationUnitRelease_Version() {
		return (EAttribute) computationUnitReleaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputationUnitRelease_Parameters() {
		return (EReference) computationUnitReleaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputationUnitRelease_DeclaredPins() {
		return (EReference) computationUnitReleaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnitParameter() {
		return unitParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitParameter_Name() {
		return (EAttribute) unitParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitParameter_Type() {
		return (EAttribute) unitParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnitParameterValue() {
		return unitParameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnitParameterValue_Value() {
		return (EAttribute) unitParameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnitParameterValue_Declaration() {
		return (EReference) unitParameterValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeclaredDataPin() {
		return declaredDataPinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComputationApplicationRelease() {
		return computationApplicationReleaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputationApplicationRelease_Calls() {
		return (EReference) computationApplicationReleaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputationApplicationRelease_Flows() {
		return (EReference) computationApplicationReleaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputationApplicationRelease_Units() {
		return (EReference) computationApplicationReleaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getComputationUnitStatus() {
		return computationUnitStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getUnitStrength() {
		return unitStrengthEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getUnitParamType() {
		return unitParamTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CALFactory getCALFactory() {
		return (CALFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		unitCallEClass = createEClass(UNIT_CALL);
		createEAttribute(unitCallEClass, UNIT_CALL__UNIT_NAME);
		createEAttribute(unitCallEClass, UNIT_CALL__UNIT_VERSION);
		createEAttribute(unitCallEClass, UNIT_CALL__NAME);
		createEAttribute(unitCallEClass, UNIT_CALL__STRENGTH);
		createEReference(unitCallEClass, UNIT_CALL__PINS);
		createEReference(unitCallEClass, UNIT_CALL__PARAMETER_VALUES);

		computedDataPinEClass = createEClass(COMPUTED_DATA_PIN);
		createEReference(computedDataPinEClass, COMPUTED_DATA_PIN__CALL);
		createEReference(computedDataPinEClass, COMPUTED_DATA_PIN__INCOMING);
		createEReference(computedDataPinEClass, COMPUTED_DATA_PIN__OUTGOING);
		createEReference(computedDataPinEClass, COMPUTED_DATA_PIN__DECLARED);

		dataFlowEClass = createEClass(DATA_FLOW);
		createEReference(dataFlowEClass, DATA_FLOW__TARGET);
		createEReference(dataFlowEClass, DATA_FLOW__SOURCE);

		computationUnitReleaseEClass = createEClass(COMPUTATION_UNIT_RELEASE);
		createEAttribute(computationUnitReleaseEClass, COMPUTATION_UNIT_RELEASE__NAME);
		createEAttribute(computationUnitReleaseEClass, COMPUTATION_UNIT_RELEASE__VERSION);
		createEReference(computationUnitReleaseEClass, COMPUTATION_UNIT_RELEASE__PARAMETERS);
		createEReference(computationUnitReleaseEClass, COMPUTATION_UNIT_RELEASE__DECLARED_PINS);

		unitParameterEClass = createEClass(UNIT_PARAMETER);
		createEAttribute(unitParameterEClass, UNIT_PARAMETER__NAME);
		createEAttribute(unitParameterEClass, UNIT_PARAMETER__TYPE);

		unitParameterValueEClass = createEClass(UNIT_PARAMETER_VALUE);
		createEAttribute(unitParameterValueEClass, UNIT_PARAMETER_VALUE__VALUE);
		createEReference(unitParameterValueEClass, UNIT_PARAMETER_VALUE__DECLARATION);

		declaredDataPinEClass = createEClass(DECLARED_DATA_PIN);

		computationApplicationReleaseEClass = createEClass(COMPUTATION_APPLICATION_RELEASE);
		createEReference(computationApplicationReleaseEClass, COMPUTATION_APPLICATION_RELEASE__CALLS);
		createEReference(computationApplicationReleaseEClass, COMPUTATION_APPLICATION_RELEASE__FLOWS);
		createEReference(computationApplicationReleaseEClass, COMPUTATION_APPLICATION_RELEASE__UNITS);

		// Create enums
		computationUnitStatusEEnum = createEEnum(COMPUTATION_UNIT_STATUS);
		unitStrengthEEnum = createEEnum(UNIT_STRENGTH);
		unitParamTypeEEnum = createEEnum(UNIT_PARAM_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(unitCallEClass, UnitCall.class, "UnitCall", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitCall_UnitName(), ecorePackage.getEString(), "unitName", null, 0, 1, UnitCall.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitCall_UnitVersion(), ecorePackage.getEString(), "unitVersion", null, 0, 1, UnitCall.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitCall_Name(), ecorePackage.getEString(), "name", "", 0, 1, UnitCall.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitCall_Strength(), this.getUnitStrength(), "strength", "", 0, 1, UnitCall.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCall_Pins(), this.getComputedDataPin(), this.getComputedDataPin_Call(), "pins", null, 0,
				-1, UnitCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCall_ParameterValues(), this.getUnitParameterValue(), null, "parameterValues", null, 0,
				-1, UnitCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computedDataPinEClass, ComputedDataPin.class, "ComputedDataPin", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputedDataPin_Call(), this.getUnitCall(), this.getUnitCall_Pins(), "call", null, 1, 1,
				ComputedDataPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputedDataPin_Incoming(), this.getDataFlow(), this.getDataFlow_Target(), "incoming", null,
				0, 1, ComputedDataPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputedDataPin_Outgoing(), this.getDataFlow(), this.getDataFlow_Source(), "outgoing", null,
				0, 1, ComputedDataPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputedDataPin_Declared(), this.getDeclaredDataPin(), null, "declared", null, 1, 1,
				ComputedDataPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataFlowEClass, DataFlow.class, "DataFlow", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlow_Target(), this.getComputedDataPin(), this.getComputedDataPin_Incoming(), "target",
				null, 1, 1, DataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFlow_Source(), this.getComputedDataPin(), this.getComputedDataPin_Outgoing(), "source",
				null, 0, 1, DataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computationUnitReleaseEClass, ComputationUnitRelease.class, "ComputationUnitRelease", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComputationUnitRelease_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				ComputationUnitRelease.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputationUnitRelease_Version(), ecorePackage.getEString(), "version", null, 0, 1,
				ComputationUnitRelease.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationUnitRelease_Parameters(), this.getUnitParameter(), null, "parameters", null, 0, -1,
				ComputationUnitRelease.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationUnitRelease_DeclaredPins(), this.getDeclaredDataPin(), null, "declaredPins", null,
				0, -1, ComputationUnitRelease.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitParameterEClass, UnitParameter.class, "UnitParameter", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, UnitParameter.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitParameter_Type(), this.getUnitParamType(), "type", "", 0, 1, UnitParameter.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitParameterValueEClass, UnitParameterValue.class, "UnitParameterValue", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitParameterValue_Value(), ecorePackage.getEString(), "value", null, 0, 1,
				UnitParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getUnitParameterValue_Declaration(), this.getUnitParameter(), null, "declaration", null, 1, 1,
				UnitParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declaredDataPinEClass, DeclaredDataPin.class, "DeclaredDataPin", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(computationApplicationReleaseEClass, ComputationApplicationRelease.class,
				"ComputationApplicationRelease", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputationApplicationRelease_Calls(), this.getUnitCall(), null, "calls", null, 0, -1,
				ComputationApplicationRelease.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationApplicationRelease_Flows(), this.getDataFlow(), null, "flows", null, 0, -1,
				ComputationApplicationRelease.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationApplicationRelease_Units(), this.getComputationUnitRelease(), null, "units", null,
				0, -1, ComputationApplicationRelease.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(computationUnitStatusEEnum, ComputationUnitStatus.class, "ComputationUnitStatus");
		addEEnumLiteral(computationUnitStatusEEnum, ComputationUnitStatus.CREATED);
		addEEnumLiteral(computationUnitStatusEEnum, ComputationUnitStatus.SUBMITTED);
		addEEnumLiteral(computationUnitStatusEEnum, ComputationUnitStatus.APPROVED);
		addEEnumLiteral(computationUnitStatusEEnum, ComputationUnitStatus.DISCONTINUED);

		initEEnum(unitStrengthEEnum, UnitStrength.class, "UnitStrength");
		addEEnumLiteral(unitStrengthEEnum, UnitStrength.WEAK);
		addEEnumLiteral(unitStrengthEEnum, UnitStrength.STRONG);

		initEEnum(unitParamTypeEEnum, UnitParamType.class, "UnitParamType");
		addEEnumLiteral(unitParamTypeEEnum, UnitParamType.VARIABLE);
		addEEnumLiteral(unitParamTypeEEnum, UnitParamType.CONFIG);
		addEEnumLiteral(unitParamTypeEEnum, UnitParamType.PORT);

		// Create resource
		createResource(eNS_URI);
	}

} //CALPackageImpl
