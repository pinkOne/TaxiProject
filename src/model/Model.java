package model;

import java.util.TreeSet;

/**
 * Created by Iurii on 02.03.2016.
 */
public class Model implements IModel{

    TreeSet<User> users = new TreeSet<User>();


    @Override
    public Order placeOrder(String userId, Address str1, Address str2) {
        return null;
    }

    @Override
    public Order viewOrder(String personId, int orderNumber) {
        return null;
    }

    @Override
    public Order pickOrder(String driverId, int orderNumber) {
        return null;
    }

    @Override
    public Order closeOrder(int OrderNymber) {
        return null;
    }

    @Override
    public boolean addPerson() {

        return false;
    }

    @Override
    public int logIn(String userName, String pass) {
        return 0;
    }
}
