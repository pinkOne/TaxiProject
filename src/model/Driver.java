package model;

/**
 * Created by Iurii on 03.03.2016.
 */
public class Driver  extends Person {

    private final String type = "User";

    public Driver(String userName, String pass) {
        super(userName, pass);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
