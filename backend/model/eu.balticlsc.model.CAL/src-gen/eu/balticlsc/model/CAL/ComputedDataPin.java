/**
 */
package eu.balticlsc.model.CAL;

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
 *   <li>{@link eu.balticlsc.model.CAL.ComputedDataPin#getDeclared <em>Declared</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getComputedDataPin()
 * @model
 * @generated
 */
public interface ComputedDataPin extends ConnectableDataPin {
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
