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
public class Participation {
    private Utilisateur participant;
    private Challenge challenge;
    
    public Participation() {
    }

    public Participation(Utilisateur participant, Challenge challenge) {
        this.participant = participant;
        this.challenge = challenge;
    }

    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur participant) {
        this.participant = participant;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    @Override
    public String toString() {
        return "Participation{" + "participant=" + participant + ", challenge=" + challenge + '}';
    }        
    
}
