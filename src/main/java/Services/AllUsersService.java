package Services;

import Interfaces.AllUsersInterface;
import Models.AllUsers;
import Util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllUsersService implements AllUsersInterface {
    Connection cnx = MyConnection.getInstance().getCnx();


    @Override
    public void AddAu(AllUsers u) {
        try {
            String req = "INSERT INTO allusers(`Name`, `Last_Name`, `Email`, `Birthday`, `Password`, `Nationality`, `type`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, u.getName());
            ps.setString(2, u.getLast_Name());
            ps.setString(3, u.getEmail());
            ps.setDate(4, (Date) u.getBirthday());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getNationality());
            ps.setString(7, u.getType());
            ps.executeUpdate();
            System.out.println("User Added Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void DeleteAu(int ID) throws SQLException {
        try {
            String req = "DELETE FROM allusers WHERE ID_User=" + ID;
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.executeUpdate();
            System.out.println("User  Deleted Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void ModifyAu(AllUsers u, int ID) throws SQLException {
        try {
            String req = "UPDATE `allusers` SET `Name`=?,`Last_Name`=?,`Email`=?,`Birthday`=?,`Password`=?,`Nationality`=?,`type`=? WHERE ID_User=" + ID;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, u.getName());
            ps.setString(2, u.getLast_Name());
            ps.setString(3, u.getEmail());
            ps.setDate(4, (Date) u.getBirthday());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getNationality());
            ps.setString(7, u.getType());
            ps.executeUpdate();
            System.out.println("User Modified Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<AllUsers> fetchAU() {
        List<AllUsers> Allusers = new ArrayList<>();
        try {

            String req = "SELECT * FROM allusers";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                AllUsers u = new AllUsers();
                u.setID_User(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setLast_Name(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
                u.setPassword(rs.getString(6));
                u.setNationality(rs.getString(7));
                u.setType(rs.getString(8));


                Allusers.add(u);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Allusers;
    }

    @Override
    public List<AllUsers> fetchAUbyID(int ID) throws SQLException {
        List<AllUsers> Allusers = new ArrayList<>();
        try {

            String req = "SELECT * FROM allusers WHERE `ID_User`=" + ID;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                AllUsers u = new AllUsers();
                u.setID_User(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setLast_Name(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
                u.setPassword(rs.getString(6));
                u.setNationality(rs.getString(7));
                u.setType(rs.getString(8));


                Allusers.add(u);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Allusers;
    }
}
