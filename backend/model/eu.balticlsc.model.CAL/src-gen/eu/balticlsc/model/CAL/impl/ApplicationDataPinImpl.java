/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.ApplicationDataPin;
import eu.balticlsc.model.CAL.CALPackage;
import eu.balticlsc.model.CAL.DataBinding;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.DataPin;

import eu.balticlsc.model.CAL.Multiplicity;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Data Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl#getDataMultiplicity <em>Data Multiplicity</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl#getTokenMultiplicity <em>Token Multiplicity</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ApplicationDataPinImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationDataPinImpl extends MinimalEObjectImpl.Container implements ApplicationDataPin {
	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected DataFlow outgoing;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected DataFlow incoming;

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
	protected ApplicationDataPinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CALPackage.Literals.APPLICATION_DATA_PIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlow getOutgoing() {
		if (outgoing != null && outgoing.eIsProxy()) {
			InternalEObject oldOutgoing = (InternalEObject) outgoing;
			outgoing = (DataFlow) eResolveProxy(oldOutgoing);
			if (outgoing != oldOutgoing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CALPackage.APPLICATION_DATA_PIN__OUTGOING,
							oldOutgoing, outgoing));
			}
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow basicGetOutgoing() {
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoing(DataFlow newOutgoing, NotificationChain msgs) {
		DataFlow oldOutgoing = outgoing;
		outgoing = newOutgoing;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					CALPackage.APPLICATION_DATA_PIN__OUTGOING, oldOutgoing, newOutgoing);
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
	public void setOutgoing(DataFlow newOutgoing) {
		if (newOutgoing != outgoing) {
			NotificationChain msgs = null;
			if (outgoing != null)
				msgs = ((InternalEObject) outgoing).eInverseRemove(this, CALPackage.DATA_FLOW__SOURCE, DataFlow.class,
						msgs);
			if (newOutgoing != null)
				msgs = ((InternalEObject) newOutgoing).eInverseAdd(this, CALPackage.DATA_FLOW__SOURCE, DataFlow.class,
						msgs);
			msgs = basicSetOutgoing(newOutgoing, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.APPLICATION_DATA_PIN__OUTGOING,
					newOutgoing, newOutgoing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlow getIncoming() {
		if (incoming != null && incoming.eIsProxy()) {
			InternalEObject oldIncoming = (InternalEObject) incoming;
			incoming = (DataFlow) eResolveProxy(oldIncoming);
			if (incoming != oldIncoming) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CALPackage.APPLICATION_DATA_PIN__INCOMING,
							oldIncoming, incoming));
			}
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow basicGetIncoming() {
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncoming(DataFlow newIncoming, NotificationChain msgs) {
		DataFlow oldIncoming = incoming;
		incoming = newIncoming;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					CALPackage.APPLICATION_DATA_PIN__INCOMING, oldIncoming, newIncoming);
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
	public void setIncoming(DataFlow newIncoming) {
		if (newIncoming != incoming) {
			NotificationChain msgs = null;
			if (incoming != null)
				msgs = ((InternalEObject) incoming).eInverseRemove(this, CALPackage.DATA_FLOW__TARGET, DataFlow.class,
						msgs);
			if (newIncoming != null)
				msgs = ((InternalEObject) newIncoming).eInverseAdd(this, CALPackage.DATA_FLOW__TARGET, DataFlow.class,
						msgs);
			msgs = basicSetIncoming(newIncoming, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.APPLICATION_DATA_PIN__INCOMING,
					newIncoming, newIncoming));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.APPLICATION_DATA_PIN__NAME, oldName,
					name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.APPLICATION_DATA_PIN__DATA_MULTIPLICITY,
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.APPLICATION_DATA_PIN__TOKEN_MULTIPLICITY,
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.APPLICATION_DATA_PIN__BINDING, oldBinding,
					binding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CALPackage.APPLICATION_DATA_PIN__OUTGOING:
			if (outgoing != null)
				msgs = ((InternalEObject) outgoing).eInverseRemove(this, CALPackage.DATA_FLOW__SOURCE, DataFlow.class,
						msgs);
			return basicSetOutgoing((DataFlow) otherEnd, msgs);
		case CALPackage.APPLICATION_DATA_PIN__INCOMING:
			if (incoming != null)
				msgs = ((InternalEObject) incoming).eInverseRemove(this, CALPackage.DATA_FLOW__TARGET, DataFlow.class,
						msgs);
			return basicSetIncoming((DataFlow) otherEnd, msgs);
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
		case CALPackage.APPLICATION_DATA_PIN__OUTGOING:
			return basicSetOutgoing(null, msgs);
		case CALPackage.APPLICATION_DATA_PIN__INCOMING:
			return basicSetIncoming(null, msgs);
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
		case CALPackage.APPLICATION_DATA_PIN__OUTGOING:
			if (resolve)
				return getOutgoing();
			return basicGetOutgoing();
		case CALPackage.APPLICATION_DATA_PIN__INCOMING:
			if (resolve)
				return getIncoming();
			return basicGetIncoming();
		case CALPackage.APPLICATION_DATA_PIN__NAME:
			return getName();
		case CALPackage.APPLICATION_DATA_PIN__DATA_MULTIPLICITY:
			return getDataMultiplicity();
		case CALPackage.APPLICATION_DATA_PIN__TOKEN_MULTIPLICITY:
			return getTokenMultiplicity();
		case CALPackage.APPLICATION_DATA_PIN__BINDING:
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
		case CALPackage.APPLICATION_DATA_PIN__OUTGOING:
			setOutgoing((DataFlow) newValue);
			return;
		case CALPackage.APPLICATION_DATA_PIN__INCOMING:
			setIncoming((DataFlow) newValue);
			return;
		case CALPackage.APPLICATION_DATA_PIN__NAME:
			setName((String) newValue);
			return;
		case CALPackage.APPLICATION_DATA_PIN__DATA_MULTIPLICITY:
			setDataMultiplicity((Multiplicity) newValue);
			return;
		case CALPackage.APPLICATION_DATA_PIN__TOKEN_MULTIPLICITY:
			setTokenMultiplicity((Multiplicity) newValue);
			return;
		case CALPackage.APPLICATION_DATA_PIN__BINDING:
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
		case CALPackage.APPLICATION_DATA_PIN__OUTGOING:
			setOutgoing((DataFlow) null);
			return;
		case CALPackage.APPLICATION_DATA_PIN__INCOMING:
			setIncoming((DataFlow) null);
			return;
		case CALPackage.APPLICATION_DATA_PIN__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CALPackage.APPLICATION_DATA_PIN__DATA_MULTIPLICITY:
			setDataMultiplicity(DATA_MULTIPLICITY_EDEFAULT);
			return;
		case CALPackage.APPLICATION_DATA_PIN__TOKEN_MULTIPLICITY:
			setTokenMultiplicity(TOKEN_MULTIPLICITY_EDEFAULT);
			return;
		case CALPackage.APPLICATION_DATA_PIN__BINDING:
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
		case CALPackage.APPLICATION_DATA_PIN__OUTGOING:
			return outgoing != null;
		case CALPackage.APPLICATION_DATA_PIN__INCOMING:
			return incoming != null;
		case CALPackage.APPLICATION_DATA_PIN__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case CALPackage.APPLICATION_DATA_PIN__DATA_MULTIPLICITY:
			return dataMultiplicity != DATA_MULTIPLICITY_EDEFAULT;
		case CALPackage.APPLICATION_DATA_PIN__TOKEN_MULTIPLICITY:
			return tokenMultiplicity != TOKEN_MULTIPLICITY_EDEFAULT;
		case CALPackage.APPLICATION_DATA_PIN__BINDING:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DataPin.class) {
			switch (derivedFeatureID) {
			case CALPackage.APPLICATION_DATA_PIN__NAME:
				return CALPackage.DATA_PIN__NAME;
			case CALPackage.APPLICATION_DATA_PIN__DATA_MULTIPLICITY:
				return CALPackage.DATA_PIN__DATA_MULTIPLICITY;
			case CALPackage.APPLICATION_DATA_PIN__TOKEN_MULTIPLICITY:
				return CALPackage.DATA_PIN__TOKEN_MULTIPLICITY;
			case CALPackage.APPLICATION_DATA_PIN__BINDING:
				return CALPackage.DATA_PIN__BINDING;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DataPin.class) {
			switch (baseFeatureID) {
			case CALPackage.DATA_PIN__NAME:
				return CALPackage.APPLICATION_DATA_PIN__NAME;
			case CALPackage.DATA_PIN__DATA_MULTIPLICITY:
				return CALPackage.APPLICATION_DATA_PIN__DATA_MULTIPLICITY;
			case CALPackage.DATA_PIN__TOKEN_MULTIPLICITY:
				return CALPackage.APPLICATION_DATA_PIN__TOKEN_MULTIPLICITY;
			case CALPackage.DATA_PIN__BINDING:
				return CALPackage.APPLICATION_DATA_PIN__BINDING;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //ApplicationDataPinImpl
