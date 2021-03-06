package controller;

import model.IModel;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by I on 2016-03-02.
 *
 */
public class WebController {
    String request;
    String response;
    IModel model;

    public WebController(IModel model) {
        this.model = model;
    }

    public String processRequest(String url) {
        Request request = null;
        try {
            request = new Request(new URL("http://www.taxi.com/page.html?" + url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (request == null) return "Wrong request retrieved.";

        if (request.containsParam("personId") || request.containsParam("person")){
            PersonController personController = new PersonController();
            response = personController.processRequest(model, request);
        }else{
            if (request.containsParam("userId")){
                UserController userController = new UserController();
                response = userController.processRequest(model, request);
            }else{
                if (request.containsParam("driverId")){
                    DriverController driverController = new DriverController();
                    response = driverController.processRequest(model, request);
                }
            }
        }
        return response;
    }
/*

    private String readRequest() {
            try {
                BufferedReader bufferedReader;
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                bufferedReader = new BufferedReader(inputStreamReader);
                return bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        return "";
    }

    private void prepareRemoteToUser() {
        String introMessage = "Hello! This is TaxiProject. We glad to see you here.\n" +
                "Please log in and have a good day! Type bye for exit.";
        System.out.println(introMessage);
    }

    public void start(){
        prepareRemoteToUser();
        while (! "bye".equals(request = readRequest())){
            System.out.println("request:");
            System.out.println( processRequest(request) );
        }
    }

    public static void main(String[] args) {
        WebController controller;
        controller = new WebController(new Model());
        controller.start();
    }
*/
}
