package LabWeek2;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter the last number: ");
        int lastNumber = scanner.nextInt();

        if (firstNumber <= lastNumber) {

            int currentNumber = firstNumber;
            while (currentNumber <= lastNumber) {
                System.out.println(currentNumber);
                currentNumber++;
            }
        } else {
            int currentNumber = firstNumber;
            while (currentNumber >= lastNumber) {
                System.out.println(currentNumber);
                currentNumber--;
            }
        }

    }
}
