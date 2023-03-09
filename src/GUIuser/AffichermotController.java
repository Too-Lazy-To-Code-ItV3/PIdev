/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIuser;

import GUIgrotmot.*;
import GUIARTISTE.*;
import controller.Menu1Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.AllUsers;
import models.demandeTravail;
import models.grosMots;
import models.offreTravail;
import service.AllUsersService;
import service.demandeTravailService;
import service.grosMotsService;
import service.offreTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class AffichermotController implements Initializable {

   
    AllUsersService userserv = new AllUsersService();
 private List<AllUsers> grosmots; 
    @FXML
    private GridPane citiesGril;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grosmots=new ArrayList<>( userserv.fetchAU());
       int column=0;
       int row = 1 ;
       for(AllUsers g : grosmots)
       {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("/GUIuser/Useritem.fxml"));
               Pane pane = fxmlLoader.load();
              Useritem ac = fxmlLoader.getController();
              ac.loaddata(g);
               if(column==2){column=0; ++row ;}
               citiesGril.add(pane,column++,row);
               GridPane.setMargin(pane, new Insets(20));
           } catch (IOException ex) {
               Logger.getLogger(Menu1Controller.class.getName()).log(Level.SEVERE, null, ex);
           } 

       }
    }    
    
}
