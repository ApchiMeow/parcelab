package com.apchimeow.lab.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonCreate {

    public static void main(String[] args) {
        JSONObject allGames = new JSONObject();
        JSONArray games = new JSONArray();

        JSONObject[] game = new JSONObject[3];

        game[0] = new JSONObject();
        JSONArray platform0 = new JSONArray();
        platform0.add("PlayStation");
        platform0.add("PlayStation 2");
        platform0.add("Wii");
        platform0.add("Microsoft Windows");
        game[0].put("platforms", platform0);
        game[0].put("title", "Silent hill");
        game[0].put("year", 1999);

        game[1] = new JSONObject();
        JSONArray platform1 = new JSONArray();
        platform1.add("PlayStation");
        platform1.add("PlayStation 2");
        platform1.add("Microsoft Windows");
        game[1].put("platforms", platform1);
        game[1].put("title", "Metal Gear Solid");
        game[1].put("year", 1998);

        game[2] = new JSONObject();
        JSONArray platform2 = new JSONArray();
        platform2.add("PlayStation 3");
        platform2.add("XBOX 360");
        platform2.add("Android");
        platform2.add("Microsoft Windows");
        platform2.add("iOS");
        game[2].put("platforms", platform2);
        game[2].put("title", "Final Fantasy XIII");
        game[2].put("year", 2009);

        for(JSONObject o : game)
            games.add(o);

        allGames.put("games", games);

        try (FileWriter file = new FileWriter("src/main/resources/myGamesList.json")) {

            file.write(allGames.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
