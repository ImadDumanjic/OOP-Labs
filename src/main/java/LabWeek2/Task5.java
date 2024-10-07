package LabWeek2;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base: ");
        int base = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();

        int sum = 0;

        for (int i = 0; i <= power; i++) {
            sum += Math.pow(base, i);
        }

        System.out.println("The sum is: " + sum);
    }
}


