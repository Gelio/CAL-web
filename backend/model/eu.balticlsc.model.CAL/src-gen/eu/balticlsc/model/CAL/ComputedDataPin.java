/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computed Data Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.ComputedDataPin#getCall <em>Call</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputedDataPin#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputedDataPin#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputedDataPin#getDeclared <em>Declared</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getComputedDataPin()
 * @model
 * @generated
 */
public interface ComputedDataPin extends EObject {
	/**
	 * Returns the value of the '<em><b>Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.UnitCall#getPins <em>Pins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call</em>' container reference.
	 * @see #setCall(UnitCall)
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputedDataPin_Call()
	 * @see eu.balticlsc.model.CAL.UnitCall#getPins
	 * @model opposite="pins" required="true" transient="false"
	 * @generated
	 */
	UnitCall getCall();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ComputedDataPin#getCall <em>Call</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call</em>' container reference.
	 * @see #getCall()
	 * @generated
	 */
	void setCall(UnitCall value);

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.DataFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference.
	 * @see #setIncoming(DataFlow)
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputedDataPin_Incoming()
	 * @see eu.balticlsc.model.CAL.DataFlow#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	DataFlow getIncoming();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ComputedDataPin#getIncoming <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(DataFlow value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.DataFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference.
	 * @see #setOutgoing(DataFlow)
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputedDataPin_Outgoing()
	 * @see eu.balticlsc.model.CAL.DataFlow#getSource
	 * @model opposite="source"
	 * @generated
	 */
	DataFlow getOutgoing();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ComputedDataPin#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(DataFlow value);

	/**
	 * Returns the value of the '<em><b>Declared</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared</em>' reference.
	 * @see #setDeclared(DeclaredDataPin)
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputedDataPin_Declared()
	 * @model required="true"
	 * @generated
	 */
	DeclaredDataPin getDeclared();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ComputedDataPin#getDeclared <em>Declared</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared</em>' reference.
	 * @see #getDeclared()
	 * @generated
	 */
	void setDeclared(DeclaredDataPin value);

} // ComputedDataPin
