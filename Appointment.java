import java.util.Date;


public class Appointment {
    // Unique ID for the appointment
    private final String appointmentId;

    // Date and time when the appointment is scheduled
    private final Date appointmentDate;

    // Description of what the appointment is for
    private final String description;




    
    //  sets up a new appointment
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Checks to make sure the ID isn't null or too long
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        // CHecks the date is not in the past and not null
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }


        // Checks the description isn't null or too long
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }



        // Assign the values 
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Method toget the appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Method to get the appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // MEthod to get the appointment description
    public String getDescription() {
        return description;
    }
}
