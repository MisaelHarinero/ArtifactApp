package com.example.missi.pruebainterfaz;

import android.graphics.Color;

public class Heroe extends Carta {

    private int daño;
    private int armadura;
    private int vida;
    private String ability;

    public Heroe(String name, int daño, int armadura, int vida, String color, String ability, int id_img) {

        super(name,id_img,color);
        this.daño = daño;
        this.armadura = armadura;
        this.vida = vida;
        this.ability = ability;

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

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}
