package vn.edu.uit.tmlnghia.shopping.until;

import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Webserviecs {
    public static String host = "https://uitshopping-backend.herokuapp.com/";
    //public static String host = "http://10.0.0.156:3000/";
    public static JSONArray getJsonArray(String link){
        try{
        URL url = new URL(host +link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        StringBuilder builder = new StringBuilder();
        String line = null;
        while((line = br.readLine()) != null){
            builder.append(line);
        }
        br.close();
        return new JSONArray(builder.toString());
        }catch (Exception ex){
            Log.e("Loi:",ex.toString());
        }
        return null;
    }

    public static boolean postAPI(String link){
        try{
            URL url = new URL(host +link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line = br.readLine()) != null){
                builder.append(line);
            }
            boolean kq = (builder.toString().length() > 1);
            br.close();
            return kq;
        }catch (Exception ex){
            Log.e("Loi:",ex.toString());
        }
        return false;
    }
}
