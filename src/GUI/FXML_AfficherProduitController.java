/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import MainTest.NewFXMain;
import Interfaces.ProduitInterface;
import MainTest.MyListener;
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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import services.ProduitService;
import MainTest.NewFXMain;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.LignePanierService;
/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_AfficherProduitController implements Initializable , MyListener{
      ProduitInterface ps= new ProduitService();
      
     private ListView<List<Produits>> myListView;
     ObservableList<Produits> list = FXCollections.observableArrayList();
    
    @FXML
    private ListView<Produits> list2;
  
    @FXML
    private Button ajouter;
    @FXML
    private Button Retour;
    @FXML
    private TextField textchercher;
    @FXML
    private Button recherche;

   
    @FXML
    private VBox chosenCard;
    @FXML
    private Label imgPrix;
    @FXML
    private ImageView imgView;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Label imgNom;
   private MyListener myListener;
    @FXML
    private Button modif;
    @FXML
    private ImageView updateIcon1;
    @FXML
    private Button supp;
    private Button modifBtn;
    Produits p;
    @FXML
    private AnchorPane anchorPane;

       private void setChosenCard(Produits p) {
   
     imgNom.setText(p.getNom());
     imgPrix.setText(MainTest.NewFXMain.CURRENCY + p.getPrix());
     if (p.getImage() != null) {
        InputStream stream = getClass().getResourceAsStream(p.getImage());
        if (stream != null) {
            Image image = new Image(stream);
            imgView.setImage(image);
        }
     
    }
   
}
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//     ListView <Produits> myListVie=(ListView <Produits>) ps.fetchProduits();

        ps.fetchProduits().stream().forEach(a->list.add(a));
        list2.setItems(list);
        
        Produits prod = new Produits();
//        if (list.size() > 0) {
//            setChosenCard(list.get(0));
//            MyListener myListener = new MyListener() {
//                public void onClickListener(Produits prod) {
//                    setChosenCard(prod);
//                    p=prod;
//                }
//          Image image = null;
//          if(prod.getImage() != null){
//          image = new Image(getClass().getResourceAsStream(prod.getImage()));
//         }
//
//                
//            }
            if (list.size() > 0) {
            setChosenCard(list.get(0));
             myListener = new MyListener() {
               @Override
                public void onClickListener(Produits prod) {
                    setChosenCard(prod);
                   
                }
            };
            }
        int column = 0;
        int row = 1;
          try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_Prod.fxml"));
                anchorPane = fxmlLoader.load();

                FXML_ProdController ProdController = fxmlLoader.getController();
                Produits prod2 = list.get(i);
                ProdController.setData(prod2,myListener);
          if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
        }

}           catch (IOException ex) {
                Logger.getLogger(FXML_AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
            }}


 
   



    @FXML
    private void GotoAjouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AjouterProduit.fxml"));
        Parent root = loader.load();
        ajouter.getScene().setRoot(root);
    }

    @FXML
    private void GotoAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
        Parent root = loader.load();
        Retour.getScene().setRoot(root);
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

    

   

    @FXML
    private void supprimer(ActionEvent event) {
        int id= Integer.parseInt(supp.getId());
         p=ps.readById(id);
        ps.spprimerProduit(id);
    }

    

    @FXML
    private void modifier(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_ModifierProduit.fxml"));
        Parent root = loader.load();
        modifBtn.getScene().setRoot(root);
    }

    @Override
    public void onClickListener(Produits prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


  
 
   
}
