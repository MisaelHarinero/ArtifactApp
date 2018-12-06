package com.example.missi.pruebainterfaz;

public class Creep extends Carta {
    private int daño;
    private int armadura;
    private int vida;

    public Creep(String name, int id_img, String color, int cost, int daño, int armadura, int vida) {
        super(name, id_img, color, cost);
        this.daño = daño;
        this.armadura = armadura;
        this.vida = vida;
    }


    public Creep(int daño, int armadura, int vida) {
        this.daño = daño;
        this.armadura = armadura;
        this.vida = vida;
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
}
