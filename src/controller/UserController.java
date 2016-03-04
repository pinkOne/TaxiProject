package controller;

import model.Model;

/**
 * Created by I on 2016-03-02.
 *
 */
public class UserController implements IController {
    public static String processRequest(Model model, Request request) {
        String response = null;
        // userId=11&street1=shevchenka 8&street2=fizkultury 28
        if (request.containsParam("street1")) {
            response = model.placeOrder(request.getIntValue("userId"),
                    request.getValue("street1"),
                    request.getValue("street2"))
                    .toString();
        }

        return response;
    }
}
