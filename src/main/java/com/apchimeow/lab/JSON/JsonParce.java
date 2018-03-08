package com.apchimeow.lab.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonParce {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("src/main/resources/myGamesList.json"));
            JSONObject jsonObject = (JSONObject) obj;
//            System.out.println(jsonObject);

            JSONArray games = (JSONArray)jsonObject.get("games");

            Iterator<JSONObject> it = games.iterator();
            while (it.hasNext()) {
                JSONObject o = it.next();
                String title = (String) o.get("title");
                System.out.println("Title : " + title);
                long year = (Long) o.get("year");
                System.out.println("Year : " + year);
                System.out.println("Platforms : ");
                JSONArray arr = (JSONArray) o.get("platforms");
                Iterator<String> iterator = arr.iterator();
                while (iterator.hasNext()) {
                    System.out.println("\t" + iterator.next());
                }
                System.out.println("----------------------------");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
