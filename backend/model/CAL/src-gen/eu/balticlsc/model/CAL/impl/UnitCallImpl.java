/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.CALPackage;
import eu.balticlsc.model.CAL.ComputationUnitRelease;
import eu.balticlsc.model.CAL.ComputedDataPin;
import eu.balticlsc.model.CAL.UnitCall;
import eu.balticlsc.model.CAL.UnitParameterValue;
import eu.balticlsc.model.CAL.UnitStrength;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.impl.UnitCallImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.UnitCallImpl#getStrength <em>Strength</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.UnitCallImpl#getPins <em>Pins</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.UnitCallImpl#getParameterValues <em>Parameter Values</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.UnitCallImpl#getRelease <em>Release</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnitCallImpl extends MinimalEObjectImpl.Container implements UnitCall {
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
	 * The default value of the '{@link #getStrength() <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrength()
	 * @generated
	 * @ordered
	 */
	protected static final UnitStrength STRENGTH_EDEFAULT = UnitStrength.WEAK;

	/**
	 * The cached value of the '{@link #getStrength() <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrength()
	 * @generated
	 * @ordered
	 */
	protected UnitStrength strength = STRENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPins() <em>Pins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPins()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputedDataPin> pins;

	/**
	 * The cached value of the '{@link #getParameterValues() <em>Parameter Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValues()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitParameterValue> parameterValues;

	/**
	 * The cached value of the '{@link #getRelease() <em>Release</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected ComputationUnitRelease release;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CALPackage.Literals.UNIT_CALL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.UNIT_CALL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitStrength getStrength() {
		return strength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStrength(UnitStrength newStrength) {
		UnitStrength oldStrength = strength;
		strength = newStrength == null ? STRENGTH_EDEFAULT : newStrength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.UNIT_CALL__STRENGTH, oldStrength,
					strength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ComputedDataPin> getPins() {
		if (pins == null) {
			pins = new EObjectContainmentWithInverseEList<ComputedDataPin>(ComputedDataPin.class, this,
					CALPackage.UNIT_CALL__PINS, CALPackage.COMPUTED_DATA_PIN__CALL);
		}
		return pins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UnitParameterValue> getParameterValues() {
		if (parameterValues == null) {
			parameterValues = new EObjectContainmentEList<UnitParameterValue>(UnitParameterValue.class, this,
					CALPackage.UNIT_CALL__PARAMETER_VALUES);
		}
		return parameterValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputationUnitRelease getRelease() {
		if (release != null && release.eIsProxy()) {
			InternalEObject oldRelease = (InternalEObject) release;
			release = (ComputationUnitRelease) eResolveProxy(oldRelease);
			if (release != oldRelease) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CALPackage.UNIT_CALL__RELEASE, oldRelease,
							release));
			}
		}
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationUnitRelease basicGetRelease() {
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelease(ComputationUnitRelease newRelease, NotificationChain msgs) {
		ComputationUnitRelease oldRelease = release;
		release = newRelease;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					CALPackage.UNIT_CALL__RELEASE, oldRelease, newRelease);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelease(ComputationUnitRelease newRelease) {
		if (newRelease != release) {
			NotificationChain msgs = null;
			if (release != null)
				msgs = ((InternalEObject) release).eInverseRemove(this, CALPackage.COMPUTATION_UNIT_RELEASE__CALL,
						ComputationUnitRelease.class, msgs);
			if (newRelease != null)
				msgs = ((InternalEObject) newRelease).eInverseAdd(this, CALPackage.COMPUTATION_UNIT_RELEASE__CALL,
						ComputationUnitRelease.class, msgs);
			msgs = basicSetRelease(newRelease, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.UNIT_CALL__RELEASE, newRelease,
					newRelease));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CALPackage.UNIT_CALL__PINS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPins()).basicAdd(otherEnd, msgs);
		case CALPackage.UNIT_CALL__RELEASE:
			if (release != null)
				msgs = ((InternalEObject) release).eInverseRemove(this, CALPackage.COMPUTATION_UNIT_RELEASE__CALL,
						ComputationUnitRelease.class, msgs);
			return basicSetRelease((ComputationUnitRelease) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CALPackage.UNIT_CALL__PINS:
			return ((InternalEList<?>) getPins()).basicRemove(otherEnd, msgs);
		case CALPackage.UNIT_CALL__PARAMETER_VALUES:
			return ((InternalEList<?>) getParameterValues()).basicRemove(otherEnd, msgs);
		case CALPackage.UNIT_CALL__RELEASE:
			return basicSetRelease(null, msgs);
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
		case CALPackage.UNIT_CALL__NAME:
			return getName();
		case CALPackage.UNIT_CALL__STRENGTH:
			return getStrength();
		case CALPackage.UNIT_CALL__PINS:
			return getPins();
		case CALPackage.UNIT_CALL__PARAMETER_VALUES:
			return getParameterValues();
		case CALPackage.UNIT_CALL__RELEASE:
			if (resolve)
				return getRelease();
			return basicGetRelease();
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
		case CALPackage.UNIT_CALL__NAME:
			setName((String) newValue);
			return;
		case CALPackage.UNIT_CALL__STRENGTH:
			setStrength((UnitStrength) newValue);
			return;
		case CALPackage.UNIT_CALL__PINS:
			getPins().clear();
			getPins().addAll((Collection<? extends ComputedDataPin>) newValue);
			return;
		case CALPackage.UNIT_CALL__PARAMETER_VALUES:
			getParameterValues().clear();
			getParameterValues().addAll((Collection<? extends UnitParameterValue>) newValue);
			return;
		case CALPackage.UNIT_CALL__RELEASE:
			setRelease((ComputationUnitRelease) newValue);
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
		case CALPackage.UNIT_CALL__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CALPackage.UNIT_CALL__STRENGTH:
			setStrength(STRENGTH_EDEFAULT);
			return;
		case CALPackage.UNIT_CALL__PINS:
			getPins().clear();
			return;
		case CALPackage.UNIT_CALL__PARAMETER_VALUES:
			getParameterValues().clear();
			return;
		case CALPackage.UNIT_CALL__RELEASE:
			setRelease((ComputationUnitRelease) null);
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
		case CALPackage.UNIT_CALL__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case CALPackage.UNIT_CALL__STRENGTH:
			return strength != STRENGTH_EDEFAULT;
		case CALPackage.UNIT_CALL__PINS:
			return pins != null && !pins.isEmpty();
		case CALPackage.UNIT_CALL__PARAMETER_VALUES:
			return parameterValues != null && !parameterValues.isEmpty();
		case CALPackage.UNIT_CALL__RELEASE:
			return release != null;
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
		result.append(", strength: ");
		result.append(strength);
		result.append(')');
		return result.toString();
	}

} //UnitCallImpl