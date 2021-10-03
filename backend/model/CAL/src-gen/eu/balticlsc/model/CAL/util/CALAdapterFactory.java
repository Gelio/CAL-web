/**
 */
package eu.balticlsc.model.CAL.util;

import eu.balticlsc.model.CAL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.balticlsc.model.CAL.CALPackage
 * @generated
 */
public class CALAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CALPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CALAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CALPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CALSwitch<Adapter> modelSwitch = new CALSwitch<Adapter>() {
		@Override
		public Adapter caseUnitCall(UnitCall object) {
			return createUnitCallAdapter();
		}

		@Override
		public Adapter caseComputedDataPin(ComputedDataPin object) {
			return createComputedDataPinAdapter();
		}

		@Override
		public Adapter caseDataFlow(DataFlow object) {
			return createDataFlowAdapter();
		}

		@Override
		public Adapter caseComputationUnitRelease(ComputationUnitRelease object) {
			return createComputationUnitReleaseAdapter();
		}

		@Override
		public Adapter caseUnitParameter(UnitParameter object) {
			return createUnitParameterAdapter();
		}

		@Override
		public Adapter caseUnitParameterValue(UnitParameterValue object) {
			return createUnitParameterValueAdapter();
		}

		@Override
		public Adapter caseDeclaredDataPin(DeclaredDataPin object) {
			return createDeclaredDataPinAdapter();
		}

		@Override
		public Adapter caseComputationApplicationRelease(ComputationApplicationRelease object) {
			return createComputationApplicationReleaseAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.UnitCall <em>Unit Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.UnitCall
	 * @generated
	 */
	public Adapter createUnitCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.ComputedDataPin <em>Computed Data Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.ComputedDataPin
	 * @generated
	 */
	public Adapter createComputedDataPinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.DataFlow
	 * @generated
	 */
	public Adapter createDataFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.ComputationUnitRelease <em>Computation Unit Release</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease
	 * @generated
	 */
	public Adapter createComputationUnitReleaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.UnitParameter <em>Unit Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.UnitParameter
	 * @generated
	 */
	public Adapter createUnitParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.UnitParameterValue <em>Unit Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.UnitParameterValue
	 * @generated
	 */
	public Adapter createUnitParameterValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.DeclaredDataPin <em>Declared Data Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.DeclaredDataPin
	 * @generated
	 */
	public Adapter createDeclaredDataPinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.balticlsc.model.CAL.ComputationApplicationRelease <em>Computation Application Release</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.balticlsc.model.CAL.ComputationApplicationRelease
	 * @generated
	 */
	public Adapter createComputationApplicationReleaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CALAdapterFactory
