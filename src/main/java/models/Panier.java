/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author aouad
 */
public class Panier {
     private int ID_User ;
     private int nbr_produits;
     private double montant_total;
     
    
  
     
    //constructeur 

    public Panier(int ID_User,int nbr_produits, double montant_total) {
   
        this.ID_User=ID_User;
        this.nbr_produits = nbr_produits;
        this.montant_total = montant_total;
     
    }

 

    public Panier() {
    }

     
     //getters

   

    public int getID_User() {
        return ID_User;
    }

   

    public int getNbr_produits() {
        return nbr_produits;
    }
    

    public double getMontant_total() {
        return montant_total;
    }

   

 
 //setters
 

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
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
        return "Panier{" + "ID_User=" + ID_User + ", nbr_produits=" + nbr_produits + ", montant_total=" + montant_total + '}';
    }


  

    public void ajouterLignePanier(LignePanier lignePanier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
   

   
    
    
    
   
     
     
     
     
     
     
}
