package ExamPrep2;

public class Motorcycle extends Vehicle{
    private double engineCapacity;

    public Motorcycle(String vehicleId, String vehicleName, double rentalRate, double engineCapacity){
        super(vehicleId, vehicleName, rentalRate);
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getDescription(){
        return super.getDescription() + "Engine capacity: " + this.engineCapacity;
    }
}
