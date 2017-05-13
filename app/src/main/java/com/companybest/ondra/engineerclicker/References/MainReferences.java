package com.companybest.ondra.engineerclicker.References;


import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.Upgrade;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.Workers.BasicWorker;

import io.realm.Realm;


public class MainReferences {

    // MACHINES

    public Machine machine1;
    public String nameOfMachine1 = "Extraction";
    public int numberOfMachine1 = 0;
    public int costOfMachine1 = 500;
    public int workersOnMachine1 = 0;
    public int timerOfMachine1 = 300;
    public String nameOfMaterialForMachine1 = "ore";
    private String nameOfImageMachine1 = "mine";

    public Machine machine2;
    public String nameOfMachine2 = "Steelworks";
    public int numberOfMachine2 = 0;
    public int costOfMachine2 = 2000;
    public int workersOnMachine2 = 0;
    public int timerOfMachine2 = 600;
    public String nameOfMaterialForMachine2 = "ingot";
    String nameOfMaterialNeededMachine2 = "ore";
    private String nameOfImageMachine2 = "factory";

    public Machine machine3;
    public String nameOfMachine3 = "Casting machine";
    public int numberOfMachine3 = 0;
    public int costOfMachine3 = 6000;
    public int workersOnMachine3 = 0;
    public int timerOfMachine3 = 900;
    public String nameOfMaterialForMachine3 = "rolled material and cast";
    String nameOfMaterialNeededMachine3 = "ingot";

    public Machine machine4;
    public String nameOfMachine4 = "Rolling machine";
    public int numberOfMachine4 = 0;
    public int costOfMachine4 = 9000;
    public int workersOnMachine4 = 0;
    public int timerOfMachine4 = 700;
    public String nameOfMaterialForMachine4 = "rolled material and cast";
    String nameOfMaterialNeededMachine4= "ingot";

    public Machine machine5;
    public String nameOfMachine5 = "Drill press";
    public int numberOfMachine5 = 0;
    public int costOfMachine5 = 25000;
    public int workersOnMachine5 = 0;
    public int timerOfMachine5 = 600;
    public String nameOfMaterialForMachine5 = "drilled workpiece";
    String nameOfMaterialNeededMachine5 = "rolled material and cast";
    private String nameOfImageMachine5 = "drill";

    public Machine machine6;
    public String nameOfMachine6 = "Countersinks";
    public int numberOfMachine6 = 0;
    public int costOfMachine6 = 53000;
    public int workersOnMachine6 = 0;
    public int timerOfMachine6 = 700;
    public String nameOfMaterialForMachine6 = "better drilled workpiece";
    String nameOfMaterialNeededMachine6 = "drilled workpiece";
    private String nameOfImageMachine6 = "countersinks";

    public Machine machine7;
    public String nameOfMachine7 = "Reamer";
    public int numberOfMachine7 = 0;
    public int costOfMachine7 = 110000;
    public int workersOnMachine7 = 0;
    public int timerOfMachine7 = 800;
    public String nameOfMaterialForMachine7 = "best drilled workpiece";
    String nameOfMaterialNeededMachine7 = "better drilled workpiece";
    private String nameOfImageMachine7 = "reamer";

    public Machine machine8;
    public String nameOfMachine8 = "Milling machine";
    public int numberOfMachine8 = 0;
    public int costOfMachine8 = 220000;
    public int workersOnMachine8 = 0;
    public int timerOfMachine8 = 1200;
    public String nameOfMaterialForMachine8 = "workpiece";
    private String nameOfMaterialNeededMachine8 = "best drilled workpiece";

    public Machine machine9;
    public String nameOfMachine9 = "Turning";
    public int numberOfMachine9 = 0;
    public int costOfMachine9 = 240000;
    public int workersOnMachine9 = 0;
    public int timerOfMachine9 = 1100;
    public String nameOfMaterialForMachine9 = "workpiece";
    String nameOfMaterialNeededMachine9 = "best drilled workpiece";

    public Machine machine10;
    public String nameOfMachine10 = "Welder";
    public int numberOfMachine10 = 0;
    public int costOfMachine10 = 500000;
    public int workersOnMachine10 = 0;
    public int timerOfMachine10 = 1800;
    public String nameOfMaterialForMachine10 = "weldment";
    String nameOfMaterialNeededMachine10 = "workpiece";
    private String nameOfImageMachine10 = "welding";


    // MATERIALS

