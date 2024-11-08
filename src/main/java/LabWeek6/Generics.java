package LabWeek6;
import java.util.ArrayList;
import java.util.Collections;

public class Generics{
    public static <T extends Number> void sumOfEvenAndOdd(ArrayList<T> list){
        int sumEven=0;
        int sumOdd=0;
        for(T value : list){
            if((int)value%2==0){
                sumEven+=(int)value;
            }
            else{
                sumOdd+=(int)value;
            }
        }
        System.out.println("Sum of evens: "+sumEven+"\nSum of odds: "+sumOdd);
    }

    public static <T extends Object> ArrayList<T> reverseListOfAnyType(ArrayList<T> lista){
        java.util.Collections.reverse(lista);
        return lista;
    }
}
