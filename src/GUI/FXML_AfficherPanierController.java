/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.LignePanier;
import Models.Panier;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.LignePanierService;
import services.PanierService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_AfficherPanierController implements Initializable {
    LignePanierService lp = new LignePanierService();
    PanierService ps=new PanierService();
    Panier pan=new Panier();
    
     private FXML_AfficherPanierController afficherPanierController;
    private int idPanier;
    @FXML
    private TableColumn<?, ?> prod;
    @FXML
    private TableColumn<?, ?> quantite;
    @FXML
    private TableColumn<?, ?> prixUn;
    @FXML
    private TableColumn<?, ?> SousPrix;
    @FXML
    private TableView<LignePanier> tablePanier;
    @FXML
    private Button vider;
    @FXML
    private Label montant_total;
    @FXML
    private Button modifier;
    @FXML
    private AnchorPane dateajout;
    @FXML
    private Label nbr_prod;
    @FXML
    private Button retour;
   

 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      idPanier=8;
      showLignePanier();

    }    
    
  public void setIdPanier(int idPanier) {
       this.idPanier = idPanier;
       showLignePanier();
    }
    
    public void showLignePanier() {
        List<LignePanier> lignePanierList = lp.getLignePanierparIdPanier(idPanier);
        ObservableList<LignePanier> observableList = FXCollections.observableArrayList(lignePanierList);
        prod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        prixUn.setCellValueFactory(new PropertyValueFactory<>("prix_unitaire"));
        SousPrix.setCellValueFactory(new PropertyValueFactory<>("sous_montant"));

        
        tablePanier.setItems(observableList);

        double montantTotal = ps.calculerMontantTotal(idPanier);
        montant_total.setText(String.valueOf(montantTotal));
        int nbrProd = ps.calculerNombreProduits(idPanier);
        nbr_prod.setText(String.valueOf(nbrProd));
    }
        public void  Mtotal(String total) {
          this.montant_total.setText(total);
        } 

    public void initializePanier(int idPanier) {
      this.idPanier = idPanier;
      showLignePanier();
   }

    @FXML
    private void vider(ActionEvent event) {
        ps.viderPanier();
    }

    @FXML
    private void GotoModifier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_ModifierPanier.fxml"));
        Parent root = loader.load();
        modifier.getScene().setRoot(root);
    }

    @FXML
    private void GotoAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
        Parent root = loader.load();
        modifier.getScene().setRoot(root);
    }
    
      
    
}
