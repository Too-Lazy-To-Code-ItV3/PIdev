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
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_AfficherProduitController implements Initializable {
      ProduitInterface ps= new ProduitService();
     
     private ListView<List<Produits>> myListView;
     ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ListView<Produits> list2;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button ajouter;
    @FXML
    private Button Retour;
    @FXML
    private TextField textchercher;
    @FXML
    private Button recherche;
    @FXML
    private ChoiceBox<Categories> boxCateg;
    @FXML
    private Button filtrer;

   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//     ListView <Produits> myListVie=(ListView <Produits>) ps.fetchProduits();

        ps.fetchProduits().stream().forEach(a->list.add(a));
        list2.setItems(list);
   
    }

    @FXML
    private void GotoModifier(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_ModifierProduit.fxml"));
        Parent root = loader.load();
        modifier.getScene().setRoot(root);
    }

    @FXML
    private void GotoSupprimer(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_SupprimerProduit.fxml"));
        Parent root = loader.load();
        modifier.getScene().setRoot(root);
    }

    @FXML
    private void GotoAjouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AjouterProduit.fxml"));
        Parent root = loader.load();
        modifier.getScene().setRoot(root);
    }

    @FXML
    private void GotoAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
        Parent root = loader.load();
        modifier.getScene().setRoot(root);
    }
      @FXML
    private void chercher() {
      String nomProduit = textchercher.getText();
      ObservableList<Produits> resultatRecherche = FXCollections.observableArrayList();
      if (nomProduit.length() > 0) {
          ps.chercherProduitParNom(nomProduit).forEach(p -> resultatRecherche.add(p));
      } else {
        resultatRecherche.addAll(list);
      }
      list2.setItems(resultatRecherche);
}
private void filtrerParCategorie(Categories categorie) {
    ObservableList<Produits> produitsFiltres = FXCollections.observableArrayList();
//    ps.chercherProduitParCategorie(categorie).forEach(p -> produitsFiltres.add(p));
    list2.setItems(produitsFiltres);
}
    @FXML
    private void filtrer(ActionEvent event) {
        
        filtrer.setOnAction(e ->filtrerParCategorie(boxCateg.getValue()));
    }

    
    
    
    
}
