package com.companybest.ondra.engineerclicker.References;


import android.util.Log;

import com.companybest.ondra.engineerclicker.Models.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.Upgrade;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.BasicWorker;

import io.realm.Realm;


//THIS IS CLASS WHERE ARE ALL THE MACHINES, MATERIALS, UPGRADES, WORKER, USER ARE CREATED

public class MainReferences {

    // MACHINES

    private Machine machine1;
    public String nameOfMachine1 = "Extraction";
    private int numberOfMachine1 = 0;
    private int costOfMachine1 = 4000;
    private int workersOnMachine1 = 0;
    private int maxTimerOfMachine1 = 300;
    private int timerOfMachine1 = maxTimerOfMachine1;
    private int expGiveMach1 = 500;
    private String nameOfMaterialForMachine1 = "ore";
    private String nameOfImageMachine1 = "mine";

    private Machine machine2;
    public String nameOfMachine2 = "Steelworks";
    private int numberOfMachine2 = 0;
    private int costOfMachine2 = 30000;
    private int workersOnMachine2 = 0;
    private int maxTimerOfMachine2 = 600;
    private int timerOfMachine2 = maxTimerOfMachine2;
    private int expGiveMach2 = 1000;
    private String nameOfMaterialForMachine2 = "ingot";
    private String nameOfMaterialNeededMachine2 = "ore";
    private String nameOfImageMachine2 = "factory";

    private Machine machine3;
    public String nameOfMachine3 = "Casting machine";
    private int numberOfMachine3 = 0;
    private int costOfMachine3 = 80000;
    private int workersOnMachine3 = 0;
    private int maxTimerOfMachine3 = 900;
    private int timerOfMachine3 = maxTimerOfMachine3;
    private int expGiveMach3 = 2000;
    private String nameOfMaterialForMachine3 = "cast";
    private String nameOfMaterialNeededMachine3 = "ingot";
    private String nameOfImageMachine3 = "casting";

    private Machine machine4;
    public String nameOfMachine4 = "Rolling machine";
    private int numberOfMachine4 = 0;
    private int costOfMachine4 = 90000;
    private int workersOnMachine4 = 0;
    private int maxTimerOfMachine4 = 700;
    private int timerOfMachine4 = maxTimerOfMachine4;
    private int expGiveMach4 = 2500;
    private String nameOfMaterialForMachine4 = "cast";
    private String nameOfMaterialNeededMachine4 = "ingot";
    private String nameOfImageMachine4 = "rolling";

    private Machine machine5;
    public String nameOfMachine5 = "Drill press";
    private int numberOfMachine5 = 0;
    private int costOfMachine5 = 170000;
    private int workersOnMachine5 = 0;
    private int maxTimerOfMachine5 = 600;
    private int timerOfMachine5 = maxTimerOfMachine5;
    private int expGiveMach5 = 4000;
    private String nameOfMaterialForMachine5 = "drilled hole";
    private String nameOfMaterialNeededMachine5 = "cast";
    private String nameOfImageMachine5 = "drill";

    private Machine machine6;
    public String nameOfMachine6 = "Countersinks";
    private int numberOfMachine6 = 0;
    private int costOfMachine6 = 290000;
    private int workersOnMachine6 = 0;
    private int maxTimerOfMachine6 = 700;
    private int timerOfMachine6 = maxTimerOfMachine6;
    private int expGiveMach6 = 8000;
    private String nameOfMaterialForMachine6 = "better hole";
    private String nameOfMaterialNeededMachine6 = "drilled hole";
    private String nameOfImageMachine6 = "countersinks";

    private Machine machine7;
    public String nameOfMachine7 = "Reamer";
    private int numberOfMachine7 = 0;
    private int costOfMachine7 = 470000;
    private int workersOnMachine7 = 0;
    private int maxTimerOfMachine7 = 800;
    private int timerOfMachine7 = maxTimerOfMachine7;
    private int expGiveMach7 = 16000;
    private String nameOfMaterialForMachine7 = "best hole";
    private String nameOfMaterialNeededMachine7 = "better hole";
    private String nameOfImageMachine7 = "reamer";

