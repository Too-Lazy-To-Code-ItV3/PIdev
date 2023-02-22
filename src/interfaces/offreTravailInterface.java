/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Categorie;
import models.artistepostuler;
import models.offreTravail;

/**
 *
 * @author nour2
 */
public interface offreTravailInterface {
    //add 
    public void addOffre(offreTravail o );
    //afficher list
public List<offreTravail> fetchOffresPerDate();
//afficher list par id connected
public List<offreTravail> fetchOffresPerIdDate(int id);
   public List<offreTravail> fetchOffresPerCategorieDate(List<offreTravail> f,Categorie c);
public void modifierOffre(offreTravail o);
public void Supprimer(offreTravail o);
public List<offreTravail> chercherOffres(String mots);
public void postuleViaMail(int idArtiste,offreTravail of);
  public List<offreTravail> fetchOffresPerType( List<offreTravail> f ,String type);
     public List<offreTravail> fetchOffresPerLocalisation( List<offreTravail> f ,String loc);
     public List<String> affichernotifications(int idStudio);

}
