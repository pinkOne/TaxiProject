package model;

/**
 * Created by Iurii on 02.03.2016.
 */
public interface IModel {

    Order placeOrder(String userId , Address str1, Address str2);
    Order viewOrder (String personId, int orderNumber);
    Order pickOrder (String driverId, int orderNumber);
    Order closeOrder (int OrderNymber);
    boolean addPerson();
    int logIn (String userName, String pass);

}
