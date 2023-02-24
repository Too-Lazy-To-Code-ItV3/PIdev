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
import Models.Challenge;
import Models.Utilisateur;
import interfaces.ChallengeInterface;
import interfaces.ParticipationInterface;
import util.MaConnexion;

/**
 *
 * @author MediaStudio
 */
public class ChallengeService implements ChallengeInterface {
        Connection cnx = MaConnexion.getInstance().getCnx();
        ParticipationInterface pi = new ParticipationService();

    @Override
    public void addChallenge(Challenge c) {
         try {
            
            String req = "INSERT INTO Challenge( `Title`, `Description`, `Date_C`, `PathIMG`, `Niveau`, `ID_Categorie`, `ID_Artist`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getDescription());
            ps.setString(3, c.getDate_C());
            ps.setString(4, c.getPathIMG());
            ps.setInt(5, c.getNiveau());
            ps.setInt(6, c.getCategorie().getID_Categorie());
            ps.setInt(7, 1);
            
            ps.executeUpdate();
            System.out.println("Challenge Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void modifyChallenge(Challenge c) {
        try {    
            String req = "update Challenge set `Title`=?, `description`=?, `date_C`=?, `PathIMG`=?, `Niveau`=?, `ID_Categorie`=? WHERE `ID_Challenge`=?";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getDescription());
            ps.setString(3, c.getDate_C());
            ps.setString(4, c.getPathIMG());
            ps.setInt(5, c.getNiveau());
            ps.setInt(6, c.getCategorie().getID_Categorie());
            ps.setInt(7, c.getID_Challenge());
            
            ps.executeUpdate();
            System.out.println("Challenge Modified Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    
    @Override
    public void deleteChallenge(int id) {
       String req = "DELETE FROM Challenge where ID_Challenge = "+id;
       Statement st;
       try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Challenge deleted Successfully!");
       } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public List<Challenge> fetchChallenges() {
        List<Challenge> Challenges = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM Challenge ch,Categorie ca,Utilisateur u where ch.ID_Categorie = ca.ID_Categorie and ch.ID_Artist=u.ID_user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Challenge ch = new Challenge();
                ch.setID_Challenge(rs.getInt(1));
                ch.setTitle(rs.getString(2));
                ch.setDescription(rs.getString(3));
                ch.setDate_C(rs.getString(4));
                ch.setPathIMG(rs.getString(5));
                ch.setNiveau(rs.getInt(6));
                ch.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                
                Categorie c = new Categorie();
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                ch.setCategorie(c);
                
                Utilisateur u = new Utilisateur();
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setEmail(rs.getString("Email"));
                u.setPathImage(rs.getString("pathImage"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setLocation(rs.getString("Location"));
                
                ch.setCategorie(c);
                ch.setCreator(u);
                Challenges.add(ch);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Challenges;
    }

    @Override
    public List<Challenge> fetchChallengesSortedByDate() {
                List<Challenge> Challenges = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM Challenge ORDER BY Date_C";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                                Challenge ch = new Challenge();
                ch.setID_Challenge(rs.getInt(1));
                ch.setTitle(rs.getString(2));
                ch.setDescription(rs.getString(3));
                ch.setDate_C(rs.getString(4));
                ch.setPathIMG(rs.getString(5));
                ch.setNiveau(rs.getInt(6));
                ch.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                
                Categorie c = new Categorie();
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                ch.setCategorie(c);
                
                Utilisateur u = new Utilisateur();
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setEmail(rs.getString("Email"));
                u.setPathImage(rs.getString("pathImage"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setLocation(rs.getString("Location"));
                
                ch.setCategorie(c);
                ch.setCreator(u);
                Challenges.add(ch);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Challenges;
    }

    @Override
    public List<Challenge> fetchChallengeById(int id) {
                List<Challenge> Challenges = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM Challenge ch,Categorie ca,Utilisateur u where ch.ID_Categorie = ca.ID_Categorie and ch.ID_Artist=u.ID_user and ID_Challenge = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Challenge ch = new Challenge();
                ch.setID_Challenge(rs.getInt(1));
                ch.setTitle(rs.getString(2));
                ch.setDescription(rs.getString(3));
                ch.setDate_C(rs.getString(4));
                ch.setPathIMG(rs.getString(5));
                ch.setNiveau(rs.getInt(6));
                ch.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                
                Categorie c = new Categorie();
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                ch.setCategorie(c);
                
                Utilisateur u = new Utilisateur();
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setEmail(rs.getString("Email"));
                u.setPathImage(rs.getString("pathImage"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setLocation(rs.getString("Location"));
                
                ch.setCategorie(c);
                ch.setCreator(u);
                Challenges.add(ch);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Challenges;
    }

    @Override
    public List<Challenge> fetchChallengeByName(String name) {
        List<Challenge> Challenges = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM Challenge ch,Categorie ca,Utilisateur u where ch.ID_Categorie = ca.ID_Categorie and ch.ID_Artist=u.ID_user and ch.Title like '%"+name+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                
                Challenge ch = new Challenge();
                ch.setID_Challenge(rs.getInt(1));
                ch.setTitle(rs.getString(2));
                ch.setDescription(rs.getString(3));
                ch.setDate_C(rs.getString(4));
                ch.setPathIMG(rs.getString(5));
                ch.setNiveau(rs.getInt(6));
                ch.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                
                Categorie c = new Categorie();
                c.setID_Categorie(rs.getInt("ID_Categorie"));
                c.setNameCategorie(rs.getString("NameCategorie"));
                c.setDescription(rs.getString("Description"));
                ch.setCategorie(c);
                
                Utilisateur u = new Utilisateur();
                u.setID_user(rs.getInt("ID_user"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setEmail(rs.getString("Email"));
                u.setPathImage(rs.getString("pathImage"));
                u.setDate_Naissance(rs.getString("Date_Naissance"));
                u.setLocation(rs.getString("Location"));
                
                ch.setCategorie(c);
                ch.setCreator(u);
                Challenges.add(ch);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Challenges;
    }
    
}