package model;

/**
 * Created by Iurii on 02.03.2016.
 */
public class Person {

    protected String userName;
    protected String pass;
    protected String userId;

    public Person(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
