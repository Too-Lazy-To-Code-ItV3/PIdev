package Services;

import Interfaces.ProduitInterface;
import Models.Categorie;
import Models.Produits;
import Util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProduitService implements ProduitInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addProduit(Produits p) {
        try {
            Date date = new Date();
            java.sql.Timestamp sqldate = new java.sql.Timestamp(date.getTime());

            String req = "INSERT INTO `produits`(`ID_User`,`idCategorie`,`nom`, `description`, `nomCategorie`,`image` ,`prix`,`dateAjout`) VALUES (?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getID_User());
            ps.setInt(2, p.getCategorieProduit().getIdCategorie());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getDescription());
            ps.setString(5, p.getCategorieProduit().getNomCategorie());
            ps.setString(6, p.getImage());
            ps.setDouble(7, p.getPrix());
            ps.setTimestamp(8, sqldate);
            ps.executeUpdate();
            System.out.println("Produit ajouté avec succés!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Produits> fetchProduits() {
        List<Produits> produits = new ArrayList<>();
        CategorieService categserv = new CategorieService() {
        };
        try {

            String req = "SELECT * FROM produits";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Produits p = new Produits();
                p.setIdProduit(rs.getInt(1));
                p.setCategorieProduit(categserv.fetchCategorieById(rs.getInt(3)));
                p.setID_User(rs.getInt("ID_User"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                p.setPrix(rs.getDouble("prix"));
                p.setDateAjout(rs.getDate("dateAjout"));
                produits.add(p);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return produits;
    }

    @Override
    public void spprimerProduit(int idProduit) {
        try {
            String req = "DELETE FROM produits WHERE idProduit= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idProduit);
            ps.executeUpdate();
            System.out.println("Produit supprimé !");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modifierProduit(Produits p) {
        try {
            String req = "update `produits` SET  `ID_User`=?,`idCategorie`=?, `nom`=?,`description`=?,`nomCategorie`=?,`image`=?,`prix`=?  where `idProduit`= ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getID_User());
            ps.setInt(2, p.getCategorieProduit().getIdCategorie());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getDescription());
            ps.setString(5, p.getCategorieProduit().getNomCategorie());
            ps.setString(6, p.getImage());
            ps.setDouble(7, p.getPrix());
            ps.setInt(8, p.getIdProduit());
            ps.executeUpdate();
            System.out.println("Produit modifié !");
            System.out.println("categ" + p.getCategorieProduit());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ObservableList<Produits> chercherProduitParCateg(String nomCategorie) {
        ObservableList<Produits> produitsTrouves = FXCollections.observableArrayList();
        CategorieService categserv = new CategorieService() {
        };
        try {
            String req = "SELECT * FROM produits WHERE `nomCategorie`=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, nomCategorie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produits produit = new Produits();
                produit.setIdProduit(rs.getInt("idProduit"));
                produit.setNom(rs.getString("nom"));
                produit.setDescription(rs.getString("description"));
                produit.setCategorieProduit(categserv.fetchCategorieById(rs.getInt(2)));
                produit.setImage(rs.getString("image"));
                produit.setPrix(rs.getInt("prix"));
                produit.setDateAjout(rs.getDate("dateAjout"));
                produitsTrouves.add(produit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produitsTrouves;
    }

    @Override
    public ObservableList<Produits> chercherProduitParNom(String nom) {
        ObservableList<Produits> produitsTrouves = FXCollections.observableArrayList();
        CategorieService categserv = new CategorieService() {
        };
        try {
            String req = "SELECT * FROM produits WHERE `nom` LIKE '%" + nom + "%'";
            Statement s = cnx.createStatement();
            ResultSet rs = s.executeQuery(req);
            while (rs.next()) {
                Produits p = new Produits();
                p.setIdProduit(rs.getInt(1));
                p.setCategorieProduit(categserv.fetchCategorieById(rs.getInt(3)));
                p.setID_User(rs.getInt("ID_User"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                p.setPrix(rs.getDouble("prix"));
                p.setDateAjout(rs.getDate("dateAjout"));
                produitsTrouves.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produitsTrouves;
    }

    @Override
    public void chercherProduitParCategorie(Categorie CategorieProduit) {
        try {
            String req = "SELECT * FROM produits WHERE `categorieProduit`='" + CategorieProduit.getNomCategorie() + "'";
            Statement s = cnx.createStatement();
            ResultSet rs = s.executeQuery(req);
            while (rs.next()) {
                System.out.println("id du produit :" + rs.getInt("idProduit") + "****ce produit est " + rs.getString("nom") + "****Description:" + rs.getString("description") + "****l image du produit est " + rs.getString("image") + "****son prix d'achat est " + rs.getInt("prix") + "****il est ajouté le " + rs.getDate("dateAjout"));
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Produits readById(int id) {
        Produits p = new Produits();
        CategorieService catserv = new CategorieService() {
        };
        try {
            String req = "SELECT * FROM produits WHERE idProduit=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setIdProduit(rs.getInt("idProduit"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setCategorieProduit(catserv.fetchCategorieById(rs.getInt("idCategorie")));
                p.setImage(rs.getString("image"));
                p.setPrix(rs.getDouble("prix"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public Produits readByName(String nom) {
        Produits p = new Produits();
        CategorieService catserv = new CategorieService() {
        };
        try {
            String req = "SELECT * FROM produits WHERE nom=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            rs.next();
            p.setIdProduit(rs.getInt(1));
            p.setNom(rs.getString(3));
            p.setDescription(rs.getString(4));
            p.setCategorieProduit(catserv.fetchCategorieById(rs.getInt(2)));
            p.setImage(rs.getString(6));
            p.setPrix(rs.getDouble(7));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
}
