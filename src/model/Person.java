package model;

/**
 * Created by Iurii on 02.03.2016.
 */
public class Person {

    protected String userName;
    protected String pass;
    protected int personId;
    private static int count = 0;
    private final String type = "Person";

    public String getUserName() {
        return userName;
    }

    public Person(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
        this.personId=count++;
    }

    public int getUserId() {
        return personId;
    }

    public String getType() {
        return type;
    }

    public String getPass() {
        return pass;
    }

    public void setUserId(int userId) {

        this.personId = userId;

    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", userId='" + personId + '\'' +
                '}';
    }
}
