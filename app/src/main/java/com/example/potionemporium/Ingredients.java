package com.example.potionemporium;

public class Ingredients {
    private long lovage;
    private long perilla;
    private long cilantro;
    private long rosemary;
    private long tarragon;
    private long savory;


    public Ingredients(){
        this.lovage=3;
        this.perilla=3;
        this.cilantro=3;
        this.rosemary=3;
        this.tarragon=3;
        this.savory=3;
    }
    public void setLovage(long num){
        this.lovage=num;
    }
    public void setPerilla(long num){
        this.perilla=num;
    }
    public void setCilantro(long num){
        this.lovage=num;
    }
    public void setRosemary(long num){
        this.rosemary=num;
    }
    public void setTarragon(long num){
        this.tarragon=num;
    }
    public void setSavory(long num){
        this.savory=num;
    }
    public long getLovage(){
        return this.lovage;
    }
    public long getPerilla(){
        return this.perilla;
    }
    public long getCilantro(){
        return this.cilantro;
    }
    public long getRosemary(){
        return this.rosemary;
    }
    public long getTarragon(){
        return this.tarragon;
    }
    public long getSavory(){
        return this.savory;
    }


}
