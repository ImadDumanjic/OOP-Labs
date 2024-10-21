package LabWeek4;

class Shape {
    private String color;
    private FillType fillType;

    public Shape(String color, FillType fillType) {
        this.color = color;
        this.fillType = fillType;
    }

    public void displayInfo() {
        System.out.println("Color: " + this.color + ", Fill: " + this.fillType.toString());
    }
}

class Circle extends Shape{
    private double radius;

    public Circle(String color, FillType fillType, double radius){
        super(color, fillType);
        this.radius = radius;
    }

    double getArea(){
        return Math.PI * radius * radius;
    }

    public void displayInfo(){
        System.out.println("Circle information: ");
        super.displayInfo();
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + this.getArea());
    }

    public double calculateCircumference(double radius, double pi){
        return 2 * pi * radius;
    }

    public double calculateCircumference(double radius){
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(String color, FillType fillType, double height, double width){
        super(color, fillType);
        this.height = height;
        this.width = width;
    }

    double getArea(){
        return height * width;
    }

    public void displayInfo() {
        System.out.println("Rectangle information: ");
        super.displayInfo();
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
    }

    public static void main(String[] args){
        Circle c1 = new Circle("Red", FillType.FILLED, 3 );
        Rectangle r1 = new Rectangle("Blue", FillType.NOT_FILLED, 3.3, 4.6 );

        c1.displayInfo();
        System.out.println();
        r1.displayInfo();
    }
}
