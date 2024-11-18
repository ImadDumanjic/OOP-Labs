package ExamPrep2;
import java.util.Date;
import java.util.*;

class RentalTransaction <T extends Vehicle & Rentable> {
    private String transactionId;
    private Date rentalDate;
    private HashMap<T, Integer> rentedVehicles;
    private int customerId;

    public RentalTransaction(String transactionId, Date rentalDate, int customerId){
        this.transactionId = transactionId;
        this.rentalDate = rentalDate;
        this.customerId = customerId;
        this.rentedVehicles = new HashMap<>();
    }

    public HashMap<T, Integer> getRentedVehicles(){
        return this.rentedVehicles;
    }

    public void setRentedVehicles(T vehicle, int days){
        rentedVehicles.put(vehicle, days);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double calculateTotalAmount(){
        double totalAmount = 0.0;

        for(Map.Entry<T, Integer> entry : rentedVehicles.entrySet()){
            totalAmount += entry.getValue() * entry.getKey().applyDiscount(0.1);
        }

        return totalAmount;
    }
}
