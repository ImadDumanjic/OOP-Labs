package ExamPrep2;

class Car extends Vehicle{
    private CarTypes type;
    private String engineType;

    public Car(String vehicleId, String vehicleName, double rentalRate, CarTypes type, String engineType){
        super(vehicleId, vehicleName, rentalRate);
        this.type = type;
        this.engineType = engineType;
    }

    public CarTypes getType() {
        return type;
    }

    public void setType(CarTypes type) {
        this.type = type;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + "\nCar Type: " + this.type + "\nEngine Type: " + this.engineType;
    }


}
