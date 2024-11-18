package ExamPrep3;

class Milk extends Item{
    private double fat;

    public Milk(String barcode, String name, double price, double fat){
        super(barcode, name, price);
        this.fat = fat;
    }

    public double getFat(){
        return this.fat;
    }

    public void setFat(double newFat){
        this.fat = newFat;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + "\nFat: " + this.fat;
    }
}
