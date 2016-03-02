package tests;

import controller.WebController;
import model.Model;
import org.junit.Test;
import static org.junit.Assert.*;
import static tests.Test.checkResult;

/**
 * Created by I on 2016-03-02.
 */
public class WebControllerTest {

    WebController controller;

    @org.junit.Before
    public void setUp() throws Exception {
        controller = new WebController(new Model());
    }

    @Test
    public void testProcessRequest() throws Exception{
        String request = "person=PetroSalo&pass=123";
        checkResult("testProcessRequest " + request,
                controller.processRequest(request).contains("logIn"));

        request = "userId=11&street1=shevchenka 8&street2=fizkultury 28";
        checkResult("testProcessRequest " + request,
                controller.processRequest(request).contains("placeOrder"));

        request = "personId=22&orderNumber=33&action=view";
        checkResult("testProcessRequest " + request,
                controller.processRequest(request).contains("viewOrder"));

        request = "driverId=6&orderNumber=5&action=close";
        checkResult("testProcessRequest " + request,
                controller.processRequest(request).contains("closeOrder"));

    }

}