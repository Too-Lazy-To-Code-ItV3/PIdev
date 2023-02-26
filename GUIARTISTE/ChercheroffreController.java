/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIARTISTE;

import GUI.*;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import service.offreTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class ChercheroffreController implements Initializable {
  offreTravailService dm = new  offreTravailService();
    private List<offreTravail> demandes=new ArrayList<>(dm.fetchOffresPerDate());
    CategoryService categorie=new  CategoryService();
      private List<Categorie> categories=new ArrayList<>(categorie.fetchCategories());
    @FXML
    private TextField resultatsearch;
    @FXML
    private GridPane gridchercher;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private VBox vbox;
    @FXML
    private VBox vboxtype;
    @FXML
    private VBox vboxxville;
 private CheckBox checkboxcateg;
    private AnchorPane anchorpa;
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
       int column=0;
       int row = 1 ;
       for(offreTravail d :  demandes)
       {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("/GUIARTISTE/designresulterrechercheoffre.fxml"));
               Pane pane = fxmlLoader.load();
             DesignresulterRechercheoffreController ac = fxmlLoader.getController();
               ac.loaddata(d);
               if(column==1){column=0; ++row ;}
             gridchercher.add(pane,column++,row);
               GridPane.setMargin(pane, new Insets(20));
               
            

           } catch (IOException ex) {
               Logger.getLogger(ChercheroffreController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       for(Categorie c: categories)
         {  
             checkboxcateg=new CheckBox();
             checkboxcateg.setText(c.getNomCategorie());
             checkboxcateg.setId(Integer.toString(c.getIdCategorie()));
        vbox.getChildren().add(checkboxcateg);
            
   ;}
          String[]type={"freelance","contract","other"};
       String[]ville = {"Nord-Est","Centre-Est","Centre-Ouest","Sud-Est","Sud-Ouest"};
       Label types=new Label("les types");
           for(String typ: type)
         {  
             checkboxcateg=new CheckBox();
             checkboxcateg.setText(typ);
        
       vboxtype.getChildren().add(checkboxcateg);
            
   ;}
       
  for(String v: ville)
         {  
             checkboxcateg=new CheckBox();
             checkboxcateg.setText(v);
        
       vboxxville.getChildren().add(checkboxcateg);
            
   ;}scrollpane.setPrefSize(anchorpane.getPrefWidth(), anchorpane.getPrefHeight());
    }    
   


    @FXML
   private void chercher(ActionEvent event) {
       gridchercher.getChildren().clear();
        int column=0;
       int row = 1 ;
       for(offreTravail d :  demandes)
       {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("/GUIARTISTE/designresulterrechercheoffre.fxml"));
               Pane pane = fxmlLoader.load();
             DesignresulterRechercheoffreController ac = fxmlLoader.getController();
               ac.loaddata(d);
               if(column==1){column=0; ++row ;}
             gridchercher.add(pane,column++,row);
               GridPane.setMargin(pane, new Insets(20));
               
            

           } catch (IOException ex) {
               Logger.getLogger(ChercheroffreController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       demandes=dm.chercherOffres(resultatsearch.getText());
        
      
      
    }
    
    
}
