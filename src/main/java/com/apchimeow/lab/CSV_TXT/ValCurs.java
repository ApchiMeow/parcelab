package com.apchimeow.lab.CSV_TXT;

import java.util.ArrayList;
import java.util.Date;

public class ValCurs {
    private String date;
    private String mainName;
    private ArrayList<Valute> valutes;

    public ValCurs(String date, String mainName, ArrayList<Valute> valutes){
        setDate(date);
        setMainName(mainName);
        setValutes(valutes);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public ArrayList<Valute> getValutes() {
        return valutes;
    }

    public void setValutes(ArrayList<Valute> valutes) {
        this.valutes = valutes;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Valute val : valutes){
            str.append(val.toString());
        }
        return String.format("\nValCurs (Date : " + getDate()
        + ", name : " + getMainName()
        + ") \n----------------------------\n"
        + str + "\n");
    }
}
