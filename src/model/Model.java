package model;

/**
 * Created by I on 2016-03-02.
 */
public class Model implements IModel {

    @Override
    public String logIn(String userName, String password) {
        return "in model logIn";
    }

    @Override
    public String placeOrder(String userId, String str1, String str2) {
        return "in model placeOrder";
    }

    @Override
    public String viewOrder(String personId, String orderNumber) {
        return "in model viewOrder";
    }
    @Override
    public String pickOrder(String driverId, String orderNumber) {
        return "in model pickOrder";
    }

    @Override
    public String closeOrder(String orderNumber) {
        return "in model closeOrder";
    }

}
