package com.example.potionemporium;

public class Potions {
    private int cold_resistancePotion;
    private int fire_resistancePotion;
    private int water_walkingPotion;
    private int necromanceyPotion;
    private int berserkPotion;
    public Potions(){
        this.berserkPotion=0;
        this.water_walkingPotion=0;
        this.fire_resistancePotion=0;
        this.cold_resistancePotion=0;
        this.necromanceyPotion=0;
    }

    public void setBerserkPotion(int berserkPotion) {
        this.berserkPotion = berserkPotion;
    }

    public void setCold_resistancePotion(int cold_resistancePotion) {
        this.cold_resistancePotion = cold_resistancePotion;
    }

    public void setFire_resistancePotion(int fire_resistancePotion) {
        this.fire_resistancePotion = fire_resistancePotion;
    }

    public void setNecromanceyPotion(int necromanceyPotion) {
        this.necromanceyPotion = necromanceyPotion;
    }

    public void setWater_walkingPotion(int water_walkingPotion) {
        this.water_walkingPotion = water_walkingPotion;
    }

    public int getBerserkPotion() {
        return berserkPotion;
    }

    public int getCold_resistancePotion() {
        return cold_resistancePotion;
    }

    public int getFire_resistancePotion() {
        return fire_resistancePotion;
    }

    public int getNecromanceyPotion() {
        return necromanceyPotion;
    }

    public int getWater_walkingPotion() {
        return water_walkingPotion;
    }
}
