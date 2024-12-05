package LabWeek10;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CanSendMessage {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RequiresPermission{
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface UserPermission {
    String value();
}

abstract class User{
    private String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public abstract String getPermissionLevel();
}

@UserPermission("Regular")
class RegularUser extends User{

    public RegularUser(String username){
        super(username);
    }

    @Override
    public String getPermissionLevel(){
        return "Regular";
    }
}

@UserPermission("Admin")
class AdminUser extends User {

    public AdminUser(String username) {
        super(username);
    }

    @Override
    public String getPermissionLevel() {
        return "Admin";
    }
}

public class MessagingSystem{
    @CanSendMessage
    @RequiresPermission("Admin")
    public void sendMessage(User user){
        if(user.getPermissionLevel().equals("Admin")){
            System.out.println(user.getUsername() + " sent a message.");
        } else {
            System.out.println("User " + user.getUsername() + " is restricted from sending messages.");
        }
        }

    public static void main(String[] args) {
        MessagingSystem system = new MessagingSystem();

        User admin = new AdminUser("AdminUser1");
        User regularUser = new RegularUser("RegularUser1");

        System.out.println("Admin trying to send a message:");
        system.sendMessage(admin);

        System.out.println("\nRegular user trying to send a message:");
        system.sendMessage(regularUser);
    }
}

