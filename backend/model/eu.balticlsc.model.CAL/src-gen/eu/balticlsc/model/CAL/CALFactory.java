/**
 */
package eu.balticlsc.model.CAL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.balticlsc.model.CAL.CALPackage
 * @generated
 */
public interface CALFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CALFactory eINSTANCE = eu.balticlsc.model.CAL.impl.CALFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Unit Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Call</em>'.
	 * @generated
	 */
	UnitCall createUnitCall();

	/**
	 * Returns a new object of class '<em>Computed Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computed Data Pin</em>'.
	 * @generated
	 */
	ComputedDataPin createComputedDataPin();

	/**
	 * Returns a new object of class '<em>Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Flow</em>'.
	 * @generated
	 */
	DataFlow createDataFlow();

	/**
	 * Returns a new object of class '<em>Computation Unit Release</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation Unit Release</em>'.
	 * @generated
	 */
	ComputationUnitRelease createComputationUnitRelease();

	/**
	 * Returns a new object of class '<em>Unit Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Parameter</em>'.
	 * @generated
	 */
	UnitParameter createUnitParameter();

	/**
	 * Returns a new object of class '<em>Unit Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Parameter Value</em>'.
	 * @generated
	 */
	UnitParameterValue createUnitParameterValue();

	/**
	 * Returns a new object of class '<em>Declared Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declared Data Pin</em>'.
	 * @generated
	 */
	DeclaredDataPin createDeclaredDataPin();

	/**
	 * Returns a new object of class '<em>Computation Application Release</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation Application Release</em>'.
	 * @generated
	 */
	ComputationApplicationRelease createComputationApplicationRelease();

	/**
	 * Returns a new object of class '<em>Application Data Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Data Pin</em>'.
	 * @generated
	 */
	ApplicationDataPin createApplicationDataPin();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CALPackage getCALPackage();

} //CALFactory
