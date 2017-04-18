package io.realm;


public interface MachineRealmProxyInterface {
    public String realmGet$name();
    public void realmSet$name(String value);
    public int realmGet$numberOf();
    public void realmSet$numberOf(int value);
    public int realmGet$numberOfWorkersOnMachine();
    public void realmSet$numberOfWorkersOnMachine(int value);
    public int realmGet$cost();
    public void realmSet$cost(int value);
    public int realmGet$timerOfMachine();
    public void realmSet$timerOfMachine(int value);
    public String realmGet$nameOfMaterial();
    public void realmSet$nameOfMaterial(String value);
    public String realmGet$nameOfNeededMaterial();
    public void realmSet$nameOfNeededMaterial(String value);
    public String realmGet$nameOfImage();
    public void realmSet$nameOfImage(String value);
}
