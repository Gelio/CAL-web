/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.DataFlow#getTarget <em>Target</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.DataFlow#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getDataFlow()
 * @model
 * @generated
 */
public interface DataFlow extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.ComputedDataPin#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ComputedDataPin)
	 * @see eu.balticlsc.model.CAL.CALPackage#getDataFlow_Target()
	 * @see eu.balticlsc.model.CAL.ComputedDataPin#getIncoming
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	ComputedDataPin getTarget();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.DataFlow#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ComputedDataPin value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.ComputedDataPin#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ComputedDataPin)
	 * @see eu.balticlsc.model.CAL.CALPackage#getDataFlow_Source()
	 * @see eu.balticlsc.model.CAL.ComputedDataPin#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	ComputedDataPin getSource();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.DataFlow#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ComputedDataPin value);

} // DataFlow
