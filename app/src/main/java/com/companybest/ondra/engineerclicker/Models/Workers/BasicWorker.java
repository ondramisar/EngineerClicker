package com.companybest.ondra.engineerclicker.Models.Workers;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class BasicWorker extends RealmObject {
    @PrimaryKey
    private String name;
    private int numberOf;
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost, boolean plus) {
        if (plus){
            this.cost += cost;
        } else {
            this.cost -= cost;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf, boolean plus) {
        if (plus) {
            this.numberOf += numberOf;
        } else {
            if (this.numberOf == 0){
                this.numberOf = 0;
            } else {
                this.numberOf -= numberOf;
            }
        }
    }
}
