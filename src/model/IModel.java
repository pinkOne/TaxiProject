package model;

/**
 * Created by Iurii on 02.03.2016.
 */
public interface IModel {
    String logIn(String userName, String password);
    String placeOrder(String userId , String str1, String str2);
    String viewOrder(String personId, String orderNumber);
    String pickOrder(String driverId, String orderNumber);
    String closeOrder(String orderNumber);
}
