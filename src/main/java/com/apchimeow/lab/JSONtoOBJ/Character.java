package com.apchimeow.lab.JSONtoOBJ;

import java.util.Date;

public class Character {

    private String nickName;
    private CharClass profa;
    private int level;
    private Date doc;
    private String[] inventory;

    public Character(){

    }

    public Character(String nickName, CharClass profa, int level, String[] inventory, Date doc){
        this.nickName = nickName;
        this.profa = profa;
        this.level = level;
        this.inventory = inventory;
        this.doc = doc;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public CharClass getProfa() {
        return profa;
    }

    public void setProfa(CharClass profa) {
        this.profa = profa;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getDoc() {
        return doc;
    }

    public void setDoc(Date doc) {
        this.doc = doc;
    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Имя персонажа : " + getNickName()
                + "\nКласс : " + profa.getP()
                + "\nХП : " + profa.getHp()
                + "\nМП : " + profa.getMp()
                + "\nУровень : " + getLevel()
                + "\nДата создания : " + getDoc()
                + "\nИнветарь : " + inventory[0] + "\n" + inventory[1] + "\n" + inventory[2];
    }

}

