package contactservice;
import java.util.HashMap;

public class ContactService {
	// Allows storage and fast lookups of contact objects
	private HashMap<String, Contact> contacts = new HashMap<>();
	
	// Adds contact only if the ID doesn't already exist in HashMap
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact is null");
		}
		String id = contact.getContactID();
		if (contacts.containsKey(id)) {
			throw new IllegalArgumentException("Contact ID not unique");
		}
		contacts.put(id, contact);
	}
	
	// throw error if object to be deleted doesn't exist
	public void deleteContact(String id) {
		if (!contacts.containsKey(id)) {
			throw new IllegalArgumentException("Contact not found");
		}
		contacts.remove(id);
	}
	
	// allows for multiple fields to be updated at once
	// only the fields to be changed are validated
	public void updateContact(String contactID, String firstName, 
			String lastName, String phone, String address) {
		Contact contact = contacts.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		
		if (firstName != null) contact.setFirstName(firstName);
		if (lastName != null) contact.setLastName(lastName);
		if (phone != null) contact.setPhone(phone);
		if (address != null) contact.setAddress(address);
	}
	
	// Throws error if contact doesn't exist
	public Contact getContact(String contactID) {
		if (!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact not found");
		}
		return contacts.get(contactID);
	}
	
	
}
