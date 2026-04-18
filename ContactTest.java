import static org.junit.jupiter.api.Assertions.*; // Import JUnit assertions
import org.junit.jupiter.api.Test; // Import JUnit test framework

public class ContactTest {

    // Test if a contact object is created correctly with valid inputs
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "Nydell", "Vera", "2815555555", "16777 Cypress Rd");

        assertEquals("12345", contact.getContactId());
        assertEquals("Nydell", contact.getFirstName());
        assertEquals("Vera", contact.getLastName());
        assertEquals("2815555555", contact.getPhone());
        assertEquals("16777 Cypress Rd", contact.getAddress());
    }

    // Test invalid contact ID
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Nydell", "Vera", "2815555555", "16777 Cypress Rd"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Nydell", "Vera", "2815555555", "16777 Cypress Rd"));
    }

    // Test invalid phone number
    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Nydell", "Vera", "12345", "16777 Cypress Rd"));
    }
}
