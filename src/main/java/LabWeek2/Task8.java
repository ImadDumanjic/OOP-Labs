package LabWeek2;

public class Task8 {
    public static void invertedStarsPiramid(int rows) {
        for (int i = rows; i >= 1; i--) {
            // Print stars for the current row
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // Move to the next line
            System.out.println();
        }
    }

    public static void main(String[] args) {
        invertedStarsPiramid(10);
    }

}
