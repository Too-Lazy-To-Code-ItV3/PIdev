/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Models.Tutoriel;
import interfaces.TutorielInterface;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import services.TutorielService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class FXML_Fetch_TutorielsController implements Initializable {

    TutorielInterface ti = new TutorielService();
    @FXML
    private HBox addButton1;
    @FXML
    private TextField search;
    @FXML
    private GridPane tutorielGrid;
    @FXML
    private HBox addButton;
    
    private List<Tutoriel> tutoriels;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            
            if(columns == 1){
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
    private void search(ActionEvent event) {
    }

    @FXML
    private void addVideo(MouseEvent event) {
    }
    
}
