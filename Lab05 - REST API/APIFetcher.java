package pl.fox.lab5;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class APIFetcher {

    public static String fetchAsString(String URL){
        String content;
        try {
            URLConnection connection =  new URL(URL).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
            return content;
        }catch (Exception ex ) {
            ex.printStackTrace();
        }
        return "Returned String was empty";
    }

    public static JSONObject fetchFrom(String URL, String method){
        String content;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod(method);
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
            return new JSONObject(content);
        }catch (Exception ex ) {
            ex.printStackTrace();
        }
        return new JSONObject();
    }


}
