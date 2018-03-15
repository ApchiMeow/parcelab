package com.apchimeow.lab.CSV;

import com.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class GetValuesFromBNM {
    private static StringBuilder url = new StringBuilder("https://bnm.md/en/official_exchange_rates?get_xml=1&date=");
    private static ArrayList<String> dates = new ArrayList<>();
    private static ArrayList<ValCurs> valCurs = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Читаем CSV: ");
        getDatesFromCSV();
        for (String url : dates) {
            System.out.println("\nПереходим по ссылке...\n" + url);
            System.out.println("Получаем данные...");
            parceXML(url);
        }
        System.out.println("Все данные получены и записаны в объекты.\nВыводим объекты...\n");
        for(ValCurs o : valCurs){
            System.out.println(o);
        }
        System.out.println("Создаём XLSX файл. Ожидайте...");
        createXLSX();
        System.out.println("Всё, закончили!");
    }

    private static void getDatesFromCSV() {
        String csvFile = "src/main/resources/myCSVFile.csv";
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                for (int i = 0; ; i++) {
                    try {
                        System.out.println("date[" + i + "] = " + line[i]);
                        dates.add(url.replace(57, 67, line[i]).toString());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("STOP");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parceXML(String url) {
        ArrayList<Valute> valutes = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL(url).openStream());
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName()
                    + " (Date : " + doc.getDocumentElement().getAttribute("Date")
                    + ", name : " + doc.getDocumentElement().getAttribute("name") + ")");
            NodeList nList = doc.getElementsByTagName("Valute");
            System.out.print("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName() + " " + temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
//                    System.out.println("ID : "
//                            + eElement.getAttribute("ID"));
//                    System.out.println("NumCode : "
//                            + eElement
//                            .getElementsByTagName("NumCode")
//                            .item(0)
//                            .getTextContent());
//                    System.out.println("CharCode : "
//                            + eElement
//                            .getElementsByTagName("CharCode")
//                            .item(0)
//                            .getTextContent());
//                    System.out.println("Nominal : "
//                            + eElement
//                            .getElementsByTagName("Nominal")
//                            .item(0)
//                            .getTextContent());
//                    System.out.println("Name : "
//                            + eElement
//                            .getElementsByTagName("Name")
//                            .item(0)
//                            .getTextContent());
//                    System.out.println("Value : "
//                            + eElement
//                            .getElementsByTagName("Value")
//                            .item(0)
//                            .getTextContent());
                    valutes.add(makeObject(eElement));
                }
            }
            valCurs.add(new ValCurs(doc.getDocumentElement().getAttribute("Date"),
                    doc.getDocumentElement().getAttribute("name"),
                    valutes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Valute makeObject(Element el){
        return new Valute(Integer.parseInt(el.getAttribute("ID")),
                Integer.parseInt(el.getElementsByTagName("NumCode").item(0).getTextContent()),
                el.getElementsByTagName("CharCode").item(0).getTextContent(),
                Integer.parseInt(el.getElementsByTagName("Nominal").item(0).getTextContent()),
                el.getElementsByTagName("Name").item(0).getTextContent(),
                Double.parseDouble(el.getElementsByTagName("Value").item(0).getTextContent())
                );
    }

    public static void createXLSX() {
        try {
            Workbook wb = new XSSFWorkbook();
            for(ValCurs valC : valCurs){
                Sheet sheet = wb.createSheet(valC.getDate());
                Row row0 = sheet.createRow(0);
                row0.createCell(0).setCellValue("Value ID");
                row0.createCell(1).setCellValue("NumCode");
                row0.createCell(2).setCellValue("CharCode");
                row0.createCell(3).setCellValue("Nominal");
                row0.createCell(4).setCellValue("Name");
                row0.createCell(5).setCellValue("Value");
                ArrayList<Valute> valutes = valC.getValutes();
                int counter = 1;
                for(Valute val : valutes){
                    Row row1 = sheet.createRow(counter);
                    row1.createCell(0).setCellValue(val.getID());
                    row1.createCell(1).setCellValue(val.getNumCode());
                    row1.createCell(2).setCellValue(val.getCharCode());
                    row1.createCell(3).setCellValue(val.getNominal());
                    row1.createCell(4).setCellValue(val.getName());
                    row1.createCell(5).setCellValue(val.getValue());
                    counter++;
                }
                counter = 1;
            }
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/workbook.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
