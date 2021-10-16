/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CALFactoryImpl extends EFactoryImpl implements CALFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CALFactory init() {
		try {
			CALFactory theCALFactory = (CALFactory) EPackage.Registry.INSTANCE.getEFactory(CALPackage.eNS_URI);
			if (theCALFactory != null) {
				return theCALFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CALFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CALFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CALPackage.UNIT_CALL:
			return createUnitCall();
		case CALPackage.COMPUTED_DATA_PIN:
			return createComputedDataPin();
		case CALPackage.DATA_FLOW:
			return createDataFlow();
		case CALPackage.COMPUTATION_UNIT_RELEASE:
			return createComputationUnitRelease();
		case CALPackage.UNIT_PARAMETER:
			return createUnitParameter();
		case CALPackage.UNIT_PARAMETER_VALUE:
			return createUnitParameterValue();
		case CALPackage.DECLARED_DATA_PIN:
			return createDeclaredDataPin();
		case CALPackage.COMPUTATION_APPLICATION_RELEASE:
			return createComputationApplicationRelease();
		case CALPackage.APPLICATION_DATA_PIN:
			return createApplicationDataPin();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case CALPackage.COMPUTATION_UNIT_STATUS:
			return createComputationUnitStatusFromString(eDataType, initialValue);
		case CALPackage.UNIT_STRENGTH:
			return createUnitStrengthFromString(eDataType, initialValue);
		case CALPackage.UNIT_PARAM_TYPE:
			return createUnitParamTypeFromString(eDataType, initialValue);
		case CALPackage.MULTIPLICITY:
			return createMultiplicityFromString(eDataType, initialValue);
		case CALPackage.DATA_BINDING:
			return createDataBindingFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case CALPackage.COMPUTATION_UNIT_STATUS:
			return convertComputationUnitStatusToString(eDataType, instanceValue);
		case CALPackage.UNIT_STRENGTH:
			return convertUnitStrengthToString(eDataType, instanceValue);
		case CALPackage.UNIT_PARAM_TYPE:
			return convertUnitParamTypeToString(eDataType, instanceValue);
		case CALPackage.MULTIPLICITY:
			return convertMultiplicityToString(eDataType, instanceValue);
		case CALPackage.DATA_BINDING:
			return convertDataBindingToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitCall createUnitCall() {
		UnitCallImpl unitCall = new UnitCallImpl();
		return unitCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputedDataPin createComputedDataPin() {
		ComputedDataPinImpl computedDataPin = new ComputedDataPinImpl();
		return computedDataPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlow createDataFlow() {
		DataFlowImpl dataFlow = new DataFlowImpl();
		return dataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputationUnitRelease createComputationUnitRelease() {
		ComputationUnitReleaseImpl computationUnitRelease = new ComputationUnitReleaseImpl();
		return computationUnitRelease;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitParameter createUnitParameter() {
		UnitParameterImpl unitParameter = new UnitParameterImpl();
		return unitParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitParameterValue createUnitParameterValue() {
		UnitParameterValueImpl unitParameterValue = new UnitParameterValueImpl();
		return unitParameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeclaredDataPin createDeclaredDataPin() {
		DeclaredDataPinImpl declaredDataPin = new DeclaredDataPinImpl();
		return declaredDataPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputationApplicationRelease createComputationApplicationRelease() {
		ComputationApplicationReleaseImpl computationApplicationRelease = new ComputationApplicationReleaseImpl();
		return computationApplicationRelease;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationDataPin createApplicationDataPin() {
		ApplicationDataPinImpl applicationDataPin = new ApplicationDataPinImpl();
		return applicationDataPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationUnitStatus createComputationUnitStatusFromString(EDataType eDataType, String initialValue) {
		ComputationUnitStatus result = ComputationUnitStatus.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComputationUnitStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitStrength createUnitStrengthFromString(EDataType eDataType, String initialValue) {
		UnitStrength result = UnitStrength.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitStrengthToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitParamType createUnitParamTypeFromString(EDataType eDataType, String initialValue) {
		UnitParamType result = UnitParamType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitParamTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multiplicity createMultiplicityFromString(EDataType eDataType, String initialValue) {
		Multiplicity result = Multiplicity.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataBinding createDataBindingFromString(EDataType eDataType, String initialValue) {
		DataBinding result = DataBinding.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataBindingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CALPackage getCALPackage() {
		return (CALPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CALPackage getPackage() {
		return CALPackage.eINSTANCE;
	}

} //CALFactoryImpl
