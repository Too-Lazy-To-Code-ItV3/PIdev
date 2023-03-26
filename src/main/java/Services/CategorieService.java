package Services;

import Interfaces.CategorieInterface;
import Models.Categorie;
import Util.MyConnection;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieService implements CategorieInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addCategorie2(Categorie c) {
        try {
            // check if a Categorie with the same name already exists
            String checkReq = "SELECT COUNT(*) FROM `Category` WHERE `name_Category`=?";
            PreparedStatement checkStmt = cnx.prepareStatement(checkReq);
            checkStmt.setString(1, c.getNomCategorie());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                // a Categorie with the same name already exists, display an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("A Categorie with the same name already exists!");
                alert.showAndWait();
                return;
            }

            // insert the new Categorie
            String addReq = "INSERT INTO `Category`(`name_Category`) VALUES (?)";
            PreparedStatement addStmt = cnx.prepareStatement(addReq);
            addStmt.setString(1, c.getNomCategorie());
            addStmt.executeUpdate();
            System.out.println("Categorie added successfully!");
            // display a success message
            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Categorie added successfully!");
            alert.showAndWait();*/
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void modifyCategorie(Categorie c, String newName) {

        try {
            String req = "UPDATE `Category` SET `name_Category`=? WHERE `name_Category`=?";
            PreparedStatement cat = cnx.prepareStatement(req);
            cat.setString(1, newName);
            cat.setString(2, c.getNomCategorie());
            cat.executeUpdate();
            System.out.println("Categorie Modified Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteCategorieById(int id) {
        try {
            String req = "DELETE FROM Categorie WHERE Id_Categorie = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Categorie deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCategorie(String name) {
        try {
            String req = "DELETE FROM Categorie WHERE name_Categorie = ?";
            PreparedStatement cat = cnx.prepareStatement(req);
            cat.setString(1, name);
            cat.executeUpdate();
            System.out.println("Categorie deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteCategoryById(int id) {
        try {
            String req = "DELETE FROM category WHERE Id_Category = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Category deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Categorie> fetchCategories() {
        List<Categorie> categories = new ArrayList<>();
        try {

            String req = "SELECT * FROM Categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt(1));
                c.setNomCategorie(rs.getString(2));
                categories.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return categories;
    }

    @Override
    public Categorie fetchCategorieById(int id) {
        Categorie Categorie = null;
        try {
            String req = "SELECT * FROM Categorie WHERE id_Categorie=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categorie = new Categorie();
                Categorie.setIdCategorie(rs.getInt(1));
                Categorie.setNomCategorie(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Categorie;
    }

    @Override
    public Categorie fetchCategories(String name) {
        Categorie categorie = new Categorie();
        try {
            String req = "SELECT * FROM Categorie WHERE name_Categorie= '" + name + "'";
            PreparedStatement cat = cnx.prepareStatement(req);
            ResultSet rs = cat.executeQuery(req);
            while (rs.next()) {
                categorie.setIdCategorie(rs.getInt(1));
                categorie.setNomCategorie(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorie;
    }
}


