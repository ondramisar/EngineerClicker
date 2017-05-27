package com.companybest.ondra.engineerclicker.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private String name;

    private float coins;


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
