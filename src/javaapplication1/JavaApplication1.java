/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import Models.Categorie;
import Models.Challenge;
import Models.Participation;
import Models.Tutoriel;
import Models.Utilisateur;
import Models.Video;
import interfaces.CategorieInterface;
import interfaces.ChallengeInterface;
import interfaces.ParticipationInterface;
import interfaces.TutorielInterface;
import interfaces.VideoInterface;
import services.CategorieService;
import services.ChallengeService;
import services.ParticipationService;
import services.TutorielService;
import services.VideoService;
import util.MaConnexion;

/**
 *
 * @author achref
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*ChallengeInterface ci = new ChallengeService() {};
        Categorie c = new Categorie();
        ParticipationInterface pi = new ParticipationService() {};
        Challenge c1 = new Challenge();
        CategorieInterface cai = new CategorieService();
        cai.fetchCategorieByName("2D");
        c1.setTitle("3D");
        c1.setPathIMG("");
        c1.setDescription("here we go");
        c1.setNiveau(3);
        c1.setDate_C("2023/03/01");
        //ci.addChallenge(c1);
        Challenge c2 = new Challenge();
        c2.setID_Challenge(1);
        c2.setTitle("2D");
        c2.setPathIMG("");
        c2.setDescription("letss go");
        c2.setNiveau(2);
        c2.setDate_C("2023/02/20");
        c.setID_Categorie(19);
        c2.setCategorie(c);
        
        ci.modifyChallenge(c2);
        //ci.deleteChallenge(1);
        //System.out.println(ci.fetchChallenges());
        Participation p = new Participation();
        Utilisateur u = new Utilisateur();
        u.setID_user(2);
        u.setNom("balbouli");
        u.setPrenom("aymen");
        u.setDate_Naissance("1989/07/19");
        u.setEmail("aymen.balblouli@gmail.com");
        u.setLocation("Monastir");
        u.setPathImage("");
        
        p.setParticipant(u);
        p.setChallenge(c2);
        
        //pi.addParticipation(p);
        //System.out.println(pi.fetchParticipantsByChallenge(2));
        //System.out.println(pi.fetchChallengesByParticipant(2));
        //System.out.println(ci.fetchChallenges());
        //System.out.println(ci.fetchChallengesSortedByDate());
        //System.out.println(pi.fetchParticipations());
        
        //pi.deleteParticipation(3, 3);*/
        TutorielInterface ti = new TutorielService();
        System.err.println(ti.fetchTutorielsByCategorie(1));
        
        
        
        
    }
    
}
