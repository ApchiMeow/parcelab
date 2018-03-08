package com.apchimeow.lab.XMLtoOBJ;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class SerializeToXml {
    public static void main(String[] args) throws IOException {

        String[] inventory = {"Броня", "Оружие", "Монеты"};
        CharClass profa = new CharClass(CharClass.profa.MAG, 100, 100);

        // не знаю, почему добавляет 1 месяц и 1900 лет...
        Character character = new Character("myNick", profa, 5, inventory, new Date(2018-1900, 3-1, 8));

        //Before
        System.out.println(character);
        serializeToXML(character);
        Character loadedCharacter = deserializeFromXML();
        //After
        System.out.println(loadedCharacter);
    }

    private static void serializeToXML(Character character) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/resources/myCharacterList.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.writeObject(character);
        encoder.close();
        fos.close();
    }

    private static Character deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/myCharacterList.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        Character decodedCharacter = (Character) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedCharacter;
    }
}