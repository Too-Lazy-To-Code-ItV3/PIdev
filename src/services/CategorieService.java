/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.CategorieInterface;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Models.Categorie;
import util.MaConnexion;

/**
 *
 * @author MediaStudio
 */
public class CategorieService implements CategorieInterface {
        Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void addCategorie(Categorie c) {
         try {
            
            String req = "INSERT INTO Categorie( `NameCategorie`, `Description`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, c.getNameCategorie());
            ps.setString(2, c.getDescription());
            ps.executeUpdate();
            System.out.println("Categorie Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifyCategorie(Categorie c) {
        try {    
            String req = "update Categorie set name_categorie`=?, description`=? WHERE `Id_categorie`=?";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setString(1, c.getNameCategorie());
           ps.setString(2, c.getDescription());
           ps.setInt(3, c.getID_Categorie());

         
            
            ps.executeUpdate();
            System.out.println("Categorie Modified Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    @Override
    public void deleteCategorie(int id) {
       String req = "DELETE FROM Categorie where ID_Categorie = "+id;
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie deleted Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Categorie> fetchCategorie() {
List<Categorie> Categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM Categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie e = new Categorie();
                e.setID_Categorie(rs.getInt(1));
                e.setNameCategorie(rs.getString(2));
                e.setDescription(rs.getString(3));
                Categories.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Categories;    }

    @Override
    public List<Categorie> fetchCategorieById(int id) {
        List<Categorie> Categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM Categorie WHERE ID_Categorie = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie l = new Categorie();
                l.setID_Categorie(rs.getInt(1));
                l.setNameCategorie(rs.getString(2));
                l.setDescription(rs.getString(3));
          
                
               Categories.add(l);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Categories;
    }    

    @Override
    public Categorie fetchCategorieByName(String name) {
        Categorie categorie = new Categorie();
        try {
            
            String req = "SELECT * FROM Categorie WHERE NameCategorie = '"+name+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                categorie.setID_Categorie(rs.getInt(1));
                categorie.setNameCategorie(rs.getString(2));
                categorie.setDescription(rs.getString(3));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return categorie;
    }
    
}