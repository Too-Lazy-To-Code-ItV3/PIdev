/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.LignePanier;
import Models.Panier;
import Models.Produits;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import services.LignePanierService;
import services.PanierService;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_ModifierPanierController implements Initializable {
     private int idPanier; // define the variable to hold the ID of the shopping cart
    
    private LignePanierService lp = new LignePanierService();
    LignePanier lignep = new LignePanier();
    Produits prod=new Produits();
    Panier pan=new Panier ();
    private PanierService panierService = new PanierService();
    private ProduitService produitService = new ProduitService();
    
    @FXML
    private Spinner<Integer> nvqt = new Spinner<>();;
    
    @FXML
    private Button valider;
    
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        nvqt.setValueFactory(valueFactory);
    }    

    // called from the previous view to pass the ID of the shopping cart
    public void setPanierId(int idPanier) {
        this.idPanier = idPanier;
    }

    @FXML
    private void valider() throws IOException {
        int nouvelleQuantite = nvqt.getValue();
         System.out.println("nv1"+nouvelleQuantite);
             System.out.println("dispo"+prod.getQuantiteDispo());
        if (nouvelleQuantite > 0 && nouvelleQuantite <= prod.getQuantiteDispo()){
             System.out.println("nv1"+nouvelleQuantite);
             System.out.println("dispo"+prod.getQuantiteDispo());
            lp.modifierQuantite(pan.getIdPanier(), nouvelleQuantite, lignep.getIdLignePanier());
            System.out.println("nv1"+pan.getIdPanier());
            System.out.println("nv"+nouvelleQuantite);
            System.out.println("nv33"+lignep.getIdLignePanier());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AfficherPanier.fxml"));
            Parent root = loader.load();
            nvqt.getScene().setRoot(root);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Veuillez entrer une quantité valide", ButtonType.OK);
            a.show();
        }
        System.err.println(nouvelleQuantite);
    }
    
    @FXML
    private void GtoPanier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AfficherPanier.fxml"));
        Parent root = loader.load();
        retour.getScene().setRoot(root);
    }
    
}
