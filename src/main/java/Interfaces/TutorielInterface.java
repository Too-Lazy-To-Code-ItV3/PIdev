package Interfaces;

import Models.Tutoriel;

import java.util.List;

public interface TutorielInterface {
    //ajout
    public void addTutoriel(Tutoriel t);

    //modification
    public void ModifyTutoriel(Tutoriel t);

    //suppression
    public void deleteTutoriel(int id);


    //list : select
    public List<Tutoriel> fetchTutoriels();

    public Tutoriel fetchTutorielByID(int ID_Tutoriel);

    public List<Tutoriel> fetchTutorielsByCategorie(String name);

    public List<Tutoriel> fetchTutorielsByArtist(String NomArtist);

    public List<Tutoriel> fetchTutorielsByTitle(String title);
    //affectation
    //public void affecterJoueur(Player p, Team t);

}
