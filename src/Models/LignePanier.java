/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author aouad
 */
public class LignePanier {


    private int IdLignePanier;
    private Panier panier;
    private Produits produit;
    private int quantite;
    private double prix_unitaire;
    private Date dateAjout;
    private double sous_montant;
    

    public LignePanier(int IdLignePanier,Panier panier, Produits produit, double prix_unitaire , int quantite, Date dateAjout, double sous_montant) {
        this.IdLignePanier = IdLignePanier;
        this.panier = panier;
        this.produit = produit;
         this.prix_unitaire = prix_unitaire;
        this.quantite = quantite;
        this.dateAjout = dateAjout;
        this.sous_montant = sous_montant;
    }

    public LignePanier() {
    }

    public LignePanier(int idLignePanier, Produits produit, int quantite, double prixUnitaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
//getters
    
    public int getIdLignePanier() {
        return IdLignePanier;
    }

    public Panier getPanier() {
        return panier;
    }
    public double getPrix_unitaire() {
        return prix_unitaire;
    }
    public Produits getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }

  
    public Date getDateAjout() {
        return dateAjout;
    }
     
    public double getSous_montant() {
        return sous_montant;
    }

 //setters 

    public void setIdLignePanier(int IdLignePanier) {
        this.IdLignePanier = IdLignePanier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public void setProduit(Produits produit) {
        this.produit = produit;
    }
    
   public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

 
    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }
    
    
    public void setSous_montant(double sous_montant) {
        this.sous_montant = sous_montant;
    }


    //toString

    @Override
    public String toString() {
        return "LignePanier{" + "IdLignePanier=" + IdLignePanier + ", panier=" + panier + ", produit=" + produit + ", quantite=" + quantite + ", prix_unitaire=" + prix_unitaire + ", dateAjout=" + dateAjout + ", sous_montant=" + sous_montant + '}';
    }

    public void add(LignePanier lp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   

  
   

 
    
    
    

}
