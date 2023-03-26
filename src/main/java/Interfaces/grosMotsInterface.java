package Interfaces;

import Models.grosMots;

import java.util.List;

public interface grosMotsInterface {
    public void ajoutGrosMot(grosMots mot);

    //afficher list
    public List<String> fetchgrosmotsString();

    public void modifierOffre(grosMots mot);

    public void Supprimer(grosMots o);

    public List<grosMots> fetchgrosmots();

    public grosMots fetchmotById(int id);
}
