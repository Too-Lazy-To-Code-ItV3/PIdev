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
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Categorie;
import models.demandeTravail;
import models.offreTravail;
import service.CategoryService;
import service.demandeTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class ChercherArtistesController implements Initializable {
    demandeTravailService dm = new  demandeTravailService();
    private List<demandeTravail> demandes=new ArrayList<>(dm.fetchDemandesPerDate());
         CategoryService categorie=new  CategoryService();
      private List<Categorie> categories=new ArrayList<>(categorie.fetchCategories());
    @FXML
    private TextField resultatsearch;
    @FXML
    private GridPane gridchercher;
    private CheckBox checkboxcateg;
    private AnchorPane anchorpa;
    @FXML
    private VBox vbox;
    @FXML
    private VBox vboxtype;
    
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private VBox vboxxville;

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

         for(Categorie c: categories)
         {  
             checkboxcateg=new CheckBox();
             checkboxcateg.setText(c.getNomCategorie());
             checkboxcateg.setId(Integer.toString(c.getIdCategorie()));
           
        vbox.getChildren().add(checkboxcateg);
            
   ;};

  
   checkboxcateg.setOnAction(event -> {
        demandes=dm.fetchDemandesPerCategorieDate(demandes, categorie.fetchCategoryByNom(checkboxcateg.getText()) );
        } );
        
    }; 
       
   


    @FXML
   private void chercher(ActionEvent event) {
       gridchercher.getChildren().clear();
        int column=0;
       int row = 1 ;
       for(demandeTravail d:  demandes)
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
