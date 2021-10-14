/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.DataPin#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.DataPin#getDataMultiplicity <em>Data Multiplicity</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.DataPin#getTokenMultiplicity <em>Token Multiplicity</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getDataPin()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DataPin extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.balticlsc.model.CAL.CALPackage#getDataPin_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.DataPin#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Data Multiplicity</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link eu.balticlsc.model.CAL.Multiplicity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Multiplicity</em>' attribute.
	 * @see eu.balticlsc.model.CAL.Multiplicity
	 * @see #setDataMultiplicity(Multiplicity)
	 * @see eu.balticlsc.model.CAL.CALPackage#getDataPin_DataMultiplicity()
	 * @model default=""
	 * @generated
	 */
	Multiplicity getDataMultiplicity();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.DataPin#getDataMultiplicity <em>Data Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Multiplicity</em>' attribute.
	 * @see eu.balticlsc.model.CAL.Multiplicity
	 * @see #getDataMultiplicity()
	 * @generated
	 */
	void setDataMultiplicity(Multiplicity value);

	/**
	 * Returns the value of the '<em><b>Token Multiplicity</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link eu.balticlsc.model.CAL.Multiplicity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Multiplicity</em>' attribute.
	 * @see eu.balticlsc.model.CAL.Multiplicity
	 * @see #setTokenMultiplicity(Multiplicity)
	 * @see eu.balticlsc.model.CAL.CALPackage#getDataPin_TokenMultiplicity()
	 * @model default=""
	 * @generated
	 */
	Multiplicity getTokenMultiplicity();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.DataPin#getTokenMultiplicity <em>Token Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Multiplicity</em>' attribute.
	 * @see eu.balticlsc.model.CAL.Multiplicity
	 * @see #getTokenMultiplicity()
	 * @generated
	 */
	void setTokenMultiplicity(Multiplicity value);

} // DataPin
