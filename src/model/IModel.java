package model;

/**
 * Created by Iurii on 02.03.2016.
 *
 */
public interface IModel {

    Order placeOrder(int personId , String str1, String str2);
    Order viewOrder (int personId, int orderNumber);
    Order pickOrder (int personId, int orderNumber);
    Order closeOrder (int personId, int orderNumber);
    boolean addPerson(Person p);
    User logIn (String userName, String pass);

}
