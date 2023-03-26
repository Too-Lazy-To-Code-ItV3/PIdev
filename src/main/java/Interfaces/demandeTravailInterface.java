package Interfaces;

import Models.Categorie;
import Models.demandeTravail;

import java.util.List;

public interface demandeTravailInterface {
    public void addDemande(demandeTravail d);
    //afficher list

    public List<demandeTravail> fetchDemandesPerDate();
//afficher list par id connected

    public List<demandeTravail> fetchDemandesPerIdDate(int id);

    public void modifierDemande(demandeTravail d);

    public void SupprimerDemande(demandeTravail d);

    public List<demandeTravail> chercherDemande(String mots);

    public void contacterViaMail(int idStudio, demandeTravail d);

    public demandeTravail fetchdemandeParId(int id);

    public List<demandeTravail> offresimilairaunedemande(int id);

    public List<demandeTravail> fetchDemandesPerCategorieDate(List<demandeTravail> d, Categorie c);


}
