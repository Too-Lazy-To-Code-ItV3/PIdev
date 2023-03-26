package Services;

import Interfaces.ChallengeInterface;
import Interfaces.ParticipationInterface;
import Models.AllUsers;
import Models.Categorie;
import Models.Challenge;
import Models.Logged;
import Util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChallengeService implements ChallengeInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
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
            ps.setInt(6, c.getCategorie().getIdCategorie());
            ps.setInt(7, Logged.get_instance().getUser().getID_User());

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
            ps.setInt(6, c.getCategorie().getIdCategorie());
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

            String req = "SELECT * FROM Challenge ch,Categorie ca,AllUsers u where ch.ID_Categorie = ca.id_Categorie and ch.ID_Artist=u.ID_user";
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

                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt("ID_Categorie"));
                c.setNomCategorie(rs.getString("NameCategorie"));

                ch.setCategorie(c);

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

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

                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                ch.setCategorie(c);

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

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
    public Challenge fetchChallengeById(int id) {
        Challenge challenge = new Challenge();
        try {

            String req = "SELECT * FROM Challenge ch,Categorie ca,allusers u where ch.ID_Categorie = ca.ID_Categorie and ch.ID_Artist=u.ID_user and ID_Challenge = "+id;
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

                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                ch.setCategorie(c);

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));


                ch.setCategorie(c);
                ch.setCreator(u);
                challenge = ch;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return challenge;
    }

    @Override
    public List<Challenge> fetchChallengeByName(String name) {
        List<Challenge> Challenges = new ArrayList<>();
        try {

            String req = "SELECT * FROM Challenge ch,Categorie ca,allusers u where ch.ID_Categorie = ca.id_Categorie and ch.ID_Artist=u.ID_user and ch.Title like '%"+name+"%'";
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

                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt("id_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                ch.setCategorie(c);

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

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
    public List<Challenge> fetchChallengeByCategorie(String name) {
        List<Challenge> Challenges = new ArrayList<>();
        try {

            String req = "SELECT * FROM Challenge ch,Categorie ca,allusers u where ch.ID_Categorie = ca.id_Categorie and ch.ID_Artist=u.ID_user and ch.ID_Categorie= ANY(select id_Categorie from categorie2 where name_Categorie in "+name+")";
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

                Categorie c = new Categorie();
                c.setIdCategorie(rs.getInt("ID_Categorie"));
                c.setNomCategorie(rs.getString("name_Categorie"));

                ch.setCategorie(c);

                AllUsers u = new AllUsers();
                u.setName(rs.getString("Name"));
                u.setID_User(rs.getInt("ID_user"));
                u.setType(rs.getString("Type"));

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
