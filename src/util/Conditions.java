
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author achref
 */
public class Conditions {
   



    Connection cnx = MaConnexion.getInstance().getCnx();
    public boolean PanierExistOupas(int idPanier) throws SQLException {
        String query = "SELECT idPanier FROM panier WHERE idPanier = ?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, idPanier);
            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }
   /* public boolean idUserExistdansPanier(int ID_User) throws SQLException {
        String query = "SELECT ID_User FROM panier WHERE ID_User = ?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, ID_User );
            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }*/
    public boolean idProduitExistdansLignePanier(int idProduit,int idPanier) throws SQLException {
        String query = "SELECT lp.idProduit FROM lignepanier lp JOIN panier p ON p.idPanier = lp.idPanier  WHERE lp.idProduit = ? AND lp.idPanier =? ";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, idProduit);
            statement.setInt(2, idPanier);
       
            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }
}

