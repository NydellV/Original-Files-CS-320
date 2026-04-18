import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // Test adding and getting a contact
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Amber", "Bernal", "1234567890", "16888 Ranch St");

        service.addContact(contact);

        assertEquals(contact, service.getContact("001"));
    }

    // Test deleting a contact
    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("002", "Amber", "Bernal", "1234567890", "16888 Ranch St");

        service.addContact(contact);
        service.deleteContact("002");

        assertNull(service.getContact("002"));
    }

    // Test updating first name
    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("003", "Amber", "Bernal", "1234567890", "16888 Ranch St");

        service.addContact(contact);
        service.updateFirstName("003", "Emily");

        assertEquals("Emily", service.getContact("003").getFirstName());
    }
}
