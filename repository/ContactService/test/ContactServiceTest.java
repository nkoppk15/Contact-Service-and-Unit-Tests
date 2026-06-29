package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.ContactService;
import contact.Contact;

/***********************************************
 * class ContactServiceTest()
 * 
 * Description: This class is a JUnit test class
 * for comprehensive unit testing of the ContactService
 * class.
 * 
 ***********************************************
 */


class ContactServiceTest {
	
	// Helper instances for testing purposes
	private ContactService service;
	private Contact contact;
	private Contact contactInMap;
	
	// Before each test, setup the service and two contacts,
	// one in the hash map and one ready to be added.
	@BeforeEach
	void setUp() {
		service = new ContactService();
		
		contact = new Contact(
				"000",
				"John",
				"Smith",
				"7175555055", 
				"1800 West Fifth Avenue");
		
		contactInMap = new Contact(
				"001",
				"Jim",
				"Jones",
				"7170001000", 
				"123 Main Street");
		
		service.addContact(contactInMap);
		}
		
	@Test
	void testContactServiceAddContact() {
		service.addContact(contact);
		
		Contact retrieved = service.getContact("000");
		
		assertNotNull(retrieved);
		assertEquals("000", retrieved.getContactID());
		assertEquals("John", retrieved.getFirstName());
		assertEquals("Smith", retrieved.getLastName());
		assertEquals("7175555055", retrieved.getPhoneNumber());
		assertEquals("1800 West Fifth Avenue", retrieved.getAddress());
		assertEquals(contact, retrieved);
	}
	
	@Test
	void testContactServiceAddDuplicateID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contactInMap);
		});
	}
	
	@Test
	void testContactServiceAddContactNull() {
		assertThrows(NullPointerException.class, () -> {
			service.addContact(null);
		});
	}
	
	@Test
	void testContactServiceDeleteContact() {
		service.deleteContact("001");
		assertNull(service.getContact("001"));
	}

	@Test
	void testContactServiceRemoveContactInvalidID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("999");
		});
	}
	
	@Test
	void testContactServiceRemoveContactNullID() {
		assertThrows(NullPointerException.class, () -> {
			service.deleteContact(null);
		});
	}
	
	@Test
	void testContactServiceUpdateFirstName() {
		service.updateFirstName("001", "Mike");
		assertEquals("Mike", service.getContact("001").getFirstName());
	}
	
	@Test
	void testContactServiceUpdateFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("001", "12345678901");
		});
	}
	
	@Test
	void testContactServiceUpdateFirstNameNull() {
		assertThrows(NullPointerException.class, () -> {
			service.updateFirstName("001", null);
		});
	}
	
	@Test
	void testContactServiceUpdateLastName() {
		service.updateLastName("001", "Albert");
		assertEquals("Albert", service.getContact("001").getLastName());
	}
	
	@Test
	void testContactServiceUpdateLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("001", "12345678901");
		});
	}
	
	@Test
	void testContactServiceUpdateLastNameNull() {
		assertThrows(NullPointerException.class, () -> {
			service.updateLastName("001", null);
		});
	}
	
	// Testing updatePhoneNumber function
	@Test
	void testContactServiceUpdatePhoneNumber() {
		service.updatePhoneNumber("001", "8885550000");
		assertEquals("8885550000", service.getContact("001").getPhoneNumber());
	}
	
	@Test
	void testContactServiceUpdatePhoneNumberTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("001", "12345678901");
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneNumberTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("001", "12345678");
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneNumberLetters() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("001", "123456789Z");
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneNumberNull() {
		assertThrows(NullPointerException.class, () -> {
			service.updatePhoneNumber("001", null);
		});
	}
	
	// Testing updateAddress function
	@Test
	void testContactServiceUpdateAddress() {
		service.updateAddress("001", "100 Smart Boulevard");
		assertEquals("100 Smart Boulevard", service.getContact("001").getAddress());
	}
	
	@Test
	void testContactServiceUpdateAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("001", "1234567890123456789012345678901");
		});
	}
	
	@Test
	void testContactServiceUpdateAddressNull() {
		assertThrows(NullPointerException.class, () -> {
			service.updateAddress("001", null);
		});
	}
	
	@Test
	void testContactServiceUpdateFirstNameNullID() {
		assertThrows(NullPointerException.class, () -> {
			service.updateFirstName(null, "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdateLastNameNullID() {
		assertThrows(NullPointerException.class, () -> {
			service.updateLastName(null, "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneNumberNullID() {
		assertThrows(NullPointerException.class, () -> {
			service.updatePhoneNumber(null, "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdateAddressNullID() {
		assertThrows(NullPointerException.class, () -> {
			service.updateAddress(null, "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdateFirstNameInvalidID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("999", "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdateLastNameInvalidID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("999", "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneNumberInvalidID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("999", "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdateAddressInvalidID() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("999", "1234567890");
		});
	}
	
}

