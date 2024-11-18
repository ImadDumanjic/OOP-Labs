package ExamPrep3;

class Honey extends Item{
    private HoneyType type;

    public Honey(String barCode, String name, double price, HoneyType type){
        super(barCode, name, price);
        this.type = type;
    }

    public HoneyType getHoneyType(){
        return this.type;
    }

    public void setHoneyType(HoneyType newType){
        this.type = newType;
    }

    public String getDescription(){
        return super.getDescription() + "\nHoney type: " + this.type;
    }
}
