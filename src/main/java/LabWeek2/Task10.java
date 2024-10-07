package LabWeek2;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number in range from 0 to 100: ");
        int num_guess = sc.nextInt();

        int counter = 0;

        while(true){
            System.out.println("Please enter your guess: ");
            int guess = sc.nextInt();
            counter++;

            if(guess == num_guess){
                System.out.println("You guessed correctly!");
                System.out.println("This was your " + counter + " guess.");
                break;
            }

            else if(guess > num_guess){
                System.out.println("Lower! This is your " + counter + " guess. ");
            }

            else if(guess < num_guess){
                System.out.println("Higher! This is your " + counter + " guess. ");
            }
        }

    }
}

