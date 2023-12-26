package com.example.potionemporium;

public class Comms {
    private User player1;
    private User player2;
    private String text;

    public Comms(User player1,User player2,String text){
        this.player1 = player1;
        this.player2 = player2;
        this.text = text;
    }
    public Comms(){}

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}