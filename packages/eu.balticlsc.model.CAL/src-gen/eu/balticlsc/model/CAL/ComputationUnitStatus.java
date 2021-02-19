/**
 */
package eu.balticlsc.model.CAL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Computation Unit Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.balticlsc.model.CAL.CALPackage#getComputationUnitStatus()
 * @model
 * @generated
 */
public enum ComputationUnitStatus implements Enumerator {
	/**
	 * The '<em><b>Created</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATED_VALUE
	 * @generated
	 * @ordered
	 */
	CREATED(0, "Created", "Created"),

	/**
	 * The '<em><b>Submitted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBMITTED_VALUE
	 * @generated
	 * @ordered
	 */
	SUBMITTED(1, "Submitted", "Submitted"),

	/**
	 * The '<em><b>Approved</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROVED_VALUE
	 * @generated
	 * @ordered
	 */
	APPROVED(2, "Approved", "Approved"),

	/**
	 * The '<em><b>Discontinued</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCONTINUED_VALUE
	 * @generated
	 * @ordered
	 */
	DISCONTINUED(3, "Discontinued", "Discontinued");

	/**
	 * The '<em><b>Created</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATED
	 * @model name="Created"
	 * @generated
	 * @ordered
	 */
	public static final int CREATED_VALUE = 0;

	/**
	 * The '<em><b>Submitted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBMITTED
	 * @model name="Submitted"
	 * @generated
	 * @ordered
	 */
	public static final int SUBMITTED_VALUE = 1;

	/**
	 * The '<em><b>Approved</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROVED
	 * @model name="Approved"
	 * @generated
	 * @ordered
	 */
	public static final int APPROVED_VALUE = 2;

	/**
	 * The '<em><b>Discontinued</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCONTINUED
	 * @model name="Discontinued"
	 * @generated
	 * @ordered
	 */
	public static final int DISCONTINUED_VALUE = 3;

	/**
	 * An array of all the '<em><b>Computation Unit Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ComputationUnitStatus[] VALUES_ARRAY = new ComputationUnitStatus[] { CREATED, SUBMITTED,
			APPROVED, DISCONTINUED, };

	/**
	 * A public read-only list of all the '<em><b>Computation Unit Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ComputationUnitStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Computation Unit Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComputationUnitStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComputationUnitStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Computation Unit Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComputationUnitStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComputationUnitStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Computation Unit Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComputationUnitStatus get(int value) {
		switch (value) {
		case CREATED_VALUE:
			return CREATED;
		case SUBMITTED_VALUE:
			return SUBMITTED;
		case APPROVED_VALUE:
			return APPROVED;
		case DISCONTINUED_VALUE:
			return DISCONTINUED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ComputationUnitStatus(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //ComputationUnitStatus