    private Machine machine8;
    public String nameOfMachine8 = "Milling machine";
    private int numberOfMachine8 = 0;
    private int costOfMachine8 = 770000;
    private int workersOnMachine8 = 0;
    private int maxTimerOfMachine8 = 1200;
    private int timerOfMachine8 = maxTimerOfMachine8;
    private int expGiveMach8 = 32000;
    private String nameOfMaterialForMachine8 = "workpiece";
    private String nameOfMaterialNeededMachine8 = "best hole";
    private String nameOfImageMachine8 = "milling";

    private Machine machine9;
    public String nameOfMachine9 = "Turning";
    private int numberOfMachine9 = 0;
    private int costOfMachine9 = 800000;
    private int workersOnMachine9 = 0;
    private int maxTimerOfMachine9 = 1100;
    private int timerOfMachine9 = maxTimerOfMachine9;
    private int expGiveMach9 = 35000;
    private String nameOfMaterialForMachine9 = "workpiece";
    private String nameOfMaterialNeededMachine9 = "best hole";
    private String nameOfImageMachine9 = "turning";

    private Machine machine10;
    public String nameOfMachine10 = "Welder";
    private int numberOfMachine10 = 0;
    private int costOfMachine10 = 1500000;
    private int workersOnMachine10 = 0;
    public int maxTimerOfMachine10 = 1800;
    private int timerOfMachine10 = maxTimerOfMachine10;
    public int expGiveMach10 = 60000;
    private String nameOfMaterialForMachine10 = "weldment";
    private String nameOfMaterialNeededMachine10 = "workpiece";
    private String nameOfImageMachine10 = "welding";


    // NEW MACHINES

    private Machine machine11;
    public String nameOfMachine11 = "Grinder";
    private int numberOfMachine11 = 0;
    private int costOfMachine11 = 20000000;
    private int workersOnMachine11 = 0;
    public int maxTimerOfMachine11 = 1500;
    private int timerOfMachine11 = maxTimerOfMachine11;
    public int expGiveMach11 = 100000;
    private String nameOfMaterialForMachine11 = "grind workpiece";
    private String nameOfMaterialNeededMachine11 = "weldment";
    private String nameOfImageMachine11 = "grinder";


    // MATERIALS

    private Material material1;
    private String nameOfMaterial1 = "ore";
    private int numnerOfMaterial1 = 0;
    private int costOfMaterial1 = 15;
    private String nameOfImgMaterial1 = "gold";

    private Material material2;
    private String nameOfMaterial2 = "ingot";
    private int numnerOfMaterial2 = 0;
    private int costOfMaterial2 = 40;

    private Material material3;
    private String nameOfMaterial3 = "cast";
    private int numnerOfMaterial3 = 0;
    private int costOfMaterial3 = 80;

    private Material material4;
    private String nameOfMaterial4 = "drilled hole";
    private int numnerOfMaterial4 = 0;
    private int costOfMaterial4 = 95;

    private Material material5;
    private String nameOfMaterial5 = "better hole";
    private int numnerOfMaterial5 = 0;
    private int costOfMaterial5 = 150;

    private Material material6;
    private String nameOfMaterial6 = "best hole";
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


    // NEW MATERIALS

    private Material material9;
    private String nameOfMaterial9 = "grind workpiece";
    private int numnerOfMaterial9 = 0;
    private int costOfMaterial9 = 1200;


    // UPGRADE MATERIAL

    private Upgrade upgrade1;
    private String nameOfUpgrade1 = "Upgrade ore cost +1";
    private int costOfUpgrade1 = 120;
    private int whatToDoUpgrade1 = 1;
    private String forWhatToDoUpgrade1 = "material";
    private String nameOfMachineToGiveUpgrade1 = "Extraction";
    private String nameOfMaterialToGiveUpgrade1 = "ore";
    private String nameOfImgUpgrade1 = "upgrade_money_for_mat";

    private Upgrade upgrade2;
    private String nameOfUpgrade2 = "Upgrade ingot cost +2";
    private int costOfUpgrade2 = 400;
    private int whatToDoUpgrade2 = 2;
    private String forWhatToDoUpgrade2 = "material";
    private String nameOfMachineToGiveUpgrade2 = "Steelworks";
    private String nameOfMaterialToGiveUpgrade2 = "ingot";


