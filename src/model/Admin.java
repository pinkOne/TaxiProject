package model;

/**
 * Created by Iurii on 04.03.2016.
 */
public class Admin extends Person {

    private final String type = "Admin";

    public Admin (String userName, String pass) {
        super(userName, pass);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", userId='" + personId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
