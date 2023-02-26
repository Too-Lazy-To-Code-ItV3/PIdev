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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.Categorie;
import models.offreTravail;
import service.CategoryService;
import service.offreTravailService;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author nour2
 */
public class AjouterOffreController implements Initializable {
    offreTravailService offs= new   offreTravailService();
    offreTravail of = new offreTravail();
CategoryService c = new CategoryService();
    @FXML
    private ChoiceBox<Categorie> listeCategorie= new ChoiceBox<>();;
    @FXML
    private ChoiceBox<String> listetypes;
    @FXML
    private ChoiceBox<String> villeliste;
    @FXML
    private TextField titreOffre;
    @FXML
    private TextField descriptionOffre;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loaddata();
    }    
     public void loaddata(){
       listeCategorie.getItems().addAll(c.fetchCategories());
       String[]type={"freelance","contract","other"};
        String[]ville = {"Nord-Est","Centre-Est","Centre-Ouest","Sud-Est","Sud-Ouest"};
       listetypes.getItems().addAll(type);
      villeliste.getItems().addAll(ville);
       
    }

    @FXML
    private void ajouterOffre(ActionEvent event) {
     

if (titreOffre.getText().matches("\\d+")) {
    Alert alert = new Alert(Alert.AlertType.ERROR, "veuiller entre un titre valide");
        alert.showAndWait();}
        else if (descriptionOffre.getText().matches("\\d+"))
                { Alert alert = new Alert(Alert.AlertType.ERROR, "veuiller entrer une dscription valide");
        alert.showAndWait();}
else {
    // Le contenu du TextField n'est pas un entier

        of.setTitreOffre(titreOffre.getText());
       
        of.setDescriptionOffre(descriptionOffre.getText());
        of.setCategorieOffre(listeCategorie.getValue());
        of.setLocalisationOffre(villeliste.getValue());
        of.setTypeOffre(listetypes.getValue());
       /*getfrom token */ of.setIdStudio(2);
      
           offs.addOffre(of);
    }
    }
}