    private Upgrade upgrade3;
    private String nameOfUpgrade3 = "Upgrade cast cost +4";
    private int costOfUpgrade3 = 250;
    private int whatToDoUpgrade3 = 4;
    private String forWhatToDoUpgrade3 = "material";
    private String nameOfMachineToGiveUpgrade3 = "Casting machine";
    private String nameOfMaterialToGiveUpgrade3 = "cast";

    private Upgrade upgrade4;
    private String nameOfUpgrade4 = "Upgrade hole cost +4";
    private int costOfUpgrade4 = 450;
    private int whatToDoUpgrade4 = 4;
    private String forWhatToDoUpgrade4 = "material";
    private String nameOfMachineToGiveUpgrade4 = "Drill press";
    public String nameOfMaterialToGiveUpgrade4 = "drilled hole";

    private Upgrade upgrade5;
    private String nameOfUpgrade5 = "Upgrade better hole cost +5";
    private int costOfUpgrade5 = 650;
    private int whatToDoUpgrade5 = 5;
    private String forWhatToDoUpgrade5 = "material";
    private String nameOfMachineToGiveUpgrade5 = "Countersinks";
    private String nameOfMaterialToGiveUpgrade5 = "better hole";

    private Upgrade upgrade6;
    private String nameOfUpgrade6 = "Upgrade best hole cost +5";
    private int costOfUpgrade6 = 600;
    private int whatToDoUpgrade6 = 5;
    private String forWhatToDoUpgrade6 = "material";
    private String nameOfMachineToGiveUpgrade6 = "Reamer";
    private String nameOfMaterialToGiveUpgrade6 = "best hole";

    private Upgrade upgrade7;
    private String nameOfUpgrade7 = "Upgrade workpiece cost +7";
    private int costOfUpgrade7 = 300;
    private int whatToDoUpgrade7 = 7;
    private String forWhatToDoUpgrade7 = "material";
    private String nameOfMachineToGiveUpgrade7 = "Turning";
    private String nameOfMaterialToGiveUpgrade7 = "workpiece";

    private Upgrade upgrade8;
    private String nameOfUpgrade8 = "Upgrade weldment cost +8";
    private int costOfUpgrade8 = 500;
    private int whatToDoUpgrade8 = 8;
    private String forWhatToDoUpgrade8 = "material";
    private String nameOfMachineToGiveUpgrade8 = "Welder";
    private String nameOfMaterialToGiveUpgrade8 = "weldment";


    // UPGRADE TIME OF MACHINE

    private Upgrade upgrade9;
    private String nameOfUpgrade9 = "Upgrade Time Of Extraction";
    private int costOfUpgrade9 = 500;
    private int whatToDoUpgrade9 = 30;
    private String forWhatToDoUpgrade9 = "machine";
    private String nameOfMachineToGiveUpgrade9 = "Extraction";
    private String nameOfMaterialToGiveUpgrade9 = "ore";
    private String NameOfImgUpgrade9 = "upgrade_time_of_machine";


    private Upgrade upgrade10;
    private String nameOfUpgrade10 = "Upgrade Time Of Steelworks";
    private int costOfUpgrade10 = 1000;
    private int whatToDoUpgrade10 = 1;
    private String forWhatToDoUpgrade10 = "machine";
    private String nameOfMachineToGiveUpgrade10 = "Steelworks";
    private String nameOfMaterialToGiveUpgrade10 = "ore";

    private Upgrade upgrade11;
    private String nameOfUpgrade11 = "Upgrade Time Of Casting machine";
    private int costOfUpgrade11 = 1500;
    private int whatToDoUpgrade11 = 1;
    private String forWhatToDoUpgrade11 = "machine";
    private String nameOfMachineToGiveUpgrade11 = "Casting machine";
    private String nameOfMaterialToGiveUpgrade11 = "ingot";

    private Upgrade upgrade13;
    private String nameOfUpgrade13 = "Upgrade Time Of Rolling machine";
    private int costOfUpgrade13 = 1700;
    private int whatToDoUpgrade13 = 1;
    private String forWhatToDoUpgrade13 = "machine";
    private String nameOfMachineToGiveUpgrade13 = "Rolling machine";
    private String nameOfMaterialToGiveUpgrade13 = "drilled hole";