    private Material material1;
    private String nameOfMaterial1 = "ore";
    private int numnerOfMaterial1 = 0;
    private int costOfMaterial1 = 15;
    String nameOfImgMaterial1 = "gold";

    private Material material2;
    private String nameOfMaterial2 = "ingot";
    private int numnerOfMaterial2 = 0;
    private int costOfMaterial2 = 40;

    private Material material3;
    private String nameOfMaterial3 = "rolled material and cast";
    private int numnerOfMaterial3 = 0;
    private int costOfMaterial3 = 80;

    private Material material4;
    private String nameOfMaterial4 = "drilled workpiece";
    private int numnerOfMaterial4 = 0;
    private int costOfMaterial4 = 95;

    private Material material5;
    private String nameOfMaterial5 = "better drilled workpiece";
    private int numnerOfMaterial5 = 0;
    private int costOfMaterial5 = 150;

    private Material material6;
    private String nameOfMaterial6 = "best drilled workpiece";
    private int numnerOfMaterial6 = 0;
    private int costOfMaterial6 = 210;

    private Material material7;
    private String nameOfMaterial7 = "workpiece";
    private int numnerOfMaterial7 = 0;
    private int costOfMaterial7 = 400;

    private Material material8;
    private String nameOfMaterial8 = "weldment";
    private int numnerOfMaterial8 = 0;
    private int costOfMaterial8 = 750;


    // UPGRADE TIME

    Upgrade upgrade0;
    String nameOfUpgrade0 = "Upgrade Time: ";
    int costOfUpgrade0 = 200;
    int whatToDoUpgrade0 = 30;
    String forWhatToDoUpgrade0 = "time";
    String nameOfImgUpgrade0 = "upgrade_time";


    // UPGRADE MATERIAL

    Upgrade upgrade1;
    String nameOfUpgrade1 = "Upgrade ore +1";
    int costOfUpgrade1 = 120;
    int whatToDoUpgrade1 = 1;
    String forWhatToDoUpgrade1 = "material";
    String nameOfMachineToGiveUpgrade1 = "Extraction";
    String nameOfMaterialToGiveUpgrade1 = "ore";
    String nameOfImgUpgrade1 = "upgrade_money_for_mat";

    Upgrade upgrade2;
    String nameOfUpgrade2 = "Upgrade ingot +2";
    int costOfUpgrade2 = 400;
    int whatToDoUpgrade2 = 2;
    String forWhatToDoUpgrade2 = "material";
    String nameOfMachineToGiveUpgrade2 = "Steelworks";
    String nameOfMaterialToGiveUpgrade2 = "ingot";


    Upgrade upgrade3;
    String nameOfUpgrade3 = "Upgrade rolled material and cast +4";
    int costOfUpgrade3 = 250;
    int whatToDoUpgrade3 = 4;
    String forWhatToDoUpgrade3 = "material";
    String nameOfMachineToGiveUpgrade3 = "Casting machine";
    String nameOfMaterialToGiveUpgrade3 = "rolled material and cast";

    Upgrade upgrade4;
    String nameOfUpgrade4 = "Upgrade drilled workpiece +4";
    int costOfUpgrade4 = 450;
    int whatToDoUpgrade4 = 4;
    String forWhatToDoUpgrade4 = "material";
    String nameOfMachineToGiveUpgrade4 = "Drill press";
    String nameOfMaterialToGiveUpgrade4 = "drilled workpiece";

    Upgrade upgrade5;
    String nameOfUpgrade5 = "Upgrade better drilled workpiece +5";
    int costOfUpgrade5 = 650;
    int whatToDoUpgrade5 = 5;
    String forWhatToDoUpgrade5 = "material";
    String nameOfMachineToGiveUpgrade5 = "Countersinks";
    String nameOfMaterialToGiveUpgrade5 = "better drilled workpiece";

    Upgrade upgrade6;
    String nameOfUpgrade6 = "Upgrade best drilled workpiece +5";
    int costOfUpgrade6 = 600;
    int whatToDoUpgrade6 = 5;
    String forWhatToDoUpgrade6 = "material";
    String nameOfMachineToGiveUpgrade6 = "Reamer";
    String nameOfMaterialToGiveUpgrade6 = "best drilled workpiece";

    Upgrade upgrade7;
    String nameOfUpgrade7 = "Upgrade workpiece +7";
    int costOfUpgrade7 = 300;
    int whatToDoUpgrade7 = 7;
    String forWhatToDoUpgrade7 = "material";
    String nameOfMachineToGiveUpgrade7 = "Turning";
    String nameOfMaterialToGiveUpgrade7 = "workpiece";

