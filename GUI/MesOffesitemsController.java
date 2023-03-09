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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.offreTravail;
import service.offreTravailService;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
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
    private Pane modifierpage;
    @FXML
    private Label decription;
    @FXML
    private Label categorie;
    @FXML
    private Circle photo;

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
 editoffre.setId(Integer.toString(f.getIdOffre())); 
   Image img = new Image("/img/capture2.PNG") ;
      photo.setFill(new ImagePattern(img));
 }
 
 
 
 /*****************************************************************************/
    @FXML
  private void modifier(ActionEvent event) {
    int id = Integer.parseInt(editoffre.getId());
    String titre = titreOffre.getText();
    String desc = decription.getText();
    String type = typeOffre.getText();
    String loc = locOffre.getText();
    String categ = categorie.getText();
    
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/modifierOffre.fxml"));
        Parent root = loader.load();
        
        ModifierOffreController modifier = loader.getController();
        modifier.getid(id, titre, desc, type, loc, categ);
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    } catch (IOException ex) {
        ex.printStackTrace();
        // Display an error message to the user
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Unable to open the modification window. Please try again.");
        alert.showAndWait();
    }
}

     /*****************************************************************************/

offreTravailService off=new offreTravailService ();
    @FXML
    
    
    private void supprimer(ActionEvent event) {
        int id= Integer.parseInt(supprimerOffre.getId());
        offreTravail of = new offreTravail();
      of=off.fetchOffresParId(id);
        off.Supprimeretajouterarchive(of);
       /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("cette offre est supprimer, veuiller refresh your page");

alert.show();*/
   
    }
    
}
