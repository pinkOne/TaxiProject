package controller;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by I on 2016-03-04.
 *
 */
public class Request {

    URL request;
    Map<String, String> paramNValues;

    public Request(URL url) {
        paramNValues = new LinkedHashMap<>();
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
