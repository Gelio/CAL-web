/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.CALPackage;
import eu.balticlsc.model.CAL.ComputationApplicationRelease;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.UnitCall;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Application Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputationApplicationReleaseImpl#getCalls <em>Calls</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputationApplicationReleaseImpl#getFlows <em>Flows</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputationApplicationReleaseImpl#getUnits <em>Units</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputationApplicationReleaseImpl extends MinimalEObjectImpl.Container
		implements ComputationApplicationRelease {
	/**
	 * The cached value of the '{@link #getCalls() <em>Calls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalls()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitCall> calls;

	/**
	 * The cached value of the '{@link #getFlows() <em>Flows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlow> flows;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputationUnitRelease> units;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputationApplicationReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CALPackage.Literals.COMPUTATION_APPLICATION_RELEASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UnitCall> getCalls() {
		if (calls == null) {
			calls = new EObjectContainmentEList<UnitCall>(UnitCall.class, this,
					CALPackage.COMPUTATION_APPLICATION_RELEASE__CALLS);
		}
		return calls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataFlow> getFlows() {
		if (flows == null) {
			flows = new EObjectContainmentEList<DataFlow>(DataFlow.class, this,
					CALPackage.COMPUTATION_APPLICATION_RELEASE__FLOWS);
		}
		return flows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ComputationUnitRelease> getUnits() {
		if (units == null) {
			units = new EObjectContainmentEList<ComputationUnitRelease>(ComputationUnitRelease.class, this,
					CALPackage.COMPUTATION_APPLICATION_RELEASE__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__CALLS:
			return ((InternalEList<?>) getCalls()).basicRemove(otherEnd, msgs);
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__FLOWS:
			return ((InternalEList<?>) getFlows()).basicRemove(otherEnd, msgs);
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__UNITS:
			return ((InternalEList<?>) getUnits()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__CALLS:
			return getCalls();
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__FLOWS:
			return getFlows();
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__UNITS:
			return getUnits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__CALLS:
			getCalls().clear();
			getCalls().addAll((Collection<? extends UnitCall>) newValue);
			return;
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__FLOWS:
			getFlows().clear();
			getFlows().addAll((Collection<? extends DataFlow>) newValue);
			return;
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__UNITS:
			getUnits().clear();
			getUnits().addAll((Collection<? extends ComputationUnitRelease>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__CALLS:
			getCalls().clear();
			return;
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__FLOWS:
			getFlows().clear();
			return;
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__UNITS:
			getUnits().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__CALLS:
			return calls != null && !calls.isEmpty();
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__FLOWS:
			return flows != null && !flows.isEmpty();
		case CALPackage.COMPUTATION_APPLICATION_RELEASE__UNITS:
			return units != null && !units.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComputationApplicationReleaseImpl
