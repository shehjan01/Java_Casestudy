package online_Food_Delivery_entites;

public class Delivery_Person {
    private int deliveryId;
    private String name;
    private long contactNo;

    public Delivery_Person(int deliveryId, String name, long contactNo) {
        this.deliveryId = deliveryId;
        this.name = name;
        this.contactNo = contactNo;
    }

    public int getDeliveryid() {
        return deliveryId;
    }

    public void setDeliveryid(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Delivery_Person [deliveryId=" + deliveryId + ", name=" + name + ", contactNo=" + contactNo + "]";
    }
}
