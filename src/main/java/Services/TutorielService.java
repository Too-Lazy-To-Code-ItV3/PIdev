package Services;

import Interfaces.TutorielInterface;
import Models.AllUsers;
import Models.Categorie;
import Models.Tutoriel;
import Util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TutorielService implements TutorielInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addTutoriel(Tutoriel t) {
        try {
            String req = "INSERT INTO `tutoriel`(`Title`,`Niveau`,`Description`, `PathImg`, `ID_Categorie`, `ID_Artist`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, t.getTitle());
            ps.setInt(2, t.getNiveau());
            ps.setString(3, t.getDescription());
            ps.setString(4, t.getPathImg());
            ps.setInt(5, t.getCategorie().getIdCategorie());
            ps.setInt(6, t.getCreator().getID_User());
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

    @Override
    public void deleteTutoriel(int id) {
        String req = "DELETE FROM tutoriel where ID_Tutoriel = " + id;
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

            String req = "SELECT * FROM tutoriel as t,Categorie as c,AllUsers as u where t.ID_Categorie=c.id_Categorie and t.ID_Artist=u.ID_User";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Tutoriel t = new Tutoriel();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                t.setPathImg(rs.getString("PathImg"));

                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

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

            String req = "SELECT * FROM tutoriel as t,Categorie as c,AllUsers as u where t.ID_Categorie=c.id_Categorie and t.ID_Artist=u.ID_User and t.ID_Tutoriel = " + ID_Tutoriel;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Categorie c = new Categorie();

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                t.setPathImg(rs.getString("PathImg"));

                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

                t.setCreator(u);
                t.setCategorie(c);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return t;
    }

    @Override
    public List<Tutoriel> fetchTutorielsByCategorie(String name) {
        List<Tutoriel> tutoriels = new ArrayList<>();
        try {
            String req = "SELECT * FROM tutoriel as t,Categorie as c,AllUsers as u where t.ID_Categorie=c.id_Categorie and t.ID_Artist=u.ID_User and t.ID_Categorie= ANY(select id_Categorie from categorie2 where name_Categorie in " + name + ")";
            ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Tutoriel t = new Tutoriel();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                t.setPathImg(rs.getString("PathImg"));

                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

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

            String req = "SELECT * FROM tutoriel as t,Categorie as c,AllUsers as u where t.ID_Categorie=c.id_Categorie and t.ID_Artist=u.ID_User and u.Name = '" + NomArtist + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Tutoriel t = new Tutoriel();
                Categorie c = new Categorie();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                t.setPathImg(rs.getString("PathImg"));

                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

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

            String req = "SELECT * FROM tutoriel as t,Categorie as c,AllUsers as u where t.ID_Categorie=c.id_Categorie and t.ID_Artist=u.ID_User and t.Title like '%" + title + "%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Tutoriel t = new Tutoriel();
                Categorie c = new Categorie();

                t.setID_Tutoriel(rs.getInt(1));

                t.setID_Tutoriel(rs.getInt("ID_Tutoriel"));
                t.setTitle(rs.getString("Title"));
                t.setNiveau(rs.getInt("Niveau"));
                t.setDescription(rs.getString("Description"));
                t.setPathImg(rs.getString("PathImg"));

                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

                t.setCreator(u);
                t.setCategorie(c);
                tutoriels.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(tutoriels);
        return tutoriels;
    }
}