    private Upgrade upgrade14;
    private String nameOfUpgrade14 = "Upgrade Time Of Drill press";
    private int costOfUpgrade14 = 2000;
    private int whatToDoUpgrade14 = 1;
    private String forWhatToDoUpgrade14 = "machine";
    private String nameOfMachineToGiveUpgrade14 = "Drill press";
    private String nameOfMaterialToGiveUpgrade14 = "better hole";

    private Upgrade upgrade15;
    private String nameOfUpgrade15 = "Upgrade Time Of Countersinks";
    private int costOfUpgrade15 = 2200;
    private int whatToDoUpgrade15 = 1;
    private String forWhatToDoUpgrade15 = "machine";
    private String nameOfMachineToGiveUpgrade15 = "Countersinks";
    private String nameOfMaterialToGiveUpgrade15 = "best hole";

    private Upgrade upgrade16;
    private String nameOfUpgrade16 = "Upgrade Time Of Reamer";
    private int costOfUpgrade16 = 2500;
    private int whatToDoUpgrade16 = 1;
    private String forWhatToDoUpgrade16 = "machine";
    private String nameOfMachineToGiveUpgrade16 = "Reamer";
    private String nameOfMaterialToGiveUpgrade16 = "workpiece";

    private Upgrade upgrade17;
    private String nameOfUpgrade17 = "Upgrade Time Of Milling machine";
    private int costOfUpgrade17 = 3000;
    private int whatToDoUpgrade17 = 1;
    private String forWhatToDoUpgrade17 = "machine";
    private String nameOfMachineToGiveUpgrade17 = "Milling machine";
    private String nameOfMaterialToGiveUpgrade17 = "workpiece";


    private Upgrade upgrade18;
    private String nameOfUpgrade18 = "Upgrade Time Of Turning";
    private int costOfUpgrade18 = 3200;
    private int whatToDoUpgrade18 = 1;
    private String forWhatToDoUpgrade18 = "machine";
    private String nameOfMachineToGiveUpgrade18 = "Turning";
    private String nameOfMaterialToGiveUpgrade18 = "workpiece";


    private Upgrade upgrade19;
    private String nameOfUpgrade19 = "Upgrade Time Of Welder";
    private int costOfUpgrade19 = 3500;
    private int whatToDoUpgrade19 = 1;
    private String forWhatToDoUpgrade19 = "machine";
    private String nameOfMachineToGiveUpgrade19 = "Welder";
    private String nameOfMaterialToGiveUpgrade19 = "weldment";

    // NEW UPGRADES

    private Upgrade upgrade20;
    private String nameOfUpgrade20 = "Upgrade grind workpiece cost +8";
    private int costOfUpgrade20 = 1000;
    private int whatToDoUpgrade20 = 8;
    private String forWhatToDoUpgrade20 = "material";
    private String nameOfMachineToGiveUpgrade20 = "Grinder";
    private String nameOfMaterialToGiveUpgrade20 = "grind workpiece";

    private Upgrade upgrade21;
    private String nameOfUpgrade21 = "Upgrade Time Of Grinder";
    private int costOfUpgrade21 = 5000;
    private int whatToDoUpgrade21 = 1;
    private String forWhatToDoUpgrade21 = "machine";
    private String nameOfMachineToGiveUpgrade21 = "Grinder";
    private String nameOfMaterialToGiveUpgrade21 = "grind workpiece";


    // WORKER
    private BasicWorker worker;
    public String nameOfWorker = "Basic Worker";
    private int numberOfWorker = 0;
    private int costOfWorker = 1000;

    //USER
    public User user;
    public float coins = 5000.f;
    public String name = "user";
    private int levelOfUser = 1;
    private int expNeeded = 2000;
    private int exp = 0;
    private int maxMachine = 5;
    private int maxWorker = 5;
    private int maxUpgrade = 5;

    private Realm realm;


