package LabWeek13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee(String type, String size, List<String> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Coffee type: " + type + ", size: " + size + ", toppings: " + toppings;
    }
}

interface CoffeeBuilder {
    void buildType();
    void buildSize(String size);
    void buildToppings(List<String> toppings);
    Coffee getCoffee();
}

class EspressoBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings;

    public EspressoBuilder() {
        toppings = new ArrayList<>();
    }

    @Override
    public void buildType() {
        this.type = "Espresso";
    }

    @Override
    public void buildSize(String size) {
        this.size = size;
    }

    @Override
    public void buildToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}

class LatteBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings;

    public LatteBuilder() {
        toppings = new ArrayList<>();
    }

    @Override
    public void buildType() {
        this.type = "Latte";
    }

    @Override
    public void buildSize(String size) {
        this.size = size;
    }

    @Override
    public void buildToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}


class CappuccinoBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings;

    public CappuccinoBuilder() {
        toppings = new ArrayList<>();
    }

    @Override
    public void buildType() {
        this.type = "Cappuccino";
    }

    @Override
    public void buildSize(String size) {
        this.size = size;
    }

    @Override
    public void buildToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}

class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder, String size, List<String> toppings) {
        builder.buildType();
        builder.buildSize(size);
        builder.buildToppings(toppings);
        return builder.getCoffee();
    }
}

class CoffeeSystem {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder, "Small", Arrays.asList("Sugar", "Milk"));
        System.out.println(espresso);

        CoffeeBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder, "Medium", Arrays.asList("Vanilla", "Whipped Cream"));
        System.out.println(latte);

        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder, "Large", Arrays.asList("Cinnamon", "Chocolate"));
        System.out.println(cappuccino);
    }
}



