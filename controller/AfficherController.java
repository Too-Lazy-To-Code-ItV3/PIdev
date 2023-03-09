/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import models.offreTravail;
import service.offreTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class AfficherController implements Initializable {

   
 offreTravailService of = new offreTravailService ();
 private List<offreTravail> listeOffres; 
    @FXML
    private GridPane citiesGril;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         listeOffres=new ArrayList<>(of.fetchOffresPerDate());
       int column=0;
       int row = 1 ;
       for(offreTravail f :listeOffres)
       {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("/GUI/Afficheroffres2.fxml"));
               Pane pane = fxmlLoader.load();
               Afficheroffres2Controller ac = fxmlLoader.getController();
               ac.loaddata(f);
               if(column==2){column=0; ++row ;}
               citiesGril.add(pane,column++,row);
               GridPane.setMargin(pane, new Insets(20));
           } catch (IOException ex) {
               Logger.getLogger(Menu1Controller.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
                 Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
             }

       }
    }    
    
}
