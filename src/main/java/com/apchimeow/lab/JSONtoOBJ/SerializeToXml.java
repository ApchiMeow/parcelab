package com.apchimeow.lab.JSONtoOBJ;


import java.io.*;
import java.util.Date;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerializeToXml {
    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        String[] inventory = {"Броня", "Оружие", "Монеты"};
        CharClass profa = new CharClass(CharClass.profa.MAG, 100, 100);

        xmlMapper.writeValue(new File("src/main/resources/myCharacterList1.xml"), new Character("myNick", profa, 5, inventory, new Date(2018-1900, 3-1, 8)));
        File file = new File("src/main/resources/myCharacterList1.xml");

        fromXmlFile();
    }

    public static void fromXmlFile() throws IOException {
        File file = new File("src/main/resources/myCharacterList1.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        Character value = xmlMapper.readValue(xml, Character.class);
        System.out.println(value);
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
