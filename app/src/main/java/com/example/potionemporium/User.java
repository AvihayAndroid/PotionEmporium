package com.example.potionemporium;

public class User {
    private String username;
    private String password;
    private long money;
    private Ingredients items;
    private Potions pots;

    public User(){

    }
    public User(String username,String password){
        this.username=username;
        this.password=password;
        this.money=10;
        this.items= new Ingredients();
        this.pots = new Potions();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Ingredients getItems() {
        return items;
    }

    public long getMoney() {
        return money;
    }

    public Potions getPots() {
        return pots;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void setItems(Ingredients items) {
        this.items = items;
    }

    public void setPots(Potions pots) {
        this.pots = pots;
    }
}
