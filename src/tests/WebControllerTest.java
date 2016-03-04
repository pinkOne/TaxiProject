package tests;

import controller.WebController;
import model.Driver;
import model.Model;
import model.Person;
import model.User;
import org.junit.Test;
import static org.junit.Assert.*;
import static tests.Test.checkResult;

/**
 * Created by I on 2016-03-02.
 *
 */
public class WebControllerTest {
    String request;
    String result;
    WebController controller;

    @org.junit.Before
    public void setUp() throws Exception {
        Person first = new User("iurii","123");
        Person second = new User("Viktor","123");
        Person driver1 = new Driver("Shef", "poehali");

        Model model = new Model();
        model.addPerson(first);
        model.addPerson(second);
        model.addPerson(driver1);

        controller = new WebController(model);
    }

    @Test
    public void testProcessRequestLogInUnknownUser() throws Exception {
        request = "person=PetroSalo&password=123";
        result = controller.processRequest(request);
        System.out.println(result);
        checkResult("testProcessRequestLogInUnknownUser " + request,
                ! result.contains("type"));
    }

    @Test
    public void testProcessRequestLogIn() throws Exception {
        request = "person=Viktor&password=123";
        result = controller.processRequest(request);
        System.out.println(result);
        checkResult("testProcessRequestLogIn " + request,
                result.contains("type"));
    }

    @Test
    public void testProcessRequestPlaceOrder() throws Exception {
        request = "userId=0&street1=shevchenka 8&street2=fizkultury 28";
        result = controller.processRequest(request);
        System.out.println(result);
        checkResult("testProcessRequestPlaceOrder " + request,
                result.contains("Order"));
    }

    @Test
    public void testProcessRequestViewOrder() throws Exception {

        request = "personId=0&orderNumber=0&action=view";
        result = controller.processRequest(request);
        System.out.println(result);
        checkResult("testProcessRequestViewOrder " + request,
                result.contains("Order"));
    }

    @Test
    public void testProcessRequestCloseOrder() throws Exception {

        //add order
        request = "userId=0&street1=shevchenka 8&street2=fizkultury 28";
        result = controller.processRequest(request);

        request = "driverId=2&orderNumber=0&action=close";
        result = controller.processRequest(request);
        System.out.println(result);
        checkResult("testProcessRequestCloseOrder " + request,
                    result.contains("CLOSED"));
    }

}