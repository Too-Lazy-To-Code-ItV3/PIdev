package Services;

import Interfaces.grosMotsInterface;
import Models.grosMots;
import Util.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class grosMotsService implements grosMotsInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void ajoutGrosMot(grosMots mot) {

    }

    @Override
    public List<String> fetchgrosmotsString() {
        return null;
    }

    @Override
    public void modifierOffre(grosMots mot) {

    }

    @Override
    public void Supprimer(grosMots o) {
        try {
            Statement st = cnx.createStatement();
            String req = "DELETE FROM `grosmots2` WHERE idMot= " + o.getIdmot() + "";
            st.executeUpdate(req);
            System.out.println("gros mot supprimer avec succès");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<grosMots> fetchgrosmots() {
        List<grosMots> grosmots = new ArrayList<>();
        try {

            String req = "SELECT * FROM `grosmots2` ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                grosMots grosmot = new grosMots();
                grosmot.setIdmot(rs.getInt(1));
                grosmot.setMot(rs.getString(2));
                grosmots.add(grosmot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(grosMotsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grosmots;
    }

    @Override
    public grosMots fetchmotById(int id) {
        return null;
    }
}
