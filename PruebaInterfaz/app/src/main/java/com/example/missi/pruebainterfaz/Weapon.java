package com.example.missi.pruebainterfaz;

public class Weapon extends  Carta {
    private int moneyCost;
    private String active;
    private String passive;

    public Weapon(String name, int id_img, String color, int cost, int moneyCost, String active, String passive) {
        super(name, id_img, color, cost);
        this.moneyCost = moneyCost;
        this.active = active;
        this.passive = passive;
    }


    public Weapon(int cost, String active, String passive) {
        this.moneyCost = cost;
        this.active = active;
        this.passive = passive;
    }


    public int getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(int moneyCost) {
        this.moneyCost = moneyCost;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }
}
