package LabWeek2;

public class Task9 {
        public static void main(String[] args) {
            drawNumbersPiramid(5);
        }

        public static void drawNumbersPiramid(int n) {
            for (int i = 1; i <= n; i++) {
                for (int k = 1; k <= i; k++) {
                    System.out.print(k + " ");
                }

                System.out.println();
            }
        }
    }
