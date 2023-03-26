package Interfaces;

import Models.Challenge;

import java.util.List;

public interface ChallengeInterface {
    public void addChallenge(Challenge c);

    //modification
    public void modifyChallenge(Challenge c);

    //suppression
    public void deleteChallenge(int id);


    //list : select
    public List<Challenge> fetchChallenges();

    public List<Challenge> fetchChallengesSortedByDate();

    //affectation
    //public void affecterJoueur(Player p, Team t)
    public Challenge fetchChallengeById(int id);

    public List<Challenge> fetchChallengeByName(String name);

    public List<Challenge> fetchChallengeByCategorie(String name);
}
