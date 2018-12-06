package com.example.missi.pruebainterfaz;

public class Carta implements Comparable {

    private String name;
    private int id_img;
    private String color;
    private int cost;

    public Carta(String name, int id_img, String color, int cost) {
        this.name = name;
        this.id_img = id_img;
        this.color = color;
        this.cost = cost;
    }

    public Carta(String name, int id_img, String color) {
        this.name = name;
        this.id_img = id_img;
        this.color = color;
    }

    public Carta() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        Carta c = (Carta) o;
        if (this.name.charAt(0) > c.getName().charAt(0)) {
            return 1;
        } else {
            if (this.name.charAt(0) > c.getName().charAt(0)) {
                return 0;

            }
        }
        return -1;
    }
}
