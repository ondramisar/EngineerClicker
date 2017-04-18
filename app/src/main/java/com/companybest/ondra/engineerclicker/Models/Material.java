package com.companybest.ondra.engineerclicker.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class Material extends RealmObject {
    @PrimaryKey
    private String name;

    private int cost;
    private int numberOf;
    private String nameOfImg;

    public String getNameOfImg() {
        return nameOfImg;
    }

    public void setNameOfImg(String nameOfImg) {
        this.nameOfImg = nameOfImg;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost, boolean plus) {
        if (plus) {
            this.cost += cost;
        } else {
            this.cost -= cost;
        }
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf, boolean plus) {
        if (plus) {
            this.numberOf += numberOf;
        } else {
            this.numberOf -= numberOf;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}