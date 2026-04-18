import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreationValid() {
        //  create a task 
        Task task = new Task("123", "Wash Camaro", "Clean the exterior and interior");
        // checking if everything was set right
        assertEquals("123", task.getTaskId());
        assertEquals("Wash Camaro", task.getName());
        assertEquals("Clean the exterior and interior", task.getDescription());
    }

    @Test
    public void testSetNameValid() {
        // changing the task name 
        Task task = new Task("456", "Temp Task", "Just a test");
        task.setName("Oil Change Camaro");
        // making sure the new name is set
        assertEquals("Oil Change Camaro", task.getName());
    }

    @Test
    public void testSetDescriptionValid() {
        // updating the task description
        Task task = new Task("789", "Tune Camaro", "Basic tuning");
        task.setDescription("Tune Camaro for better performance");
        // checking that description updated
        assertEquals("Tune Camaro for better performance", task.getDescription());
    }

    @Test
    public void testTaskIdNotUpdatable() {
        // task ID shouldn’t change, just checking it's staying the same
        Task task = new Task("001", "Detail Camaro", "Interior and exterior");
        assertEquals("001", task.getTaskId());
    }

    @Test
    public void testInvalidTaskName() {
        // name can’t be null 
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("001", null, "Install new Camaro exhaust");
        });
    }

    @Test
    public void testInvalidTaskDescription() {
        // description can’t be null either
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("001", "Paint Camaro", null);
        });
    }
}
