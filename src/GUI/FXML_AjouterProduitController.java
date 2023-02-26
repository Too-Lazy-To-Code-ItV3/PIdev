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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TextField;
import services.CategoriesService;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_AjouterProduitController implements Initializable {
     ProduitInterface ps= new ProduitService();
     CategoriesService cs= new CategoriesService() {};
     Produits p= new Produits();
  
    @FXML
    private TextField nom;
    @FXML
    private TextField descp;
    @FXML
    private TextField image;
    @FXML
    private TextField qtdispo;
    @FXML
    private TextField prix;
    @FXML
    private ChoiceBox<Categories> listeCateg= new ChoiceBox<>();
    @FXML
    private Button ajouter;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ImportCateg();
    }    
     public void ImportCateg(){
       listeCateg.getItems().addAll(cs.fetchCategories()); }

    @FXML
    private void ajouterProduit(ActionEvent event) {
        
        if (nom.getText().isEmpty() || descp.getText().isEmpty() || image.getText().isEmpty() || qtdispo.getText().isEmpty() || prix.getText().isEmpty() || listeCateg.getValue() == null) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur de saisie !");
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.show();
        return;
    }

            p.setNom(nom.getText());
            p.setDescription(descp.getText());
            p.setCategorieProduit(listeCateg.getValue());      
            p.setImage(image.getText());
            p.setQuantiteDispo(Integer.parseInt(qtdispo.getText()));
            p.setPrix(Double.parseDouble(prix.getText()));
            System.out.println(p);
            ps.addProduit(p);
        
        
    }

    @FXML
    private void GotoAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
        Parent root = loader.load();
        retour.getScene().setRoot(root);
    }
    
    
    
}
