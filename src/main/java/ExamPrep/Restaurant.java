package ExamPrep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Restaurant{
    private String restaurantName;
    private List<Customer> customers;
    private HashMap<String, MenuItem> menuItems;

    public Restaurant(String restaurantName){
        this.restaurantName = restaurantName;
        this.customers = new ArrayList<>();
        this.menuItems = new HashMap<>();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public HashMap<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(HashMap<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void addMenuItem(MenuItem item){
        menuItems.put(item.getCode(), item);
    }

    public Customer getCustomer(String customerId){
        for(Customer customer : customers){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public void displayMenu(){
        System.out.println("Menu: ");
        for(Map.Entry<String, MenuItem> entry : menuItems.entrySet()){
            System.out.println(entry.getValue().getDescription());
        }
    }

    public double calculateTotalSales(){
        double totalAmount = 0.0;

        for(Customer customer : customers){
            for(TableReservation<? extends MenuItem> reservation : customer.getReservations()){
                totalAmount += reservation.calculateTotalAmount();
            }
        }

        return totalAmount;
    }
}
