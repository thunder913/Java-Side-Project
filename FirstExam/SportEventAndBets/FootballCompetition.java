package com.company;

public class FootballCompetition implements Competition {

    public double fastestGoal;
    public Participant[] schedule;

    public FootballCompetition(){

    }

    public FootballCompetition(double fastestGoal, Participant[] schedule) {
        this.fastestGoal = fastestGoal;
        this.schedule = schedule;
    }

    @Override
    public Participant[] getSchedule() {
        return new Participant[0];
    }
}
