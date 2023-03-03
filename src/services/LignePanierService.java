/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Interfaces.LignePanierInterface;
import Models.LignePanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.MyConnection;

/**
 *
 * @author aouad
 */
public class LignePanierService implements LignePanierInterface{
     //var
    Connection cnx = MyConnection.getInstance().getCnx();
    
   //var 
   

//******************************* Ajouter une ligne Panier  ***********************************************//      
    @Override
    public void ajouterLignePanier(LignePanier lp) {
       
        try {
            Date date = new Date();
            java.sql.Timestamp  sqldate  = new java.sql.Timestamp(date.getTime());
            
            String req ="INSERT INTO `lignepanier`(`idPanier`,`idProduit`, `NomProd`,`prix_unitaire`,`dateAjout`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lp.getPanier().getIdPanier());
            ps.setInt(2, lp.getProduit().getIdProduit());
            ps.setString(3, lp.getProduit().getNom());
            ps.setDouble(4, lp.getProduit().getPrix());
            ps.setTimestamp(5,sqldate);
            ps.executeUpdate();
            System.out.println("LignePanier ajoutée avec succés!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
    
    }
  //******************************* modifier une ligne Panier  ***********************************************//      
       
    //update
    @Override
    public void modifierlLignePanier(LignePanier lp, int IdLignePanier) {
      
        try {
          
            String req ="UPDATE `lignepanier` SET  `idPanier`=? , `idProduit`= ? ,`NomProd`= ? ,`prix_unitaire`= ?  WHERE idLignePanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lp.getPanier().getIdPanier());
            ps.setInt(2, lp.getProduit().getIdProduit());
            ps.setString(3, lp.getProduit().getNom());
            ps.setDouble(4, lp.getProduit().getPrix());
            ps.setInt(5, lp.getIdLignePanier());
            ps.executeUpdate();
            System.out.println("Ligne panier modifiée  avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
 
    
 //******************************* supprimer ligne panier  ***********************************************//      
   @Override
    public void supprimerLignePanier(int idLignePanier){
      try {
            String req = "DELETE FROM panier WHERE idLignePanier= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,1);
            ps.executeUpdate();
            System.out.println("Ligne Panier supprimée avec succés!");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
    
//******************************* Afficher  lignePanier  ***********************************************//  
    
 @Override
public ArrayList<LignePanier> afficherTous() {
    ArrayList<LignePanier> lignepanier = new ArrayList<>();
    ProduitService prodserv = new ProduitService();
    PanierService panserv = new PanierService();
    try {
        String req ="SELECT * FROM lignepanier";
        PreparedStatement ps = cnx.prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            LignePanier lignep = new LignePanier();
            lignep.setIdLignePanier(rs.getInt("idLignePanier"));
            lignep.setPanier(panserv.afficherPanierParId(rs.getInt("idPanier")));
            lignep.setProduit(prodserv.readById(rs.getInt("idProduit")));
            lignep.setPrix_unitaire(rs.getDouble("prix_unitaire"));
            lignep.setDateAjout(rs.getTimestamp("dateAjout"));
         
            System.out.println();
            lignepanier.add(lignep);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return lignepanier;
}


     
//******************************* Afficher  lignePanier  par id ***********************************************//  
    @Override
    public List<LignePanier> getLignePanierparIdPanier(int idPanier) {
            ArrayList<LignePanier> lignepanier;
            lignepanier = new ArrayList<>();
          ProduitService prodserv = new ProduitService();
          PanierService panserv = new PanierService();
    try {   
          
           String req = "SELECT * FROM lignepanier WHERE idPanier = ?";
           PreparedStatement ps = cnx.prepareStatement(req);
           ps.setInt(1, idPanier);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {{
                    LignePanier lignep = new LignePanier();
//                        lignep.setIdLignePanier(rs.getInt(1));
//                        lignep.setPanier(panserv.afficherPanierParId(rs.getInt(2)));
                        lignep.setNomProd(rs.getString("NomProd"));
                        lignep.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                        lignep.setDateAjout(rs.getTimestamp("dateAjout"));
                        
                  System.out.println();
                lignepanier.add(lignep);
                    }   }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération des lignes de panier: " + ex.getMessage());
    }
    return lignepanier;
}
     

      
}
