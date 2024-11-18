package ExamPrep;

import java.util.Date;

class MainRun{
    public static void main(String[] args){
        Dish pasta = new Dish("D1", "Spaghetti Carbonara", 12.99, CuisineType.ITALIAN, "Pasta");
        Dish tacos = new Dish("D2", "Beef Tacos", 8.99, CuisineType.MEXICAN, "Beef");

        Drink cola = new Drink("DR1", "Coca-Cola", 2.49, 330);
        Drink wine = new Drink("DR2", "Red Wine", 6.99, 150);

        Restaurant restaurant = new Restaurant("Gourmet Paradise");

        restaurant.addMenuItem(pasta);
        restaurant.addMenuItem(tacos);
        restaurant.addMenuItem(cola);
        restaurant.addMenuItem(wine);


        TableReservation<Dish> dishReservation = new TableReservation<>("R1", new Date(), 1);
        dishReservation.addItemToOrder(pasta, 2);
        dishReservation.addItemToOrder(tacos, 3);

        TableReservation<Drink> drinkReservation = new TableReservation<>("R2", new Date(), 2);
        drinkReservation.addItemToOrder(cola, 4);
        drinkReservation.addItemToOrder(wine, 2);

        Customer customer = new Customer("C1", "John Doe", "123-456-7890");

        customer.addReservation(dishReservation);
        customer.addReservation(drinkReservation);

        restaurant.addCustomer(customer);

        System.out.println("Reservation History for " + customer.getName() + ":");
        for (TableReservation<? extends MenuItem> reservation : customer.getReservations()) {
            System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("Table Number: " + reservation.getTableNumber());
            System.out.println("Items Ordered:");
            for (MenuItem item : reservation.getOrderedItems().keySet()) {
                int quantity = reservation.getOrderedItems().get(item);
                System.out.println("- " + item.getName() + " x " + quantity);
            }
            System.out.println("Total Amount: " + reservation.calculateTotalAmount() + "$.");
            System.out.println();
        }

    }
}
