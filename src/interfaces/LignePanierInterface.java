/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.LignePanier;
import java.util.ArrayList;
import java.util.List;
import models.Produits;

/**
 *
 * @author aouad
 */
public interface LignePanierInterface {
    public void ajouterLignePanier(Produits p);
    
     public void modifierlLignePanier(LignePanier lp, int IdLignePanier) ;
     public Boolean added(Produits p);

//     public void supprimerLignePanier(int idLignePanier);
//      public void supprimerLignePanier(int idPanier, int idProduit);
//       public void supprimerLignePanier(int idLignePanier);
//       public void supprimerLignePanier(int idPanier, int idProduit);
    public void supprimerLignePanier(int idLignePanier);
//         public void supprimerLignePanier(int idPanier, int idProduit);
     public List<LignePanier> afficheligne(int idPanier);
     //list : select
   public ArrayList<LignePanier> afficherTous();
    public List<LignePanier> getLignePanierparIdPanier(int idPanier);
    
    public LignePanier getLignePanierparIdLignePanier(int idLignePanier) ;
}