    //FIRST MACHINE IS DIFFERENT
    private void creatingMachine(Machine machine, String nameOfMachine, int numberOfMachine, int costOfMachine, int workersOnMachine, int maxTimerOfMachine, int timerOfMachine, int expGive, String nameOfMaterialForMachine, String nameOfImgMachine) {
        machine = new Machine();
        machine.setName(nameOfMachine);
        machine.setNumberOf(numberOfMachine, true);
        machine.setCost(costOfMachine, true);
        machine.setNumberOfWorkersOnMachine(workersOnMachine, true);
        machine.setTimerOfMachine(timerOfMachine, true);
        machine.setExpGive(expGive);
        machine.setMaxTimerOfMachine(maxTimerOfMachine, true);
        machine.setNameOfMaterial(nameOfMaterialForMachine);
        machine.setNameOfImage(nameOfImgMachine);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(machine);
        realm.commitTransaction();
    }

    //METHOD FOR ALL THE OTHERS MACHINES
    private void creatingMachine(Machine machine, String nameOfMachine, int numberOfMachine, int costOfMachine, int workersOnMachine, int maxTimerOfMachine, int timerOfMachine, int expGive, String nameOfMaterialForMachine, String nameOfMaterialNeededMachine, String nameOfImgMachine) {
        machine = new Machine();
        machine.setName(nameOfMachine);
        machine.setNumberOf(numberOfMachine, true);
        machine.setCost(costOfMachine, true);
        machine.setNumberOfWorkersOnMachine(workersOnMachine, true);
        machine.setTimerOfMachine(timerOfMachine, true);
        machine.setExpGive(expGive);
        machine.setMaxTimerOfMachine(maxTimerOfMachine, true);
        machine.setNameOfMaterial(nameOfMaterialForMachine);
        machine.setNameOfNeededMaterial(nameOfMaterialNeededMachine);
        machine.setNameOfImage(nameOfImgMachine);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(machine);
        realm.commitTransaction();
    }

    //METHOD FOR CREATE ALL MATERIALS
    private void createMaterial(Material material, String nameOfMaterial, int costOfMaterial, int numnerOfMaterial, String nameOfImgMaterial) {
        material = new Material();
        material.setName(nameOfMaterial);
        material.setCost(costOfMaterial, true);
        material.setNumberOf(numnerOfMaterial, true);
        material.setNameOfImg(nameOfImgMaterial);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(material);
        realm.commitTransaction();
    }

    //METHOD FOR CREATE ALL UPGRADE
    private void createUpgrade(Upgrade upgrade, String nameOfUpgrade, int costOfUpgrade, int whatToDoUpgrade, String forWhatToDoUpgrade, String nameOfMachineToGiveUpgrade, String nameOfMaterialToGiveUpgrade, String nameOfImgUpgrade) {
        upgrade = new Upgrade();
        upgrade.setName(nameOfUpgrade);
        upgrade.setCost(costOfUpgrade, true);
        upgrade.setWhatDo(whatToDoUpgrade);
        upgrade.setForWhatToDo(forWhatToDoUpgrade);
        upgrade.setNameOfMachinetoGive(nameOfMachineToGiveUpgrade);
        upgrade.setNameOfMaterialGive(nameOfMaterialToGiveUpgrade);
        upgrade.setNameOfImg(nameOfImgUpgrade);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(upgrade);
        realm.commitTransaction();
    }


