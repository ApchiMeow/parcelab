package com.apchimeow.lab.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SaxParceXmlHandler extends DefaultHandler {

    private boolean titleJP = false;
    private boolean titleEN = false;
    private boolean year = false;
    private boolean episodes = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("anime")) {
            String imdb = attributes.getValue("IMDB");
            System.out.println("IMDB : " + imdb);
        } else if (qName.equalsIgnoreCase("title")) {
            if(attributes.getValue("language").equals("JP"))
                titleJP = true;
            else if(attributes.getValue("language").equals("EN"))
                titleEN = true;
        } else if (qName.equalsIgnoreCase("year")) {
            year = true;
        } else if (qName.equalsIgnoreCase("episodes")) {
            episodes = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("anime")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (titleJP) {
            System.out.println("Title (JP): " + new String(ch, start, length));
            titleJP = false;
        } else if(titleEN) {
            System.out.println("Title (EN): " + new String(ch, start, length));
            titleEN = false;
        } else if (year) {
            System.out.println("Year: " + new String(ch, start, length));
            year = false;
        } else if (episodes) {
            System.out.println("Episodes: " + new String(ch, start, length));
            episodes = false;
        }
    }
}
