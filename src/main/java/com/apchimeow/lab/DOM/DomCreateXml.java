package com.apchimeow.lab.DOM;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class DomCreateXml {

    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("myAnimeList");
            doc.appendChild(rootElement);

            int anime = 0;
            Attr total = doc.createAttribute("total");

            Element anime1 = doc.createElement("anime");
            anime++;
            Attr imdb1 = doc.createAttribute("IMDB");
            imdb1.setValue("0112159");
            anime1.setAttributeNode(imdb1);
            rootElement.appendChild(anime1);

            Element title1 = doc.createElement("title");
            anime1.appendChild(title1);
            Attr language1 = doc.createAttribute("language");
            language1.setValue("JP");
            title1.setAttributeNode(language1);
            title1.appendChild(doc.createTextNode("新世紀エヴァンゲリオン"));

            Element title2 = doc.createElement("title");
            anime1.appendChild(title2);
            Attr language2 = doc.createAttribute("language");
            language2.setValue("EN");
            title2.setAttributeNode(language2);
            title2.appendChild(doc.createTextNode("Neon Genesis Evangelion"));

            Element year1 = doc.createElement("year");
            anime1.appendChild(year1);
            year1.appendChild(doc.createTextNode("1995"));

            Element episodes1 = doc.createElement("episodes");
            anime1.appendChild(episodes1);
            episodes1.appendChild(doc.createTextNode("26"));


            Element anime2 = doc.createElement("anime");
            anime++;
            Attr imdb2 = doc.createAttribute("IMDB");
            imdb2.setValue("0480489");
            anime2.setAttributeNode(imdb2);
            rootElement.appendChild(anime2);

            Element title3 = doc.createElement("title");
            anime2.appendChild(title3);
            Attr language3 = doc.createAttribute("language");
            language3.setValue("JP");
            title3.setAttributeNode(language3); // language = "JP"
            title3.appendChild(doc.createTextNode("エルフェンリート"));

            Element title4 = doc.createElement("title");
            anime2.appendChild(title4);
            Attr language4 = doc.createAttribute("language");
            language4.setValue("EN");
            title4.setAttributeNode(language4);
            title4.appendChild(doc.createTextNode("Elfen Lied"));

            Element year2 = doc.createElement("year");
            anime2.appendChild(year2);
            year2.appendChild(doc.createTextNode("2004"));

            Element episodes2 = doc.createElement("episodes");
            anime2.appendChild(episodes2);
            episodes2.appendChild(doc.createTextNode("13"));

            Element anime3 = doc.createElement("anime");
            anime++;
            Attr imdb3 = doc.createAttribute("IMDB");
            imdb3.setValue("1355642");
            anime3.setAttributeNode(imdb3);
            rootElement.appendChild(anime3);

            Element title5 = doc.createElement("title");
            anime3.appendChild(title5);
            Attr language5 = doc.createAttribute("language");
            language5.setValue("JP");
            title5.setAttributeNode(language5);
            title5.appendChild(doc.createTextNode("鋼の錬金術師 FULLMETAL ALCHEMIST"));

            Element title6 = doc.createElement("title");
            anime3.appendChild(title6);
            Attr language6 = doc.createAttribute("language");
            language6.setValue("EN");
            title6.setAttributeNode(language6);
            title6.appendChild(doc.createTextNode("Fullmetal Alchemist: Brotherhood"));

            Element year3 = doc.createElement("year");
            anime3.appendChild(year3);
            year3.appendChild(doc.createTextNode("2009"));

            Element episodes3 = doc.createElement("episodes");
            anime3.appendChild(episodes3);
            episodes3.appendChild(doc.createTextNode("64"));

            total.setValue(String.valueOf(anime));
            rootElement.setAttributeNode(total);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/myAnimeList.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
