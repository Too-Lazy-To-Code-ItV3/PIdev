/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIARTISTE;

import controller.ModifierOffreController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Categorie;
import models.demandeTravail;
import models.offreTravail;
import service.CategoryService;
import service.demandeTravailService;
import static service.demandeTravailService.verifdemande;
import service.offreTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class modifierdemandeController implements Initializable {

    @FXML
    private TextField titreOffre;
    @FXML
    private TextField descriptionOffre;
    @FXML
    private ChoiceBox<Categorie> listeCategorie;
   
    @FXML
    private Button modifier;
   CategoryService c = new CategoryService();
   demandeTravailService offs= new   demandeTravailService();
   demandeTravail of = new demandeTravail();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      getdata();
    }       

public void getdata()
        
{
    listeCategorie.getItems().addAll(c.fetchCategories());
      
   
}
public void getid(int i,String titre,String desc,String categ){
             modifier.setId(Integer.toString(i));
titreOffre.setText(titre);
descriptionOffre.setText(desc);

listeCategorie.setValue(c.fetchCategoryByNom(categ));
}
  

    @FXML
    private void modifierOffre(ActionEvent event) {
          int id= Integer.parseInt(modifier.getId());
           Categorie c = new Categorie(); 
          if(titreOffre.getText().matches("\\d+")) {
    Alert alert = new Alert(Alert.AlertType.ERROR, "veuiller entre un titre valide");
        alert.showAndWait();}
        else if (descriptionOffre.getText().matches("\\d+"))
                { Alert alert = new Alert(Alert.AlertType.ERROR, "veuiller entrer une dscription valide");
        alert.showAndWait();}
else {
              try {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIARTISTE/menuartiste.fxml"));
                  Parent root = loader.load();
           of.setIdDemande(id);
        of.setTitreDemande(titreOffre.getText());
      
        CategoryService cs = new CategoryService();
       c= cs.fetchCategoryByNom(listeCategorie.getValue().getNomCategorie());
        of.setDescriptionDemande(descriptionOffre.getText());
        of.setCategorieDemande(c);
       
       //fromtoken of.setIdStudio(2);
    
           offs.modifierDemande(of);
            if(verifdemande==true) { Scene scene = new Scene(root,1380,700);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);}
                
              } catch (IOException ex) {
                  Logger.getLogger(ModifierOffreController.class.getName()).log(Level.SEVERE, null, ex);
              }
    

}
    }}