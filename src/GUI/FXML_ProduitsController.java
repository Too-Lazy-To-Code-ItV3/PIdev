/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Categories;
import Models.Produits;

import java.net.URL;
import static java.rmi.Naming.list;
import static java.util.Collections.list;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import services.CategoriesService;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_ProduitsController implements Initializable {
//var 
    ProduitService ps= new ProduitService();
    Produits p=new Produits();
   CategoriesService categ= new CategoriesService() {};
   Categories c = new Categories();
    
    @FXML
    private TextArea nomProduit;
    @FXML
    private TextArea descriptionProd;
    @FXML
    private TextArea categorieProd;
  
    @FXML
    private TextArea quantite;
    @FXML
    private TextArea prix_prod;
    @FXML
    private TextArea date_Ajout;
    @FXML
    private Button afficher;
    @FXML
    private Button ajouter;
    @FXML
    private Label selectLabel;
//    @FXML
//    private ListView<List<Lignepanier>> listView;
    @FXML
    private Button Import;
    @FXML
    private TextArea date_Ajout1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        list.removeAll(list);
//        categ.fetchCategories().stream().forEach(e->list.add(e.getNomCategorie()));
//        categorieProd.getItems().addAll(list);
    }    

    
      @FXML
    private void Ajouter(ActionEvent event) {
        
        
            p.setNom(nomProduit.getText());
          System.out.println(p);
         
            p.setDescription(descriptionProd.getText());
          System.out.println(p);
          
//            p.getCategorieProduit().setNomCategorie(categorieProd.getText());
//          System.out.println(p);
          
        
            p.setQuantiteDispo(Integer.parseInt(quantite.getText()));
          System.out.println(p);
          
            p.setPrix(Double.parseDouble(prix_prod.getText()));
        System.out.println(p);
//            p.setImage (date_Ajout.getText());
    
//        p.setDateAjout(date_Ajout.getValue().toString());
          System.out.println(p);
        ps.addProduit(p);
        
    }
    
    
    @FXML
    private void afficher(ActionEvent event) {
      selectLabel.setText(ps.fetchProduits().toString());
    }

    @FXML
    private void ImporterImage(ActionEvent event) {
    }

  
}
