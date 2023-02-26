/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aouad
 */
public class Panier {

    public static Iterable<LignePanier> getLignesPanier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     private int idPanier ;
     private int nbr_produits;
     private double montant_total;
     
    
  
     
    //constructeur 

    public Panier(int idPanier,int nbr_produits, double montant_total) {
        this.idPanier = idPanier;
        this.nbr_produits = nbr_produits;
        this.montant_total = montant_total;
     
    }

 

    public Panier() {
    }

     
     //getters

    public int getIdPanier() {
        return idPanier;
    }

   

    public int getNbr_produits() {
        return nbr_produits;
    }
    

    public double getMontant_total() {
        return montant_total;
    }

   

 
 //setters
    
    public void setIdPanier(int idPanier) {    
        this.idPanier = idPanier;
    }


    public void setNbr_produits(int nbr_produits) {
        this.nbr_produits = nbr_produits;
    }

    public void setMontant_total(double montant_total) {
        this.montant_total = montant_total;
    }

 
    //toString

    @Override
    public String toString() {
        return "Panier{" + "idPanier=" + idPanier + ", nbr_produits=" + nbr_produits + ", montant_total=" + montant_total + '}';
    }

   

    public void ajouterLignePanier(LignePanier lignePanier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
   

   
    
    
    
   
     
     
     
     
     
     
}