    Upgrade upgrade8;
    String nameOfUpgrade8 = "Upgrade weldment +8";
    int costOfUpgrade8 = 200;
    int whatToDoUpgrade8 = 8;
    String forWhatToDoUpgrade8 = "material";
    String nameOfMachineToGiveUpgrade8 = "Welder";
    String nameOfMaterialToGiveUpgrade8 = "weldment";

    // UPGRADE TIME OF MACHINE

    Upgrade upgrade9;
    String nameOfUpgrade9 = "Upgrade Time Of Extraction";
    int costOfUpgrade9 = 500;
    int whatToDoUpgrade9 = 30;
    String forWhatToDoUpgrade9 = "machine";
    String nameOfMachineToGiveUpgrade9 = "Extraction";
    String nameOfMaterialToGiveUpgrade9 = "ore";
    String NameOfImgUpgrade9 = "upgrade_time_of_machine";


    Upgrade upgrade10;
    String nameOfUpgrade10 = "Upgrade Time Of Steelworks";
    int costOfUpgrade10 = 1000;
    int whatToDoUpgrade10 = 1;
    String forWhatToDoUpgrade10 = "machine";
    String nameOfMachineToGiveUpgrade10 = "Steelworks";
    String nameOfMaterialToGiveUpgrade10 = "ore";

    Upgrade upgrade11;
    String nameOfUpgrade11 = "Upgrade Time Of Casting machine";
    int costOfUpgrade11 = 1500;
    int whatToDoUpgrade11 = 1;
    String forWhatToDoUpgrade11 = "machine";
    String nameOfMachineToGiveUpgrade11 = "Casting machine";
    String nameOfMaterialToGiveUpgrade11 = "ingot";


    Upgrade upgrade13;
    String nameOfUpgrade13 = "Upgrade Time Of Rolling machine";
    int costOfUpgrade13 = 1700;
    int whatToDoUpgrade13 = 1;
    String forWhatToDoUpgrade13 = "machine";
    String nameOfMachineToGiveUpgrade13 = "Rolling machine";
    String nameOfMaterialToGiveUpgrade13 = "drilled workpiece";

    Upgrade upgrade14;
    String nameOfUpgrade14 = "Upgrade Time Of Drill press";
    int costOfUpgrade14 = 2000;
    int whatToDoUpgrade14 = 1;
    String forWhatToDoUpgrade14 = "machine";
    String nameOfMachineToGiveUpgrade14 = "Drill press";
    String nameOfMaterialToGiveUpgrade14 = "better drilled workpiece";

    Upgrade upgrade15;
    String nameOfUpgrade15 = "Upgrade Time Of Countersinks";
    int costOfUpgrade15 = 2200;
    int whatToDoUpgrade15 = 1;
    String forWhatToDoUpgrade15 = "machine";
    String nameOfMachineToGiveUpgrade15 = "Countersinks";
    String nameOfMaterialToGiveUpgrade15 = "best drilled workpiece";

    Upgrade upgrade16;
    String nameOfUpgrade16 = "Upgrade Time Of Reamer";
    int costOfUpgrade16 = 2500;
    int whatToDoUpgrade16 = 1;
    String forWhatToDoUpgrade16 = "machine";
    String nameOfMachineToGiveUpgrade16 = "Reamer";
    String nameOfMaterialToGiveUpgrade16 = "workpiece";

    Upgrade upgrade17;
    String nameOfUpgrade17 = "Upgrade Time Of Milling machine";
    int costOfUpgrade17 = 3000;
    int whatToDoUpgrade17 = 1;
    String forWhatToDoUpgrade17 = "machine";
    String nameOfMachineToGiveUpgrade17 = "Milling machine";
    String nameOfMaterialToGiveUpgrade17 = "workpiece";


    Upgrade upgrade18;
    String nameOfUpgrade18 = "Upgrade Time Of Turning";
    int costOfUpgrade18 = 3200;
    int whatToDoUpgrade18 = 1;
    String forWhatToDoUpgrade18 = "machine";
    String nameOfMachineToGiveUpgrade18 = "Turning";
    String nameOfMaterialToGiveUpgrade18 = "workpiece";


    Upgrade upgrade19;
    String nameOfUpgrade19 = "Upgrade Time Of Welder";
    int costOfUpgrade19 = 3500;
    int whatToDoUpgrade19 = 1;
    String forWhatToDoUpgrade19 = "machine";
    String nameOfMachineToGiveUpgrade19 = "Welder";
    String nameOfMaterialToGiveUpgrade19 = "weldment";

