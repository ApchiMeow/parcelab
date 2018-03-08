package com.apchimeow.lab.DOM;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class DomQueryXml {

    public static void main(String argv[]) {

        try {
            File inputFile = new File("src/main/resources/myAnimeList1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Root element: ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("completed");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :");
                System.out.print(nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("Total completed : ");
                    System.out.println(eElement.getAttribute("total"));
                    NodeList animeList = eElement.getElementsByTagName("anime");

                    for (int count = 0; count < animeList.getLength(); count++) {
                        Node node1 = animeList.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element anime = (Element) node1;
                            System.out.print("IMDB : ");
                            System.out.println(anime.getAttribute("IMDB"));
                            System.out.print("Info : ");
                            System.out.println(anime.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
