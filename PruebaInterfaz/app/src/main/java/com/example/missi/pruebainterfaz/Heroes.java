package com.example.missi.pruebainterfaz;

import android.graphics.Color;

public class Heroes {
    private String name;
    private int daño;
    private int armadura;
    private int vida;
    private String color;
    private String ability;
    private int id_img;

    public Heroes(String name, int daño, int armadura, int vida, String color, String ability, int id_img) {
        this.name = name;
        this.daño = daño;
        this.armadura = armadura;
        this.vida = vida;
        this.color = color;
        this.ability = ability;
        this.id_img = id_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }
}
