package Interfaces;

import Models.Categorie;
import Models.offreTravail;

import java.util.List;

public interface offreTravailInterface {
    public void addOffre(offreTravail o);

    public List<offreTravail> fetchOffresPerDate();

    public List<offreTravail> fetchOffresPerIdDate(int id);

    public List<offreTravail> fetchOffresPerCategorieDate(List<offreTravail> f, Categorie c);

    public void modifierOffre(offreTravail o);

    public void Supprimeretajouterarchive(offreTravail o);

    public List<offreTravail> chercherOffres(String mots);

    public void postuleViaMail(int idArtiste, offreTravail of);

    public List<offreTravail> fetchOffresPerType(List<offreTravail> f, String type);

    public List<offreTravail> fetchOffresPerLocalisation(List<offreTravail> f, String loc);

    public List<String> affichernotifications(int idStudio);

    public List<offreTravail> offresimilairaunedemande(int id);
}