    //CREATING ALL THE MACHINES
    public void createAllMachines() {
        creatingMachine(machine1, nameOfMachine1, numberOfMachine1, costOfMachine1, workersOnMachine1, maxTimerOfMachine1, timerOfMachine1, expGiveMach1, nameOfMaterialForMachine1, nameOfImageMachine1);
        creatingMachine(machine2, nameOfMachine2, numberOfMachine2, costOfMachine2, workersOnMachine2, maxTimerOfMachine2, timerOfMachine2, expGiveMach2, nameOfMaterialForMachine2, nameOfMaterialNeededMachine2, nameOfImageMachine2);
        creatingMachine(machine3, nameOfMachine3, numberOfMachine3, costOfMachine3, workersOnMachine3, maxTimerOfMachine3, timerOfMachine3, expGiveMach3, nameOfMaterialForMachine3, nameOfMaterialNeededMachine3, nameOfImageMachine3);
        creatingMachine(machine4, nameOfMachine4, numberOfMachine4, costOfMachine4, workersOnMachine4, maxTimerOfMachine4, timerOfMachine4, expGiveMach4, nameOfMaterialForMachine4, nameOfMaterialNeededMachine4, nameOfImageMachine4);
        creatingMachine(machine5, nameOfMachine5, numberOfMachine5, costOfMachine5, workersOnMachine5, maxTimerOfMachine5, timerOfMachine5, expGiveMach5, nameOfMaterialForMachine5, nameOfMaterialNeededMachine5, nameOfImageMachine5);
        creatingMachine(machine6, nameOfMachine6, numberOfMachine6, costOfMachine6, workersOnMachine6, maxTimerOfMachine6, timerOfMachine6, expGiveMach6, nameOfMaterialForMachine6, nameOfMaterialNeededMachine6, nameOfImageMachine6);
        creatingMachine(machine7, nameOfMachine7, numberOfMachine7, costOfMachine7, workersOnMachine7, maxTimerOfMachine7, timerOfMachine7, expGiveMach7, nameOfMaterialForMachine7, nameOfMaterialNeededMachine7, nameOfImageMachine7);
        creatingMachine(machine8, nameOfMachine8, numberOfMachine8, costOfMachine8, workersOnMachine8, maxTimerOfMachine8, timerOfMachine8, expGiveMach8, nameOfMaterialForMachine8, nameOfMaterialNeededMachine8, nameOfImageMachine8);
        creatingMachine(machine9, nameOfMachine9, numberOfMachine9, costOfMachine9, workersOnMachine9, maxTimerOfMachine9, timerOfMachine9, expGiveMach9, nameOfMaterialForMachine9, nameOfMaterialNeededMachine9, nameOfImageMachine9);
        creatingMachine(machine10, nameOfMachine10, numberOfMachine10, costOfMachine10, workersOnMachine10, maxTimerOfMachine10, timerOfMachine10, expGiveMach10, nameOfMaterialForMachine10, nameOfMaterialNeededMachine10, nameOfImageMachine10);
    }

    //CREATING ALL THE MATERIALS
    public void createAllMaterials() {
        createMaterial(material1, nameOfMaterial1, costOfMaterial1, numnerOfMaterial1, nameOfImgMaterial1);
        createMaterial(material2, nameOfMaterial2, costOfMaterial2, numnerOfMaterial2, nameOfImgMaterial1);
        createMaterial(material3, nameOfMaterial3, costOfMaterial3, numnerOfMaterial3, nameOfImgMaterial1);
        createMaterial(material4, nameOfMaterial4, costOfMaterial4, numnerOfMaterial4, nameOfImgMaterial1);
        createMaterial(material5, nameOfMaterial5, costOfMaterial5, numnerOfMaterial5, nameOfImgMaterial1);
        createMaterial(material6, nameOfMaterial6, costOfMaterial6, numnerOfMaterial6, nameOfImgMaterial1);
        createMaterial(material7, nameOfMaterial7, costOfMaterial7, numnerOfMaterial7, nameOfImgMaterial1);
        createMaterial(material8, nameOfMaterial8, costOfMaterial8, numnerOfMaterial8, nameOfImgMaterial1);
    }

