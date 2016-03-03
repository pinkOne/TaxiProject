package model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Iurii on 02.03.2016.
 */
public class Model implements IModel{

    ArrayList<Person> persons = new ArrayList<Person>();
    ArrayList<Order> orders = new ArrayList<Order>();

    @Override
    public Order placeOrder(int personId , String str1, String str2) {

        if (getPersons().get(personId).getType().equals("User")) {
            Order res = new Order(str1,str2);
            orders.add(res);
            return res;
        } else throw new TypeNotPresentException("Just User can create order", null);
    }

    @Override
    public Order viewOrder(int personId, int orderNumber) {
        return null;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public Order pickOrder(int personId, int orderNumber) {
        if (getPersons().get(personId).getType().equals("Driver")) {
            orders.get(orderNumber).setState("In Prodgress");
            return orders.get(orderNumber);
        } else throw new TypeNotPresentException("Just Driver can pick up order", null);
    }

    @Override
    public Order closeOrder(int personId ,int orderNumber) {
        if (getPersons().get(personId).getType().equals("Driver")) {
            orders.get(orderNumber).setState("Closed");
            return orders.get(orderNumber);
        } else throw new TypeNotPresentException("Just Driver can close order", null);
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    @Override
    public boolean addPerson(Person p) {

        persons.add(p);
        //persons.indexOf(p);
        return true;

    }

    @Override
    public int logIn(String userName, String pass) {
        return 0;
    }
}
