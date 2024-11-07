package LabWeek6;
import java.util.Random;

public class NightSky{
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;
    private Random random;

    public NightSky(double density) {
        this(density, 20, 10);
    }

    public NightSky(int width, int height) {
        this(0.1, width, height);
    }

    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
        this.random = new Random();
        this.starsInLastPrint = 0;
    }

    public void printLine() {
        for (int i = 0; i < width; i++) {
            if (random.nextDouble() <= density) {
                System.out.print("*");
                starsInLastPrint++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void print() {
        this.starsInLastPrint = 0;
        for (int i = 0; i < height; i++) {
            printLine();
        }
    }

    public int starsInLastPrint() {
        return this.starsInLastPrint;
    }

    public static void main(String[] args) {
        NightSky nightSky = new NightSky(0.1, 40, 10);
        nightSky.printLine();

        NightSky skyWithDimensions = new NightSky(8, 4);
        skyWithDimensions.print();
        System.out.println("Number of stars: " + skyWithDimensions.starsInLastPrint());

        System.out.println();

        skyWithDimensions.print();
        System.out.println("Number of stars: " + skyWithDimensions.starsInLastPrint());
    }
}
