/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.LignePanier;
import Models.Produits;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.LignePanierService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_CartePanierController implements Initializable {
    
    LignePanierService lp = new LignePanierService();
    LignePanier ligneP= new LignePanier();
    @FXML
    private ImageView imgProd;
    @FXML
    private Label nomProd;
    @FXML
    private Label prixProd;
    @FXML
    private Label dateAj;
//    private Button suppProd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
    int idPanier=8;
    private Produits prod;
    public void setDataPanier(LignePanier ligneP) throws MalformedURLException {
        this.ligneP = ligneP;
        nomProd.setText(ligneP.getNomProd());
        prixProd.setText(Double.toString(ligneP.getPrix_unitaire()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateAjout = sdf.format(ligneP.getDateAjout());
        dateAj.setText(dateAjout);
        File file = new File("C:\\xampp\\htdocs\\img\\"+ligneP.getImageProd());
//        System.out.println("fprod"+file);
        Image img = new Image(file.toURI().toString());
//        System.out.println("nmgProd"+img);
        imgProd.setImage(img);
//        suppProd.setId(Integer.toString(ligneP.getIdLignePanier()));  
   
  }
    
//    private void suppProd(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation de suppression");
//        alert.setHeaderText(null);
//        alert.setContentText("Voulez-vous vraiment supprimer ce produit ?");
//      
//        
//         Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK){
//        int id= Integer.parseInt(suppProd.getId());
//        lp.supprimerLignePanier(id);
//        
//        System.out.println("Produit supprimé avec succés!");
//        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
//        alert2.setTitle("Success");
//        alert2.setHeaderText(null);
//        alert2.setContentText("Produit supprimé avec succés!");
//        alert2.showAndWait();
//       
//      } else {
////        System.out.println("Le produit n'a pas été supprimé");
////    }
//    }


    
}
