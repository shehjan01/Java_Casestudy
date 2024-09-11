package online_Food_Delivery_entites;

public class Customer extends User {
    private Cart cart;

    public Customer(int userid, String userName, long contactNo, Cart cart) {
        super(userid, userName, contactNo);
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }
}
