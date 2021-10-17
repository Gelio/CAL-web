/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connectable Data Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.ConnectableDataPin#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ConnectableDataPin#getIncoming <em>Incoming</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getConnectableDataPin()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ConnectableDataPin extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.DataFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference.
	 * @see #setOutgoing(DataFlow)
	 * @see eu.balticlsc.model.CAL.CALPackage#getConnectableDataPin_Outgoing()
	 * @see eu.balticlsc.model.CAL.DataFlow#getSource
	 * @model opposite="source"
	 * @generated
	 */
	DataFlow getOutgoing();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ConnectableDataPin#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(DataFlow value);

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.DataFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference.
	 * @see #setIncoming(DataFlow)
	 * @see eu.balticlsc.model.CAL.CALPackage#getConnectableDataPin_Incoming()
	 * @see eu.balticlsc.model.CAL.DataFlow#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	DataFlow getIncoming();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ConnectableDataPin#getIncoming <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(DataFlow value);

	/**
	 * Gets the underlying DataPin for a given ConnectableDataPin.
	 * This is necessary because some ConnectableDataPins are based on another
	 * DataPin (e.g. ComputedDataPin is based on DeclaredDataPin).
	 */
	DataPin getDataPin();

} // ConnectableDataPin