    // WORKER

    public BasicWorker worker;
    public String nameOfWorker = "Basic Woker";
    public int numberOfWorker = 0;
    public int costOfWorker = 50;

    public User user;
    public float coins = 1500.f;
    public String name = "user";
    public float timerOutOfApp = 60.f;
    public int costOfTimeOutOfApp = 200;

    Realm realm;

    public MainReferences() {
        //this.realm = realm;
    }

    private void creatingMachine(Machine machine, String nameOfMachine, int numberOfMachine, int costOfMachine, int workersOnMachine, int timerOfMachine, String nameOfMaterialForMachine, String nameOfImgMachine){
        machine = new Machine();
        machine.setName(nameOfMachine);
        machine.setNumberOf(numberOfMachine,true);
        machine.setCost(costOfMachine, true);
        machine.setNumberOfWorkersOnMachine(workersOnMachine,true);
        machine.setTimerOfMachine(timerOfMachine, true);
        machine.setNameOfMaterial(nameOfMaterialForMachine);
        machine.setNameOfImage(nameOfImgMachine);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(machine);
        realm.commitTransaction();
    }

    private void creatingMachine(Machine machine, String nameOfMachine, int numberOfMachine, int costOfMachine, int workersOnMachine, int timerOfMachine, String nameOfMaterialForMachine, String nameOfMaterialNeededMachine, String nameOfImgMachine){
        machine = new Machine();
        machine.setName(nameOfMachine);
        machine.setNumberOf(numberOfMachine,true);
        machine.setCost(costOfMachine, true);
        machine.setNumberOfWorkersOnMachine(workersOnMachine,true);
        machine.setTimerOfMachine(timerOfMachine, true);
        machine.setNameOfMaterial(nameOfMaterialForMachine);
        machine.setNameOfNeededMaterial(nameOfMaterialNeededMachine);
        machine.setNameOfImage(nameOfImgMachine);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(machine);
        realm.commitTransaction();
    }

    private void createMaterial(Material material, String nameOfMaterial, int costOfMaterial, int numnerOfMaterial, String nameOfImgMaterial){
        material = new Material();
        material.setName(nameOfMaterial);
        material.setCost(costOfMaterial,true);
        material.setNumberOf(numnerOfMaterial,true);
        material.setNameOfImg(nameOfImgMaterial);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(material);
        realm.commitTransaction();
    }

    private void createUpgrade(Upgrade upgrade, String nameOfUpgrade, int costOfUpgrade, int whatToDoUpgrade, String forWhatToDoUpgrade, String nameOfMachineToGiveUpgrade, String nameOfMaterialToGiveUpgrade, String nameOfImgUpgrade){
        upgrade = new Upgrade();
        upgrade.setName(nameOfUpgrade);
        upgrade.setCost(costOfUpgrade, true);
        upgrade.setWhatDo(whatToDoUpgrade);
        upgrade.setForWhatToDo(forWhatToDoUpgrade);
        upgrade.setNameOfMachinetoGive(nameOfMachineToGiveUpgrade);
        upgrade.setNameOfMaterialGive(nameOfMaterialToGiveUpgrade);
        upgrade.setNameOfImg(nameOfImgUpgrade);
        realm.beginTransaction();
        realm.copyToRealm(upgrade);
        realm.commitTransaction();
    }

    private void createUpgradeOfTime(Upgrade upgrade, String nameOfUpgrade, int costOfUpgrade, int whatToDoUpgrade, String forWhatToDoUpgrade, String nameOfImgUpgrade){
        upgrade = new Upgrade();
        upgrade.setName(nameOfUpgrade);
        upgrade.setCost(costOfUpgrade, true);
        upgrade.setWhatDo(whatToDoUpgrade);
        upgrade.setForWhatToDo(forWhatToDoUpgrade);
        upgrade.setNameOfImg(nameOfImgUpgrade);
        realm.beginTransaction();
        realm.copyToRealm(upgrade);
        realm.commitTransaction();
    }

