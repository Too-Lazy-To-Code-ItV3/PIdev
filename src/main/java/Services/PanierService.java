package Services;

import Interfaces.PanierInterface;
import Models.Panier;
import Util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PanierService implements PanierInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public List<Panier> fetchPanier() {
        List<Panier> pan = new ArrayList<>();
        Panier pnr = new Panier();
        try {
            String req = "SELECT * FROM panier ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                pnr.setIdPanier(rs.getInt(1));
                pnr.setID_User(rs.getInt(2));
                pnr.setNbr_produits(rs.getInt(3));
                pnr.setMontant_total(rs.getDouble(4));
                pan.add(pnr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pan;
    }

    @Override
    public void ajouterPanier(int ID_User) {
        try {
            String req = "INSERT INTO `panier`(`ID_User`,`nbr_produits`,`montant_total`) VALUES (?,0,0)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, ID_User);
            ps.executeUpdate();
            System.out.println("Panier ajouté avec succés!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void modifierPanier(Panier pan, int IdPanier) {
        try {

            String req = "UPDATE `panier` SET   `ID_User`= ? ,`nbr_produits`= ? ,`montant_total`= ?   WHERE idPanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, pan.getID_User());
            ps.setInt(2, pan.getNbr_produits());
            ps.setDouble(3, pan.getMontant_total());
            ps.setInt(4, pan.getIdPanier());
            ps.executeUpdate();
            System.out.println("Panier modifié  avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void supprimerPanier(int idPanier) {
        try {
            String req = "DELETE FROM panier WHERE idPanier= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idPanier);
            ps.executeUpdate();
            System.out.println("Panier supprimé avec succés!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void viderPanier() {
        try {
            String req = "DELETE FROM panier";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.executeUpdate();
            System.out.println("Panier vide");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Panier afficherPanierParId(int idPanier) {
        Panier p = new Panier();

        try {

            String req = "SELECT * FROM panier WHERE `idPanier`=" + idPanier;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                p.setIdPanier(rs.getInt(1));
                p.setID_User(rs.getInt(2));
                p.setNbr_produits(rs.getInt(3));
                p.setMontant_total(rs.getDouble(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public double calculerMontantTotal(int idPanier) {
        double montantTotal = 0;
        try {
            String req = "SELECT SUM(prix_unitaire) FROM lignepanier WHERE idPanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idPanier);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                montantTotal = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.print(montantTotal);
        return montantTotal;
    }

    @Override
    public void MisàjourMontantTotal(int idPanier, double montant_tot) {
        try {
            String req = " UPDATE panier SET montant_total = ? WHERE idPanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDouble(1, montant_tot);
            ps.setDouble(2, idPanier);
            ps.executeUpdate();

            System.out.println("le montant total mis à jour avec succées");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int calculerNombreProduits(int idPanier) {
        int nbr_produits = 0;
        try {
            String req = "UPDATE panier SET nbr_produits = (SELECT COUNT(*) FROM lignepanier WHERE idPanier = ?) WHERE idPanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idPanier);
            ps.setInt(2, idPanier);
            ps.executeUpdate();
            System.out.println("Nombre de produits mis à jour pour le panier avec ID " + idPanier);
            // récupérer le nombre de produits mis à jour depuis la base de données
            String req2 = "SELECT nbr_produits FROM panier WHERE idPanier = ?";
            PreparedStatement ps2 = cnx.prepareStatement(req2);
            ps2.setInt(1, idPanier);
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                nbr_produits = rs.getInt("nbr_produits");
                return nbr_produits;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du nombre de produits : " + e.getMessage());
        }
        return nbr_produits;
    }

    @Override
    public Panier afficherPanierParIdUser(int ID_User) {
        Panier p = new Panier();

        try {

            String req = "SELECT * FROM panier WHERE `ID_User`=" + ID_User;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                p.setIdPanier(rs.getInt(1));
                p.setID_User(rs.getInt(2));
                p.setNbr_produits(rs.getInt(3));
                p.setMontant_total(rs.getDouble(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
}
