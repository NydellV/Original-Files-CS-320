import java.util.HashMap;
import java.util.Map;

//  manages a list of appointments
public class AppointmentService {
    // Map to store appointments using their ID 
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Adds a new appointment to the list
    public void addAppointment(Appointment appointment) {
        // Check if the appointment ID already exists
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        // Add the new appointment
        appointments.put(appointment.getAppointmentId(), appointment);
    }




    
    // Deletes an appointment by ID
    public void deleteAppointment(String appointmentId) {
        // If the ID is not found, throw an error
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }

        // Remove the appointment from the list
        appointments.remove(appointmentId);
    }

    // Gets an appointment by ID 
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
