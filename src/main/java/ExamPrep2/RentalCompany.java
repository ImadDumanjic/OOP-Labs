package ExamPrep2;
import java.util.*;

public class RentalCompany {
    private String companyName;
    private List<Customer> customers;
    private Map<String, Vehicle> vehicleInventory;

    public RentalCompany(String companyName){
        this.companyName = companyName;
        this.customers = new ArrayList<>();
        this.vehicleInventory = new HashMap<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(Map<String, Vehicle> vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public void addCustomerToCompany(Customer customer){
        customers.add(customer);
    }

    public void addVehicleToInventory(Vehicle vehicle){
        vehicleInventory.put(vehicle.getVehicleId(), vehicle);
    }

    public Customer getCustomer(String customerId){
        for(Customer customer : customers){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public void displayInventory(){
        if(vehicleInventory.isEmpty()){
            System.out.println("No vehicles available.");
        }
        else{
            for(Map.Entry<String, Vehicle> entry : vehicleInventory.entrySet()){
                System.out.println("Vehicle: " + entry.getValue().getDescription());
            }
        }

    }

    public double calculateTotalRevenue(){
        double totalRevenue = 0.0;

        for(Customer customer : customers){
            for(RentalTransaction<? extends Vehicle> transaction : customer.getRentalHistory()){
                totalRevenue += transaction.calculateTotalAmount();
            }
        }

        return totalRevenue;
    }
}
