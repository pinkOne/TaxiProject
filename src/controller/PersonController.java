package controller;

import model.IModel;
import model.Order;
import model.Person;
import model.User;
import view.IView;
import view.LogInFailedView;
import view.LoggedInView;

/**
 * Created by I on 2016-03-04.
 *
 */
public class PersonController {
    public String processRequest(IModel model, Request request) {
        String response = null;
        // Web Requests like
        // person=PetroSalo&password=123
        if (request.containsParam("password")) {
            String userName = request.getValue("person");
            String password = request.getValue("password");
            Person person = model.logIn(userName, password);

            if (person != null){
                IView view = new LoggedInView(person);
                response = view.show();
            }else{
                IView view = new LogInFailedView(userName, password);
                response = view.show();
            }
        }
        // personId=22&orderNumber=33&action=view
        if (request.containsParam("action")
                && "view".equals(request.getValue("action"))) {
            Order order = model.getOrder(request.getIntValue("orderNumber"));
            response = ( order == null)? "" : order.toString();
        }
        return response;
        
    }
}
