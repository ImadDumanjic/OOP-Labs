package ExamPrep;

abstract class MenuItem implements Billable{
    private String code;
    private String name;
    private double price;

    public MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    public double applyDiscount(double discountRate){
        return price - (price * discountRate);
    }

    @Override
    public String getDescription(){
        return "Item code: " + this.code + "\nItem name: " + this.name + "\nItem price: " + this.price;
    }
}
