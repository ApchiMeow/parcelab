package com.apchimeow.lab.CSV_TXT;

public class Valute {
    private int ID;
    private int numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;

    public Valute(int ID, int numCode, String charCode, int nominal, String name, double value){
        setID(ID);
        setNumCode(numCode);
        setCharCode(charCode);
        setNominal(nominal);
        setName(name);
        setValue(value);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumCode() {
        return numCode;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("\nValute ID : " + getID()
        + "\nNumCode : " + getNumCode()
        + "\nCharCode : " + getCharCode()
        + "\nNominal : " + getNominal()
        + "\nName : " + getName()
        + "\nValue : " + getValue() + "\n");
    }
}
