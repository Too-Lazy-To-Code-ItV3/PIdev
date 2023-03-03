/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_AcceuilController implements Initializable {

    @FXML
    private Button produits;
    @FXML
    private Button panier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GotoProduits(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AfficherProduit.fxml"));
        Parent root = loader.load();
        produits.getScene().setRoot(root);
    }

    @FXML
    private void GotoPanier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AfficherPanier.fxml"));
        Parent root = loader.load();
        panier.getScene().setRoot(root);
    }
    
}
