package com.example.missi.pruebainterfaz;

public class Spell extends  Carta{
    private String effect;

    public Spell(String name, int id_img, String color, int cost, String effect) {
        super(name, id_img, color, cost);
        this.effect = effect;
    }


    public Spell(String effect) {
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
