package contactservice.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactservice.ContactService;
import contactservice.Contact;

public class ContactServiceTest {
	// Valid field values
	private static final String VALID_ID = "abc123";
	private static final String VALID_FIRST = "jon";
	private static final String VALID_LAST = "snow";
	private static final String VALID_PHONE = "1234567890";
	private static final String VALID_ADDRESS = "iceland";
	
	// object to be tested
	ContactService service = new ContactService();
	
	// Helper method to reduce repeated code
	private Contact addValidContact(String id) {
        Contact contact = new Contact(id, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        service.addContact(contact);
        return contact;
    }
	
	@Test
	void testAddValidContact() {
		Contact contact = addValidContact(VALID_ID);
		Contact retrieved = service.getContact(VALID_ID);
		assertTrue(contact.getContactID().equals(retrieved.getContactID()));
	    assertTrue(contact.getFirstName().equals(retrieved.getFirstName()));
	    assertTrue(contact.getLastName().equals(retrieved.getLastName()));
	    assertTrue(contact.getPhone().equals(retrieved.getPhone()));
	    assertTrue(contact.getAddress().equals(retrieved.getAddress()));
		
	}
	
	@Test
	void testDuplicateContact() { // ensure duplicate values disallowed
		addValidContact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(new Contact(VALID_ID, "John", "Slow", "9876543210", "1234 Bob street"));
		});
	}
	
	@Test
	void testDeleteContact() {
		addValidContact(VALID_ID);
		service.deleteContact(VALID_ID);
		assertThrows(IllegalArgumentException.class, () -> {
	        service.getContact(VALID_ID);
	    });
	}
	
	@Test
	void testUpdateFirstName() {
	    addValidContact(VALID_ID);
	    service.updateContact(VALID_ID, "George", null, null, null);
	    assertTrue(service.getContact(VALID_ID).getFirstName().equals("George"));  
	}
	
	@Test
	void testUpdateLastName() {
		addValidContact(VALID_ID);
	    service.updateContact(VALID_ID, null, "Red", null, null);
	    assertTrue(service.getContact(VALID_ID).getLastName().equals("Red"));
	    
	}
	
	@Test
	void testUpdatePhone() {
	    addValidContact(VALID_ID);
	    service.updateContact(VALID_ID, null, null, "9876543210", null);
	    assertTrue(service.getContact(VALID_ID).getPhone().equals("9876543210"));
	}
	
	@Test
	void testUpdateAddress() {
	    addValidContact(VALID_ID);
	    service.updateContact(VALID_ID, null, null, null, "1234 Street");
	    assertTrue(service.getContact(VALID_ID).getAddress().equals("1234 Street"));
	    
	}
	
	@Test
    void testUpdateInvalidPhone() {
        addValidContact(VALID_ID);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(VALID_ID, null, null, "123", null); // too short
        });
    }
	
	 @Test
	    void testUpdateNonexistentContact() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            service.updateContact("nope", "name", null, null, null);
	        });
	    }
	
}
