/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interfaces.ProduitInterface;
import models.Produits;
import models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.MaConnexion;

/**
 *
 * @author aouad
 */ 
public  class ProduitService implements ProduitInterface{
     //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
   //var 
    int id = 0;
    //instanciation
    Category c= new Category ();
    
    //******************************* Ajouter un produit ***********************************************//   
  
    @Override
    public void addProduit(Produits p) {
       
        try {
            Date date = new Date();
            java.sql.Timestamp  sqldate  = new java.sql.Timestamp(date.getTime());
            
            String req = "INSERT INTO `produits`(`ID_User`,`idCategorie`,`nom`, `description`, `nomCategorie`,`image` ,`prix`,`dateAjout`) VALUES (?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getID_User());
            ps.setInt(2, p.getCategorieProduit().getId_Category());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getDescription());
            ps.setString(5,p.getCategorieProduit().getName_category());
            ps.setString(6, p.getImage());
            ps.setDouble(7, p.getPrix());
            ps.setTimestamp(8,sqldate);
            ps.executeUpdate();
            System.out.println("Produit ajouté avec succés!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
    
    }
    
    
    
 //*********************************** Modifier un produit *******************************************//  
    
  
    @Override
    public void modifierProduit(Produits p){
     try {
            String req = "update `produits` SET  `ID_User`=?,`idCategorie`=?, `nom`=?,`description`=?,`nomCategorie`=?,`image`=?,`prix`=?  where `idProduit`= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,p.getID_User());
            ps.setInt(2, p.getCategorieProduit().getId_Category());
            ps.setString(3,p.getNom());
            ps.setString(4,p.getDescription());
            ps.setString(5,p.getCategorieProduit().getName_category());
            ps.setString(6,p.getImage());
            ps.setDouble(7,p.getPrix());
            ps.setInt(8, p.getIdProduit());
            ps.executeUpdate();
            System.out.println("Produit modifié !");
            System.out.println("categ"+p.getCategorieProduit());
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
  //******************************* Supprimer un produit ***********************************************//  
    
    //supprimer un produit 

    @Override
    public void spprimerProduit(int idProduit){
      try {
            String req = "DELETE FROM produits WHERE idProduit= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idProduit);
            ps.executeUpdate();
            System.out.println("Produit supprimé !");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
     
     //***************************** chercher  Produit par nom *************************************************//  
    
    //chercher un produit par nom
  
    @Override
 public ObservableList<Produits> chercherProduitParNom(String nom) {
    ObservableList<Produits> produitsTrouves = FXCollections.observableArrayList();
     CategoryService categserv = new CategoryService() {};
    try {
        String req = "SELECT * FROM produits WHERE `nom` LIKE '%" + nom + "%'";
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery(req);
        while (rs.next()) {
            Produits p = new Produits();
                p.setIdProduit(rs.getInt(1));
                p.setCategorieProduit(categserv.fetchCategoryById(rs.getInt(3)));
                p.setID_User(rs.getInt("ID_User"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                p.setPrix(rs.getDouble("prix"));
                p.setDateAjout(rs.getDate("dateAjout"));       
            produitsTrouves.add(p);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return produitsTrouves;
}
         //***************************** chercher  Produit par categorie *************************************************//  
    
    //chercher un produit par categorie
  
    @Override
public void chercherProduitParCategorie(Category CategorieProduit) {
    try {
        String req = "SELECT * FROM produits WHERE `categorieProduit`='"+ CategorieProduit.getName_category() +"'";
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery(req);
        while (rs.next()) {
            System.out.println("id du produit :"+rs.getInt("idProduit")+"****ce produit est "+rs.getString("nom")+"****Description:"+rs.getString("description")+"****l image du produit est "+ rs.getString("image") +"****son prix d'achat est "+rs.getInt("prix")+"****il est ajouté le "+rs.getDate("dateAjout"));
            System.out.println();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
@Override
public ObservableList<Produits> chercherProduitParCateg(String nomCategorie) {
    ObservableList<Produits> produitsTrouves = FXCollections.observableArrayList();
    CategoryService categserv = new CategoryService () {};
    try {
        String req = "SELECT * FROM produits WHERE `nomCategorie`=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, nomCategorie);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Produits produit = new Produits();
            produit.setIdProduit(rs.getInt("idProduit"));
            produit.setNom(rs.getString("nom"));
            produit.setDescription(rs.getString("description"));
            produit.setCategorieProduit(categserv.fetchCategoryById(rs.getInt(2)));
            produit.setImage(rs.getString("image"));
            produit.setPrix(rs.getInt("prix"));
            produit.setDateAjout(rs.getDate("dateAjout"));
            produitsTrouves.add(produit);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return produitsTrouves;
}





      //*****************************lire Produit par id *************************************************//     
    
    @Override
public Produits readById(int id) {
    Produits p = new Produits();
    CategoryService catserv = new CategoryService() {};
    try {
        String req = "SELECT * FROM produits WHERE idProduit=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            p.setIdProduit(rs.getInt("idProduit"));
            p.setNom(rs.getString("nom"));
            p.setDescription(rs.getString("description"));
            p.setCategorieProduit(catserv.fetchCategoryById(rs.getInt("idCategorie")));
            p.setImage(rs.getString("image"));
            p.setPrix(rs.getDouble("prix"));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return p;    
}
////*****************************lire Produit par nom *************************************************//     
    
    @Override
    public Produits readByName(String nom) {
         Produits p = new Produits();
    CategoryService catserv = new CategoryService() {};
    try {
        String req = "SELECT * FROM produits WHERE nom=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, nom);
        ResultSet rs = ps.executeQuery();
        rs.beforeFirst();
        rs.next();
        p.setIdProduit(rs.getInt(1));
        p.setNom(rs.getString(3));
        p.setDescription(rs.getString(4));   
        p.setCategorieProduit(catserv.fetchCategoryById(rs.getInt(2)));  
        p.setImage(rs.getString(6));  
        p.setPrix(rs.getDouble(7));  
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return p;
    }
    
    //*****************************Afficher List des Produits *************************************************//     
     
    @Override
    public List<Produits> fetchProduits() {
        List<Produits> produits = new ArrayList<>();
        CategoryService categserv = new CategoryService() {};
        try {
            
            String req = "SELECT * FROM produits";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Produits p = new Produits();
                p.setIdProduit(rs.getInt(1));
                p.setCategorieProduit(categserv.fetchCategoryById(rs.getInt(3)));
                p.setID_User(rs.getInt("ID_User"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                p.setPrix(rs.getDouble("prix"));
                p.setDateAjout(rs.getDate("dateAjout"));       
                produits.add(p);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return produits;
    }

   
    
     }
    



    


  

   

  

  
    
    

