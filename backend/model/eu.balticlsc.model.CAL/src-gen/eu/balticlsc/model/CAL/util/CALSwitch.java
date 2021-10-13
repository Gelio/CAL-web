/**
 */
package eu.balticlsc.model.CAL.util;

import eu.balticlsc.model.CAL.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.balticlsc.model.CAL.CALPackage
 * @generated
 */
public class CALSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CALPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CALSwitch() {
		if (modelPackage == null) {
			modelPackage = CALPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case CALPackage.UNIT_CALL: {
			UnitCall unitCall = (UnitCall) theEObject;
			T result = caseUnitCall(unitCall);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.COMPUTED_DATA_PIN: {
			ComputedDataPin computedDataPin = (ComputedDataPin) theEObject;
			T result = caseComputedDataPin(computedDataPin);
			if (result == null)
				result = caseConnectableDataPin(computedDataPin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.DATA_FLOW: {
			DataFlow dataFlow = (DataFlow) theEObject;
			T result = caseDataFlow(dataFlow);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.COMPUTATION_UNIT_RELEASE: {
			ComputationUnitRelease computationUnitRelease = (ComputationUnitRelease) theEObject;
			T result = caseComputationUnitRelease(computationUnitRelease);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.UNIT_PARAMETER: {
			UnitParameter unitParameter = (UnitParameter) theEObject;
			T result = caseUnitParameter(unitParameter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.UNIT_PARAMETER_VALUE: {
			UnitParameterValue unitParameterValue = (UnitParameterValue) theEObject;
			T result = caseUnitParameterValue(unitParameterValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.DECLARED_DATA_PIN: {
			DeclaredDataPin declaredDataPin = (DeclaredDataPin) theEObject;
			T result = caseDeclaredDataPin(declaredDataPin);
			if (result == null)
				result = caseDataPin(declaredDataPin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.COMPUTATION_APPLICATION_RELEASE: {
			ComputationApplicationRelease computationApplicationRelease = (ComputationApplicationRelease) theEObject;
			T result = caseComputationApplicationRelease(computationApplicationRelease);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.APPLICATION_DATA_PIN: {
			ApplicationDataPin applicationDataPin = (ApplicationDataPin) theEObject;
			T result = caseApplicationDataPin(applicationDataPin);
			if (result == null)
				result = caseConnectableDataPin(applicationDataPin);
			if (result == null)
				result = caseDataPin(applicationDataPin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.CONNECTABLE_DATA_PIN: {
			ConnectableDataPin connectableDataPin = (ConnectableDataPin) theEObject;
			T result = caseConnectableDataPin(connectableDataPin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CALPackage.DATA_PIN: {
			DataPin dataPin = (DataPin) theEObject;
			T result = caseDataPin(dataPin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitCall(UnitCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computed Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computed Data Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputedDataPin(ComputedDataPin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlow(DataFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computation Unit Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computation Unit Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputationUnitRelease(ComputationUnitRelease object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitParameter(UnitParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Parameter Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitParameterValue(UnitParameterValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declared Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declared Data Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaredDataPin(DeclaredDataPin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computation Application Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computation Application Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputationApplicationRelease(ComputationApplicationRelease object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Data Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationDataPin(ApplicationDataPin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connectable Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connectable Data Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectableDataPin(ConnectableDataPin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPin(DataPin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CALSwitch
