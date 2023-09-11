package assignments.assign02;

/**
 * This class represents a University of Utah student, in which the uNID cannot
 * change once the student is created.  Note that each student's uNID is unique.
 * 
 * @author Aaron Wood and Stewart Russell
 * @version 2023-08-31 
 */
public class UofUStudent {

	private String firstName;
	
	private String lastName;
	
	private int uNID;
	
	/**
	 * Creates a student from the given first name, last name, and uNID.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param uNID
	 */
	public UofUStudent(String firstName, String lastName, int uNID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.uNID = uNID;
	}

	/**
	 * Getter method for the first name field of this student object.
	 * 
	 * @return this student's first name
	 */
	public String getFirstName() {
		return this.firstName;
	}


	/**
	 * Getter method for the last name field of this student object.
	 * 
	 * @return this student's last name
	 */
	public String getLastName() {
		return this.lastName;
	}


	/**
	 * Getter method for the uNID field of this student object.
	 * 
	 * @return this student's uNID
	 */
	public int getUNID() {
		return this.uNID;
	}
	
	/**
	 * Setter method for the name fields of this student object.
	 * 
	 * NOTE: This method is provided since a student's name(s) may change.
	 *       No setter method is provided for the uNID, since it may not change.
	 * 
	 * @param firstName - updated first name
	 * @param lastName - updated last name
	 */
	public void updateName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Two University of Utah students are considered equal if they have the same uNID.
	 * 
	 * @param other - the object being compared with this student
	 * @return true if the other object is a UofUStudent type and is equal to this student, 
	 *         false otherwise
	 */
	public boolean equals(Object other) {
		if(!(other instanceof UofUStudent)) return false;

		return ((UofUStudent) other).uNID == this.uNID;
	}

	/**
	 * Returns a textual representation of this student.
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + " (u" + String.format("%07d", this.uNID) + ")";
	}
}