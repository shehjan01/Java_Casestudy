package online_Food_Delivery_entites;

import java.util.Map;

public class Order {
    private int orderId;
    private Customer customer;
    private Map<Fooditem, Integer> items;
    private String status;
    private Delivery_Person deliveryPerson;
    private String deliveryAddress;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addItem(Fooditem foodItem, int quantity) {
        items.merge(foodItem, quantity, Integer::sum);
    }

    public int getOrderid() {
        return orderId;
    }

    public void setOrderid(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Fooditem, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Fooditem, Integer> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Delivery_Person getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(Delivery_Person deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customer=" + customer + ", items=" + items + ", status=" + status
                + ", deliveryPerson=" + deliveryPerson + ", deliveryAddress=" + deliveryAddress + "]";
    }
}
