package io.realm;


public interface UserRealmProxyInterface {
    public String realmGet$name();
    public void realmSet$name(String value);
    public int realmGet$level();
    public void realmSet$level(int value);
    public int realmGet$expNeeded();
    public void realmSet$expNeeded(int value);
    public int realmGet$exp();
    public void realmSet$exp(int value);
    public float realmGet$coins();
    public void realmSet$coins(float value);
    public int realmGet$maxMachine();
    public void realmSet$maxMachine(int value);
    public int realmGet$maxWorkers();
    public void realmSet$maxWorkers(int value);
    public int realmGet$maxUpgrade();
    public void realmSet$maxUpgrade(int value);
}
