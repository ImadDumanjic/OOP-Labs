package ExamPrep3;
import java.util.Date;

class MainRun{
    public static void main(String[] args){

        Milk milk1 = new Milk("M01", "Meggle", 1.69, 1.9);
        Milk milk2 = new Milk("M02", "Dukat", 1.39, 2.5);

        Honey honey1 = new Honey("H01", "Medeni", 15.89, HoneyType.BAGREMOV);
        Honey honey2 = new Honey("H02", "Divlji", 18.99, HoneyType.ORAHOV);

        Order<Milk> order1 = new Order("O1", new Date());
        Order<Honey> order2 = new Order("O2", new Date());

        order1.addItem(milk1, 3);
        order1.addItem(milk2, 4);

        order2.addItem(honey1, 2);
        order2.addItem(honey2, 1);

        Person customer = new Person("John Doe", 30);
        customer.addOrder(order1);
        customer.addOrder(order2);

        for (Order<? extends Item> order : customer.getOrders()) {
            System.out.println("\nOrder No: " + order.getOrderNo() + " | Date: " + order.getOrderedAt());
            System.out.println("Items:");
            for (Item item : order.getItems().keySet()) {
                System.out.println(item.getDescription() + " | Quantity: " + order.getItems().get(item) + " | Price: " + item.getPrice());
            }
            System.out.println("Total Amount: " + order.calculateTotalAmount());
        }
    }
}
