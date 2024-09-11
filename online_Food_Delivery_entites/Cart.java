package online_Food_Delivery_entites;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Fooditem, Integer> items = new HashMap<>();

    public Cart() {
        // Default constructor
    }

    public void addItem(Fooditem foodItem, int quantity) {
        items.merge(foodItem, quantity, Integer::sum);
    }

    public void removeItem(Fooditem foodItem) {
        items.remove(foodItem);
    }

    public Map<Fooditem, Integer> getItems() {
        return new HashMap<>(items);
    }

    @Override
    public String toString() {
        return "Cart [items=" + items + "]";
    }
}
