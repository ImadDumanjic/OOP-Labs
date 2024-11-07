package LabWeek6;

public class Task1 {

    public static int smallest(int[] array){
        int smallest = array[0];

        for(int element : array){
            if(element < smallest){
                smallest = element;
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        int[] values = {6, 5, 8, 6, 11};
        System.out.println("smallest: " + smallest(values));
    }
}
