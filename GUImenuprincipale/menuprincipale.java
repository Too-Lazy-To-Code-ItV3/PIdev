/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUImenuprincipale;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.NewFXMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import models.Logged;
import models.demandeTravail;
import models.offreTravail;
import service.demandeTravailService;
import service.offreTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class menuprincipale implements Initializable {

    private GridPane citiesGrid;
 offreTravailService of = new offreTravailService ();
 private List<offreTravail> listeOffres; 
    @FXML
    private Pane CRUD;
 offreTravailService off=new offreTravailService();
    @FXML
    private Button forstudio;
    @FXML
    private Button forartiste;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      try {//get the css for popup 
          
//design my popup
       
             
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/GUImenuprincipale/menuelements.fxml"));
            CRUD.getChildren().add(pane);
            
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }    



    @FXML
    private void gotomenu(ActionEvent event) {
        
        
         try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/GUImenuprincipale/menuelements.fxml"));
            CRUD.getChildren().add(pane);
            
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    @FXML
    private void forstudio(ActionEvent event) {
        try {
                 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/menu1.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root,1380,700);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(menuprincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void forartiste(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIARTISTE/menuartiste.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root,1380,700);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(menuprincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
