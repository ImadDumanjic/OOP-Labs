package ExamPrep;
import java.util.Date;
import java.util.HashMap;

public class TableReservation <T extends MenuItem & Billable>{
    private String reservationId;
    private Date reservedAt;
    private HashMap<T, Integer> orderedItems;
    private int tableNumber;

    public TableReservation(String reservationId, Date reservedAt, int tableNumber) {
        this.reservationId = reservationId;
        this.reservedAt = reservedAt;
        this.tableNumber = tableNumber;
        this.orderedItems = new HashMap<>();
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(Date reservedAt) {
        this.reservedAt = reservedAt;
    }

    public HashMap<T, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(HashMap<T, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void addItemToOrder(T item, int quantity){
        orderedItems.put(item, quantity);
    }

    public double calculateTotalAmount(){
        double totalAmount = 0.0;

        for(T item : orderedItems.keySet()){
            totalAmount += orderedItems.get(item) * item.applyDiscount(0.2);
        }

        return totalAmount;
    }
}
