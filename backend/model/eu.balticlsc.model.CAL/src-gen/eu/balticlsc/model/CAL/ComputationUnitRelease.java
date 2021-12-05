/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Unit Release</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getName <em>Name</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getVersion <em>Version</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getDeclaredPins <em>Declared Pins</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getComputationUnitRelease()
 * @model
 * @generated
 */
public interface ComputationUnitRelease extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationUnitRelease_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationUnitRelease_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link eu.balticlsc.model.CAL.ComputationUnitRelease#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Declared Pins</b></em>' containment reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.DeclaredDataPin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Pins</em>' containment reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationUnitRelease_DeclaredPins()
	 * @model containment="true"
	 * @generated
	 */
	EList<DeclaredDataPin> getDeclaredPins();

	/**
	 * Returns the value of the '<em><b>Calls</b></em>' reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.UnitCall}.
	 * It is bidirectional and its opposite is '{@link eu.balticlsc.model.CAL.UnitCall#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls</em>' reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationUnitRelease_Calls()
	 * @see eu.balticlsc.model.CAL.UnitCall#getUnit
	 * @model opposite="unit"
	 * @generated
	 */
	EList<UnitCall> getCalls();

} // ComputationUnitRelease
