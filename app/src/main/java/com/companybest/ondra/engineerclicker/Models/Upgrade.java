package com.companybest.ondra.engineerclicker.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Upgrade extends RealmObject {
    @PrimaryKey
    private String name;

    private String nameOfMachinetoGive;
    private String nameOfMaterialGive;
    private String forWhatToDo;
    private int cost;
    private int whatDo;
    private String nameOfImg;


    public String getNameOfImg() {
        return nameOfImg;
    }

    public void setNameOfImg(String nameOfImg) {
        this.nameOfImg = nameOfImg;
    }

    public String getForWhatToDo() {
        return forWhatToDo;
    }

    public void setForWhatToDo(String forWhatToDo) {
        this.forWhatToDo = forWhatToDo;
    }

    public String getNameOfMaterialGive() {
        return nameOfMaterialGive;
    }

    public void setNameOfMaterialGive(String nameOfMaterialGive) {
        this.nameOfMaterialGive = nameOfMaterialGive;
    }

    public String getNameOfMachinetoGive() {
        return nameOfMachinetoGive;
    }

    public void setNameOfMachinetoGive(String nameOfMachinetoGive) {
        this.nameOfMachinetoGive = nameOfMachinetoGive;
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

    public int getWhatDo() {
        return whatDo;
    }

    public void setWhatDo(int whatDo) {
        this.whatDo = whatDo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
