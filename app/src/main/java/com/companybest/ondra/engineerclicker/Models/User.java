package com.companybest.ondra.engineerclicker.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private String name;

    private int level;
    private int expNeeded;
    private int exp;

    private float coins;

    //
    int maxMachine;
    int maxWorkers;
    int maxUpgrade;

    public int getMaxMachine() {
        return maxMachine;
    }

    public void setMaxMachine(int maxMachine) {
        this.maxMachine = maxMachine;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public int getMaxUpgrade() {
        return maxUpgrade;
    }

    public void setMaxUpgrade(int maxUpgrade) {
        this.maxUpgrade = maxUpgrade;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp, int plusOrMinusOrSet) {
        if (plusOrMinusOrSet == 0) {
            this.exp += exp;
        } else if (plusOrMinusOrSet == 1){
            this.exp -= exp;
        } else if (plusOrMinusOrSet == 2){
            this.exp = exp;
        }
    }

    public int getExpNeeded() {
        return expNeeded;
    }

    public void setExpNeeded(int expNeeded, boolean plus) {
        if (plus) {
            this.expNeeded += expNeeded;
        } else {
            this.expNeeded -= expNeeded;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level, boolean plus) {
        if (plus) {
            this.level += level;
        } else {
            this.level -= level;
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
