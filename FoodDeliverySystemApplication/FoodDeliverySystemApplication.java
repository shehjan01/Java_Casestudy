package FoodDeliverySystemApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import online_Food_Delivery_entites.Customer;
import online_Food_Delivery_entites.Delivery_Person;
import online_Food_Delivery_entites.Fooditem;
import online_Food_Delivery_entites.Order;
import online_Food_Delivery_entites.Resturant;
import online_Food_Delivery_entites.Cart;

public class FoodDeliverySystemApplication {
    private static Map<Integer, Resturant> restaurants = new HashMap<>();
    private static Map<Integer, Order> orders = new HashMap<>();
    private static Map<Integer, Delivery_Person> deliveryPersons = new HashMap<>();
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    customerMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                     System.out.print("Enter Restaurant ID: ");
                    int restId = scanner.nextInt();
                    System.out.print("Enter Restaurant Name: ");
                    scanner.nextLine(); 
                    String restName = scanner.nextLine();
                    restaurants.put(restId, new Resturant(restId, restName, new ArrayList<>()));
                    System.out.println("Restaurant added successfully!");
                   
                    break;
                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int restIdForFood = scanner.nextInt();
                    if (restaurants.containsKey(restIdForFood)) {
                        System.out.print("Enter Food Item ID: ");
                        int foodId = scanner.nextInt();
                        System.out.print("Enter Food Item Name: ");
                        scanner.nextLine();
                        String foodName = scanner.nextLine();
                        System.out.print("Enter Food Item Price: ");
                        double foodPrice = scanner.nextDouble();
                        restaurants.get(restIdForFood).addFoodItem(new Fooditem(foodId, foodName, foodPrice));
                        System.out.println("Food item added successfully!");
                    } else {
                        System.out.println("Restaurant ID not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int restIdForRemoval = scanner.nextInt();
                    if (restaurants.containsKey(restIdForRemoval)) {
                        System.out.print("Enter Food Item ID to Remove: ");
                        int foodItemId = scanner.nextInt();
                        restaurants.get(restIdForRemoval).removeFoodItem(foodItemId);
                        System.out.println("Food item removed successfully!");
                    } else {
                        System.out.println("Restaurant ID not found.");
                    }
                    break;
                case 4:
                    System.out.println("Restaurants and Menus:");
                    for (Resturant restaurant : restaurants.values()) {
                        System.out.println(restaurant);
                    }
                    break;
                case 5:
                    System.out.println("Orders:");
                    for (Order order : orders.values()) {
                        System.out.println(order);
                    }
                    break;
                case 6:
                    System.out.print("Enter Delivery Person ID: ");
                    int deliveryPersonId = scanner.nextInt();
                    System.out.print("Enter Delivery Person Name: ");
                    scanner.nextLine();
                    String deliveryPersonName = scanner.nextLine();
                    System.out.print("Enter Delivery Person Contact Number: ");
                    long deliveryPersonContactNo = scanner.nextLong();
                    deliveryPersons.put(deliveryPersonId, new Delivery_Person(deliveryPersonId, deliveryPersonName, deliveryPersonContactNo));
                    System.out.println("Delivery person added successfully!");
                    break;
                case 7:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    if (orders.containsKey(orderId)) {
                        System.out.print("Enter Delivery Person ID: ");
                        int delPersonId = scanner.nextInt();
                        if (deliveryPersons.containsKey(delPersonId)) {
                            orders.get(orderId).setDeliveryPerson(deliveryPersons.get(delPersonId));
                            orders.get(orderId).setStatus("Assigned");
                            System.out.println("Delivery person assigned to order successfully!");
                        } else {
                            System.out.println("Delivery Person ID not found.");
                        }
                    } else {
                        System.out.println("Order ID not found.");
                    }
                    break;
                case 8:
                    System.out.println("Exiting Admin Module");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void customerMenu(Scanner scanner) {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Username: ");
                    scanner.nextLine();
                    String username = scanner.nextLine();
                    System.out.print("Enter Contact No.: ");
                    long contactNo = scanner.nextLong();
                    customers.put(userId, new Customer(userId, username, contactNo, new Cart()));
                    System.out.println("Customer created successfully!");
                    break;
                case 2:
                    System.out.println("Restaurants and Menus:");
                    for (Resturant restaurant : restaurants.values()) {
                        System.out.println(restaurant);
                    }
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    if (customers.containsKey(customerId)) {
                        System.out.print("Enter Restaurant ID: ");
                        int restId = scanner.nextInt();
                        if (restaurants.containsKey(restId)) {
                            System.out.print("Enter Food Item ID: ");
                            int foodId = scanner.nextInt();
                            Fooditem foodItem = null;
                            for (Fooditem item : restaurants.get(restId).getMenu()) {
                                if (item.getId() == foodId) {
                                    foodItem = item;
                                    break;
                                }
                            }
                            if (foodItem != null) {
                                System.out.print("Enter Quantity: ");
                                int quantity = scanner.nextInt();
                                customers.get(customerId).getCart().addItem(foodItem, quantity);
                                System.out.println("Food item added to cart!");
                            } else {
                                System.out.println("Food Item ID not found.");
                            }
                        } else {
                            System.out.println("Restaurant ID not found.");
                        }
                    } else {
                        System.out.println("Customer ID not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    int custIdForCart = scanner.nextInt();
                    if (customers.containsKey(custIdForCart)) {
                        System.out.println(customers.get(custIdForCart).getCart());
                    } else {
                        System.out.println("Customer ID not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    int custIdForOrder = scanner.nextInt();
                    if (customers.containsKey(custIdForOrder)) {
                        orders.put(orderIdCounter, new Order(orderIdCounter, customers.get(custIdForOrder)));
                        System.out.println("Order placed successfully! Your order ID is: " + orderIdCounter);
                        orderIdCounter++;
                    } else {
                        System.out.println("Customer ID not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Customer ID: ");
                    int custIdForOrders = scanner.nextInt();
                    if (customers.containsKey(custIdForOrders)) {
                        System.out.println("Orders:");
                        for (Order order : orders.values()) {
                            if (order.getCustomer().getUserid() == custIdForOrders) {
                                System.out.println(order);
                            }
                        }
                    } else {
                        System.out.println("Customer ID not found.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting Customer Module");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }
}
