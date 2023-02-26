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
            
            String req ="INSERT INTO `lignepanier`(`idPanier`,`idProduit`, `nom`,`categorieProduit`,`prix_unitaire`,`quantite`,`dateAjout`,`sous_montant`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lp.getPanier().getIdPanier());
            ps.setInt(2, lp.getProduit().getIdProduit());
            ps.setString(3, lp.getProduit().getNom());
            ps.setString(4, lp.getProduit().getCategorieProduit().getNomCategorie());
            ps.setDouble(5, lp.getProduit().getPrix());
            ps.setInt(6,lp.getQuantite());
            ps.setTimestamp(7,sqldate);
            ps.setDouble(8,lp.getSous_montant());
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
          
            String req ="UPDATE `lignepanier` SET  `idPanier`=? , `idProduit`= ? ,`nom`= ? ,`categorieProduit`= ? ,`prix_unitaire`= ?,`quantite`=?,`sous_montant`=?   WHERE idLignePanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lp.getPanier().getIdPanier());
            ps.setInt(2, lp.getProduit().getIdProduit());
            ps.setString(3, lp.getProduit().getNom());
            ps.setString(4, lp.getProduit().getCategorieProduit().getNomCategorie());
            ps.setDouble(5, lp.getProduit().getPrix());
            ps.setInt(6, lp.getQuantite());
           
            ps.setDouble(7, lp.getSous_montant());
            ps.setInt(8, lp.getIdLignePanier());
            ps.executeUpdate();
            System.out.println("Ligne panier modifiée  avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      //******************************* modifier quantité  demandée des produits***********************************************//  
 @Override
    public void modifierQuantite(int quantite,int IdPanier,  int idLignePanier) {
      LignePanier lp = new LignePanier ();
      try {
          
            String req = "UPDATE `lignepanier` SET `quantite` = ? WHERE `lignepanier`.`IdPanier` = ? AND `lignepanier`.`idLignePanier` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, quantite);
            ps.setInt(2, IdPanier);
            ps.setInt(3, idLignePanier);
            ps.executeUpdate();
            System.out.println("Quantité  modifié  avec succés");
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
            lignep.setQuantite(rs.getInt("quantite"));
            lignep.setDateAjout(rs.getTimestamp("dateAjout"));
            lignep.setSous_montant(rs.getDouble("sous_montant"));
            System.out.println();
            lignepanier.add(lignep);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return lignepanier;
}

//*****************Calculer sous montant de chaque lignepanier (le prix_untitaire * quantite demandé )******************//
      @Override
        public double calculerSousMontant(LignePanier lp , int idLignePanier) {
         double sous_montant =0;
          try {
          sous_montant = lp.getQuantite()*lp.getPrix_unitaire();
          System.out.println("soum ="+sous_montant);
          String req ="UPDATE lignepanier  SET  sous_montant = ? WHERE idLignePanier = ?";
          PreparedStatement ps = cnx.prepareStatement(req);
          ps.setDouble(1,sous_montant);
          ps.setDouble(2, lp.getIdLignePanier());
          ps.executeUpdate();
       
        System.out.println(sous_montant);
    } catch (SQLException ex) {
        ex.printStackTrace();}
    return sous_montant;
}
      //*****************mis à jour sous montant de chaque lignepanier (le prix_untitaire * quantite demandé )******************//
       @Override
      public void MisàjourSousMontant(LignePanier lp,int idLignePanier,double nvmontant ) {
      
        try {
            String req =" UPDATE lignepanier SET sous_montant = ? WHERE idLignePanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDouble(1,nvmontant);
            ps.setDouble(2, idLignePanier);
            ps.executeUpdate();
           
            System.out.println("sous_montant mis à jour avec succées");
        } catch (SQLException ex) {
            ex.printStackTrace();}
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
                        lignep.setIdLignePanier(rs.getInt(1));
                        lignep.setPanier(panserv.afficherPanierParId(rs.getInt(2)));
                        lignep.setProduit(prodserv.readByName(rs.getString(4))); 
                        lignep.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                        lignep.setQuantite(rs.getInt("quantite"));
                        lignep.setDateAjout(rs.getTimestamp("dateAjout"));
                        lignep.setSous_montant(rs.getDouble("sous_montant"));
                  System.out.println();
                lignepanier.add(lignep);
                    }   }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération des lignes de panier: " + ex.getMessage());
    }
    return lignepanier;
}
     

      
}
