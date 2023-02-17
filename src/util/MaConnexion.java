/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author achref
 */
public class MaConnexion {
    //db credentials
  final String URL = "jdbc:mysql://localhost:3306/pidev?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false" ;
  final String USRNAME = "root" ;
  final String PASSWORD = "" ;
 
    //var
    private Connection cnx;
    //2 :creation dde la variable MaConnexion

    private static MaConnexion instance = new MaConnexion();
    //1 : privatisation du constructor
    private MaConnexion() {
      try {
          cnx = DriverManager.getConnection(URL, USRNAME, PASSWORD);
                  } catch (SQLException ex) {
          Logger.getLogger(MaConnexion.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    public Connection getCnx() {
        return cnx;
    }
    
    //3
    public static MaConnexion getInstance() {
        if(instance == null)
            instance = new MaConnexion();
        
        return instance;
    }
}
