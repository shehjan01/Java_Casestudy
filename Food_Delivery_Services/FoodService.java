package Food_Delivery_Services;

import java.util.ArrayList;
import java.util.List;
import online_Food_Delivery_entites.Fooditem;
import online_Food_Delivery_entites.Resturant;

public class FoodService {
    private List<Resturant> restaurants = new ArrayList<>();

    public void addRestaurant(Resturant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Resturant> getRestaurants() {
        return restaurants;
    }

    public List<Fooditem> getAllFoodItems() {
        List<Fooditem> allFoodItems = new ArrayList<>();
        for (Resturant restaurant : restaurants) {
            allFoodItems.addAll(restaurant.getMenu());
        }
        return allFoodItems;
    }

    public void addFoodItemToRestaurant(int restaurantId, Fooditem foodItem) {
        Resturant restaurant = findRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.getMenu().add(foodItem);
            System.out.println("Food item added to the restaurant.");
        } else {
            System.out.println("Restaurant with ID " + restaurantId + " not found.");
        }
    }

    public void removeFoodItemFromRestaurant(int restaurantId, Fooditem foodItem) {
        Resturant restaurant = findRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.getMenu().remove(foodItem);
            System.out.println("Food item removed from the restaurant.");
        } else {
            System.out.println("Restaurant with ID " + restaurantId + " not found.");
        }
    }

    private Resturant findRestaurantById(int restaurantId) {
        return restaurants.stream().filter(restaurant -> restaurant.getId() == restaurantId).findFirst().orElse(null);
    }
}