    public void createAllMachines(){
        creatingMachine(machine1, nameOfMachine1, numberOfMachine1,costOfMachine1,workersOnMachine1,timerOfMachine1, nameOfMaterialForMachine1, nameOfImageMachine1);
        creatingMachine(machine2, nameOfMachine2, numberOfMachine2,costOfMachine2, workersOnMachine2,timerOfMachine2,nameOfMaterialForMachine2, nameOfMaterialNeededMachine2, nameOfImageMachine2);
        creatingMachine(machine3, nameOfMachine3, numberOfMachine3,costOfMachine3, workersOnMachine3,timerOfMachine3,nameOfMaterialForMachine3, nameOfMaterialNeededMachine3, nameOfImageMachine1);
        creatingMachine(machine4, nameOfMachine4, numberOfMachine4,costOfMachine4, workersOnMachine4,timerOfMachine4,nameOfMaterialForMachine4, nameOfMaterialNeededMachine4, nameOfImageMachine1);
        creatingMachine(machine5, nameOfMachine5, numberOfMachine5,costOfMachine5, workersOnMachine5,timerOfMachine5,nameOfMaterialForMachine5, nameOfMaterialNeededMachine5, nameOfImageMachine5);
        creatingMachine(machine6, nameOfMachine6, numberOfMachine6,costOfMachine6, workersOnMachine6,timerOfMachine6,nameOfMaterialForMachine6, nameOfMaterialNeededMachine6, nameOfImageMachine6);
        creatingMachine(machine7, nameOfMachine7, numberOfMachine7,costOfMachine7, workersOnMachine7,timerOfMachine7,nameOfMaterialForMachine7, nameOfMaterialNeededMachine7, nameOfImageMachine7);
        creatingMachine(machine8, nameOfMachine8, numberOfMachine8,costOfMachine8, workersOnMachine8,timerOfMachine8,nameOfMaterialForMachine8, nameOfMaterialNeededMachine8, nameOfImageMachine1);
        creatingMachine(machine9, nameOfMachine9, numberOfMachine9,costOfMachine9, workersOnMachine9,timerOfMachine9,nameOfMaterialForMachine9, nameOfMaterialNeededMachine9, nameOfImageMachine1);
        creatingMachine(machine10, nameOfMachine10, numberOfMachine10,costOfMachine10, workersOnMachine10,timerOfMachine10,nameOfMaterialForMachine10, nameOfMaterialNeededMachine10, nameOfImageMachine10);
    }

    public void createAllMaterials(){
        createMaterial(material1, nameOfMaterial1, costOfMaterial1, numnerOfMaterial1, nameOfImgMaterial1);
        createMaterial(material2, nameOfMaterial2, costOfMaterial2, numnerOfMaterial2, nameOfImgMaterial1);
        createMaterial(material3, nameOfMaterial3, costOfMaterial3, numnerOfMaterial3, nameOfImgMaterial1);
        createMaterial(material4, nameOfMaterial4, costOfMaterial4, numnerOfMaterial4, nameOfImgMaterial1);
        createMaterial(material5, nameOfMaterial5, costOfMaterial5, numnerOfMaterial5, nameOfImgMaterial1);
        createMaterial(material6, nameOfMaterial6, costOfMaterial6, numnerOfMaterial6, nameOfImgMaterial1);
        createMaterial(material7, nameOfMaterial7, costOfMaterial7, numnerOfMaterial7, nameOfImgMaterial1);
        createMaterial(material8, nameOfMaterial8, costOfMaterial8, numnerOfMaterial8, nameOfImgMaterial1);
    }

