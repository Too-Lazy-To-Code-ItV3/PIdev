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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import models.demandeTravail;
import models.offreTravail;
import service.demandeTravailService;
import service.offreTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class DesignresulterRechercheoffreController implements Initializable {

    @FXML
    private Circle photo;
    @FXML
    private Label nomartiste;
    @FXML
    private Label categorie;
    @FXML
    private Label titredemande;
    @FXML
    private Label description;
    @FXML
    private Button contacter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void loaddata(offreTravail f){
       titredemande.setText(f.getTitreOffre());
      description.setText(f.getDescriptionOffre());
       nomartiste.setText(f.getNomStudio());
      categorie.setText(f.getCategorieOffre().getNomCategorie());
      
      contacter.setId(Integer.toString(f.getIdOffre()));   
      Image img = new Image("/img/capture2.PNG") ;
      photo.setFill(new ImagePattern(img));
   }
    offreTravailService demandeserv=new offreTravailService ();
    @FXML
    private void contacteraction(ActionEvent event) {
        int id= Integer.parseInt(contacter.getId());
        offreTravail demande = new offreTravail();
     demande=demandeserv.fetchOffresParId(id);
       demandeserv.postuleViaMail(3, demande);
       

    }
    
}
