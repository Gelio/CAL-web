/**
 */
package eu.balticlsc.model.CAL.impl;

import eu.balticlsc.model.CAL.CALPackage;
import eu.balticlsc.model.CAL.ComputedDataPin;
import eu.balticlsc.model.CAL.DataFlow;
import eu.balticlsc.model.CAL.DataPin;
import eu.balticlsc.model.CAL.DeclaredDataPin;
import eu.balticlsc.model.CAL.UnitCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computed Data Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputedDataPinImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputedDataPinImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputedDataPinImpl#getCall <em>Call</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.impl.ComputedDataPinImpl#getDeclared <em>Declared</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputedDataPinImpl extends MinimalEObjectImpl.Container implements ComputedDataPin {
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
	 * The cached value of the '{@link #getDeclared() <em>Declared</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclared()
	 * @generated
	 * @ordered
	 */
	protected DeclaredDataPin declared;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputedDataPinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CALPackage.Literals.COMPUTED_DATA_PIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitCall getCall() {
		if (eContainerFeatureID() != CALPackage.COMPUTED_DATA_PIN__CALL)
			return null;
		return (UnitCall) eInternalContainer();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CALPackage.COMPUTED_DATA_PIN__INCOMING,
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
					CALPackage.COMPUTED_DATA_PIN__INCOMING, oldIncoming, newIncoming);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.COMPUTED_DATA_PIN__INCOMING, newIncoming,
					newIncoming));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CALPackage.COMPUTED_DATA_PIN__OUTGOING,
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
					CALPackage.COMPUTED_DATA_PIN__OUTGOING, oldOutgoing, newOutgoing);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.COMPUTED_DATA_PIN__OUTGOING, newOutgoing,
					newOutgoing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeclaredDataPin getDeclared() {
		if (declared != null && declared.eIsProxy()) {
			InternalEObject oldDeclared = (InternalEObject) declared;
			declared = (DeclaredDataPin) eResolveProxy(oldDeclared);
			if (declared != oldDeclared) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CALPackage.COMPUTED_DATA_PIN__DECLARED,
							oldDeclared, declared));
			}
		}
		return declared;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredDataPin basicGetDeclared() {
		return declared;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeclared(DeclaredDataPin newDeclared) {
		DeclaredDataPin oldDeclared = declared;
		declared = newDeclared;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CALPackage.COMPUTED_DATA_PIN__DECLARED, oldDeclared,
					declared));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CALPackage.COMPUTED_DATA_PIN__OUTGOING:
			if (outgoing != null)
				msgs = ((InternalEObject) outgoing).eInverseRemove(this, CALPackage.DATA_FLOW__SOURCE, DataFlow.class,
						msgs);
			return basicSetOutgoing((DataFlow) otherEnd, msgs);
		case CALPackage.COMPUTED_DATA_PIN__INCOMING:
			if (incoming != null)
				msgs = ((InternalEObject) incoming).eInverseRemove(this, CALPackage.DATA_FLOW__TARGET, DataFlow.class,
						msgs);
			return basicSetIncoming((DataFlow) otherEnd, msgs);
		case CALPackage.COMPUTED_DATA_PIN__CALL:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return eBasicSetContainer(otherEnd, CALPackage.COMPUTED_DATA_PIN__CALL, msgs);
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
		case CALPackage.COMPUTED_DATA_PIN__OUTGOING:
			return basicSetOutgoing(null, msgs);
		case CALPackage.COMPUTED_DATA_PIN__INCOMING:
			return basicSetIncoming(null, msgs);
		case CALPackage.COMPUTED_DATA_PIN__CALL:
			return eBasicSetContainer(null, CALPackage.COMPUTED_DATA_PIN__CALL, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case CALPackage.COMPUTED_DATA_PIN__CALL:
			return eInternalContainer().eInverseRemove(this, CALPackage.UNIT_CALL__PINS, UnitCall.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CALPackage.COMPUTED_DATA_PIN__OUTGOING:
			if (resolve)
				return getOutgoing();
			return basicGetOutgoing();
		case CALPackage.COMPUTED_DATA_PIN__INCOMING:
			if (resolve)
				return getIncoming();
			return basicGetIncoming();
		case CALPackage.COMPUTED_DATA_PIN__CALL:
			return getCall();
		case CALPackage.COMPUTED_DATA_PIN__DECLARED:
			if (resolve)
				return getDeclared();
			return basicGetDeclared();
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
		case CALPackage.COMPUTED_DATA_PIN__OUTGOING:
			setOutgoing((DataFlow) newValue);
			return;
		case CALPackage.COMPUTED_DATA_PIN__INCOMING:
			setIncoming((DataFlow) newValue);
			return;
		case CALPackage.COMPUTED_DATA_PIN__DECLARED:
			setDeclared((DeclaredDataPin) newValue);
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
		case CALPackage.COMPUTED_DATA_PIN__OUTGOING:
			setOutgoing((DataFlow) null);
			return;
		case CALPackage.COMPUTED_DATA_PIN__INCOMING:
			setIncoming((DataFlow) null);
			return;
		case CALPackage.COMPUTED_DATA_PIN__DECLARED:
			setDeclared((DeclaredDataPin) null);
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
		case CALPackage.COMPUTED_DATA_PIN__OUTGOING:
			return outgoing != null;
		case CALPackage.COMPUTED_DATA_PIN__INCOMING:
			return incoming != null;
		case CALPackage.COMPUTED_DATA_PIN__CALL:
			return getCall() != null;
		case CALPackage.COMPUTED_DATA_PIN__DECLARED:
			return declared != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public DataPin getDataPin() {
		return getDeclared();
	}

} //ComputedDataPinImpl
