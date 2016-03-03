package model;

/**
 * Created by Iurii on 02.03.2016.
 */
public class User extends Person {

    private final String type = "User";

    public User(String userName, String pass) {
        super(userName, pass);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId='" + personId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
