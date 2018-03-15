package com.apchimeow.lab.JSONtoOBJ;


import java.io.*;
import java.util.Date;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeToJson {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/myCharacterList1.json");
        String[] inventory = {"Броня", "Оружие", "Монеты"};
        CharClass profa = new CharClass(CharClass.profa.MAG, 100, 100);
        ObjectMapper mapper = new ObjectMapper();
        Character character = new Character("myNick", profa, 5, inventory, new Date(2018-1900, 3-1, 8));

        //сериализация
        mapper.writeValue(file, character); //конвертируем объект в json

        //десериализация
        String str = inputStreamToString(new FileInputStream(file)); //записываем всю информацию в одну строку
        Character value = mapper.readValue(str, Character.class); //конвертируем строку в объект
        System.out.println(value); //вызов toString() нашего объекта
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
