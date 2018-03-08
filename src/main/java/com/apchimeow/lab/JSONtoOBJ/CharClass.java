package com.apchimeow.lab.JSONtoOBJ;

public class CharClass {
    public static enum profa{WAR, MAG, ARC};
    private profa p;
    private int hp;
    private int mp;
    private static boolean create = true;

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
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
}
