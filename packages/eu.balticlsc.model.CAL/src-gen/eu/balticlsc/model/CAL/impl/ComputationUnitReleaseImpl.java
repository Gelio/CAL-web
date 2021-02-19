/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.CALPackage;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.DeclaredDataPin;
import eu.balticlsc.model.CAL.UnitParameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Unit Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputationUnitReleaseImpl#getDeclaredPins <em>Declared Pins</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputationUnitReleaseImpl extends MinimalEObjectImpl.Container implements ComputationUnitRelease {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitParameter> parameters;

	/**
	 * The cached value of the '{@link #getDeclaredPins() <em>Declared Pins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredPins()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclaredDataPin> declaredPins;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputationUnitReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CALPackage.Literals.COMPUTATION_UNIT_RELEASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.COMPUTATION_UNIT_RELEASE__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.COMPUTATION_UNIT_RELEASE__VERSION,
					oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UnitParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<UnitParameter>(UnitParameter.class, this,
					CALPackage.COMPUTATION_UNIT_RELEASE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeclaredDataPin> getDeclaredPins() {
		if (declaredPins == null) {
			declaredPins = new EObjectContainmentEList<DeclaredDataPin>(DeclaredDataPin.class, this,
					CALPackage.COMPUTATION_UNIT_RELEASE__DECLARED_PINS);
		}
		return declaredPins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CALPackage.COMPUTATION_UNIT_RELEASE__PARAMETERS:
			return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
		case CALPackage.COMPUTATION_UNIT_RELEASE__DECLARED_PINS:
			return ((InternalEList<?>) getDeclaredPins()).basicRemove(otherEnd, msgs);
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
		case CALPackage.COMPUTATION_UNIT_RELEASE__NAME:
			return getName();
		case CALPackage.COMPUTATION_UNIT_RELEASE__VERSION:
			return getVersion();
		case CALPackage.COMPUTATION_UNIT_RELEASE__PARAMETERS:
			return getParameters();
		case CALPackage.COMPUTATION_UNIT_RELEASE__DECLARED_PINS:
			return getDeclaredPins();
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
		case CALPackage.COMPUTATION_UNIT_RELEASE__NAME:
			setName((String) newValue);
			return;
		case CALPackage.COMPUTATION_UNIT_RELEASE__VERSION:
			setVersion((String) newValue);
			return;
		case CALPackage.COMPUTATION_UNIT_RELEASE__PARAMETERS:
			getParameters().clear();
			getParameters().addAll((Collection<? extends UnitParameter>) newValue);
			return;
		case CALPackage.COMPUTATION_UNIT_RELEASE__DECLARED_PINS:
			getDeclaredPins().clear();
			getDeclaredPins().addAll((Collection<? extends DeclaredDataPin>) newValue);
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
		case CALPackage.COMPUTATION_UNIT_RELEASE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CALPackage.COMPUTATION_UNIT_RELEASE__VERSION:
			setVersion(VERSION_EDEFAULT);
			return;
		case CALPackage.COMPUTATION_UNIT_RELEASE__PARAMETERS:
			getParameters().clear();
			return;
		case CALPackage.COMPUTATION_UNIT_RELEASE__DECLARED_PINS:
			getDeclaredPins().clear();
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
		case CALPackage.COMPUTATION_UNIT_RELEASE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case CALPackage.COMPUTATION_UNIT_RELEASE__VERSION:
			return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
		case CALPackage.COMPUTATION_UNIT_RELEASE__PARAMETERS:
			return parameters != null && !parameters.isEmpty();
		case CALPackage.COMPUTATION_UNIT_RELEASE__DECLARED_PINS:
			return declaredPins != null && !declaredPins.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //ComputationUnitReleaseImpl
