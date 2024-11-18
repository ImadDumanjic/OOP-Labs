package ExamPrep;
import java.util.ArrayList;
import java.util.List;

class Customer{
    private String customerId;
    private String name;
    private String phoneNum;
    private List<TableReservation<? extends MenuItem>> reservations;

    public Customer(String customerId, String name, String phoneNum) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.reservations = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<TableReservation<? extends MenuItem>> getReservations() {
        return reservations;
    }

    public void setReservations(List<TableReservation<? extends MenuItem>> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(TableReservation<? extends MenuItem> reservation){
        reservations.add(reservation);
    }
}
