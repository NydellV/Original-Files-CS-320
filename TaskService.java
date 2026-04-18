import java.util.HashMap;
import java.util.Map;

public class TaskService {
  
    // holds tasks using their ID as the key
    private Map<String, Task> taskMap = new HashMap<>();



    // add a new task
    public void addTask(Task task) {
      
        // make sure the task isn’t null and ID doesn’t already exist
        if (task == null || taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Invalid or duplicate task");
        }
        taskMap.put(task.getTaskId(), task);
    }

    // delete a task by its ID
    public void deleteTask(String taskId) {
       
        // remove only if task exists
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found");
        }
        taskMap.remove(taskId);
    }



    // update the name and description of a task using its ID
    public void updateTask(String taskId, String newName, String newDescription) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }



        // update name and description with validation from Task class
        task.setName(newName);
        task.setDescription(newDescription);
    }

    // method to get task during testing
    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }
}
