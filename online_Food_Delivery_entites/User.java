package online_Food_Delivery_entites;

public class User {
    private int userid;
    private String userName;
    private long contactNo;

    public User(int userid, String userName, long contactNo) {
        this.userid = userid;
        this.userName = userName;
        this.contactNo = contactNo;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", userName=" + userName + ", contactNo=" + contactNo + "]";
    }
}
