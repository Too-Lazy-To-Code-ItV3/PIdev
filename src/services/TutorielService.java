/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Models.Tutoriel;
import java.sql.Connection;
import java.sql.Statement;
import interfaces.TutorielInterface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Categorie;
import Models.Utilisateur;
import util.MaConnexion;

/**
 *
 * @author achref
 */
//on utilise htdocs
public class TutorielService implements TutorielInterface {
    Connection cnx = MaConnexion.getInstance().getCnx();
    
    public void addTutoriel(Tutoriel t) {
        try {
            String req = "INSERT INTO `tutoriel`(`Title`,`Niveau`,`Description`, `PathImg`, `ID_Categorie`, `ID_Artist`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, t.getTitle());
            ps.setInt(2, t.getNiveau());
            ps.setString(3, t.getDescription());
            ps.setString(4, t.getPathImg());
            ps.setInt(5, t.getCategorie().getID_Categorie());
            ps.setInt(6, t.getCreator().getID_user());
            ps.executeUpdate();
            System.out.println("Tutoriel Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
        @Override
    public void ModifyTutoriel(Tutoriel t) {
        try {    
            String req = "update Tutoriel set `Title`=?, `Niveau`=?,`Description`=?,`PathImg`=? where `ID_Tutoriel`= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getTitle());
            ps.setInt(2, t.getNiveau());
            ps.setString(3, t.getDescription());
            ps.setString(4, t.getPathImg());
            ps.setInt(5, t.getID_Tutoriel());
            ps.executeUpdate();
            System.out.println("Tutoriel Modified Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteTutoriel(int id) {
        String req = "DELETE FROM tutoriel where ID_Tutoriel = "+id;
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Tutoriel deleted Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @Override
    public List<Tutoriel> fetchTutoriels() {
        List<Tutoriel> tutoriels = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM tutoriel as t,categorie as c,utilisateur as u where t.ID_Categorie=c.ID_Categorie and t.ID_Artist=u.ID_user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Tutoriel t = new Tutoriel();
                Categorie c = new Categorie();
                Utilisateur u = new Utilisateur();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                        
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setLocation(rs.getString("Location"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setEmail(rs.getString("Email"));
                
                t.setCreator(u);
                t.setCategorie(c);
                tutoriels.add(t);
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return tutoriels;
    }
    
    @Override
    public List<Tutoriel> fetchTutorielsByArtist(String NomArtist) {
        List<Tutoriel> tutoriels = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM tutoriel as t,categorie as c,utilisateur as u where t.ID_Categorie=c.ID_Categorie and t.ID_Artist=u.ID_user and u.nom = '"+NomArtist+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Tutoriel t = new Tutoriel();
                Categorie c = new Categorie();
                Utilisateur u = new Utilisateur();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                        
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setLocation(rs.getString("Location"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setEmail(rs.getString("Email"));
                
                t.setCreator(u);
                t.setCategorie(c);
                tutoriels.add(t);
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return tutoriels;
    }

    @Override
    public List<Tutoriel> fetchTutorielsByTitle(String title) {
        List<Tutoriel> tutoriels = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM tutoriel as t,categorie as c,utilisateur as u where t.ID_Categorie=c.ID_Categorie and t.ID_Artist=u.ID_user and t.Title like '%"+title+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Tutoriel t = new Tutoriel();
                Categorie c = new Categorie();
                Utilisateur u = new Utilisateur();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                        
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setLocation(rs.getString("Location"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setEmail(rs.getString("Email"));
                
                t.setCreator(u);
                t.setCategorie(c);
                tutoriels.add(t);
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return tutoriels;
    }
    
        @Override
    public Tutoriel fetchTutorielByID(int ID_Tutoriel) {
        Tutoriel t = new Tutoriel();
        try {
            
            String req = "SELECT * FROM tutoriel as t,categorie as c,utilisateur as u where t.ID_Categorie=c.ID_Categorie and t.ID_Artist=u.ID_user and t.ID_Tutoriel = "+ID_Tutoriel;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Categorie c = new Categorie();
                Utilisateur u = new Utilisateur();

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                t.setPathImg(rs.getString("PathImg"));
                
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                        
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setLocation(rs.getString("Location"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setEmail(rs.getString("Email"));
                u.setPathImage(rs.getString("pathImage"));
                
                t.setCreator(u);
                t.setCategorie(c);
                
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return t;
    }

    @Override
    public List<Tutoriel> fetchTutorielsByCategorie(int ID_Categorie ){
        List<Tutoriel> tutoriels = new ArrayList<>();
        try {
            String req = "SELECT * FROM tutoriel as t,categorie as c,utilisateur as u where t.ID_Categorie=c.ID_Categorie and t.ID_Artist=u.ID_user and t.ID_Categorie = "+ID_Categorie;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Tutoriel t = new Tutoriel();
                Categorie c = new Categorie();
                Utilisateur u = new Utilisateur();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                        
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setLocation(rs.getString("Location"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setEmail(rs.getString("Email"));
                
                t.setCreator(u);
                t.setCategorie(c);
                tutoriels.add(t);
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return tutoriels;
    }
}
