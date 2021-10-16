/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.CALPackage;
import eu.balticlsc.model.CAL.DataBinding;
import eu.balticlsc.model.CAL.DeclaredDataPin;

import eu.balticlsc.model.CAL.Multiplicity;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Data Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl#getDataMultiplicity <em>Data Multiplicity</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl#getTokenMultiplicity <em>Token Multiplicity</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.DeclaredDataPinImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclaredDataPinImpl extends MinimalEObjectImpl.Container implements DeclaredDataPin {
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
	 * The default value of the '{@link #getDataMultiplicity() <em>Data Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final Multiplicity DATA_MULTIPLICITY_EDEFAULT = Multiplicity.SINGLE;
	/**
	 * The cached value of the '{@link #getDataMultiplicity() <em>Data Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected Multiplicity dataMultiplicity = DATA_MULTIPLICITY_EDEFAULT;
	/**
	 * The default value of the '{@link #getTokenMultiplicity() <em>Token Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokenMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final Multiplicity TOKEN_MULTIPLICITY_EDEFAULT = Multiplicity.SINGLE;
	/**
	 * The cached value of the '{@link #getTokenMultiplicity() <em>Token Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokenMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected Multiplicity tokenMultiplicity = TOKEN_MULTIPLICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected static final DataBinding BINDING_EDEFAULT = DataBinding.REQUIRED;
	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected DataBinding binding = BINDING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredDataPinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CALPackage.Literals.DECLARED_DATA_PIN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.DECLARED_DATA_PIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Multiplicity getDataMultiplicity() {
		return dataMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataMultiplicity(Multiplicity newDataMultiplicity) {
		Multiplicity oldDataMultiplicity = dataMultiplicity;
		dataMultiplicity = newDataMultiplicity == null ? DATA_MULTIPLICITY_EDEFAULT : newDataMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.DECLARED_DATA_PIN__DATA_MULTIPLICITY,
					oldDataMultiplicity, dataMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Multiplicity getTokenMultiplicity() {
		return tokenMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTokenMultiplicity(Multiplicity newTokenMultiplicity) {
		Multiplicity oldTokenMultiplicity = tokenMultiplicity;
		tokenMultiplicity = newTokenMultiplicity == null ? TOKEN_MULTIPLICITY_EDEFAULT : newTokenMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.DECLARED_DATA_PIN__TOKEN_MULTIPLICITY,
					oldTokenMultiplicity, tokenMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataBinding getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBinding(DataBinding newBinding) {
		DataBinding oldBinding = binding;
		binding = newBinding == null ? BINDING_EDEFAULT : newBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.DECLARED_DATA_PIN__BINDING, oldBinding,
					binding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CALPackage.DECLARED_DATA_PIN__NAME:
			return getName();
		case CALPackage.DECLARED_DATA_PIN__DATA_MULTIPLICITY:
			return getDataMultiplicity();
		case CALPackage.DECLARED_DATA_PIN__TOKEN_MULTIPLICITY:
			return getTokenMultiplicity();
		case CALPackage.DECLARED_DATA_PIN__BINDING:
			return getBinding();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CALPackage.DECLARED_DATA_PIN__NAME:
			setName((String) newValue);
			return;
		case CALPackage.DECLARED_DATA_PIN__DATA_MULTIPLICITY:
			setDataMultiplicity((Multiplicity) newValue);
			return;
		case CALPackage.DECLARED_DATA_PIN__TOKEN_MULTIPLICITY:
			setTokenMultiplicity((Multiplicity) newValue);
			return;
		case CALPackage.DECLARED_DATA_PIN__BINDING:
			setBinding((DataBinding) newValue);
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
		case CALPackage.DECLARED_DATA_PIN__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CALPackage.DECLARED_DATA_PIN__DATA_MULTIPLICITY:
			setDataMultiplicity(DATA_MULTIPLICITY_EDEFAULT);
			return;
		case CALPackage.DECLARED_DATA_PIN__TOKEN_MULTIPLICITY:
			setTokenMultiplicity(TOKEN_MULTIPLICITY_EDEFAULT);
			return;
		case CALPackage.DECLARED_DATA_PIN__BINDING:
			setBinding(BINDING_EDEFAULT);
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
		case CALPackage.DECLARED_DATA_PIN__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case CALPackage.DECLARED_DATA_PIN__DATA_MULTIPLICITY:
			return dataMultiplicity != DATA_MULTIPLICITY_EDEFAULT;
		case CALPackage.DECLARED_DATA_PIN__TOKEN_MULTIPLICITY:
			return tokenMultiplicity != TOKEN_MULTIPLICITY_EDEFAULT;
		case CALPackage.DECLARED_DATA_PIN__BINDING:
			return binding != BINDING_EDEFAULT;
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
		result.append(", dataMultiplicity: ");
		result.append(dataMultiplicity);
		result.append(", tokenMultiplicity: ");
		result.append(tokenMultiplicity);
		result.append(", binding: ");
		result.append(binding);
		result.append(')');
		return result.toString();
	}

} //DeclaredDataPinImpl
