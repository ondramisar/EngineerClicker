package com.companybest.ondra.engineerclicker.Models.Machines;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Machine extends RealmObject{
    //private int lvl;
    @PrimaryKey
    private String name;


    private int numberOf;
    private int numberOfWorkersOnMachine;
    private int cost;
    private int timerOfMachine;
    private String nameOfMaterial;
    private String nameOfNeededMaterial;
    private String nameOfImage;

    public String getNameOfImage() {
        return nameOfImage;
    }

    public void setNameOfImage(String nameOfImage) {
        this.nameOfImage = nameOfImage;
    }

    public String getNameOfNeededMaterial() {
        return nameOfNeededMaterial;
    }

    public void setNameOfNeededMaterial(String nameOfNeededMaterial) {
        this.nameOfNeededMaterial = nameOfNeededMaterial;
    }

    public String getNameOfMaterial() {
        return nameOfMaterial;
    }

    public void setNameOfMaterial(String nameOfMaterial) {
        this.nameOfMaterial = nameOfMaterial;
    }


    public int getTimerOfMachine() {
        return timerOfMachine;
    }

    public void setTimerOfMachine(int timerOfMachine, boolean plus) {
        if (plus) {
            this.timerOfMachine += timerOfMachine;
        } else {
            this.timerOfMachine -= timerOfMachine;
        }
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
            if (this.numberOf == 0) {
                this.numberOf = 0;
            } else {
                this.numberOf -= numberOf;
            }
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWorkersOnMachine() {
        return numberOfWorkersOnMachine;
    }

    public void setNumberOfWorkersOnMachine(int numberOfWorkersOnMachine, boolean plus) {
        if (plus) {
            this.numberOfWorkersOnMachine += numberOfWorkersOnMachine;
        } else {
            if (this.numberOfWorkersOnMachine == 0){
                this.numberOfWorkersOnMachine = 0;
            }else {
                this.numberOfWorkersOnMachine -= numberOfWorkersOnMachine;
            }
        }
    }

}
