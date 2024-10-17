package LabWeek1;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        int rows;
        int current_num = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter how many rows you want: ");
        rows = input.nextInt();

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(current_num + " ");
                current_num++;
            }
            System.out.println();
        }
    }
}
