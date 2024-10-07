package LabWeek2;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        while (true) {
            int number;
            int counter = 0;
            System.out.print("Enter number: ");
            number = sc.nextInt();

            if (number == 0) {
                break;
            } else if (number != 0) {
                sum += number;
                counter++;
            }

        }

        System.out.println("Sum: " + sum);
    }
}
