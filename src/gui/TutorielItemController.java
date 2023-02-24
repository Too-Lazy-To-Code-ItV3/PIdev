/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Models.Tutoriel;
import Models.Video;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class TutorielItemController implements Initializable {

    @FXML
    private ImageView tutorial_image;
    @FXML
    private Label tutorial_title;
    @FXML
    private Label tutorial_description;
    
    Tutoriel tutoriel = new Tutoriel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showTutorial(MouseEvent event) {
        
    }
    
    void setData(Tutoriel tutoriel) {
        Image imageg = new Image(getClass().getResourceAsStream(tutoriel.getPathImg()));
        
        tutorial_image.setImage(imageg);
        tutorial_title.setText(tutoriel.getTitle());
        tutorial_description.setText(tutoriel.getDescription());
        
        this.tutoriel = tutoriel;
    }
}
