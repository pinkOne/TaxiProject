package model;

import java.util.ArrayList;

/**
 * Created by Iurii on 02.03.2016.
 *
 */
public interface IModel {

    Order placeOrder(int personId , String str1, String str2);
    Order getOrder ( int orderNumber);
    Order pickOrder (int personId, int orderNumber);
    Order closeOrder (int personId, int orderNumber);
    boolean addPerson(Person p);
    Person createPerson (String userName, String pass);
    Person logIn (String userName, String pass);
    ArrayList<Order> getNewOrders(int personId);
    Person getOnePerson(int personId);



}
