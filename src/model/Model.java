package model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Iurii on 02.03.2016.
 */
public class Model implements IModel {

    ArrayList<Person> persons = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public Order placeOrder(int personId, String str1, String str2) {

        if (getPersons().get(personId).getType().equals("User")) {
            Order res = new Order(str1, str2);
            res.setClient(getPersons().get(personId).getUserName());
            orders.add(res);
            return res;
        } else throw new TypeNotPresentException("Just User can create order", null);
    }

    @Override
    public Order getOrder(int orderNumber) {
        if (orderNumber >= orders.size()) {
            return null;
        } else return orders.get(orderNumber);
    }



    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public Order pickOrder(int personId, int orderNumber) {
        return changeOrder(this, personId, orderNumber, "IN PROGRESS");
    }

    @Override
    public Order closeOrder(int personId, int orderNumber) {
        return changeOrder(this, personId, orderNumber, "CLOSED");
    }

    public static Order changeOrder(Model m, int personId, int orderNumber, String status) {
        if (m.getPersons().get(personId).getType().equals("Driver")) {
            m.orders.get(orderNumber).setState(status);
            m.orders.get(orderNumber).setDriver(m.getPersons().get(personId).getUserName());
            return m.orders.get(orderNumber);
        } else throw new TypeNotPresentException("Just Driver can do this", null);

    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    @Override
    public boolean addPerson(Person p) {
        persons.add(p);
        return true;
    }

    @Override
    public Person createPerson(String userName, String pass) {
        return new Person(userName, pass);
    }

    @Override
    public Person logIn(String userName, String pass) {
/*
        for (int ind=0; ind < persons.size(); ind++ ){
            String uName = persons.get(ind).getUserName();
            String upass = persons.get(ind).getPass();
            if (uName.equals(userName)
                    && upass.equals(pass)){
                return persons.get(ind);
            }
        }
        return null;
*/
        int index =-1;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getUserName().equals(userName)){
                index = i;
                break;
            }
        }
        if ((index >=0) && persons.get(index).getPass().equals(pass)) {
            return persons.get(index);
        } else return null;
    }

    @Override
    public ArrayList<Order> getNewOrders(int personId) {
        ArrayList<Order> res = new ArrayList<Order>();

        if (getPersons().get(personId).getType().equals("Driver")) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getState().equals("New")){
                    res.add(orders.get(i));
                }
            }
            return res;
        }
            return null;
    }

    @Override
    public Person getOnePerson(int personId) {
        return getPersons().get(personId);
    }
}
