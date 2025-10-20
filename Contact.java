package contactservice;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Validate fields at construction
	public Contact(String contactID, String firstName,
			String lastName, String phone, String address) {
		
		validateString(contactID, "ID", 10);
		validateString(firstName, "First Name", 10);
		validateString(lastName, "Last Name", 10);
		validatePhone(phone);
		validateString(address, "Address", 30);
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters and Setters
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	} 
	
	public void setFirstName(String firstName) {
		validateString(firstName, "First Name", 10);
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		validateString(lastName, "Last Name", 10);
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		validatePhone(phone);
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		validateString(address, "Address", 30);
		this.address = address;
	}
	
	// Helper methods to mitigate repeated code
	private void validateString(String value, String fieldName, int maxLength) {
		if (value == null || value.length() > maxLength) {
			throw new IllegalArgumentException("Invalid " + fieldName);
		}
	}
	
	private void validatePhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone");
		}
	}
}
