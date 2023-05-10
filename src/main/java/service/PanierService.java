/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.PanierInterface;


import models.Panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import util.MaConnexion;

/**
 *
 * @author aouad
 */
public class PanierService implements PanierInterface{
   
     //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
   //var 
   

//******************************* Ajouter un Panier  ***********************************************//      

    @Override
    public void ajouterPanier(Panier pan) {
       
        try {
            String req ="INSERT INTO `panier`(`nbr_produits`,`montant_total`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, pan.getNbr_produits());
            ps.setDouble(2, pan.getMontant_total());  
            ps.executeUpdate();
            System.out.println("Panier ajouté avec succés!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
    
    }
     //******************************* modifier une ligne Panier  ***********************************************//      
       
    //update
    @Override
    public void modifierPanier(Panier pan, int ID_User) {
      
        try {
          
            String req ="UPDATE `panier` SET   `nbr_produits`= ? ,`montant_total`= ?   WHERE ID_User = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, pan.getNbr_produits());
            ps.setDouble(2, pan.getMontant_total());
            ps.setInt(3, pan.getID_User());
            ps.executeUpdate();
            System.out.println("Panier modifié  avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
   //******************************* supprimer un Panier  ***********************************************//      
     
    @Override
    public void supprimerPanier(int ID_User){
      try {
            String req = "DELETE FROM panier WHERE ID_User= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,ID_User);
            ps.executeUpdate();
            System.out.println("Panier supprimé avec succés!");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //******************************* vider un Panier  ***********************************************//      
     
    @Override
    public void viderPanier(){
      try {
            String req = "DELETE FROM panier";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.executeUpdate();
            System.out.println("Panier vide");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  //******************************* List Panier , afficher tout ***********************************************//        
       @Override
    public List<Panier> fetchPanier() {
        List<Panier> pan = new ArrayList<>();
         Panier pnr = new Panier();
        try {
            String req = "SELECT * FROM panier ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                pnr.setID_User(rs.getInt(1));
                pnr.setNbr_produits(rs.getInt(2));
                pnr.setMontant_total(rs.getDouble(3));
            pan.add(pnr);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pan;
    }

 //******************************* Calculer le montant total et le mettre à jour dans la base de données ***********************************************//    
    @Override
    public double calculerMontantTotal(int ID_User) {
    double montantTotal = 0;
    try {
        String req = "SELECT SUM(prix_unitaire) FROM lignepanier WHERE ID_User = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, ID_User);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            montantTotal = rs.getDouble(1);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    System.out.print(montantTotal);
    return montantTotal;
}
  @Override
      public void MisàjourMontantTotal(int ID_User,double montant_tot ) {
      
        try {
            String req =" UPDATE panier SET montant_total = ? WHERE ID_User = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDouble(1,montant_tot);
            ps.setDouble(2,ID_User);
            ps.executeUpdate();
           
            System.out.println("le montant total mis à jour avec succées");
        } catch (SQLException ex) {
            ex.printStackTrace();}
    }
 //******************************* Calculer le nombre de produit d'un meme panier ***********************************************//  
   @Override
     public int calculerNombreProduits(int ID_User) {
         int nbr_produits=0;
      try {
        String req = "UPDATE panier SET nbr_produits = (SELECT COUNT(*) FROM lignepanier WHERE ID_User = ?) WHERE ID_User = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, ID_User);
        ps.setInt(2, ID_User);
        ps.executeUpdate();
        System.out.println("Nombre de produits mis à jour pour le panier avec ID " + ID_User);
         // récupérer le nombre de produits mis à jour depuis la base de données
        String req2 = "SELECT nbr_produits FROM panier WHERE idPanier = ?";
        PreparedStatement ps2 = cnx.prepareStatement(req2);
        ps2.setInt(1, ID_User);
        ResultSet rs = ps2.executeQuery();
        if (rs.next()) {
            nbr_produits = rs.getInt("nbr_produits");
            return nbr_produits;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la mise à jour du nombre de produits : " + e.getMessage());
    } return nbr_produits;
}

//******************************* Afficher un Panier par id ***********************************************//  
    
    @Override
     public Panier afficherPanierParId(int ID_User) {
         
         Panier p = new Panier();
      
          try {

            String req ="SELECT * FROM panier WHERE `ID_User`='"+ID_User+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
                p.setID_User(rs.getInt(1));
                p.setNbr_produits(rs.getInt(2));
                p.setMontant_total(rs.getDouble(3));   
            } catch (SQLException ex) {
           ex.printStackTrace();
        } return p;
        
}
     




}
