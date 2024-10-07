package LabWeek2;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            sum += num;
        }

        System.out.println("The sum is: " + sum);
    }
}
