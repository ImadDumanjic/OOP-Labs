package ExamPrep3;

abstract class Item implements Sellable{
    private String barCode;
    private String name;
    private double price;

    public Item(String barCode, String name, double price){
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double calculateDiscount(double discountRate){
        return price - (price * discountRate);
    }

    @Override
    public String getDescription(){
        return "Item Barcode: " + this.barCode + "\nItem name: " + this.name + "\nItem price: " + this.price;
    }
}
