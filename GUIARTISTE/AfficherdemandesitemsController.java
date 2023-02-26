/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIARTISTE;

import GUI.*;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import models.demandeTravail;

import models.offreTravail;


/**
 * FXML Controller class
 *
 * @author nour2
 */
public class AfficherdemandesitemsController implements Initializable {

    @FXML
    private Label titreOffre;
    @FXML
    private Label nomStudio;
    private Label typeOffre;
    private Label locOffre;
    @FXML
    private Label dateAjout;
    @FXML
    private Label description;
    @FXML
    private Label categorie;
    @FXML
    private Circle photo1;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void loaddata(demandeTravail f){
       titreOffre.setText(f.getTitreDemande());
       nomStudio.setText(f.getNomArtiste());
       
       dateAjout.setText(f.getDateAjoutDemande().toString());
       description.setText(f.getDescriptionDemande());
          categorie.setText(f.getCategorieDemande().getNomCategorie());
            Image img = new Image("/img/capture2.PNG") ;
      photo1.setFill(new ImagePattern(img));
   }

   
}
