package com.apchimeow.lab.CSV_TXT;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVTest {

    public static void main(String[] args) {
        String csvFile = "src/main/resources/myCSVFile.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Dates [id= " + line[0] + ", code= " + line[1] + " , name=" + line[2] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}