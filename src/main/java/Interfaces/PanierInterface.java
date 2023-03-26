package Interfaces;

import Models.Panier;

import java.util.List;

public interface PanierInterface {
    List<Panier> fetchPanier();
//    void afficherProduit(Panier pan,int idPanier);

    public void ajouterPanier(int ID_User);

    public void modifierPanier(Panier pan, int IdPanier);

    public void supprimerPanier(int idPanier);

    public void viderPanier();

    public Panier afficherPanierParId(int idPanier);

    public double calculerMontantTotal(int idPanier);

    //     public void MisàjourMontantTotal(Panier pan,int idPanier,double montant_tot );
    public void MisàjourMontantTotal(int idPanier, double montant_tot);

    public int calculerNombreProduits(int idPanier);

    public Panier afficherPanierParIdUser(int ID_User);
}
