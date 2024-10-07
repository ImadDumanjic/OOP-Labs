package LabWeek2;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("How many times do you want to print out the message? ");
                int times = scanner.nextInt();

                for(int i = 0; i < times; i++){
                    printText();
                }
            }

            public static void printText(){
                System.out.println("In the beginning there were the swamp, the hoe and Java.");
            }
        }
