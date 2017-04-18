package com.companybest.ondra.engineerclicker.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private String name;

    private float coins;
    private float timeOutOfApp;
    private int cost;

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

    public float getTimeOutOfApp() {
        return timeOutOfApp;
    }

    public void setTimeOutOfApp(float timeOutOfApp, boolean plus) {
        if (plus) {
            this.timeOutOfApp += timeOutOfApp;
        } else {
            this.timeOutOfApp -= timeOutOfApp;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins, boolean plus) {
        if (plus) {
            this.coins += coins;
        } else {
            this.coins -= coins;
        }
    }
}
