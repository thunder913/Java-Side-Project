package com.company;

public class CreateEvent {
    public String typeOfEvent;

    public CreateEvent(){

    }

    public Competition getEvent(String competitionType) throws EventException {
        if (competitionType.equals("horse")) {
            return new HorseCompetition();
        } else if (competitionType.equals("football")) {
            return new FootballCompetition();
        } else if (competitionType.equals("formula1")) {
            return new Formula1Competition();
        }

        throw new EventException("The competition type was invalid");
    }

    public void fillSchedule(Competition ob, Participant[] schedule) throws EmptySetException {
        if (schedule.length == 0){
            throw new EmptySetException("The list of participants cannot be empty!");
        }
        //TODO Logic
    }
}
