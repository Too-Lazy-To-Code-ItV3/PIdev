/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.LignePanierInterface;
import models.LignePanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.MaConnexion;

/**
 *
 * @author aouad
 */
public class LignePanierService implements LignePanierInterface{
     //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
   //var 
   

//******************************* Ajouter une ligne Panier  ***********************************************//      
    @Override
    public void ajouterLignePanier(LignePanier lp) {
       
        try {
            Date date = new Date();
            java.sql.Timestamp  sqldate  = new java.sql.Timestamp(date.getTime());
            
            String req ="INSERT INTO `lignepanier`(`ID_User`,`idProduit`, `NomProd`,`imageProd`,`prix_unitaire`,`dateAjout`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lp.getPanier().getID_User());
            ps.setInt(2, lp.getProduit().getIdProduit());
            ps.setString(3, lp.getProduit().getNom());
            ps.setString(4, lp.getProduit().getImage());
            ps.setDouble(5, lp.getProduit().getPrix());
            ps.setTimestamp(6,sqldate);
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
          
            String req ="UPDATE `lignepanier` SET  `ID_User`=? , `idProduit`= ? ,`NomProd`= ? ,`imageProd`= ?,`prix_unitaire`= ?  WHERE idLignePanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lp.getPanier().getID_User());
            ps.setInt(2, lp.getProduit().getIdProduit());
            ps.setString(3, lp.getProduit().getNom());
            ps.setString(4, lp.getProduit().getImage());
            ps.setDouble(5, lp.getProduit().getPrix());
            ps.setInt(6, lp.getIdLignePanier());
            ps.executeUpdate();
            System.out.println("Ligne panier modifiée  avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
 
    
 //******************************* supprimer ligne panier  ***********************************************//      
   @Override
    public void supprimerLignePanier(int idLignePanier  ){
      try {
            String req = "DELETE FROM lignepanier WHERE idLignePanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,idLignePanier);
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
            lignep.setPanier(panserv.afficherPanierParId(rs.getInt("ID_User")));
            lignep.setProduit(prodserv.readById(rs.getInt("idProduit")));

            lignep.setDateAjout(rs.getTimestamp("dateAjout"));
         
            System.out.println();
            lignepanier.add(lignep);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return lignepanier;
}

//******************************* Afficher  ligne***********************************************//  
    @Override
    public List<LignePanier> afficheligne(int ID_User) {
            ArrayList<LignePanier> lignepanier;
            lignepanier = new ArrayList<>();
        
    try {   
          
           String req = "SELECT  NomProd ,imageProd, prix_unitaire , dateAjout FROM lignepanier WHERE ID_User = ?";
           PreparedStatement ps = cnx.prepareStatement(req);
           ps.setInt(1, ID_User);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {{
                    LignePanier lignep = new LignePanier();
                    lignep.getProduit().setNom(rs.getString("nom"));
                    lignep.getProduit().setImage(rs.getString("image"));
                    lignep.getProduit().setPrix(rs.getDouble("prix"));
                    lignep.setDateAjout(rs.getTimestamp("dateAjout"));
   
                lignepanier.add(lignep);
                    }   }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération des lignes de panier: " + ex.getMessage());
    }
    return lignepanier;
}
     
     
//******************************* Afficher  lignePanier  par id ***********************************************//  
    @Override
    public List<LignePanier> getLignePanierparIdPanier(int ID_User) {
            ArrayList<LignePanier> lignepanier;
            lignepanier = new ArrayList<>();
          ProduitService prodserv = new ProduitService();
          PanierService panserv = new PanierService();
    try {   
          
           String req = "SELECT * FROM lignepanier WHERE ID_User = ?";
           PreparedStatement ps = cnx.prepareStatement(req);
           ps.setInt(1, ID_User);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {{
                    LignePanier lignep = new LignePanier();
                    lignep.getProduit().setNom(rs.getString("nom"));
                    lignep.getProduit().setImage(rs.getString("image"));
                    lignep.getProduit().setPrix(rs.getDouble("prix"));
                    lignep.setDateAjout(rs.getTimestamp("dateAjout"));
                        
                  System.out.println();
                lignepanier.add(lignep);
                    }   }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération des lignes de panier: " + ex.getMessage());
    }
    return lignepanier;
}
     
    @Override
    public LignePanier getLignePanierparIdLignePanier(int idLignePanier) {
        LignePanier lignePanier = null;
    try {
        String req = "SELECT * FROM lignepanier WHERE idLignePanier = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, idLignePanier);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            lignePanier = new LignePanier();
            lignePanier.setIdLignePanier(rs.getInt("idLignePanier"));
            lignePanier.getPanier().setID_User(rs.getInt("idID_User"));
            lignePanier.getProduit().setIdProduit(rs.getInt("idProduit"));
            lignePanier.getProduit().setNom(rs.getString("nom"));
            lignePanier.getProduit().setImage(rs.getString("image"));
            lignePanier.getProduit().setPrix(rs.getDouble("prix"));
            lignePanier.setDateAjout(rs.getDate("dateAjout"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
         return lignePanier;
}
    
    
    
    

      
}
