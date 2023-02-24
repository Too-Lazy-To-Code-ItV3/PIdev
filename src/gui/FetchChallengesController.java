/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import Models.Challenge;
import interfaces.ChallengeInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ChallengeService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class FetchChallengesController implements Initializable {

    //ChallengeInterface ci = new ChallengeService();
    //List<Challenge> Challenges = ci.fetchChallenges();
    ChallengeInterface chi= new ChallengeService();
    
    ObservableList list = FXCollections.observableArrayList();
    
    private ListView<Challenge> listView;
    @FXML
    private ScrollPane challengesPane;
    @FXML
    private GridPane challengeGrid;
    private List<Challenge> challenges;
    @FXML
    private HBox addButton;
    @FXML
    private HBox addButton1;
    @FXML
    private TextField search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(search.getText()=="")
            afficher_Challenge();
        else
            search();
    }
    
    private void afficher_Challenge() {
        challengeGrid.getChildren().clear();
        challenges = chi.fetchChallenges();
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<challenges.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("item.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            ItemController itemController = fxmlLoader.getController();
            itemController.setData(challenges.get(i));
            
            if(columns == 1){
                columns = 0 ;
                ++rows;
            }
            
            challengeGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FetchChallengesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    private void search() {
        challengeGrid.getChildren().clear();
        challenges = chi.fetchChallengeByName(search.getText());
        System.out.println(challenges);
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<challenges.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("item.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            ItemController itemController = fxmlLoader.getController();
            itemController.setData(challenges.get(i));
            
            if(columns == 1){
                columns = 0 ;
                ++rows;
            }
            
            challengeGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FetchChallengesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    private void addChallenge(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_ADD_Challenge.fxml"));
        Parent view_2=loader.load();
        Scene scene = new Scene(view_2);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
        

}

