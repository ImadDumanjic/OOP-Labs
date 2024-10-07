package LabWeek2;

public class Task7 {
    public static void drawStarsPiramid(int rows) {
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawStarsPiramid(5);
    }
}

