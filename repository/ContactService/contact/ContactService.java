package contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/***********************************************
 * class ContactService()
 * 
 * Description: This class instantiates a service
 * for contacts. It contains a hash map for storing
 * individual contacts and methods to remove and 
 * modify elements after storage.
 * 
 ***********************************************
 */
public class ContactService {
	
	// Constructor 
	public ContactService() {}
	
	// Hash map using contact ID and Contact object as k, v pair
	private final Map<String, Contact> map = new HashMap<>();
	
	// Helper function to retrieve a contact using ID or throw if null
	private Contact getContactOrThrow(String contactID) {
		
		Objects.requireNonNull(contactID, "Contact ID cannot be null");
		
		Contact contact = map.get(contactID);
		
		if (contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		
		return contact;
	}
	
	// Helper function for testing to retrieve contact
	// Exposed for unit testing
	public Contact getContact(String id) {
		return map.get(id);
	}
	
	// Add contact to hash map unless null or duplicate
	public void addContact(Contact contact) {
		
		Objects.requireNonNull(contact, "Contact cannot be null");
		
		if (map.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		
		map.put(contact.getContactID(), contact);
		
	}
	
	// Delete contact from hash map
	public void deleteContact(String id) {
		
		map.remove(getContactOrThrow(id).getContactID());
	}
	
	// Find contact and update firstName
	public void updateFirstName (String id, String name) {
		
		getContactOrThrow(id).setFirstName(name);
	}
	
	// Find contact and update lastName
	public void updateLastName (String id, String name) {
		
		getContactOrThrow(id).setLastName(name);
		
	}
	
	// Find contact and update phoneNumber
	public void updatePhoneNumber(String id, String number) {
		
		getContactOrThrow(id).setPhoneNumber(number);
		
	}
	
	// Find contact and update address
	public void updateAddress(String id, String address) {
		
		getContactOrThrow(id).setAddress(address);
		
	}
}
