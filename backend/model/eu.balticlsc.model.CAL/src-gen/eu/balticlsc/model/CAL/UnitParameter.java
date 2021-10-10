/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.UnitParameter#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.UnitParameter#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getUnitParameter()
 * @model
 * @generated
 */
public interface UnitParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.UnitParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.balticlsc.model.CAL.UnitParamType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eu.balticlsc.model.CAL.UnitParamType
	 * @see #setType(UnitParamType)
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitParameter_Type()
	 * @model
	 * @generated
	 */
	UnitParamType getType();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.UnitParameter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eu.balticlsc.model.CAL.UnitParamType
	 * @see #getType()
	 * @generated
	 */
	void setType(UnitParamType value);

} // UnitParameter
