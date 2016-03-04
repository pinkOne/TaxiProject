package controller;

import model.Model;
import model.Order;

/**
 * Created by I on 2016-03-04.
 *
 */
public class PersonController {
    public static String processRequest(Model model, Request request) {
        String response = null;
        // Web Requests like
        // person=PetroSalo&pass=123
        if (request.containsParam("pass")) {
            response = String.valueOf(model.logIn(request.getValue("userName"),
                    request.getValue("password")));
        }
        // personId=22&orderNumber=33&action=view
        if (request.containsParam("action")
                && "view".equals(request.getValue("action"))) {
            Order order = model.viewOrder(request.getIntValue("personId"),
                    request.getIntValue("orderNumber"));
            response = ( order == null)? "" : order.toString();
        }

        return response;
    }
}
