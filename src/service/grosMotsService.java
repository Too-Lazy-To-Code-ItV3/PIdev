/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.grosMotsInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categorie;
import models.grosMots;
import models.offreTravail;
import util.MaConnexion;

/**
 *
 * @author nour2
 */
public class grosMotsService implements  grosMotsInterface {
     Connection cnx = MaConnexion.getInstance().getCnx();
        //******************** suppression*********************************************

    public void Supprimer(grosMots o) {
        try {
            Statement st = cnx.createStatement();
            String req = "DELETE FROM `grosmots` WHERE idMot= " + o.getIdmot() + "";
            st.executeUpdate(req);
            System.out.println("gros mot supprimer avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
    //******************** affichage*********************************************
         public List<grosMots> fetchgrosmots() {
              List<grosMots> grosmots = new ArrayList<>();
         try {
            
             String req = "SELECT * FROM `grosmots` ";
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()) {
                 grosMots grosmot= new grosMots();
                 grosmot.setIdmot(rs.getInt(1));
                 grosmot.setMot(rs.getString(2));
                 grosmots.add(grosmot);
             } 
         } catch (SQLException ex) {
             Logger.getLogger(grosMotsService.class.getName()).log(Level.SEVERE, null, ex);
         }
return  grosmots;
    }
    public List<String> fetchgrosmotsString() {
              List<String> grosmots = new ArrayList<>();
         try {
            
             String req = "SELECT * FROM `grosmots` ";
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()) {
                 grosMots grosmot= new grosMots();
                 grosmot.setIdmot(rs.getInt(1));
                 grosmot.setMot(rs.getString(2));
                                   grosmots.add( grosmot.toStringmot());

             } 
         } catch (SQLException ex) {
             Logger.getLogger(grosMotsService.class.getName()).log(Level.SEVERE, null, ex);
         }
return  grosmots;
    }
    //******************** ajout*********************************************
             public void ajoutGrosMot(grosMots mot) {
        try {
            
            String req = "INSERT INTO `grosmots` (`mot`) VALUES (?)";
            PreparedStatement cat = cnx.prepareStatement(req);
            cat.setString(1, mot.getMot());
            cat.executeUpdate();
            System.out.println("gros mot ajouté");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
             //********************modification*********************************************



public void modifierOffre(grosMots mot) {
            try {
                
                String req = "update `grosmots` set mot=?,where idMOT=?";
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, mot.getMot());
                pst.setInt(2, mot.getIdmot());
                pst.executeUpdate();
                
                System.out.println("gros mot modifié  avec succès");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
}
