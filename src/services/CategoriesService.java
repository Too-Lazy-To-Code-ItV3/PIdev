/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Interfaces.CategoriesInterface;
import Models.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;

/**
 *
 * @author aouad
 */
public abstract class CategoriesService implements CategoriesInterface{
    
      //var
    Connection cnx = MyConnection.getInstance().getCnx();
    
  //******************************* Ajouter une catégorie ***********************************************//   
    
     @Override
    public void addCategorie(Categories c) {
       
        try {
            
            String req = "INSERT INTO `categories`(`nomCategorie`) VALUES (?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getNomCategorie());
            ps.executeUpdate();
            System.out.println("Catégorie ajouté avec succés!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();}
    
    }
     //******************************* modifier une catégorie ***********************************************//   
    
//     @Override
//    public void modifierCategorie(Categories c) {
//       
//        try {
//            String req = "update `categories` SET  `nomCategorie`=? where `idCategorie`= ? ";
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setString(1, c.getNomCategorie());
//            ps.setInt(2, c.getIdCategorie());
//            ps.executeUpdate();
//            System.out.println("categorie modifié !");
//            } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    //******************************* afficher catégorie par id***********************************************// 
   
    @Override
    public Categories readById(int id) {
        Categories cat = new Categories();
        try {
            
       String req="SELECT * FROM categories WHERE `idCategorie`='"+id+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
                cat.setIdCategorie(rs.getInt(1));
                cat.setNomCategorie(rs.getString(2));
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return  cat;
        
      
    }
       //******************************* afficher catégorie par nom **********************************************// 
      @Override
    public Categories readByNom(String nom) {
        Categories categorieNom =null;
     
        try {
            
            String req = "SELECT * FROM categories where nomCategorie=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Categories c = new Categories();
                c.setNomCategorie(rs.getString(1));
             
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return categorieNom;
    }
   //******************************* List catégorie ***********************************************//     
    
    
      @Override
    public List<Categories> fetchCategories() {
        List<Categories> categories = new ArrayList<>();
     
        try {
            
            String req = "SELECT * FROM categories";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categories c = new Categories();
                c.setIdCategorie(rs.getInt(1));
                c.setNomCategorie(rs.getString(2));
                categories.add(c);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return categories;
    }

   

    
    
    
    
    
}
