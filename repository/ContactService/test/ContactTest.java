package test;

import static org.junit.jupiter.api.Assertions.*;
import contact.Contact;
import org.junit.jupiter.api.Test;



class ContactTest {

	@Test
	void testContactGetters() {
		Contact contact = new Contact(
				"12345",
				"firstName",
				"lastName",
				"7175555055",
				"address");
		assertEquals("12345", contact.getContactID());
		assertEquals("firstName", contact.getFirstName());
		assertEquals("lastName", contact.getLastName());
		assertEquals("7175555055", contact.getPhoneNumber());
		assertEquals("address", contact.getAddress());
	}
	
	
	@Test
	void testContactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
				new Contact(
					"12345678901",
					"firstName",
					"lastName",
					"7175555055",
					"address");
		});         
				
	}
	
	@Test
	void testContactIDNull() {
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					null,
					"firstName",
					"lastName",
					"7175555055",
					"address");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345",
					"12345678901",
					"lastName",
					"7175555055",
					"address");
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345",
					null,
					"lastName",
					"7175555055",
					"address");
		});
	}
	
	@Test
	void testContactLastNameTooLong () {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					"12345678901",
					"7175555055",
					"address");
		});
	}
	
	@Test
	void testContactLastNameNull() {
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					null,
					"7175555055",
					"address");
		});
	}
	
	@Test
	void testContactPhoneNumberTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					"lastName",
					"12345678901",
					"address");
		});
	}
	
	@Test
	void testContactPhoneNumberTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					"lastName",
					"123456789",
					"address");
		});
	}
	
	@Test
	void testContactPhoneNumberNull() {
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					"lastName",
					null,
					"address");
		});
	}
	
	@Test
	void testContactPhoneNumberHasLetters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					"lastName",
					"717555505B",
					"address");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					"lastName",
					"7175555055",
					"1234567890123456789012345678901");
		});
	}
	
	@Test
	void testContactAddressNull() {
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345",
					"firstName",
					"lastName",
					"7175555055",
					null);
		});
	}
	
	@Test
	void testContactFieldsMaxLength() {
		Contact contact = new Contact(
				"1234567890",
				"1234567890",
				"1234567890",
				"7175555055",
				"123456789012345678901234567890");
		assertEquals("1234567890", contact.getContactID());
		assertEquals("1234567890", contact.getFirstName());
		assertEquals("1234567890", contact.getLastName());
		assertEquals("123456789012345678901234567890", contact.getAddress());
		
	}
	
	@Test
	void testContactSetters() {
		Contact contact = new Contact(
				"12345",
				"firstName",
				"lastName",
				"7175555055",
				"address");
		
		contact.setFirstName("newFirst");
		contact.setLastName("newLast");
		contact.setPhoneNumber("1112223333");
		contact.setAddress("newAddress");
		
		assertEquals("newFirst", contact.getFirstName());
		assertEquals("newLast", contact.getLastName());
		assertEquals("1112223333", contact.getPhoneNumber());
		assertEquals("newAddress", contact.getAddress());	
	}
	
	@Test
	void testContactSetFirstNameTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setFirstName(
							"12345678901");
		});
	}
	
	@Test
	void testContactSetFirstNameNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setFirstName(
							null);
		});
	}
	
	@Test
	void testContactSetLastNameTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setLastName(
							"12345678901");
		});
	}
	
	@Test
	void testContactSetLastNameNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setLastName(
							null);
		});
	}
	
	@Test
	void testContactSetPhoneNumberTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setPhoneNumber(
							"12345678901");
		});
	}
	
	@Test
	void testContactSetPhoneNumberLetters() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setPhoneNumber(
							"123456789Z");
		});
	}
	
	@Test
	void testContactSetPhoneNumberNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setPhoneNumber(
							null);
		});
	}
	
	@Test
	void testContactSetAddressTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setAddress(
							"1234567890123456789012345678901");
		});
	}
	
	@Test
	void testContactSetAddressNull() {
		
		assertThrows(NullPointerException.class, () -> {
			new Contact(
					"12345", "first", "last", "7175555055", "address").setAddress(
							null);
		});
	}
	
	@Test
	void testContactIDNoSetter() {
		
		assertThrows(NoSuchMethodException.class, () -> {
			Contact.class.getDeclaredMethod("setContactID", String.class);
		});
	}
}
