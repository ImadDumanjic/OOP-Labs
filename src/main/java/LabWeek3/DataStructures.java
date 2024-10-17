package LabWeek3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1, "Push lab code to the github", Status.TO_DO),
                new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab2", Status.COMPLETED));
    }

    public List<TaskItem> getTasks() {
        return tasks;
    }

    public List<TaskItem> getByStatus(Status status) {
        List<TaskItem> filteredTasks = new ArrayList<>();
        for (TaskItem task : tasks) {
            if (task.getTaskStatus() == status) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public List<TaskItem> findTasksWithIdGreaterOrEqualToTwo(){
        List<TaskItem> filteredTasks = new ArrayList<>();
        for (TaskItem task : tasks) {
            if (task.getTaskId() >= 2) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void printTaskDescriptions() {
        tasks.forEach(task -> System.out.println("Task ID: " + task.getTaskId() +
                ", Description: " + task.getTaskDescription() +
                ", Status: " + task.getTaskStatus()));
    }

    public static void main(String[] args) {
        DataStructures dataStructures = new DataStructures();

        System.out.println("All tasks:");
        dataStructures.printTaskDescriptions();

        // Get tasks by status
        System.out.println("Tasks with status IN_PROGRESS:");
        List<TaskItem> inProgressTasks = dataStructures.getByStatus(Status.IN_PROGRESS);
        inProgressTasks.forEach(task -> System.out.println(task.getTaskDescription()));

        System.out.println("Tasks with ID greater than or equal to 2:");
        List<TaskItem> tasksWithIdGreaterOrEqualToTwo = dataStructures.findTasksWithIdGreaterOrEqualToTwo();
        tasksWithIdGreaterOrEqualToTwo.forEach(task -> System.out.println(task.getTaskDescription()));
    }
}

