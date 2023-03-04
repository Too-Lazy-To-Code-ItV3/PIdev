/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Models.Categorie;
import Models.Challenge;
import Models.Utilisateur;
import interfaces.CategorieInterface;
import interfaces.ChallengeInterface;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.CategorieService;
import services.ChallengeService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class FXML_Modify_ChallengeController implements Initializable {
    
    CategorieInterface ci = new CategorieService();
    ChallengeInterface chi= new ChallengeService();
    Challenge challenge = new Challenge();
    
    @FXML
    private TextField titre;
    @FXML
    private DatePicker date_challenge;
    @FXML
    private TextArea descrption;
    @FXML
    private Label image_name;
    @FXML
    private ComboBox<String> categories;
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private AnchorPane a;
    @FXML
    private TextField niveau;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.removeAll(list);
        ci.fetchCategorie().stream().forEach(e->list.add(e.getNameCategorie()));
        System.out.println(chi.fetchChallenges());
        categories.getItems().addAll(list);
    }    
    
    @FXML
    private void importImage(ActionEvent event) {
           FileChooser fc = new FileChooser();
           fc.getExtensionFilters().addAll(
           new FileChooser.ExtensionFilter("Image Files","*.png"));
           File selectedFile = fc.showOpenDialog(null);
           if(selectedFile != null) {
               image_name.setText(selectedFile.getName());
               challenge.setPathIMG(selectedFile.getAbsolutePath());
           } else {
               System.err.println("file is not valid");
           }
    }

    public void getChallenge(Challenge c){
        titre.setText(c.getTitle());
        descrption.setText(c.getDescription());
        categories.setValue(c.getCategorie().getNameCategorie());
        niveau.setText(String.valueOf(c.getNiveau()));
        image_name.setText(c.getPathIMG());
        
        int year = Integer.parseInt(c.getDate_C().substring(0, 4));
        int mois = Integer.parseInt(c.getDate_C().substring(5, 7));
        int jour = Integer.parseInt(c.getDate_C().substring(7, 9));
        
        date_challenge.setValue(LocalDate.parse(c.getDate_C()));
        
        challenge.setID_Challenge(c.getID_Challenge());
        challenge.setPathIMG(c.getPathIMG());
        //challenge.setCategorie(c.getCategorie());
    }

    @FXML
    private void modifyChallenge(ActionEvent event) throws IOException {
        if(titre.getText().length()==0||descrption.getText().length()==0||date_challenge.getValue().toString().length()==0||niveau.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez  remplir tous les champs");
            alert.show();
            return;
        }
        else if(!niveau.getText().matches("[0-9]")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez  remplir tous les champs"+ "");
            alert.show();
            return;
        }else{
        challenge.setTitle(titre.getText());
        challenge.setDescription(descrption.getText());
        challenge.setCategorie(ci.fetchCategorieByName(categories.getValue().toString()));
        challenge.setDate_C(date_challenge.getValue().toString());
        challenge.setCreator(new Utilisateur());
        challenge.setNiveau(Integer.parseInt(niveau.getText()));
                    System.out.println(challenge);
        chi.modifyChallenge(challenge);
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FetchChallenges.fxml"));
        Parent view_2=loader.load();
        Scene scene = new Scene(view_2);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();}
           
//       
//          catch (IOException ex) {
//          Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
//     }
    }
}
    
