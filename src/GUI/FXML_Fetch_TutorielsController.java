/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Tutoriel;
import interfaces.CategoryInterface;
import interfaces.FavorisTutorielInterface;
import interfaces.TutorielInterface;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Logged;
import service.CategoryService;
import service.FavorisTutorielService;
import service.TutorielService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class FXML_Fetch_TutorielsController implements Initializable {

    FavorisTutorielInterface ft = new FavorisTutorielService();
    TutorielInterface ti = new TutorielService();
    @FXML
    private HBox addButton1;
    private TextField search;
    @FXML
    private GridPane tutorielGrid;
    @FXML
    private HBox addButton;
    
    private List<Tutoriel> tutoriels;
    @FXML
    private TextField searching;
    @FXML
    private ComboBox<String> categorie;
    
    ObservableList list = FXCollections.observableArrayList();
    
    CategoryInterface ci = new CategoryService();
    @FXML
    private VBox vBox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(Logged.get_instance().getUser().getType().equals("Observer")){
            vBox.getChildren().remove(addButton);
        }
        
        list.removeAll(list);
        ci.fetchCategories().stream().forEach(e->list.add(e.getNomCategorie()));
        categorie.getItems().addAll(list);
        
        if(searching.getText().length()!=0)
            search();
        else
            afficher_Tutoriels();
    }    
    
    private void afficher_Tutoriels() {
        tutorielGrid.getChildren().clear();
        tutoriels = ti.fetchTutoriels();
        
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<tutoriels.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TutorielItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            TutorielItemController tutorielItemController = fxmlLoader.getController();
            tutorielItemController.setData(tutoriels.get(i));
            
            if(columns == 2){
                columns = 0 ;
                ++rows;
            }
            
            tutorielGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FetchChallengesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void search() {
        tutorielGrid.getChildren().clear();
        tutoriels = ti.fetchTutorielsByTitle(searching.getText());
        System.out.println(tutoriels);
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<tutoriels.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TutorielItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            TutorielItemController tutorielItemController = fxmlLoader.getController();
            tutorielItemController.setData(tutoriels.get(i));
            
            if(columns == 2){
                columns = 0 ;
                ++rows;
            }
            
            tutorielGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FetchChallengesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    private void setCategorie(ActionEvent event) {
        
    }

    @FXML
    private void addTutoriel(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_ADD_Tutoriel.fxml"));
        Parent view_2=loader.load();
        Scene scene = new Scene(view_2);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showFavoris(MouseEvent event) {
        tutorielGrid.getChildren().clear();
        tutoriels = ft.fetchFavorisTutorials();
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<tutoriels.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TutorielItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            TutorielItemController tutorielItemController = fxmlLoader.getController();
            tutorielItemController.setData(tutoriels.get(i));
            
            if(columns == 2){
                columns = 0 ;
                ++rows;
            }
            
            tutorielGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FetchChallengesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
