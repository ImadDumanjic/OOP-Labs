package LabWeek6;

public class Task6{
    public static void printElegantly(int[]array){
        for(int element : array){
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args){
        int[] array = {5, 1, 3, 4, 2};
        printElegantly(array);
    }

}
