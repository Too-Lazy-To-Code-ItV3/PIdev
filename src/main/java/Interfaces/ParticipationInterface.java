package Interfaces;

import Models.Challenge;
import Models.Participation;

import java.util.List;

public interface ParticipationInterface {
    public void addParticipation(Participation p);

    //suppression
    public void deleteParticipation(int ID_Challenge, int ID_Participant);

    //list : select
    public List<Participation> fetchParticipations();

    public List<Participation> fetchParticipantionsByChallenge(int ID_Challenge);

    public List<Challenge> fetchChallengesByParticipant(int ID_Participant);

    public Boolean Participated(int ID_Challenge, int ID_Participant);
}
