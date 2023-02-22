/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import models.Categorie;

import interfaces.CategoryInterface;
import util.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amine
 */
public class CategoryService implements CategoryInterface{
        //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    @Override
    public void addCategory(Categorie c) {
         try {
            String req = "INSERT INTO `category`(`name_category`) VALUES ('"+c.getNomCategorie()+")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Category Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addCategory2(Categorie c) {
        try {
            
            String req = "INSERT INTO `category`(`name_category`) VALUES (?)";
            PreparedStatement cat = cnx.prepareStatement(req);
            cat.setString(1, c.getNomCategorie());
            cat.executeUpdate();
            System.out.println("cat Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void modifyCategory(Categorie c,String newName) {
        try {
        String req = "UPDATE `category` SET `name_category`=? WHERE `name_category`=?";
        PreparedStatement cat = cnx.prepareStatement(req);
        cat.setString(1, newName);
        cat.setString(2, c.getNomCategorie());
        cat.executeUpdate();
        System.out.println("Category Modified Successfully!");
        } catch (SQLException ex) {
         ex.printStackTrace();
         }
    }
    
       @Override
    public void deleteCategory(String name) {
        try {
                String req = "DELETE FROM category WHERE name_category = ?";
                PreparedStatement cat = cnx.prepareStatement(req);
                cat.setString(1, name);
                cat.executeUpdate();
                System.out.println("Category deleted successfully!");
                } catch (SQLException ex) {
                ex.printStackTrace();
}
    }
    
    

    @Override
    public List<Categorie> fetchCategories() {
         List<Categorie> categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie c = new Categorie();
                 c.setIdCategorie(rs.getInt(1));
                c.setNomCategorie(rs.getString(2));
                categories.add(c);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return categories;
    }

    //fetch by id

    @Override
    public Categorie fetchCategoryById(int id) {
        Categorie categorie = null;
        try {
            String req = "SELECT * FROM categorie WHERE id_Category=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categorie = new Categorie();
                categorie.setIdCategorie(rs.getInt(1));
                categorie.setNomCategorie(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorie;
    }
    
@Override
    public Categorie fetchCategoryByNom(String nom) {
        Categorie categorie = null;
        try {
            String req = "SELECT * FROM categorie WHERE name_Category=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categorie = new Categorie();
                categorie.setIdCategorie(rs.getInt(1));
                categorie.setNomCategorie(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorie;
    }
    

}
