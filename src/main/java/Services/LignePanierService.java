package Services;

import Interfaces.LignePanierInterface;
import Interfaces.PanierInterface;
import Models.LignePanier;
import Models.Logged;
import Models.Produits;
import Util.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LignePanierService implements LignePanierInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    PanierInterface pi = new PanierService();

    @Override
    public void ajouterLignePanier(Produits p) {
        try {

            Date date = new Date();
            java.sql.Timestamp sqldate = new java.sql.Timestamp(date.getTime());
            System.out.println(added(p));
            if (!added(p)) {
                String req = "INSERT INTO `lignepanier`(`idPanier`,`idProduit`, `NomProd`,`imageProd`,`prix_unitaire`) VALUES (?,?,?,?,?)";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setInt(1, pi.afficherPanierParIdUser(Logged.get_instance().getUser().getID_User()).getIdPanier());
                ps.setInt(2, p.getIdProduit());
                ps.setString(3, p.getNom());
                ps.setString(4, p.getImage());
                ps.setDouble(5, p.getPrix());
                ps.executeUpdate();
                System.out.println("LignePanier ajoutée avec succés!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifierlLignePanier(LignePanier lp, int IdLignePanier) {
        try {

            String req = "UPDATE `lignepanier` SET  `idPanier`=? , `idProduit`= ? ,`NomProd`= ? ,`imageProd`= ?,`prix_unitaire`= ?  WHERE idLignePanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lp.getPanier().getIdPanier());
            ps.setInt(2, lp.getProduit().getIdProduit());
            ps.setString(3, lp.getProduit().getNom());
            ps.setString(4, lp.getProduit().getImage());
            ps.setDouble(5, lp.getProduit().getPrix());
            ps.setInt(6, lp.getIdLignePanier());
            ps.executeUpdate();
            System.out.println("Ligne panier modifiée  avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean added(Produits p) {
        return null;
    }

    @Override
    public void supprimerLignePanier(int idLignePanier) {
        try {
            String req = "DELETE FROM panier WHERE idLignePanier= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, 1);
            ps.executeUpdate();
            System.out.println("Ligne Panier supprimée avec succés!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<LignePanier> afficheligne(int idPanier) {
        ArrayList<LignePanier> lignepanier;
        lignepanier = new ArrayList<>();

        try {

            String req = "SELECT  NomProd ,imageProd, prix_unitaire , dateAjout FROM lignepanier WHERE idPanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idPanier);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                {
                    LignePanier lignep = new LignePanier();
                    lignep.setNomProd(rs.getString("NomProd"));
                    lignep.setImageProd(rs.getString("imageProd"));
                    lignep.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                    lignep.setDateAjout(rs.getTimestamp("dateAjout"));

                    lignepanier.add(lignep);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des lignes de panier: " + ex.getMessage());
        }
        return lignepanier;
    }

    @Override
    public ArrayList<LignePanier> afficherTous() {
        ArrayList<LignePanier> lignepanier = new ArrayList<>();
        ProduitService prodserv = new ProduitService();
        PanierService panserv = new PanierService();
        try {
            String req = "SELECT * FROM lignepanier";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LignePanier lignep = new LignePanier();
                lignep.setIdLignePanier(rs.getInt("idLignePanier"));
                lignep.setPanier(panserv.afficherPanierParId(rs.getInt("idPanier")));
                lignep.setProduit(prodserv.readById(rs.getInt("idProduit")));
                lignep.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                lignep.setDateAjout(rs.getTimestamp("dateAjout"));

                System.out.println();
                lignepanier.add(lignep);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lignepanier;
    }

    @Override
    public List<LignePanier> getLignePanierparIdPanier(int idPanier) {
        ArrayList<LignePanier> lignepanier;
        lignepanier = new ArrayList<>();
        ProduitService prodserv = new ProduitService();
        PanierService panserv = new PanierService();
        try {

            String req = "SELECT * FROM lignepanier WHERE idPanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idPanier);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                {
                    LignePanier lignep = new LignePanier();
//                        lignep.setIdLignePanier(rs.getInt(1));
//                        lignep.setPanier(panserv.afficherPanierParId(rs.getInt(2)));
                    lignep.setNomProd(rs.getString("NomProd"));
                    lignep.setNomProd(rs.getString("imageProd"));
                    lignep.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                    lignep.setDateAjout(rs.getTimestamp("dateAjout"));

                    System.out.println();
                    lignepanier.add(lignep);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des lignes de panier: " + ex.getMessage());
        }
        return lignepanier;
    }

    @Override
    public LignePanier getLignePanierparIdLignePanier(int idLignePanier) {
        LignePanier lignePanier = null;
        try {
            String req = "SELECT * FROM lignepanier WHERE idLignePanier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idLignePanier);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lignePanier = new LignePanier();
                lignePanier.setIdLignePanier(rs.getInt("idLignePanier"));
                lignePanier.getPanier().setIdPanier(rs.getInt("idIdPanier"));
                lignePanier.getProduit().setIdProduit(rs.getInt("idProduit"));
                lignePanier.setNomProd(rs.getString("NomProd"));
                lignePanier.setImageProd(rs.getString("imageProd"));
                lignePanier.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                lignePanier.setDateAjout(rs.getDate("dateAjout"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lignePanier;
    }
}

