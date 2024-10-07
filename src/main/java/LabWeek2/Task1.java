package LabWeek2;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your password:");
        String userPassword = sc.nextLine();

        while (true) {
            System.out.println("Enter your password: ");
            String password = sc.nextLine();

            if (userPassword.equals(password)) {
                System.out.print("Right!!! ");
                System.out.print("Secret is 'dnfjdfkng snfkrkki'");
                break;
            }
        }
    }
}
