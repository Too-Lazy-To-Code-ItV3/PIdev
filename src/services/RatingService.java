/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Models.Categorie;
import Models.Challenge;
import Models.Rate;
import Models.Tutoriel;
import Models.Utilisateur;
import interfaces.RatingInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MaConnexion;

/**
 *
 * @author achref
 */
public class RatingService implements RatingInterface {
    Connection cnx = MaConnexion.getInstance().getCnx();
    
    @Override
    public void updateRating(Rate rate) {
        try {
            if(fetchRating(rate)==0)
            {
                String req = "INSERT INTO `rating`(`rating`,`challenge_id`,`participator_id`, `rater_id`) VALUES (?,?,?,?)";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setDouble(1, rate.getRating());
                ps.setInt(2, rate.getChallenge().getID_Challenge());
                ps.setInt(3, rate.getParticipator().getID_user());
                ps.setInt(4, rate.getRater().getID_user());
                ps.executeUpdate();
                System.out.println("rate is inserted");
            }
            else
            {
                String req = "update rating set `rating`=? where `challenge_id`= ? and `participator_id`=? and `rater_id`=? ";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setDouble(1, rate.getRating());
                ps.setInt(2, rate.getChallenge().getID_Challenge());
                ps.setInt(3, rate.getParticipator().getID_user());
                ps.setInt(4, rate.getRater().getID_user());
                ps.executeUpdate();
                System.out.println("rate is updated");

            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Double fetchRating(Rate rate) {
        Rate rating = new Rate();
        try {
            
            String req = "SELECT * FROM rating as rat,challenge as c,utilisateur as p,utilisateur as r where rat.challenge_id="+rate.getChallenge().getID_Challenge()+" and rat.participator_id="+rate.getParticipator().getID_user()+" and rat.rater_id="+rate.getRater().getID_user();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                return(rs.getDouble("rating"));
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public Double fetchRatingAVG(Rate rate) {
        Rate rating = new Rate();
        try {
            String req = "SELECT AVG(rating) FROM rating as rat,challenge as c,utilisateur as p where rat.challenge_id="+rate.getChallenge().getID_Challenge()+" and rat.participator_id="+rate.getParticipator().getID_user();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                return(rs.getDouble("AVG(rating)"));
            }   
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }
    
}
