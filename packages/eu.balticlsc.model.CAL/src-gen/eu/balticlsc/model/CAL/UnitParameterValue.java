/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.UnitParameterValue#getValue <em>Value</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.UnitParameterValue#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getUnitParameterValue()
 * @model
 * @generated
 */
public interface UnitParameterValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitParameterValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.UnitParameterValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(UnitParameter)
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitParameterValue_Declaration()
	 * @model required="true"
	 * @generated
	 */
	UnitParameter getDeclaration();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.UnitParameterValue#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(UnitParameter value);

} // UnitParameterValue
