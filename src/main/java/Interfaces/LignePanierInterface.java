package Interfaces;

import Models.LignePanier;
import Models.Produits;

import java.util.ArrayList;
import java.util.List;

public interface LignePanierInterface {
    public void ajouterLignePanier(Produits p);

    public void modifierlLignePanier(LignePanier lp, int IdLignePanier);

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

    public LignePanier getLignePanierparIdLignePanier(int idLignePanier);
}

