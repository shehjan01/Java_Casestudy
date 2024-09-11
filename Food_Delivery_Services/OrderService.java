package Food_Delivery_Services;

import java.util.ArrayList;
import java.util.List;
import online_Food_Delivery_entites.Delivery_Person;
import online_Food_Delivery_entites.Order;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private List<Delivery_Person> deliveryPersons = new ArrayList<>();

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addDeliveryPerson(Delivery_Person deliveryPerson) {
        deliveryPersons.add(deliveryPerson);
    }

    public List<Delivery_Person> getDeliveryPersons() {
        return deliveryPersons;
    }

    public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
        Order orderToAssign = findOrderById(orderId);
        if (orderToAssign == null) {
            System.out.println("Order with ID " + orderId + " not found.");
            return;
        }

        Delivery_Person deliveryPersonToAssign = findDeliveryPersonById(deliveryPersonId);
        if (deliveryPersonToAssign == null) {
            System.out.println("Delivery person with ID " + deliveryPersonId + " not found.");
            return;
        }

        orderToAssign.setDeliveryPerson(deliveryPersonToAssign);
        System.out.println("Assigned delivery person with ID " + deliveryPersonId + " to order with ID " + orderId);
    }

    private Order findOrderById(int orderId) {
        return orders.stream().filter(order -> order.getOrderid() == orderId).findFirst().orElse(null);
    }

    private Delivery_Person findDeliveryPersonById(int deliveryPersonId) {
        return deliveryPersons.stream().filter(person -> person.getDeliveryid() == deliveryPersonId).findFirst().orElse(null);
    }
}