    //CREATING ALL THE UPGRADES
    public void createAllUpgrades() {

        createUpgrade(upgrade1, nameOfUpgrade1, costOfUpgrade1, whatToDoUpgrade1, forWhatToDoUpgrade1, nameOfMachineToGiveUpgrade1, nameOfMaterialToGiveUpgrade1, nameOfImgUpgrade1);
        createUpgrade(upgrade9, nameOfUpgrade9, costOfUpgrade9, whatToDoUpgrade9, forWhatToDoUpgrade9, nameOfMachineToGiveUpgrade9, nameOfMaterialToGiveUpgrade9, NameOfImgUpgrade9);
        createUpgrade(upgrade2, nameOfUpgrade2, costOfUpgrade2, whatToDoUpgrade2, forWhatToDoUpgrade2, nameOfMachineToGiveUpgrade2, nameOfMaterialToGiveUpgrade2, nameOfImgUpgrade1);
        createUpgrade(upgrade10, nameOfUpgrade10, costOfUpgrade10, whatToDoUpgrade10, forWhatToDoUpgrade10, nameOfMachineToGiveUpgrade10, nameOfMaterialToGiveUpgrade10, NameOfImgUpgrade9);
        createUpgrade(upgrade3, nameOfUpgrade3, costOfUpgrade3, whatToDoUpgrade3, forWhatToDoUpgrade3, nameOfMachineToGiveUpgrade3, nameOfMaterialToGiveUpgrade3, nameOfImgUpgrade1);
        createUpgrade(upgrade11, nameOfUpgrade11, costOfUpgrade11, whatToDoUpgrade11, forWhatToDoUpgrade11, nameOfMachineToGiveUpgrade11, nameOfMaterialToGiveUpgrade11, NameOfImgUpgrade9);
        createUpgrade(upgrade13, nameOfUpgrade13, costOfUpgrade13, whatToDoUpgrade13, forWhatToDoUpgrade13, nameOfMachineToGiveUpgrade13, nameOfMaterialToGiveUpgrade13, NameOfImgUpgrade9);
        createUpgrade(upgrade4, nameOfUpgrade4, costOfUpgrade4, whatToDoUpgrade4, forWhatToDoUpgrade4, nameOfMachineToGiveUpgrade4, nameOfMaterialToGiveUpgrade4, nameOfImgUpgrade1);
        createUpgrade(upgrade14, nameOfUpgrade14, costOfUpgrade14, whatToDoUpgrade14, forWhatToDoUpgrade14, nameOfMachineToGiveUpgrade14, nameOfMaterialToGiveUpgrade14, NameOfImgUpgrade9);
        createUpgrade(upgrade5, nameOfUpgrade5, costOfUpgrade5, whatToDoUpgrade5, forWhatToDoUpgrade5, nameOfMachineToGiveUpgrade5, nameOfMaterialToGiveUpgrade5, nameOfImgUpgrade1);
        createUpgrade(upgrade15, nameOfUpgrade15, costOfUpgrade15, whatToDoUpgrade15, forWhatToDoUpgrade15, nameOfMachineToGiveUpgrade15, nameOfMaterialToGiveUpgrade15, NameOfImgUpgrade9);
        createUpgrade(upgrade6, nameOfUpgrade6, costOfUpgrade6, whatToDoUpgrade6, forWhatToDoUpgrade6, nameOfMachineToGiveUpgrade6, nameOfMaterialToGiveUpgrade6, nameOfImgUpgrade1);
        createUpgrade(upgrade16, nameOfUpgrade16, costOfUpgrade16, whatToDoUpgrade16, forWhatToDoUpgrade16, nameOfMachineToGiveUpgrade16, nameOfMaterialToGiveUpgrade16, NameOfImgUpgrade9);
        createUpgrade(upgrade7, nameOfUpgrade7, costOfUpgrade7, whatToDoUpgrade7, forWhatToDoUpgrade7, nameOfMachineToGiveUpgrade7, nameOfMaterialToGiveUpgrade7, nameOfImgUpgrade1);
        createUpgrade(upgrade17, nameOfUpgrade17, costOfUpgrade17, whatToDoUpgrade17, forWhatToDoUpgrade17, nameOfMachineToGiveUpgrade17, nameOfMaterialToGiveUpgrade17, NameOfImgUpgrade9);
        createUpgrade(upgrade18, nameOfUpgrade18, costOfUpgrade18, whatToDoUpgrade18, forWhatToDoUpgrade18, nameOfMachineToGiveUpgrade18, nameOfMaterialToGiveUpgrade18, NameOfImgUpgrade9);
        createUpgrade(upgrade8, nameOfUpgrade8, costOfUpgrade8, whatToDoUpgrade8, forWhatToDoUpgrade8, nameOfMachineToGiveUpgrade8, nameOfMaterialToGiveUpgrade8, nameOfImgUpgrade1);
        createUpgrade(upgrade19, nameOfUpgrade19, costOfUpgrade19, whatToDoUpgrade19, forWhatToDoUpgrade19, nameOfMachineToGiveUpgrade19, nameOfMaterialToGiveUpgrade19, NameOfImgUpgrade9);

    }


    //CREATING WORKER
    public void createWorker() {
        worker = new BasicWorker();
        worker.setName(nameOfWorker);
        worker.setNumberOf(numberOfWorker, true);
        worker.setCost(costOfWorker, true);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(worker);
        realm.commitTransaction();
    }

