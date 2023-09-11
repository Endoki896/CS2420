package assignments.assign02;

/**
 * This class represents a U.S. mailing address.
 * 
 * @author Aaron Wood
 * @version 2023-08-31 
 */
public class MailingAddress {
	
	private String street;
	
	private String city;
	
	private String state;
	
	private int zipCode;
	
	/**
	 * Creates a mailing address, given the street, city, state, and zip code.
	 * 
	 * @param street
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public MailingAddress(String street, String city, String state, int zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/**
	 * Two mailing addresses are considered equal if they have the same street, city, state, and zip code.
	 * 
	 * @param other - the object being compared with this mailing address
	 * @return true if the other object is a MailingAddress type and is equal to this mailing address, 
	 *         false otherwise
	 */
	public boolean equals(Object other) {
		if(!(other instanceof MailingAddress))
			return false;
		
		MailingAddress rhs = (MailingAddress) other;
		MailingAddress lhs = this;

		return lhs.street.equals(rhs.street) && lhs.city.equals(rhs.city) && 
				 lhs.state.equals(rhs.state) && lhs.zipCode == rhs.zipCode;
	}
	
	/**
	 * Returns a textual representation of this mailing address.
	 */
	public String toString() {
		return this.street + "\n" + this.city + ", " + this.state + "  " + this.zipCode;
	}
}