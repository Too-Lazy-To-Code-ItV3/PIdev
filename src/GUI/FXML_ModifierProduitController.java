/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.ProduitInterface;
import Models.Categories;
import Models.Produits;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.CategoriesService;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_ModifierProduitController implements Initializable {
       ProduitInterface ps= new ProduitService();
     CategoriesService cs= new CategoriesService() {};
     Produits p= new Produits();
  
 

    @FXML
    private Button modifier;
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TextField qtDispo;
    @FXML
    private TextField prixText;
    @FXML
    private TextField image;
    @FXML
    private Button retour;
    @FXML
    private ChoiceBox<Categories> listeCateg;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO
        ImportCateg();
    }    
     
 public void ImportCateg(){
       listeCateg.getItems().addAll(cs.fetchCategories()); 
 }
     
   @FXML
private void modifier(ActionEvent event) {

    Button modifier = (Button) event.getSource();
    modifier.setUserData("20");
    int idProduit = Integer.parseInt(modifier.getUserData().toString());


    p = ps.readById(idProduit);

    if (!nom.getText().isEmpty() && !description.getText().isEmpty() && listeCateg.getValue() != null && !image.getText().isEmpty() && !qtDispo.getText().isEmpty() && !prixText.getText().isEmpty()) {
        p.setNom(nom.getText());

//        cs.addCategorie(listeCateg.getValue());

        p.setCategorieProduit(listeCateg.getValue());

        p.setDescription(description.getText());
        p.setImage(image.getText());
        p.setQuantiteDispo(Integer.parseInt(qtDispo.getText()));
        p.setPrix(Double.parseDouble(prixText.getText()));
        ps.modifierProduit(p);
    } else {
        System.out.println("Veuillez remplir tous les champs.");
    }
}

    @FXML
    private void retourAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
        Parent root = loader.load();
        retour.getScene().setRoot(root);
    }
}

