package contact;

import java.util.Objects;

/***********************************************
 * class Contact()
 * 
 * Description: This class holds contact information,
 * each using a unique ID that will be stored in a
 * hash map.
 * 
 ***********************************************
 */

public class Contact {
	
	// Class Attributes
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Constructor with input validation
	public Contact (String contactID,
					String firstName,
					String lastName,
					String phoneNumber,
					String address) {
		
		validateContactID(contactID);
		validateFirstName(firstName);
		validateLastName(lastName);
		validatePhoneNumber(phoneNumber);
		validateAddress(address);
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	// Getter for ID
	public String getContactID() {
		return contactID;
	}

	// Getter for firstName
	public String getFirstName() {	
		return firstName;
	}

	// Setter for firstName w/ validation
	public void setFirstName(String firstName) {
		
		validateFirstName(firstName);		
		this.firstName = firstName;
	}
	
	// Getter for lastName
	public String getLastName() {
		return lastName;
	}
	
	// Setter for lastName w/ validation
	public void setLastName(String lastName) {
		
		validateLastName(lastName);
		this.lastName = lastName;
	}
	
	// Getter for phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	// Setter for phoneNumber w/ validation
	public void setPhoneNumber(String phoneNumber) {
		
		validatePhoneNumber(phoneNumber);
		this.phoneNumber = phoneNumber;
	}
	
	
	// Getter for address
	public String getAddress() {
		return address;
	}
	
	// Setter for address w/ validation
	public void setAddress(String address) {
	
		validateAddress(address);
		this.address = address;
	}
	
	private static void validateContactID(String contactID) {
		
		Objects.requireNonNull(contactID, "Contact ID cannot be null");
		
		if (contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID too long");
		}
	}
	
	private static void validateFirstName(String firstName) {
		
		Objects.requireNonNull(firstName, "First name cannot be null");
		
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name too long");
		}
	}
	
	private static void validateLastName(String lastName) {
		
		Objects.requireNonNull(lastName, "Last name cannot be null");
		
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name too long");
		}
	}
	
	private static void validatePhoneNumber(String phoneNumber) { 
		
		Objects.requireNonNull(phoneNumber, "Phone number cannot be null");
		
		if (phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Phone number must contain 10 digits Ex: 2135550000");
		}
		
		for (int i = 0; i < phoneNumber.length(); i++) {
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				throw new IllegalArgumentException("Phone number may only contain numbers");
			}
		}
	}
	
	private static void validateAddress(String address) {
		
		Objects.requireNonNull(address, "Address cannot be null");
		
		if (address.length() > 30) {
			throw new IllegalArgumentException("Address too long");
		}
		
	}
	
	@Override
	public String toString() {
		return "Contact [contactID =" + contactID
				+ ", firstName= " + firstName
				+ ", lastName= " + lastName
				+ ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) { return true;}
		
		if (!(obj instanceof Contact)) { return false;}
		
		Contact other = (Contact) obj;
		
		return contactID.equals(other.contactID);
	}
	
	@Override
	public int hashCode() { return contactID.hashCode();}
}