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
            
            String req = "INSERT INTO Challenge( `Title`, `Description`, `Date_C`, `PathIMG`, `Niveau`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getDescription());
            ps.setString(3, c.getDate_C());
            ps.setString(4, c.getPathIMG());
            ps.setInt(5, c.getNiveau());

            ps.executeUpdate();
            System.out.println("Challenge Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void modifyChallenge(Challenge c) {
        try {    
            String req = "update Challenge set `Title`=?, `description`=?, `date_C`=?, `PathIMG`=?, `Niveau`=? WHERE `ID_Challenge`=?";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getDescription());
            ps.setString(3, c.getDate_C());
            ps.setString(4, c.getPathIMG());
            ps.setInt(5, c.getNiveau());
            ps.setInt(6, c.getID_Challenge());
         
            
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
            
            String req = "SELECT * FROM Challenge";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Challenge c = new Challenge();
                c.setID_Challenge(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setDate_C(rs.getString(4));
                c.setPathIMG(rs.getString(5));
                c.setNiveau(rs.getInt(6));
                c.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                Challenges.add(c);
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
                Challenge c = new Challenge();
                c.setID_Challenge(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setDate_C(rs.getString(4));
                c.setPathIMG(rs.getString(5));
                c.setNiveau(rs.getInt(6));
                c.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                Challenges.add(c);
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
            
            String req = "SELECT * FROM Challenge where ID_Challenge = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Challenge c = new Challenge();
                c.setID_Challenge(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setDate_C(rs.getString(4));
                c.setPathIMG(rs.getString(5));
                c.setNiveau(rs.getInt(6));
                c.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                Challenges.add(c);
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
            
            String req = "SELECT * FROM Challenge where Title like '%"+name+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Challenge c = new Challenge();
                c.setID_Challenge(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setDate_C(rs.getString(4));
                c.setPathIMG(rs.getString(5));
                c.setNiveau(rs.getInt(6));
                c.setParticipants(pi.fetchParticipantsByChallenge(rs.getInt(1)));
                Challenges.add(c);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Challenges;
    }
    
}