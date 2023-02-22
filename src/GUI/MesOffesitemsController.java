/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.offreTravail;
import service.offreTravailService;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author nour2
 */
public class MesOffesitemsController implements Initializable {

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
    
 public void loaddata(offreTravail f){
       titreOffre.setText(f.getTitreOffre());
       nomStudio.setText(f.getNomStudio());
       typeOffre.setText(f.getTypeOffre());
       locOffre.setText(f.getLocalisationOffre());
       dateAjout.setText(f.getDateAjoutOffre().toString());
       decription.setText(f.getDescriptionOffre());
       categorie.setText(f.getCategorieOffre().getNomCategorie());
       supprimerOffre.setId(Integer.toString(f.getIdOffre()));   
 editoffre.setId(Integer.toString(f.getIdOffre()));   }
 
 
 
 /*****************************************************************************/
    @FXML
    private void modifier(ActionEvent event) {
        
         int id= Integer.parseInt(editoffre.getId());
         String  titre=titreOffre.getText();
       String desc = decription.getText();
      String type= typeOffre.getText();
      String loc = locOffre.getText();
     String categ = categorie.getText();
    
       try { //affichage d'interface modifier
            FXMLLoader fxmlLoader = new FXMLLoader();
          
               fxmlLoader.setLocation(getClass().getResource("/GUI/modifierOffre.fxml"));
                 Pane pane = fxmlLoader.load();
                  //get modifier controller to set data a mmodifier
            ModifierOffreController  modifier = fxmlLoader.getController();
            //envoyer donner
      modifier.getid(id,titre,desc,type,loc,categ);
      
          modifierpage.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     /*****************************************************************************/

offreTravailService off=new offreTravailService ();
    @FXML
    
    
    private void supprimer(ActionEvent event) {
        int id= Integer.parseInt(supprimerOffre.getId());
        offreTravail of = new offreTravail();
      of=off.fetchOffresParId(id);
        off.Supprimer(of);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("cette offre est supprimer, veuiller refresh your page");

alert.show();
   
    }
    
}
