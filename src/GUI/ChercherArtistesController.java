/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.demandeTravail;
import models.offreTravail;
import service.demandeTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class ChercherArtistesController implements Initializable {
    demandeTravailService dm = new  demandeTravailService();
    private List<demandeTravail> demandes=new ArrayList<>(dm.fetchDemandesPerDate());
    @FXML
    private TextField resultatsearch;
    @FXML
    private GridPane gridchercher;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
       int column=0;
       int row = 1 ;
       for(demandeTravail d :  demandes)
       {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("/GUI/designresulterrecherche.fxml"));
               Pane pane = fxmlLoader.load();
             DesignresulterRechercheController ac = fxmlLoader.getController();
               ac.loaddata(d);
               if(column==1){column=0; ++row ;}
             gridchercher.add(pane,column++,row);
               GridPane.setMargin(pane, new Insets(20));
               
            

           } catch (IOException ex) {
               Logger.getLogger( ChercherArtistesController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     
    }    
   


    @FXML
   private void chercher(ActionEvent event) {
       gridchercher.getChildren().clear();
        int column=0;
       int row = 1 ;
       for(demandeTravail d :  demandes)
       {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("/GUI/designresulterrecherche.fxml"));
               Pane pane = fxmlLoader.load();
             DesignresulterRechercheController ac = fxmlLoader.getController();
               ac.loaddata(d);
               if(column==1){column=0; ++row ;}
             gridchercher.add(pane,column++,row);
               GridPane.setMargin(pane, new Insets(20));
               
            

           } catch (IOException ex) {
               Logger.getLogger( ChercherArtistesController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       demandes=dm.chercherDemande(resultatsearch.getText());
        
      
      
    }
    
    
}
