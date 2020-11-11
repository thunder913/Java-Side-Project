package com.company;

public class Formula1Competition implements Competition{

    public String winnersTime;
    public Participant[] schedule;

    public Formula1Competition(){

    }

    public Formula1Competition(String winnersTime, Participant[] schedule) {
        this.winnersTime = winnersTime;
        this.schedule = schedule;
    }

    @Override
    public Participant[] getSchedule() {
        return new Participant[0];
    }
}
