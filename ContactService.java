import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Store contacts in a HashMap using contactId as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact if the ID is unique
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact using contactId
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String newFirstName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setFirstName(newFirstName);
    }

    // Update last name
    public void updateLastName(String contactId, String newLastName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setLastName(newLastName);
    }

    // Update phone number
    public void updatePhone(String contactId, String newPhone) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setPhone(newPhone);
    }

    // Update address
    public void updateAddress(String contactId, String newAddress) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setAddress(newAddress);
    }

    // getting a contact 
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
