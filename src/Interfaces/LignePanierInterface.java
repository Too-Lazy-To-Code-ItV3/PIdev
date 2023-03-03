/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.LignePanier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aouad
 */
public interface LignePanierInterface {
    public void ajouterLignePanier(LignePanier lp);
    
     public void modifierlLignePanier(LignePanier lp, int IdLignePanier) ;

     public void supprimerLignePanier(int idLignePanier);
     
     
     //list : select
   public ArrayList<LignePanier> afficherTous();
    public List<LignePanier> getLignePanierparIdPanier(int idPanier);
    

}
