package com.company;

public class Participant {
    public Participant(int id, String name, int age, double chanceToWin, double betForWin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.chanceToWin = chanceToWin;
        this.betForWin = betForWin;
    }

    public int id;
    public String name;
    public int age;
    public double chanceToWin;
    public double betForWin;
}
