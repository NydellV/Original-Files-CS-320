import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;


public class AppointmentTest {

    // checks if a valid appointment can be created


    @Test
    void testValidAppointmentCreation() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DATE, 1); // Schedule for tomorrow

        Appointment appointment = new Appointment("ZL12023", futureDate.getTime(), "Supercharger install");

        assertEquals("ZL12023", appointment.getAppointmentId());
        assertEquals("Supercharger install", appointment.getDescription());
        assertEquals(futureDate.getTime(), appointment.getAppointmentDate());
    }




    // checks if null ID throws an exception
    @Test
    void testInvalidAppointmentId() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DATE, 1);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate.getTime(), "Brake upgrade");
        });
    }




    // checks if a past date throws an exception
    @Test
    void testPastDateThrowsException() {
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DATE, -1); // Yesterday

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("SS1969", pastDate.getTime(), "Classic Camaro restoration");
        });
    }




    // This test checks if a long description throws an exception
    @Test
    void testLongDescriptionThrowsException() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DATE, 1);

        String longDesc = "Camaro needs full wrap, ceramic coat, interior clean, engine tune";

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("Z28MOD", futureDate.getTime(), longDesc);
        });
    }
}
