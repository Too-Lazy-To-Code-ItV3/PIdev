/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIARTISTE;

import GUI.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.NewFXMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.offreTravail;
import service.offreTravailService;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.demandeTravail;
import service.demandeTravailService;
/**
 * FXML Controller class
 *
 * @author nour2
 */
public class MesdemandesitemsController implements Initializable {

    @FXML
    private Label titreOffre;
    @FXML
    private Label nomStudio;
   
    @FXML
    private Label dateAjout;
    @FXML
    private Button editoffre;
    @FXML
    private Button supprimerOffre;
    @FXML
    private Pane showcrud;
    @FXML
    private Pane modifierpage;
    @FXML
    private Label decription;
    @FXML
    private Label categorie;

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
       decription.setText(f.getDescriptionDemande());
       categorie.setText(f.getCategorieDemande().getNomCategorie());
       supprimerOffre.setId(Integer.toString(f.getIdDemande()));   
 editoffre.setId(Integer.toString(f.getIdDemande()));   }
 
 
 
 /*****************************************************************************/
    @FXML
    private void modifier(ActionEvent event) {
        
         int id= Integer.parseInt(editoffre.getId());
         String  titre=titreOffre.getText();
       String desc = decription.getText();
      
     String categ = categorie.getText();
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIARTISTE/modifierdemande.fxml"));
        Parent root = loader.load();
        
                  //get modifier controller to set data a mmodifier
            modifierdemandeController  modifier = loader.getController();
            //envoyer donner
      modifier.getid(id,titre,desc,categ);
      
      
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     /*****************************************************************************/

demandeTravailService off=new demandeTravailService ();
    @FXML
    
    
    private void supprimer(ActionEvent event) {
       int id= Integer.parseInt(supprimerOffre.getId());
        demandeTravail of = new demandeTravail();
      of=off.fetchdemandeParId(id);
        off.SupprimerDemande(of);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("cette offre est supprimer, veuiller refresh your page");

alert.show();
   
    }
    
}
