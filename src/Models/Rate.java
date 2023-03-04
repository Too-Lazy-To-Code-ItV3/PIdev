/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author achref
 */
public class Rate {
    private Utilisateur rater,participator;
    private Challenge challenge;
    private Double rating;

    public Rate() {
    }

    public Rate(Utilisateur rater, Utilisateur participator, Challenge challenge, Double rating) {
        this.rater = rater;
        this.participator = participator;
        this.challenge = challenge;
        this.rating = rating;
    }

    public Utilisateur getRater() {
        return rater;
    }

    public void setRater(Utilisateur rater) {
        this.rater = rater;
    }

    public Utilisateur getParticipator() {
        return participator;
    }

    public void setParticipator(Utilisateur participator) {
        this.participator = participator;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" + "rater=" + rater + ", participator=" + participator + ", challenge=" + challenge + ", rating=" + rating + '}';
    }
    
}

