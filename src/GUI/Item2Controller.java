/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Models.Challenge;
import Models.Participation;
import Models.Utilisateur;
import interfaces.ChallengeInterface;
import interfaces.ParticipationInterface;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ChallengeService;
import services.ParticipationService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class Item2Controller implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private ImageView image;
    
    private int id;
    private Challenge challenge;
    
    ChallengeInterface chi= new ChallengeService();
    @FXML
    private Label level;
    @FXML
    private Label level1;
    @FXML
    private Label categorie;
    @FXML
    private Label date;
    
    ParticipationInterface pi = new ParticipationService();
    Participation p = new Participation();

    public void setData(Challenge challenge){
        File file = new File("C:\\xampp\\htdocs\\img\\"+challenge.getPathIMG());
        Image img = new Image(file.toURI().toString());
        image.setImage(img);
        title.setText(challenge.getTitle());
        description.setText(challenge.getDescription());
        level.setText(String.valueOf(challenge.getNiveau()));
        categorie.setText(challenge.getCategorie().getNameCategorie());
        date.setText(challenge.getDate_C()); 
        
        this.challenge = challenge;
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void removeChallenge(ActionEvent event) throws IOException {
        chi.deleteChallenge(challenge.getID_Challenge());
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FetchChallenges.fxml"));
        Parent view_2=loader.load();
        Scene scene = new Scene(view_2);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void modifyChallenge(ActionEvent event) {
               try {
        //Article selectedGarage=listaf.getSelectionModel().getSelectedItem();
        
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_Modify_Challenge.fxml"));
        Parent view_2=loader.load();
        FXML_Modify_ChallengeController modify_ChallengeController=loader.getController();
        modify_ChallengeController.getChallenge(challenge);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
        //Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void participate(ActionEvent event) throws IOException {
        /*Utilisateur u = new Utilisateur();
        u.setID_user(3);
        u.setNom("balbouli");
        u.setPrenom("aymen");
        u.setDate_Naissance("1989/07/19");
        u.setEmail("aymen.balblouli@gmail.com");
        u.setLocation("Monastir");
        u.setPathImage("");
        p.setParticipant(u);
        p.setChallenge(challenge);
        pi.addParticipation(p);*/
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_FetchParticipations.fxml"));
        Parent view_2=loader.load();
        FXML_FetchParticipationsController fetchParticipationsController=loader.getController();
        fetchParticipationsController.getChallenge(challenge);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }
    
}