/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.UnitCall#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.UnitCall#getStrength <em>Strength</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.UnitCall#getPins <em>Pins</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.UnitCall#getParameterValues <em>Parameter Values</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.UnitCall#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getUnitCall()
 * @model
 * @generated
 */
public interface UnitCall extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitCall_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.UnitCall#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Strength</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.balticlsc.model.CAL.UnitStrength}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strength</em>' attribute.
	 * @see eu.balticlsc.model.CAL.UnitStrength
	 * @see #setStrength(UnitStrength)
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitCall_Strength()
	 * @model
	 * @generated
	 */
	UnitStrength getStrength();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.UnitCall#getStrength <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strength</em>' attribute.
	 * @see eu.balticlsc.model.CAL.UnitStrength
	 * @see #getStrength()
	 * @generated
	 */
	void setStrength(UnitStrength value);

	/**
	 * Returns the value of the '<em><b>Pins</b></em>' containment reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.ComputedDataPin}.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.ComputedDataPin#getCall <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pins</em>' containment reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitCall_Pins()
	 * @see eu.balticlsc.model.CAL.ComputedDataPin#getCall
	 * @model opposite="call" containment="true" changeable="false"
	 * @generated
	 */
	EList<ComputedDataPin> getPins();

	/**
	 * Returns the value of the '<em><b>Parameter Values</b></em>' containment reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.UnitParameterValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Values</em>' containment reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitCall_ParameterValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnitParameterValue> getParameterValues();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #setUnit(ComputationUnitRelease)
	 * @see eu.balticlsc.model.CAL.CALPackage#getUnitCall_Unit()
	 * @see eu.balticlsc.model.CAL.ComputationUnitRelease#getCalls
	 * @model opposite="calls" required="true"
	 * @generated
	 */
	ComputationUnitRelease getUnit();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.UnitCall#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(ComputationUnitRelease value);

} // UnitCall
