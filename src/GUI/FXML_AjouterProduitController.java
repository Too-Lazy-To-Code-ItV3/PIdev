/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import interfaces.ProduitInterface;
import models.Category;
import models.Produits;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.CategoryService;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_AjouterProduitController implements Initializable {
     ProduitInterface ps= new ProduitService();
     CategoryService cs= new CategoryService() {};
     Produits p= new Produits();
  
    @FXML
    private TextField nom;
    @FXML
    private TextField descp;
    private TextField image;
    private TextField qtdispo;
    @FXML
    private TextField prix;
    @FXML
    private ChoiceBox<?> listeCateg= new ChoiceBox<>();
     ObservableList listCat = FXCollections.observableArrayList();
    @FXML
    private Button ajouter;
    @FXML
    private Button retour;
    private String src;
    private String dest;
    @FXML
    private Button imp;
    
    private  Boolean  test;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ImportCateg();
    }    
     public void ImportCateg(){
      List<Category> categories = cs .fetchCategories();
        
        if (categories != null) {

            
         cs.fetchCategories().stream().forEach(e->listCat.add(e.getName_category()));
         
         
        listeCateg.getItems().addAll(listCat);
     }}

    @FXML
    private void ajouterProduit(ActionEvent event) throws IOException {
        
        if (false) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur de saisie !");
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.show();
        return;
    }

            p.setNom(nom.getText());
            p.setDescription(descp.getText());
            p.setCategorieProduit((Category) listeCateg.getValue());      
            p.setPrix(Double.parseDouble(prix.getText()));
            System.out.println(p);
            ps.addProduit(p);
            Files.copy(Paths.get(src), Paths.get(dest));
             FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
             Parent root = loader.load();
             retour.getScene().setRoot(root);
        
    }

    @FXML
    private void GotoAccueil(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUImenuprincipale/menuprincipale.fxml"));
     Scene scene = new Scene(root);
     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     stage.setScene(scene);
     stage.show();
    }

    @FXML
    private void importer(ActionEvent event) {
           FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG Files","*.png");
           FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG Files","*.jpg");

           fc.getExtensionFilters().addAll(extFilterPNG,extFilterJPG);
           
           File selectedFile = fc.showOpenDialog(null);
           
           if(selectedFile != null) {
               src = selectedFile.getPath();
               dest = "C:\\xampp\\htdocs\\img\\"+selectedFile.getName();
               imp.setText(selectedFile.getName());
               p.setImage(selectedFile.getName());
               test = true;
           } else {
               System.err.println("file is not valid");
           }
    }
    
    
    
}
