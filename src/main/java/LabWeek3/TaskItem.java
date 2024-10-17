package LabWeek3;

public class TaskItem {
    int taskId;
    String taskDescription;
    Status taskStatus;

    public TaskItem(int id, String description, Status Status) {
            taskId = id;
            taskDescription = description;
            taskStatus = Status;
    }

    // getters
    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    //setteri
    public void setTaskId(int id) {
        taskId = id;
    }

    public void setTaskDescription(String description) {
        taskDescription = description;
    }

    public void setTaskStatus(Status status) {
        taskStatus = status;
    }
}
