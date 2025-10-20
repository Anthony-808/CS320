package contactservice.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contactservice.Contact;

public class ContactTest {
	// Valid values for each field
	private static final String VALID_ID = "abc123";
	private static final String VALID_FIRST = "jon";
	private static final String VALID_LAST = "snow";
	private static final String VALID_PHONE = "1234567890";
	private static final String VALID_ADDRESS = "iceland";
	
	// ----- Positive Tests (where valid values are passed) -----
	@Test
	void testValidFieldValues() {
		Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
		assertTrue(contact.getContactID().equals(VALID_ID));
		assertTrue(contact.getFirstName().equals(VALID_FIRST));
		assertTrue(contact.getLastName().equals(VALID_LAST));
		assertTrue(contact.getPhone().equals(VALID_PHONE));
		assertTrue(contact.getAddress().equals(VALID_ADDRESS));
	}
	
	// ----- Negative Tests (where an invalid value is passed for a field) -----
	@Test
	void testNullContactID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
		});
	}
	
	@Test
	void testContactIDToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("abcdefghijk", VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
		});
		
	}
	
	@Test 
	void testNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, null, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
		});
	}
	
	@Test 
	void testFirstNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, "Octaviousnes", VALID_LAST, VALID_PHONE, VALID_ADDRESS);
		});
	}
	
	@Test 
	void testNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, VALID_FIRST, null, VALID_PHONE, VALID_ADDRESS);
		});
	}
	
	@Test 
	void testLastNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, VALID_FIRST, "Oppenheimer", VALID_PHONE, VALID_ADDRESS);
		});
	}
	
	@Test 
	void testNullPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, VALID_FIRST, VALID_LAST, null, VALID_ADDRESS);
		});
	}
	
	@Test 
	void testPhoneToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, VALID_FIRST, VALID_LAST, "12345678901", VALID_ADDRESS);
		});
	}
	
	@Test 
	void testNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, null);
		});
	}
	
	@Test 
	void testAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, "Orange house on the first corner, past McDonalds");
		});
	}
	
	@Test
	void testSetFirstNameValid() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    contact.setFirstName("George");
	    assertTrue(contact.getFirstName().equals("George"));
	}

	@Test
	void testSetFirstNameTooLong() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setFirstName("reallylongname");
	    });
	}
	
	@Test
	void testSetLastNameValid() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    contact.setLastName("Carlin");
	    assertTrue(contact.getLastName().equals("Carlin"));
	}

	@Test
	void testSetLastNameTooLong() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setLastName("reallylongname");
	    });
	}
	
	@Test
	void testSetPhoneValid() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    contact.setPhone("9891234567");
	    assertTrue(contact.getPhone().equals("9891234567"));
	}
	
	@Test
	void testSetPhoneToShort() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setPhone("123456789");
	    });
	}

	@Test
	void testSetPhoneToLong() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setPhone("12345678901");
	    });
	}
	
	@Test
	void testSetAddressValid() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    contact.setAddress("123 First Street");
	    assertTrue(contact.getAddress().equals("123 First Street"));
	}

	@Test
	void testSetAddressToLong() {
	    Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setAddress("12345 South Pumpernickle Avenue Unit A");
	    });
	}
	
	
}
