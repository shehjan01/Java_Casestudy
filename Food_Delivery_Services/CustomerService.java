package Food_Delivery_Services;

import java.util.ArrayList;
import java.util.List;
import online_Food_Delivery_entites.Customer;

public class CustomerService {
    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public Customer getCustomer(int userId) {
        return customerList.stream().filter(customer -> customer.getUserid() == userId).findFirst().orElse(null);
    }

    public List<Customer> getCustomers() {
        return customerList;
    }
}
