package com.apchimeow.lab.DOM;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomCreateXml1 {

    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("myAnimeList");
            doc.appendChild(rootElement);

            Element completed = doc.createElement("completed");
            rootElement.appendChild(completed);

            int animeCompleted = 0;
            Attr totalCompleted = doc.createAttribute("total");

            Element anime1 = doc.createElement("anime");
            animeCompleted++;
            Attr imdb1 = doc.createAttribute("IMDB");
            imdb1.setValue("0877057");
            anime1.setAttributeNode(imdb1);
            completed.appendChild(anime1);

            Element title1 = doc.createElement("title");
            anime1.appendChild(title1);
            Attr language1 = doc.createAttribute("language");
            language1.setValue("JP");
            title1.setAttributeNode(language1);
            title1.appendChild(doc.createTextNode("デスノート"));

            Element title2 = doc.createElement("title");
            anime1.appendChild(title2);
            Attr language2 = doc.createAttribute("language");
            language2.setValue("EN");
            title2.setAttributeNode(language2);
            title2.appendChild(doc.createTextNode("Death Note"));

            Element year1 = doc.createElement("year");
            anime1.appendChild(year1);
            year1.appendChild(doc.createTextNode("2006"));

            Element episodes1 = doc.createElement("episodes");
            anime1.appendChild(episodes1);
            episodes1.appendChild(doc.createTextNode("37"));


            Element anime2 = doc.createElement("anime");
            animeCompleted++;
            Attr imdb2 = doc.createAttribute("IMDB");
            imdb2.setValue("0765491");
            anime2.setAttributeNode(imdb2);
            completed.appendChild(anime2);

            Element title3 = doc.createElement("title");
            anime2.appendChild(title3);
            Attr language3 = doc.createAttribute("language");
            language3.setValue("JP");
            title3.setAttributeNode(language3); // language = "JP"
            title3.appendChild(doc.createTextNode("交響詩篇エウレカセブン"));

            Element title4 = doc.createElement("title");
            anime2.appendChild(title4);
            Attr language4 = doc.createAttribute("language");
            language4.setValue("EN");
            title4.setAttributeNode(language4);
            title4.appendChild(doc.createTextNode("Eureka Seven"));

            Element year2 = doc.createElement("year");
            anime2.appendChild(year2);
            year2.appendChild(doc.createTextNode("2005"));

            Element episodes2 = doc.createElement("episodes");
            anime2.appendChild(episodes2);
            episodes2.appendChild(doc.createTextNode("50"));

            Element anime3 = doc.createElement("anime");
            animeCompleted++;
            Attr imdb3 = doc.createAttribute("IMDB");
            imdb3.setValue("0315008");
            anime3.setAttributeNode(imdb3);
            completed.appendChild(anime3);

            Element title5 = doc.createElement("title");
            anime3.appendChild(title5);
            Attr language5 = doc.createAttribute("language");
            language5.setValue("JP");
            title5.setAttributeNode(language5);
            title5.appendChild(doc.createTextNode("グレート・ティーチャー・オニヅカ"));

            Element title6 = doc.createElement("title");
            anime3.appendChild(title6);
            Attr language6 = doc.createAttribute("language");
            language6.setValue("EN");
            title6.setAttributeNode(language6);
            title6.appendChild(doc.createTextNode("Great Teacher Onizuka"));

            Element year3 = doc.createElement("year");
            anime3.appendChild(year3);
            year3.appendChild(doc.createTextNode("1999"));

            Element episodes3 = doc.createElement("episodes");
            anime3.appendChild(episodes3);
            episodes3.appendChild(doc.createTextNode("43"));

            totalCompleted.setValue(String.valueOf(animeCompleted));
            completed.setAttributeNode(totalCompleted);

            Element watching = doc.createElement("watching");
            rootElement.appendChild(watching);

            int animeWatching = 0;
            Attr totalWatching = doc.createAttribute("total");

            Element anime4 = doc.createElement("anime");
            animeWatching++;
            Attr imdb4 = doc.createAttribute("IMDB");
            imdb4.setValue("1158671");
            anime4.setAttributeNode(imdb4);
            watching.appendChild(anime4);

            Element title7 = doc.createElement("title");
            anime4.appendChild(title7);
            Attr language7 = doc.createAttribute("language");
            language7.setValue("JP");
            title7.setAttributeNode(language7);
            title7.appendChild(doc.createTextNode("狼と香辛料"));

            Element title8 = doc.createElement("title");
            anime4.appendChild(title8);
            Attr language8 = doc.createAttribute("language");
            language8.setValue("EN");
            title8.setAttributeNode(language8);
            title8.appendChild(doc.createTextNode("Spice and Wolf"));

            Element year4 = doc.createElement("year");
            anime4.appendChild(year4);
            year4.appendChild(doc.createTextNode("2008"));

            Element episodes4 = doc.createElement("episodes");
            anime4.appendChild(episodes4);
            episodes4.appendChild(doc.createTextNode("13"));


            Element anime5 = doc.createElement("anime");
            animeWatching++;
            Attr imdb5 = doc.createAttribute("IMDB");
            imdb5.setValue("0948103");
            anime5.setAttributeNode(imdb5);
            watching.appendChild(anime5);

            Element title9 = doc.createElement("title");
            anime5.appendChild(title9);
            Attr language9 = doc.createAttribute("language");
            language9.setValue("JP");
            title9.setAttributeNode(language9); // language = "JP"
            title9.appendChild(doc.createTextNode("天元突破グレンラガン"));

            Element title10 = doc.createElement("title");
            anime5.appendChild(title10);
            Attr language10 = doc.createAttribute("language");
            language10.setValue("EN");
            title10.setAttributeNode(language10);
            title10.appendChild(doc.createTextNode("Gurren Lagann"));

            Element year5 = doc.createElement("year");
            anime5.appendChild(year5);
            year5.appendChild(doc.createTextNode("2007"));

            Element episodes5 = doc.createElement("episodes");
            anime5.appendChild(episodes5);
            episodes5.appendChild(doc.createTextNode("27"));

            totalWatching.setValue(String.valueOf(animeWatching));
            watching.setAttributeNode(totalWatching);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/myAnimeList1.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
