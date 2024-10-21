package Vjezba;
import java.util.ArrayList;
import java.util.Scanner;

public class Arr{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> integers = new ArrayList<>();

        int size;
        System.out.println("Enter the size: ");
        size = sc.nextInt();

        for(int i = 0; i < size; i++){
            System.out.println("Enter number: ");
            integers.add(sc.nextInt());
        }

        int max = integers.get(0);
        int min = integers.get(0);

        for(int i = 0; i < size; i++){
            if(integers.get(i) > max){
                max = integers.get(i);
            }

            if(integers.get(i) < min){
                min = integers.get(i);
            }
        }

        System.out.println("Max is: " + max + " and min is: " + min);
    }
}
