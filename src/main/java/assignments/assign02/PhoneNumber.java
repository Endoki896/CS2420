package assignments.assign02;

/**
 * This class represents a phone number.
 * 
 * @author Aaron Wood
 * @version 2023-08-31 
 */
public class PhoneNumber {

	private String areaCode;

	private String trunk;

	private String rest;

	/**
	 * Parses the given string to create a phone number.
	 * 
	 * @param phoneNum - the given string, representing a phone number
	 */
	public PhoneNumber(String phoneNum) {
		phoneNum = phoneNum.replaceAll("-|\\s|\\.|\\(|\\)", "");

		boolean isValid = true;
		if(phoneNum.length() != 10)
			isValid = false;
		for(int i = 0; isValid && i < 10; i++)
			if(!Character.isDigit(phoneNum.charAt(i)))
				isValid = false;

		if(isValid) {
			this.areaCode = phoneNum.substring(0, 3);
			this.trunk = phoneNum.substring(3, 6);
			this.rest = phoneNum.substring(6, 10);
		}
		else {
			this.areaCode = "000";
			this.trunk = "000";
			this.rest = "000";
			System.err.println("Phone number \"" + phoneNum + "\" is not formatted correctly, initializing as " + 
					             toString() + ".");
		}
	}

	/**
	 * Two phone numbers are considered equal if they have the same area code, trunk, and remaining numbers.
	 * 
	 * @param other - the object being compared with this phone number
	 * @return true if the other object is a PhoneNumer type and is equal to this phone number, 
	 *         false otherwise
	 */
	public boolean equals(Object other) {
		if(!(other instanceof PhoneNumber))
			return false;

		PhoneNumber rhs = (PhoneNumber) other;
		PhoneNumber lhs = this;

		return lhs.areaCode.equals(rhs.areaCode) && lhs.trunk.equals(rhs.trunk) && lhs.rest.equals(rhs.rest);
	}

	/**
	 * Returns a textual representation of this phone number.
	 */
	public String toString() {
		return "(" + this.areaCode + ") " + this.trunk + "-" + this.rest;
	}
}