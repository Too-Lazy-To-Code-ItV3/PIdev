package Services;

import Interfaces.RatingInterface;
import Models.Rate;
import Util.MyConnection;

import java.sql.*;

public class RatingService implements RatingInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void updateRating(Rate rate) {
        try {
            if (fetchRating(rate) == 0) {
                String req = "INSERT INTO `rating`(`rating`,`challenge_id`,`participator_id`, `rater_id`) VALUES (?,?,?,?)";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setDouble(1, rate.getRating());
                ps.setInt(2, rate.getChallenge().getID_Challenge());
                ps.setInt(3, rate.getParticipator().getID_User());
                ps.setInt(4, rate.getRater().getID_User());
                ps.executeUpdate();
                System.out.println("rate is inserted");
            } else {
                String req = "update rating set `rating`=? where `challenge_id`= ? and `participator_id`=? and `rater_id`=? ";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setDouble(1, rate.getRating());
                ps.setInt(2, rate.getChallenge().getID_Challenge());
                ps.setInt(3, rate.getParticipator().getID_User());
                ps.setInt(4, rate.getRater().getID_User());
                ps.executeUpdate();
                System.out.println("rate is updated");

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Double fetchRating(Rate rate) {
        Rate rating = new Rate();
        try {

            String req = "SELECT * FROM rating as rat where rat.challenge_id=" + rate.getChallenge().getID_Challenge() + " and rat.participator_id=" + rate.getParticipator().getID_User() + " and rat.rater_id=" + rate.getRater().getID_User();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                return (rs.getDouble("rating"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public Double fetchRatingAVG(Rate rate) {
        Rate rating = new Rate();
        try {
            String req = "SELECT AVG(rating) FROM rating as rat where rat.challenge_id=" + rate.getChallenge().getID_Challenge() + " and rat.participator_id=" + rate.getParticipator().getID_User();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                return (rs.getDouble("AVG(rating)"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }
}

