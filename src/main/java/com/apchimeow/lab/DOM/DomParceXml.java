package com.apchimeow.lab.DOM;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParceXml {
    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/resources/myAnimeList.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName() + "\nTotal : " + doc.getDocumentElement().getAttribute("total"));
            NodeList nList = doc.getElementsByTagName("anime");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName() + " " + temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("IMDB : "
                            + eElement.getAttribute("IMDB"));
                    System.out.println("Title (JP) : "
                            + eElement
                            .getElementsByTagName("title")
                            .item(0)
                            .getTextContent());
                    System.out.println("Title (EN) : "
                            + eElement
                            .getElementsByTagName("title")
                            .item(1)
                            .getTextContent());
                    System.out.println("Year : "
                            + eElement
                            .getElementsByTagName("year")
                            .item(0)
                            .getTextContent());
                    System.out.println("Episodes : "
                            + eElement
                            .getElementsByTagName("episodes")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