    //CREATING USER
    public void createUser() {
        user = new User();
        user.setName(name);
        user.setCoins(coins, true);
        user.setLevel(levelOfUser, true);
        user.setExpNeeded(expNeeded, true);
        user.setExp(exp, 1);
        user.setMaxMachine(maxMachine);
        user.setMaxWorkers(maxWorker);
        user.setMaxUpgrade(maxUpgrade);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    //CREATING THE NEW PART OF USER, THIS IS NOT BEING USED
    public void createPartOfUser(){
        final User user = realm.where(User.class).equalTo("name", name).findFirst();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                user.setMaxMachine(maxMachine);
                user.setMaxWorkers(maxWorker);
                user.setMaxUpgrade(maxUpgrade);
            }
        });
    }


    //NEW METHODS FOR CREATING BETTER MATERIALS
    public void createMaterialBetter(int plusCost) {
        costOfMaterial1 += plusCost;
        costOfMaterial2 += 2 * plusCost;
        costOfMaterial3 += 2 * plusCost;
        costOfMaterial4 += 2 * plusCost;
        costOfMaterial5 += 3 * plusCost;
        costOfMaterial6 += 3 * plusCost;
        costOfMaterial7 += 3 * plusCost;
        costOfMaterial8 += 3 * plusCost;

        Log.i("user", "COST OF MATERIAL 1: " + String.valueOf(costOfMaterial1));
        Log.i("user", "COST OF MATERIAL 2: " + String.valueOf(costOfMaterial2));


        createMaterial(material1, nameOfMaterial1, costOfMaterial1, numnerOfMaterial1, nameOfImgMaterial1);
        createMaterial(material2, nameOfMaterial2, costOfMaterial2, numnerOfMaterial2, nameOfImgMaterial1);
        createMaterial(material3, nameOfMaterial3, costOfMaterial3, numnerOfMaterial3, nameOfImgMaterial1);
        createMaterial(material4, nameOfMaterial4, costOfMaterial4, numnerOfMaterial4, nameOfImgMaterial1);
        createMaterial(material5, nameOfMaterial5, costOfMaterial5, numnerOfMaterial5, nameOfImgMaterial1);
        createMaterial(material6, nameOfMaterial6, costOfMaterial6, numnerOfMaterial6, nameOfImgMaterial1);
        createMaterial(material7, nameOfMaterial7, costOfMaterial7, numnerOfMaterial7, nameOfImgMaterial1);
        createMaterial(material8, nameOfMaterial8, costOfMaterial8, numnerOfMaterial8, nameOfImgMaterial1);

    }

    //NEW METHODS FOR CREATING NEW MACHINES
    public void createNewMachinesFirst() {
        creatingMachine(machine11, nameOfMachine11, numberOfMachine11, costOfMachine11, workersOnMachine11, maxTimerOfMachine11, timerOfMachine11, expGiveMach11, nameOfMaterialForMachine11, nameOfMaterialNeededMachine11, nameOfImageMachine11);

        Log.i("user", String.valueOf(timerOfMachine11));
    }

    //NEW METHODS FOR CREATING NEW MATERIAL
    public void createNewMaterial() {
        createMaterial(material9, nameOfMaterial9, costOfMaterial9, numnerOfMaterial9, nameOfImgMaterial1);

    }

    //NEW METHODS FOR CREATING NEW BETTER MATERIAL
    public void createNewMaterialBetter(int plusCost) {
        costOfMaterial9 += 3 * plusCost;

        createMaterial(material9, nameOfMaterial9, costOfMaterial9, numnerOfMaterial9, nameOfImgMaterial1);
    }

    //NEW METHODS FOR CREATING NEW UPGRADE
    public void createNewUpgrade() {
        createUpgrade(upgrade20, nameOfUpgrade20, costOfUpgrade20, whatToDoUpgrade20, forWhatToDoUpgrade20, nameOfMachineToGiveUpgrade20, nameOfMaterialToGiveUpgrade20, nameOfImgUpgrade1);
        createUpgrade(upgrade21, nameOfUpgrade21, costOfUpgrade21, whatToDoUpgrade21, forWhatToDoUpgrade21, nameOfMachineToGiveUpgrade21, nameOfMaterialToGiveUpgrade21, NameOfImgUpgrade9);

    }



}
