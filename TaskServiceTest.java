import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTaskValid() {

        // adding a task 

        TaskService service = new TaskService();
        Task task = new Task("123", "Camaro Tires", "Replace with new performance tires");

        service.addTask(task); // adding to task service

        // checking if task was added 

        assertEquals("Camaro Tires", service.getTask("123").getName());
    }

    @Test
    public void testAddTaskDuplicateId() {
        // trying to add two tasks with same ID which is not allowed
        TaskService service = new TaskService();
        Task task1 = new Task("101", "Camaro Wrap", "Matte black vinyl wrap");
        Task task2 = new Task("101", "Camaro Spoiler", "Install new spoiler");

        service.addTask(task1);

        // second task with same ID should throw error
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {

        // add and then delete a task
        TaskService service = new TaskService();
        Task task = new Task("222", "Camaro Brakes", "Upgrade to Brembo brakes");
        service.addTask(task);
        service.deleteTask("222");

        
        assertNull(service.getTask("222"));
    }

    @Test
    public void testDeleteTaskNotFound() {

        // try to delete a task that doesn’t exist
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("999"); // not in the list
        });
    }

    @Test
    public void testUpdateTask() {
        // add atask and update it


        TaskService service = new TaskService();
        Task task = new Task("303", "Old Camaro Task", "Old task for Camaro");
        service.addTask(task);

        // updating task with new info

        service.updateTask("303", "Camaro Lights", "Install LED headlight kit");


        // check if updated 
        Task updatedTask = service.getTask("303");
        assertEquals("Camaro Lights", updatedTask.getName());
        assertEquals("Install LED headlight kit", updatedTask.getDescription());
    }
}
