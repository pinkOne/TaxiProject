package controller;

import model.Model;

/**
 * Created by I on 2016-03-02.
 *
 */
public class DriverController implements IController {
    public static String processRequest(Model model, Request request) {
        String response = null;
        // driverId=4&orderNumber=5&action=pick
        if (request.containsParam("action")
                && "pick".equals(request.getValue("action"))) {
            response = model.pickOrder(request.getIntValue("driverId"),
                    request.getIntValue("orderNumber"))
                    .toString();
        }
        //driverId=6&orderNumber=5&action=close
        if (request.containsParam("action")
                && "close".equals(request.getValue("action"))) {
            response = model.closeOrder(request.getIntValue("driverId"),
                    request.getIntValue("orderNumber"))
                    .toString();
        }

        return response;
    }
}
