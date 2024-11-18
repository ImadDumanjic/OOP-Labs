package ExamPrep;

class Dish extends MenuItem{
    private CuisineType type;
    private String mainIngredient;

    public Dish(String code, String name, double price, CuisineType type, String mainIngredient){
        super(code, name, price);
        this.type = type;
        this.mainIngredient = mainIngredient;
    }

    public CuisineType getType() {
        return type;
    }

    public void setType(CuisineType type) {
        this.type = type;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + "\nCuisine Type: " + this.type + "\nMain ingredient: " + this.mainIngredient;
    }
}
