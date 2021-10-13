/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Application Release</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getCalls <em>Calls</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getFlows <em>Flows</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getUnits <em>Units</em>}</li>
 *   <li>{@link eu.balticlsc.model.CAL.ComputationApplicationRelease#getApplicationDataPins <em>Application Data Pins</em>}</li>
 * </ul>
 *
 * @see eu.balticlsc.model.CAL.CALPackage#getComputationApplicationRelease()
 * @model
 * @generated
 */
public interface ComputationApplicationRelease extends EObject {
	/**
	 * Returns the value of the '<em><b>Calls</b></em>' containment reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.UnitCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls</em>' containment reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationApplicationRelease_Calls()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnitCall> getCalls();

	/**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.DataFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationApplicationRelease_Flows()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataFlow> getFlows();

	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.ComputationUnitRelease}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationApplicationRelease_Units()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputationUnitRelease> getUnits();

	/**
	 * Returns the value of the '<em><b>Application Data Pins</b></em>' containment reference list.
	 * The list contents are of type {@link eu.balticlsc.model.CAL.ApplicationDataPin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Data Pins</em>' containment reference list.
	 * @see eu.balticlsc.model.CAL.CALPackage#getComputationApplicationRelease_ApplicationDataPins()
	 * @model containment="true"
	 * @generated
	 */
	EList<ApplicationDataPin> getApplicationDataPins();

} // ComputationApplicationRelease
