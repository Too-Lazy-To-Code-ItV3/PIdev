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
public class DesignresulterRechercheController implements Initializable {

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
 public void loaddata(demandeTravail d){
       titredemande.setText(d.getTitreDemande());
      description.setText(d.getDescriptionDemande());
       nomartiste.setText(d.getNomArtiste());
      categorie.setText(d.getCategorieDemande().getNomCategorie());
      
      contacter.setId(Integer.toString(d.getIdDemande()));   
      Image img = new Image("/img/mito-s-bb.jpg") ;
      photo.setFill(new ImagePattern(img));
   }
    demandeTravailService demandeserv=new demandeTravailService ();
    @FXML
    private void contacteraction(ActionEvent event) {
        int id= Integer.parseInt(contacter.getId());
        demandeTravail demande = new demandeTravail();
     demande=demandeserv.fetchdemandeParId(id);
       demandeserv.contacterViaMail(2, demande);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("Votre mail est envoyer avec succes ");

alert.show();
    }
    
}