    public void createAllUpgrades(){
        createUpgradeOfTime(upgrade0,nameOfUpgrade0,costOfUpgrade0,whatToDoUpgrade0, forWhatToDoUpgrade0, nameOfImgUpgrade0);

        createUpgrade(upgrade1, nameOfUpgrade1, costOfUpgrade1, whatToDoUpgrade1, forWhatToDoUpgrade1, nameOfMachineToGiveUpgrade1, nameOfMaterialToGiveUpgrade1, nameOfImgUpgrade1);
        createUpgrade(upgrade2, nameOfUpgrade2, costOfUpgrade2, whatToDoUpgrade2, forWhatToDoUpgrade2, nameOfMachineToGiveUpgrade2, nameOfMaterialToGiveUpgrade2, nameOfImgUpgrade1);
        createUpgrade(upgrade3, nameOfUpgrade3, costOfUpgrade3, whatToDoUpgrade3, forWhatToDoUpgrade3, nameOfMachineToGiveUpgrade3, nameOfMaterialToGiveUpgrade3, nameOfImgUpgrade1);
        createUpgrade(upgrade4, nameOfUpgrade4, costOfUpgrade4, whatToDoUpgrade4, forWhatToDoUpgrade4, nameOfMachineToGiveUpgrade4, nameOfMaterialToGiveUpgrade4, nameOfImgUpgrade1);
        createUpgrade(upgrade5, nameOfUpgrade5, costOfUpgrade5, whatToDoUpgrade5, forWhatToDoUpgrade5, nameOfMachineToGiveUpgrade5, nameOfMaterialToGiveUpgrade5, nameOfImgUpgrade1);
        createUpgrade(upgrade6, nameOfUpgrade6, costOfUpgrade6, whatToDoUpgrade6, forWhatToDoUpgrade6, nameOfMachineToGiveUpgrade6, nameOfMaterialToGiveUpgrade6, nameOfImgUpgrade1);
        createUpgrade(upgrade7, nameOfUpgrade7, costOfUpgrade7, whatToDoUpgrade7, forWhatToDoUpgrade7, nameOfMachineToGiveUpgrade7, nameOfMaterialToGiveUpgrade7, nameOfImgUpgrade1);
        createUpgrade(upgrade8, nameOfUpgrade8, costOfUpgrade8, whatToDoUpgrade8, forWhatToDoUpgrade8, nameOfMachineToGiveUpgrade8, nameOfMaterialToGiveUpgrade8, nameOfImgUpgrade1);

        createUpgrade(upgrade9, nameOfUpgrade9, costOfUpgrade9, whatToDoUpgrade9, forWhatToDoUpgrade9, nameOfMachineToGiveUpgrade9, nameOfMaterialToGiveUpgrade9, NameOfImgUpgrade9);
        createUpgrade(upgrade10, nameOfUpgrade10, costOfUpgrade10, whatToDoUpgrade10, forWhatToDoUpgrade10, nameOfMachineToGiveUpgrade10, nameOfMaterialToGiveUpgrade10, NameOfImgUpgrade9);
        createUpgrade(upgrade11, nameOfUpgrade11, costOfUpgrade11, whatToDoUpgrade11, forWhatToDoUpgrade11, nameOfMachineToGiveUpgrade11, nameOfMaterialToGiveUpgrade11, NameOfImgUpgrade9);
        createUpgrade(upgrade13, nameOfUpgrade13, costOfUpgrade13, whatToDoUpgrade13, forWhatToDoUpgrade13, nameOfMachineToGiveUpgrade13, nameOfMaterialToGiveUpgrade13, NameOfImgUpgrade9);
        createUpgrade(upgrade14, nameOfUpgrade14, costOfUpgrade14, whatToDoUpgrade14, forWhatToDoUpgrade14, nameOfMachineToGiveUpgrade14, nameOfMaterialToGiveUpgrade14, NameOfImgUpgrade9);
        createUpgrade(upgrade15, nameOfUpgrade15, costOfUpgrade15, whatToDoUpgrade15, forWhatToDoUpgrade15, nameOfMachineToGiveUpgrade15, nameOfMaterialToGiveUpgrade15, NameOfImgUpgrade9);
        createUpgrade(upgrade16, nameOfUpgrade16, costOfUpgrade16, whatToDoUpgrade16, forWhatToDoUpgrade16, nameOfMachineToGiveUpgrade16, nameOfMaterialToGiveUpgrade16, NameOfImgUpgrade9);
        createUpgrade(upgrade17, nameOfUpgrade17, costOfUpgrade17, whatToDoUpgrade17, forWhatToDoUpgrade17, nameOfMachineToGiveUpgrade17, nameOfMaterialToGiveUpgrade17, NameOfImgUpgrade9);
        createUpgrade(upgrade18, nameOfUpgrade18, costOfUpgrade18, whatToDoUpgrade18, forWhatToDoUpgrade18, nameOfMachineToGiveUpgrade18, nameOfMaterialToGiveUpgrade18, NameOfImgUpgrade9);
        createUpgrade(upgrade19, nameOfUpgrade19, costOfUpgrade19, whatToDoUpgrade19, forWhatToDoUpgrade19, nameOfMachineToGiveUpgrade19, nameOfMaterialToGiveUpgrade19, NameOfImgUpgrade9);

    }


    public void createWorker(){
        worker = new BasicWorker();
        worker.setName(nameOfWorker);
        worker.setNumberOf(numberOfWorker,true);
        worker.setCost(costOfWorker, true);
        realm.beginTransaction();
        realm.copyToRealm(worker);
        realm.commitTransaction();
    }

    public void createUser(){
        user = new User();
        user.setName(name);
        user.setCoins(coins, true);
        user.setTimeOutOfApp(timerOutOfApp, true);
        user.setCost(costOfTimeOutOfApp,true);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

}
