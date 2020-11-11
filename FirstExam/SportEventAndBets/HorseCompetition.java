package com.company;

public class HorseCompetition implements Competition{

    public String breed;
    public Participant[] schedule;

    public HorseCompetition(){

    }

    public HorseCompetition(String breed, Participant[] schedule) {
        this.breed = breed;
        this.schedule = schedule;
    }

    @Override
    public Participant[] getSchedule() {
        return new Participant[0];
    }
}
