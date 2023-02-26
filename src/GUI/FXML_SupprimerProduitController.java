/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Interfaces.ProduitInterface;

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
import javafx.scene.control.TextField;

import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_SupprimerProduitController implements Initializable {
    ProduitInterface ps= new ProduitService();
   
    
    Produits p=new Produits();
    @FXML
    private Button supp;
    @FXML
    private Button retour;
    @FXML
    private TextField nomText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimer(ActionEvent event) {
      String nomProduit =nomText.getText();
      System.out.println(nomProduit);
      ps.spprimerProduit(nomProduit);
}

    @FXML
    private void GotoAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
        Parent root = loader.load();
        retour.getScene().setRoot(root);
    }
    

}