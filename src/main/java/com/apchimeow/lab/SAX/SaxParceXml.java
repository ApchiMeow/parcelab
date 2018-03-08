package com.apchimeow.lab.SAX;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParceXml {

    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/resources/myAnimeList.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxParceXmlHandler userhandler = new SaxParceXmlHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
