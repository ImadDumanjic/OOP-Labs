package LabWeek3;
import java.sql.*;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "imadex2004";

    private Connection connection = null;

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllTasks() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM tasks"
        );

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            System.out.println("Id: " + resultSet.getInt("id"));
            System.out.println("Description: " + resultSet.getString("task_description"));
            System.out.println("Status: " + resultSet.getString("task_status"));
        }
    }

    public void getTaskById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM tasks WHERE id = ?"
        );

        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Description: " + rs.getString("task_description"));
            System.out.println("Status: " + rs.getString("task_status"));
        } else {
            System.out.println("Task not found with ID: " + id);
        }
    }

    public void createTask(int id, String description, String status) throws SQLException {
        String query = "INSERT INTO tasks (id, task_description, task_status) VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);
        statement.setString(2, description);
        statement.setString(3, status);
        statement.executeUpdate();
        System.out.println("Task created");
    }

    public void updateTaskName(int id, String newTaskDescription) throws SQLException{
        String query = "UPDATE tasks SET task_description = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, newTaskDescription);
        statement.setInt(2, id);

        int rowsUpdate = statement.executeUpdate();

        if(rowsUpdate > 0){
            System.out.println("Success.");
        }
        else {
            System.out.println("Task not found with ID: " + id);
        }
    }

    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();

        try {
            System.out.println("All tasks:");
            dbConnect.getAllTasks();

            System.out.println("Fetching task with ID 1:");
            dbConnect.getTaskById(1);

            System.out.println("Creating a new task:");
            dbConnect.createTask(6, "Coffee", "CANCELLED");

            System.out.println("Updating task with ID 2:");
            dbConnect.updateTaskName(2, "Prepare for the upcoming exam");

            System.out.println("All tasks after updates:");
            dbConnect.getAllTasks();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
