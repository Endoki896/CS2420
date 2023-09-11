package assignments.assign02;

/**
 * This class represents an email address.
 * 
 * @author Aaron Wood
 * @version 2023-08-31 
 */
public class EmailAddress {
	
	private String userName;
	
	private String domainName;
	
	/**
	 * Creates an email address, given the user name and domain name.
	 * 
	 * @param userName
	 * @param domainName
	 */
	public EmailAddress(String userName, String domainName) {
		this.userName = userName;
		this.domainName = domainName;
	}
	
	/**
	 * Two email addresses are considered equal if they have the same user name and domain name.
	 * 
	 * @param other - the object being compared with this email address
	 * @return true if the other object is an EmailAddress type and is equal to this email address, 
	 *         false otherwise
	 */
	public boolean equals(Object other) {
		if(!(other instanceof EmailAddress))
			return false;

		EmailAddress rhs = (EmailAddress) other;
		EmailAddress lhs = this;

		return lhs.userName.equals(rhs.userName) && lhs.domainName.equals(rhs.domainName);
	}
	
	/**
	 * Returns a textual representation of this email address.
	 */
	public String toString() {
		return this.userName + "@" + this.domainName;
	}
}