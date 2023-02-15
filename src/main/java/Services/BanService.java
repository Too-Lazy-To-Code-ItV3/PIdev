package Services;

import Interfaces.BanInterface;
import Models.AllUsers;
import Models.Ban;
import Util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BanService implements BanInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void AddBan(Ban B, AllUsers U) throws SQLException {
        try {
            String req = "INSERT INTO Ban(`ID_User`, `Reason`, `DateB`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, U.getID_User());
            ps.setString(2, B.getReason());
            ps.setString(3, B.getDate());
            ps.executeUpdate();
            System.out.println("Ban Added Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void DeleteBan(int ID) throws SQLException {
        try {
            String req = "DELETE FROM Ban WHERE ID_Ban=" + ID;
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.executeUpdate();
            System.out.println("Ban Removed Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void ModifyBan(Ban B, int ID) throws SQLException {
        try {
            String req = "UPDATE `Ban` SET `Reason`=?,`DateB`=? WHERE ID_Ban=" + ID;
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(2, B.getReason());
            ps.setString(3, B.getDate());
            ps.executeUpdate();
            System.out.println("User Modified Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void ModifyBanByUser(Ban B, int ID) throws SQLException {
        try {
            String req = "UPDATE `Ban` SET `Reason`=?,`DateB`=? WHERE ID_User=" + ID;
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(2, B.getReason());
            ps.setString(3, B.getDate());
            ps.executeUpdate();
            System.out.println("User Modified Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public List<Ban> fetchBan() throws SQLException {
        List<Ban> Ban = new ArrayList<>();
        try {

            String req = "SELECT * FROM Ban";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Ban B = new Ban();
                B.setID_Ban(rs.getInt(1));
                B.setID_User(rs.getInt(2));
                B.setReason(rs.getString(3));
                B.setNickname(rs.getString(4));



                Ban.add(B);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Ban;

    }

    @Override
    public List<Ban> fetchBanbyID(int ID) throws SQLException {
        List<Ban> Ban = new ArrayList<>();
        try {

            String req = "SELECT * FROM Ban WHERE `ID_User`=" + ID;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Ban u = new Ban();
                u.setID_User(rs.getInt(1));



                Ban.add(u);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Ban;
    }

    @Override
    public List<Ban> fetchBanbyIDUser(int ID) throws SQLException {
        return null;
    }
}
