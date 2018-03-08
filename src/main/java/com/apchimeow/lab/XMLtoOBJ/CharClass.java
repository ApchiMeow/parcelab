package com.apchimeow.lab.XMLtoOBJ;

public class CharClass {
    public static enum profa{WAR, MAG, ARC};
    private profa p;
    private int hp;
    private int mp;

    public CharClass(){

    }

    public CharClass(profa p, int hp, int mp){
        setP(p);
        setHp(hp);
        setMp(mp);
    }

    public profa getP() {
        return p;
    }

    public void setP(profa p) {
        this.p = p;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if(getP() == profa.WAR){
            this.hp = hp + 150;
        }
        if(getP() == profa.MAG){
            this.hp = hp + 50;
        }
        if(getP() == profa.ARC){
            this.hp = hp + 100;
        }
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
        if(getP() == profa.WAR){
            this.mp = mp + 50;
        }
        if(getP() == profa.MAG){
            this.mp = mp + 150;
        }
        if(getP() == profa.ARC){
            this.mp = mp + 100;
        }
    }
}
