package model;

/**
 * Created by Iurii on 02.03.2016.
 */
public class Order {
    private String str1;
    private String str2;
    private double price;
    private int orderId;
    static int count;
    private String state;
    private String driver;
    private String Client;

    public Order(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.orderId=count++;
        this.state="New";
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setClient(String client) {
        Client = client;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Order{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", price=" + price +
                ", orderId=" + orderId +
                ", driver=" + driver +
                ", state=" + state +
                '}';
    }

    public String getState() {
        return state;
    }
}
