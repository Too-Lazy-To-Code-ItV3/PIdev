/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import MainTest.MyListener;
import Models.Produits;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_ProdController implements Initializable{
    ProduitService ps= new ProduitService();
    Produits p = new Produits();
    @FXML
    private ImageView imgcard;
    @FXML
    private Label nomCard;
    @FXML
    private Label prixCard;

    @FXML
    private Label idProd;
    @FXML
    private AnchorPane anchorPane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Ne rien faire ici
    
    }
    
//    @FXML
//    private void click(MouseEvent mouseEvent) {
//        myListener.onClickListener(prod);
//    }

    private Produits prod;
    private MyListener myListener;

    public void setData(Produits prod, MyListener myListener) throws MalformedURLException {
        this.prod = prod;
        this.myListener = myListener;
    idProd.setText(String.valueOf(prod.getIdProduit()));
    nomCard.setText(prod.getNom());
    prixCard.setText(MainTest.NewFXMain.CURRENCY + prod.getPrix());
    String imagePath = prod.getImage(); // Récupérer le chemin de l'image depuis la base de données
    String absoluteImagePath = "C:" + File.separator + "xampp" + File.separator + "htdocs" + File.separator + "img" + File.separator;
    File imageFile = new File(absoluteImagePath + imagePath); // Créer un objet File avec le chemin de l'image
    System.out.println(imageFile.getAbsolutePath()); // Afficher le chemin d'accès à l'image dans la console
    Image image = new Image(imageFile.toURI().toURL().toString()); // Créer un objet Image avec l'URL de l'objet File
    imgcard.setImage(image); // Appliquer l'image à votre ImageView
    
//    File file=new File("C:\\xampp\\htdocs\\img\\"+prod.getImage());
//        Image image=new Image(file.toURI().toString());
//        imgcard.setImage(image); 
       
  
       
    }
 
    
    @FXML
    private void click(MouseEvent event) {
          myListener.onClickListener(prod);
    }

   

    
}
