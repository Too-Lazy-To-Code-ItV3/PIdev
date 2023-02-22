/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import models.offreTravail;


/**
 * FXML Controller class
 *
 * @author nour2
 */
public class Afficheroffres2Controller implements Initializable {

    @FXML
    private Label titreOffre;
    @FXML
    private Label nomStudio;
    @FXML
    private Label typeOffre;
    @FXML
    private Label locOffre;
    @FXML
    private Label dateAjout;
    @FXML
    private Label description;
    @FXML
    private Label categorie;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void loaddata(offreTravail f){
       titreOffre.setText(f.getTitreOffre());
       nomStudio.setText(f.getNomStudio());
       typeOffre.setText(f.getTypeOffre());
       locOffre.setText(f.getLocalisationOffre());
       dateAjout.setText(f.getDateAjoutOffre().toString());
       description.setText(f.getDescriptionOffre());
          categorie.setText(f.getCategorieOffre().getNomCategorie());
   }

   
}
