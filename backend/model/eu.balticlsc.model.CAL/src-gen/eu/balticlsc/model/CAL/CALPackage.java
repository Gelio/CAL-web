/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.balticlsc.model.CAL.CALFactory
 * @model kind="package"
 * @generated
 */
public interface CALPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CAL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.balticlsc.eu/model/CAL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CAL";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CALPackage eINSTANCE = eu.balticlsc.model.CAL.impl.CALPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.UnitCallImpl <em>Unit Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.UnitCallImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitCall()
	 * @generated
	 */
	int UNIT_CALL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CALL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Strength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CALL__STRENGTH = 1;

	/**
	 * The feature id for the '<em><b>Pins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CALL__PINS = 2;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CALL__PARAMETER_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CALL__RELEASE = 4;

	/**
	 * The number of structural features of the '<em>Unit Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CALL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Unit Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CALL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.ConnectableDataPin <em>Connectable Data Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.ConnectableDataPin
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getConnectableDataPin()
	 * @generated
	 */
	int CONNECTABLE_DATA_PIN = 9;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_DATA_PIN__OUTGOING = 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_DATA_PIN__INCOMING = 1;

	/**
	 * The number of structural features of the '<em>Connectable Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_DATA_PIN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Connectable Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_DATA_PIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.ComputedDataPinImpl <em>Computed Data Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.ComputedDataPinImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputedDataPin()
	 * @generated
	 */
	int COMPUTED_DATA_PIN = 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_DATA_PIN__OUTGOING = CONNECTABLE_DATA_PIN__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_DATA_PIN__INCOMING = CONNECTABLE_DATA_PIN__INCOMING;

	/**
	 * The feature id for the '<em><b>Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_DATA_PIN__CALL = CONNECTABLE_DATA_PIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_DATA_PIN__DECLARED = CONNECTABLE_DATA_PIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Computed Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_DATA_PIN_FEATURE_COUNT = CONNECTABLE_DATA_PIN_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Computed Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_DATA_PIN_OPERATION_COUNT = CONNECTABLE_DATA_PIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.DataFlowImpl <em>Data Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.DataFlowImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getDataFlow()
	 * @generated
	 */
	int DATA_FLOW = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Data Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl <em>Computation Unit Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputationUnitRelease()
	 * @generated
	 */
	int COMPUTATION_UNIT_RELEASE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_UNIT_RELEASE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_UNIT_RELEASE__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_UNIT_RELEASE__PARAMETERS = 2;

	/**
	 * The feature id for the '<em><b>Declared Pins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_UNIT_RELEASE__DECLARED_PINS = 3;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_UNIT_RELEASE__CALLS = 4;

	/**
	 * The number of structural features of the '<em>Computation Unit Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_UNIT_RELEASE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Computation Unit Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_UNIT_RELEASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.UnitParameterImpl <em>Unit Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.UnitParameterImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitParameter()
	 * @generated
	 */
	int UNIT_PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Unit Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Unit Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.UnitParameterValueImpl <em>Unit Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.UnitParameterValueImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitParameterValue()
	 * @generated
	 */
	int UNIT_PARAMETER_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER_VALUE__DECLARATION = 1;

	/**
	 * The number of structural features of the '<em>Unit Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Unit Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PARAMETER_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.DataPin <em>Data Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.DataPin
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getDataPin()
	 * @generated
	 */
	int DATA_PIN = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PIN__NAME = 0;

	/**
	 * The number of structural features of the '<em>Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PIN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl <em>Declared Data Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getDeclaredDataPin()
	 * @generated
	 */
	int DECLARED_DATA_PIN = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_DATA_PIN__NAME = DATA_PIN__NAME;

	/**
	 * The number of structural features of the '<em>Declared Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_DATA_PIN_FEATURE_COUNT = DATA_PIN_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Declared Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_DATA_PIN_OPERATION_COUNT = DATA_PIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.ComputationApplicationReleaseImpl <em>Computation Application Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.ComputationApplicationReleaseImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputationApplicationRelease()
	 * @generated
	 */
	int COMPUTATION_APPLICATION_RELEASE = 7;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_APPLICATION_RELEASE__CALLS = 0;

	/**
	 * The feature id for the '<em><b>Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_APPLICATION_RELEASE__FLOWS = 1;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_APPLICATION_RELEASE__UNITS = 2;

	/**
	 * The feature id for the '<em><b>Application Data Pins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_APPLICATION_RELEASE__APPLICATION_DATA_PINS = 3;

	/**
	 * The number of structural features of the '<em>Computation Application Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_APPLICATION_RELEASE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Computation Application Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_APPLICATION_RELEASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl <em>Application Data Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getApplicationDataPin()
	 * @generated
	 */
	int APPLICATION_DATA_PIN = 8;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DATA_PIN__OUTGOING = CONNECTABLE_DATA_PIN__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DATA_PIN__INCOMING = CONNECTABLE_DATA_PIN__INCOMING;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DATA_PIN__NAME = CONNECTABLE_DATA_PIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Application Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DATA_PIN_FEATURE_COUNT = CONNECTABLE_DATA_PIN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Application Data Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DATA_PIN_OPERATION_COUNT = CONNECTABLE_DATA_PIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.ComputationUnitStatus <em>Computation Unit Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.ComputationUnitStatus
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputationUnitStatus()
	 * @generated
	 */
	int COMPUTATION_UNIT_STATUS = 11;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.UnitStrength <em>Unit Strength</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.UnitStrength
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitStrength()
	 * @generated
	 */
	int UNIT_STRENGTH = 12;

	/**
	 * The meta object id for the '{@link eu.balticlsc.model.CAL.UnitParamType <em>Unit Param Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.balticlsc.model.CAL.UnitParamType
	 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitParamType()
	 * @generated
	 */
	int UNIT_PARAM_TYPE = 13;

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.UnitCall <em>Unit Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Call</em>'.
	 * @see eu.balticlsc.model.CAL.UnitCall
	 * @generated
	 */
	EClass getUnitCall();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.UnitCall#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.balticlsc.model.CAL.UnitCall#getName()
	 * @see #getUnitCall()
	 * @generated
	 */
	EAttribute getUnitCall_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.UnitCall#getStrength <em>Strength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strength</em>'.
	 * @see eu.balticlsc.model.CAL.UnitCall#getStrength()
	 * @see #getUnitCall()
	 * @generated
	 */
	EAttribute getUnitCall_Strength();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.UnitCall#getPins <em>Pins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pins</em>'.
	 * @see eu.balticlsc.model.CAL.UnitCall#getPins()
	 * @see #getUnitCall()
	 * @generated
	 */
	EReference getUnitCall_Pins();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.UnitCall#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
	 * @see eu.balticlsc.model.CAL.UnitCall#getParameterValues()
	 * @see #getUnitCall()
	 * @generated
	 */
	EReference getUnitCall_ParameterValues();

	/**
	 * Returns the meta object for the reference '{@link eu.balticlsc.model.CAL.UnitCall#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Release</em>'.
	 * @see eu.balticlsc.model.CAL.UnitCall#getRelease()
	 * @see #getUnitCall()
	 * @generated
	 */
	EReference getUnitCall_Release();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.ComputedDataPin <em>Computed Data Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computed Data Pin</em>'.
	 * @see eu.balticlsc.model.CAL.ComputedDataPin
	 * @generated
	 */
	EClass getComputedDataPin();

	/**
	 * Returns the meta object for the container reference '{@link eu.balticlsc.model.CAL.ComputedDataPin#getCall <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Call</em>'.
	 * @see eu.balticlsc.model.CAL.ComputedDataPin#getCall()
	 * @see #getComputedDataPin()
	 * @generated
	 */
	EReference getComputedDataPin_Call();

	/**
	 * Returns the meta object for the reference '{@link eu.balticlsc.model.CAL.ComputedDataPin#getDeclared <em>Declared</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declared</em>'.
	 * @see eu.balticlsc.model.CAL.ComputedDataPin#getDeclared()
	 * @see #getComputedDataPin()
	 * @generated
	 */
	EReference getComputedDataPin_Declared();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow</em>'.
	 * @see eu.balticlsc.model.CAL.DataFlow
	 * @generated
	 */
	EClass getDataFlow();

	/**
	 * Returns the meta object for the reference '{@link eu.balticlsc.model.CAL.DataFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see eu.balticlsc.model.CAL.DataFlow#getTarget()
	 * @see #getDataFlow()
	 * @generated
	 */
	EReference getDataFlow_Target();

	/**
	 * Returns the meta object for the reference '{@link eu.balticlsc.model.CAL.DataFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see eu.balticlsc.model.CAL.DataFlow#getSource()
	 * @see #getDataFlow()
	 * @generated
	 */
	EReference getDataFlow_Source();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.ComputationUnitRelease <em>Computation Unit Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Unit Release</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease
	 * @generated
	 */
	EClass getComputationUnitRelease();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease#getName()
	 * @see #getComputationUnitRelease()
	 * @generated
	 */
	EAttribute getComputationUnitRelease_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease#getVersion()
	 * @see #getComputationUnitRelease()
	 * @generated
	 */
	EAttribute getComputationUnitRelease_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease#getParameters()
	 * @see #getComputationUnitRelease()
	 * @generated
	 */
	EReference getComputationUnitRelease_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getDeclaredPins <em>Declared Pins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Pins</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease#getDeclaredPins()
	 * @see #getComputationUnitRelease()
	 * @generated
	 */
	EReference getComputationUnitRelease_DeclaredPins();

	/**
	 * Returns the meta object for the reference list '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Calls</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease#getCalls()
	 * @see #getComputationUnitRelease()
	 * @generated
	 */
	EReference getComputationUnitRelease_Calls();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.UnitParameter <em>Unit Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Parameter</em>'.
	 * @see eu.balticlsc.model.CAL.UnitParameter
	 * @generated
	 */
	EClass getUnitParameter();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.UnitParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.balticlsc.model.CAL.UnitParameter#getName()
	 * @see #getUnitParameter()
	 * @generated
	 */
	EAttribute getUnitParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.UnitParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.balticlsc.model.CAL.UnitParameter#getType()
	 * @see #getUnitParameter()
	 * @generated
	 */
	EAttribute getUnitParameter_Type();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.UnitParameterValue <em>Unit Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Parameter Value</em>'.
	 * @see eu.balticlsc.model.CAL.UnitParameterValue
	 * @generated
	 */
	EClass getUnitParameterValue();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.UnitParameterValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.balticlsc.model.CAL.UnitParameterValue#getValue()
	 * @see #getUnitParameterValue()
	 * @generated
	 */
	EAttribute getUnitParameterValue_Value();

	/**
	 * Returns the meta object for the reference '{@link eu.balticlsc.model.CAL.UnitParameterValue#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see eu.balticlsc.model.CAL.UnitParameterValue#getDeclaration()
	 * @see #getUnitParameterValue()
	 * @generated
	 */
	EReference getUnitParameterValue_Declaration();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.DeclaredDataPin <em>Declared Data Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declared Data Pin</em>'.
	 * @see eu.balticlsc.model.CAL.DeclaredDataPin
	 * @generated
	 */
	EClass getDeclaredDataPin();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.ComputationApplicationRelease <em>Computation Application Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Application Release</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationApplicationRelease
	 * @generated
	 */
	EClass getComputationApplicationRelease();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Calls</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationApplicationRelease#getCalls()
	 * @see #getComputationApplicationRelease()
	 * @generated
	 */
	EReference getComputationApplicationRelease_Calls();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getFlows <em>Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flows</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationApplicationRelease#getFlows()
	 * @see #getComputationApplicationRelease()
	 * @generated
	 */
	EReference getComputationApplicationRelease_Flows();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationApplicationRelease#getUnits()
	 * @see #getComputationApplicationRelease()
	 * @generated
	 */
	EReference getComputationApplicationRelease_Units();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getApplicationDataPins <em>Application Data Pins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Data Pins</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationApplicationRelease#getApplicationDataPins()
	 * @see #getComputationApplicationRelease()
	 * @generated
	 */
	EReference getComputationApplicationRelease_ApplicationDataPins();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.ApplicationDataPin <em>Application Data Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Data Pin</em>'.
	 * @see eu.balticlsc.model.CAL.ApplicationDataPin
	 * @generated
	 */
	EClass getApplicationDataPin();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.ConnectableDataPin <em>Connectable Data Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connectable Data Pin</em>'.
	 * @see eu.balticlsc.model.CAL.ConnectableDataPin
	 * @generated
	 */
	EClass getConnectableDataPin();

	/**
	 * Returns the meta object for the reference '{@link eu.balticlsc.model.CAL.ConnectableDataPin#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see eu.balticlsc.model.CAL.ConnectableDataPin#getOutgoing()
	 * @see #getConnectableDataPin()
	 * @generated
	 */
	EReference getConnectableDataPin_Outgoing();

	/**
	 * Returns the meta object for the reference '{@link eu.balticlsc.model.CAL.ConnectableDataPin#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see eu.balticlsc.model.CAL.ConnectableDataPin#getIncoming()
	 * @see #getConnectableDataPin()
	 * @generated
	 */
	EReference getConnectableDataPin_Incoming();

	/**
	 * Returns the meta object for class '{@link eu.balticlsc.model.CAL.DataPin <em>Data Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Pin</em>'.
	 * @see eu.balticlsc.model.CAL.DataPin
	 * @generated
	 */
	EClass getDataPin();

	/**
	 * Returns the meta object for the attribute '{@link eu.balticlsc.model.CAL.DataPin#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.balticlsc.model.CAL.DataPin#getName()
	 * @see #getDataPin()
	 * @generated
	 */
	EAttribute getDataPin_Name();

	/**
	 * Returns the meta object for enum '{@link eu.balticlsc.model.CAL.ComputationUnitStatus <em>Computation Unit Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Computation Unit Status</em>'.
	 * @see eu.balticlsc.model.CAL.ComputationUnitStatus
	 * @generated
	 */
	EEnum getComputationUnitStatus();

	/**
	 * Returns the meta object for enum '{@link eu.balticlsc.model.CAL.UnitStrength <em>Unit Strength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unit Strength</em>'.
	 * @see eu.balticlsc.model.CAL.UnitStrength
	 * @generated
	 */
	EEnum getUnitStrength();

	/**
	 * Returns the meta object for enum '{@link eu.balticlsc.model.CAL.UnitParamType <em>Unit Param Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unit Param Type</em>'.
	 * @see eu.balticlsc.model.CAL.UnitParamType
	 * @generated
	 */
	EEnum getUnitParamType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CALFactory getCALFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.UnitCallImpl <em>Unit Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.UnitCallImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitCall()
		 * @generated
		 */
		EClass UNIT_CALL = eINSTANCE.getUnitCall();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_CALL__NAME = eINSTANCE.getUnitCall_Name();

		/**
		 * The meta object literal for the '<em><b>Strength</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_CALL__STRENGTH = eINSTANCE.getUnitCall_Strength();

		/**
		 * The meta object literal for the '<em><b>Pins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CALL__PINS = eINSTANCE.getUnitCall_Pins();

		/**
		 * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CALL__PARAMETER_VALUES = eINSTANCE.getUnitCall_ParameterValues();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CALL__RELEASE = eINSTANCE.getUnitCall_Release();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.ComputedDataPinImpl <em>Computed Data Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.ComputedDataPinImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputedDataPin()
		 * @generated
		 */
		EClass COMPUTED_DATA_PIN = eINSTANCE.getComputedDataPin();

		/**
		 * The meta object literal for the '<em><b>Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_DATA_PIN__CALL = eINSTANCE.getComputedDataPin_Call();

		/**
		 * The meta object literal for the '<em><b>Declared</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_DATA_PIN__DECLARED = eINSTANCE.getComputedDataPin_Declared();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.DataFlowImpl <em>Data Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.DataFlowImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getDataFlow()
		 * @generated
		 */
		EClass DATA_FLOW = eINSTANCE.getDataFlow();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW__TARGET = eINSTANCE.getDataFlow_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW__SOURCE = eINSTANCE.getDataFlow_Source();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl <em>Computation Unit Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputationUnitRelease()
		 * @generated
		 */
		EClass COMPUTATION_UNIT_RELEASE = eINSTANCE.getComputationUnitRelease();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTATION_UNIT_RELEASE__NAME = eINSTANCE.getComputationUnitRelease_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTATION_UNIT_RELEASE__VERSION = eINSTANCE.getComputationUnitRelease_Version();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_UNIT_RELEASE__PARAMETERS = eINSTANCE.getComputationUnitRelease_Parameters();

		/**
		 * The meta object literal for the '<em><b>Declared Pins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_UNIT_RELEASE__DECLARED_PINS = eINSTANCE.getComputationUnitRelease_DeclaredPins();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_UNIT_RELEASE__CALLS = eINSTANCE.getComputationUnitRelease_Calls();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.UnitParameterImpl <em>Unit Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.UnitParameterImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitParameter()
		 * @generated
		 */
		EClass UNIT_PARAMETER = eINSTANCE.getUnitParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_PARAMETER__NAME = eINSTANCE.getUnitParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_PARAMETER__TYPE = eINSTANCE.getUnitParameter_Type();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.UnitParameterValueImpl <em>Unit Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.UnitParameterValueImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitParameterValue()
		 * @generated
		 */
		EClass UNIT_PARAMETER_VALUE = eINSTANCE.getUnitParameterValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_PARAMETER_VALUE__VALUE = eINSTANCE.getUnitParameterValue_Value();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_PARAMETER_VALUE__DECLARATION = eINSTANCE.getUnitParameterValue_Declaration();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl <em>Declared Data Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getDeclaredDataPin()
		 * @generated
		 */
		EClass DECLARED_DATA_PIN = eINSTANCE.getDeclaredDataPin();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.ComputationApplicationReleaseImpl <em>Computation Application Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.ComputationApplicationReleaseImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputationApplicationRelease()
		 * @generated
		 */
		EClass COMPUTATION_APPLICATION_RELEASE = eINSTANCE.getComputationApplicationRelease();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_APPLICATION_RELEASE__CALLS = eINSTANCE.getComputationApplicationRelease_Calls();

		/**
		 * The meta object literal for the '<em><b>Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_APPLICATION_RELEASE__FLOWS = eINSTANCE.getComputationApplicationRelease_Flows();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_APPLICATION_RELEASE__UNITS = eINSTANCE.getComputationApplicationRelease_Units();

		/**
		 * The meta object literal for the '<em><b>Application Data Pins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_APPLICATION_RELEASE__APPLICATION_DATA_PINS = eINSTANCE
				.getComputationApplicationRelease_ApplicationDataPins();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl <em>Application Data Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getApplicationDataPin()
		 * @generated
		 */
		EClass APPLICATION_DATA_PIN = eINSTANCE.getApplicationDataPin();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.ConnectableDataPin <em>Connectable Data Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.ConnectableDataPin
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getConnectableDataPin()
		 * @generated
		 */
		EClass CONNECTABLE_DATA_PIN = eINSTANCE.getConnectableDataPin();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTABLE_DATA_PIN__OUTGOING = eINSTANCE.getConnectableDataPin_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTABLE_DATA_PIN__INCOMING = eINSTANCE.getConnectableDataPin_Incoming();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.DataPin <em>Data Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.DataPin
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getDataPin()
		 * @generated
		 */
		EClass DATA_PIN = eINSTANCE.getDataPin();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_PIN__NAME = eINSTANCE.getDataPin_Name();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.ComputationUnitStatus <em>Computation Unit Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.ComputationUnitStatus
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getComputationUnitStatus()
		 * @generated
		 */
		EEnum COMPUTATION_UNIT_STATUS = eINSTANCE.getComputationUnitStatus();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.UnitStrength <em>Unit Strength</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.UnitStrength
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitStrength()
		 * @generated
		 */
		EEnum UNIT_STRENGTH = eINSTANCE.getUnitStrength();

		/**
		 * The meta object literal for the '{@link eu.balticlsc.model.CAL.UnitParamType <em>Unit Param Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.balticlsc.model.CAL.UnitParamType
		 * @see eu.balticlsc.model.CAL.impl.CALPackageImpl#getUnitParamType()
		 * @generated
		 */
		EEnum UNIT_PARAM_TYPE = eINSTANCE.getUnitParamType();

	}

} //CALPackage
