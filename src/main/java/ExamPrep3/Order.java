package ExamPrep3;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Order <T extends Item & Sellable> {
    private String orderNo;
    private Date orderedAt;
    private HashMap<T, Integer> items;

    public Order(String orderNo, Date orderedAt){
        this.orderNo = orderNo;
        this.orderedAt = orderedAt;
        this.items = new HashMap<>();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public HashMap<T, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<T, Integer> newItems) {
        this.items = newItems;
    }

    public void addItem(T item, int quantity){
        if(items.containsKey(item)){
            items.put(item, items.get(item) + quantity);
        }

        else{
            items.put(item, quantity);
        }
    }

    public double calculateTotalAmount(){
        double totalAmount = 0.0;

        for(Map.Entry<T, Integer> entry : items.entrySet()){
            T item = entry.getKey();
            int quantity = entry.getValue();

            totalAmount += item.getPrice() * quantity;
        }

        return totalAmount;
    }
}
