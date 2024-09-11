package online_Food_Delivery_entites;

import java.util.List;

public class Resturant {
    private int id;
    private String name;
    private List<Fooditem> menu;

    public Resturant(int id, String name, List<Fooditem> menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    public void addFoodItem(Fooditem foodItem) {
        menu.add(foodItem);
        System.out.println(foodItem.getName() + " added to the menu.");
    }

    public void removeFoodItem(int foodItemId) {
        menu.removeIf(item -> item.getId() == foodItemId);
        System.out.println("Item with ID " + foodItemId + " removed from the menu.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fooditem> getMenu() {
        return menu;
    }

    public void setMenu(List<Fooditem> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Resturant [id=" + id + ", name=" + name + ", menu=" + menu + "]";
    }
}
