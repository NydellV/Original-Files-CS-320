import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;


public class AppointmentServiceTest {

    private AppointmentService service;
    private Appointment appointment;

    // runs before each test to set up fresh data
    @BeforeEach
    void setUp() {
        service = new AppointmentService();

        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DATE, 2); // Two days from now

        // Creating an appointment for testing
        appointment = new Appointment("CAM2025", futureDate.getTime(), "Paint and wheels");
    }

    // test checks if an appointment can be added
    @Test
    void testAddAppointment() {
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("CAM2025"));
    }



    //  checks that duplicate IDs can't be added
    @Test
    void testAddDuplicateAppointmentThrowsException() {
        service.addAppointment(appointment);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }



    //  checks if an appointment can be deleted
    @Test
    void testDeleteAppointment() {
        service.addAppointment(appointment);
        service.deleteAppointment("CAM2025");

        assertNull(service.getAppointment("CAM2025"));
    }


    
    //  checks if deleting a non-existent ID causes an error
    @Test
    void testDeleteNonExistentAppointmentThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("GHOSTID");
        });
    }
}
