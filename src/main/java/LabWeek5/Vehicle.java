package LabWeek5;
import java.util.Scanner;

abstract class Vehicle {
    private String modelName;
    private int mileage;
    private int health;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
    }

    public Vehicle(String modelName, int mileage, int health) {
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setModelName(String newModelName) {
        this.modelName = newModelName;
    }

    public void setMileage(int newMileage) {
        this.mileage = newMileage;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance() {
        return health < 70;
    }

    public int calculateRemainingLifespan() {
        int remainingLifespan = expectedLifespan() - mileage;

        if (health < 50) {
            remainingLifespan -= (50 - health) * 2;
        }
        return remainingLifespan;
    }

    public void simulateYear() {
        if (mileage > expectedLifespan() / 2) {
            setHealth(getHealth() - 5);
        }

        if (getHealth() < 0) {
            setHealth(0);
        }

        int adjustedLifespan = calculateRemainingLifespan();

        System.out.println("After one year, " + getModelName() + " has a mileage of " + getMileage() +
                " miles, health is " + getHealth() + "%, and remaining lifespan is " + adjustedLifespan + " miles.");
    }

        public void performMaintenance(Vehicle vehicle) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.println(car.repair());
                car.drive(100);
            }
            else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                System.out.println(truck.repair());
                truck.haul(6000);
            }
            else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                motorcycle.race(150);
            }
        }
    }


interface Repairable {
    String repair();
}

class Car extends Vehicle implements Repairable {
    Car(String modelName) {
        super(modelName);
    }

    Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine tuned and oil changed for " + getModelName();
    }

    @Override
    public String service() {
        return "Performing service on " + getModelName() + ". Checking engine, changing oil on mileage: " + getMileage() + " miles. Vehicle's health is: " + getHealth() + "%.";
    }

    @Override
    public int expectedLifespan() {
        return 150000;
    }

    public void drive(int miles) {
        int newMileage = getMileage() + miles;
        int newHealth = getHealth() - (miles / 100);

        setMileage(newMileage);
        setHealth(newHealth);

        if (getHealth() < 30) {
            setHealth(Math.max(0, getHealth()));
            int newExpectedLifeSpan = expectedLifespan() - 10000;
        }
    }
}

class Truck extends Vehicle implements Repairable {
    Truck(String modelName) {
        super(modelName);
    }

    Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public String service() {
        return "Performing service on " + getModelName() + ". Checking engine, changing oil on mileage: " + getMileage() + " miles. Vehicle's health is: " + getHealth() + "%.";
    }

    @Override
    public int expectedLifespan() {
        return 300000;
    }

    public void haul(int loadWeight) {
        if (loadWeight > 5000) {
            setHealth(getHealth() - 20);
        }

        if (getHealth() < 50) {
            int newExpectedLifeSpan = expectedLifespan() - 20000;
        }
    }
}

class Motorcycle extends Vehicle implements Repairable {
    public Motorcycle(String modelName) {
        super(modelName);
    }

    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public String service() {
        return "Performing service on " + getModelName() + ". Checking engine, lubricating the chain on mileage: " + getMileage() + " miles. Vehicle's health is: " + getHealth() + "%.";
    }

    @Override
    public int expectedLifespan() {
        return 50000;
    }

    public void race(int raceMiles) {
        int newMileage = getMileage() + raceMiles;
        int newHealth = getHealth() - (raceMiles / 10);

        setMileage(newMileage);
        setHealth(newHealth);

        if (getHealth() < 40) {
            int newExpectedLifeSpan = expectedLifespan() - 5000;
        }
    }

}


class Main {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[5];

        vehicles[0] = new Car("Toyota", 60000, 80);
        vehicles[1] = new Truck("Ford", 150000, 60);
        vehicles[2] = new Motorcycle("Harley Davidson", 20000, 90);
        vehicles[3] = new Car("Honda", 50000, 70);
        vehicles[4] = new Truck("Chevy", 250000, 50);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.service());
            vehicle.simulateYear();
        }

        for (Vehicle vehicle : vehicles) {
            vehicle.performMaintenance(vehicle);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a vehicle for maintenance (0 - " + (vehicles.length - 1) + "): ");
        int index = scanner.nextInt();

        if (index >= 0 && index < vehicles.length) {
            System.out.println("Performing maintenance on: " + vehicles[index].getModelName());
            vehicles[index].performMaintenance(vehicles[index]);
        } else {
            System.out.println("Invalid selection.");
        }

        scanner.close();
    }
}

