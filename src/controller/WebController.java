package controller;

import model.Model;
import model.Order;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by I on 2016-03-02.
 *
 */
public class WebController {
    String request;
    String response;
    Model model;

    public WebController(Model model) {
        this.model = model;
    }

    private class Request{

        URL request;
        Map<String, String> paramNValues;
        public Request(URL url) {
            this.request = request;
            paramNValues = new LinkedHashMap<String, String>();
            String query = url.getQuery();
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                try {
                    paramNValues.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        public boolean containsParam(String paramName) {
            return paramNValues.containsKey(paramName);
        }

        public String getValue(String paramName) {
            return paramNValues.get(paramName);
        }

        public int getIntValue(String paramName) {
            String value = paramNValues.get(paramName);
            Integer result = null;
            try {
                result = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (result == null) result = -1;
            return result;
        }
    }
    public String processRequest(String url) {
        Request request = null;
        try {
            request = new Request(new URL("http://www.taxi.com/page.html?" + url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (request == null) return "Wrong request retrieved.";

        // Web Requests like
        // person=PetroSalo&pass=123
        if (request.containsParam("pass")) {
            response = String.valueOf(model.logIn(request.getValue("userName"),
                                    request.getValue("password")));
        }
        // userId=11&street1=shevchenka 8&street2=fizkultury 28
        if (request.containsParam("street1")) {
            response = model.placeOrder(request.getIntValue("userId"),
                                        request.getValue("street1"),
                                        request.getValue("street2"))
                                        .toString();
        }
        // personId=22&orderNumber=33&action=view
        if (request.containsParam("action")
                && "view".equals(request.getValue("action"))) {
            Order order = model.viewOrder(request.getIntValue("personId"),
                                            request.getIntValue("orderNumber"));
            response = ( order == null)? "" : order.toString();
        }
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

    private String readRequest() {
            try {
                System.out.println("request:");
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
            System.out.println( processRequest(request) );
        }
    }

    public static void main(String[] args) {
        WebController controller;
        controller = new WebController(new Model());
        controller.start();
    }
}
