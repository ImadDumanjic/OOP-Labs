package ExamPrep2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

abstract class Vehicle{
    private String vehicleId;
    private String vehicleName;
    private double rentalRate;
    private HashMap<Date, Integer> kilometersRecord;

    public Vehicle(String vehicleId, String vehicleName, double rentalRate){
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.rentalRate = rentalRate;
        this.kilometersRecord = new HashMap<>();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public HashMap<Date, Integer> getKilometersRecord() {
        return kilometersRecord;
    }

    public void setKilometersRecord(HashMap<Date, Integer> kilometersRecord) {
        this.kilometersRecord = kilometersRecord;
    }

    public double applyDiscount(double discountRate){
        return rentalRate - (rentalRate * discountRate);
    }

    public String getDescription(){
        return "Vehicle ID: " + vehicleId + "\nVehicle name: " + vehicleName + "\nRental rate: " + rentalRate;
    }

    public void addKilometers(Date date, int kilometers){
        kilometersRecord.put(date, kilometers);
    }

    public int getKilometers(){
        int totalKilometers = 0;

        for(Map.Entry<Date, Integer> entry : kilometersRecord.entrySet()){
            totalKilometers += entry.getValue();
        }

        return totalKilometers;
    }
}
