/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.NewFXMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane rootmenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
  public void lancerinterfaceaffiche(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/GUI/CRUD.fxml"));
            rootmenu.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       @FXML
    public void lancerinterfacerecherche(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/GUI/chercherArtistes.fxml"));
            rootmenu.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
