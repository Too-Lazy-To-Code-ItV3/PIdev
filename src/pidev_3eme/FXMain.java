/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev_3eme;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author amine
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            //need it
           
            //need it
            
            //root = FXMLLoader.load(getClass().getResource("/Gui/ViewPortfolio.fxml"));
            //na9sa
            //root = FXMLLoader.load(getClass().getResource("/Gui/ViewComments.fxml"));
            //root = FXMLLoader.load(getClass().getResource("/Gui/CommentsControlPanel.fxml"));
          //root = FXMLLoader.load(getClass().getResource("/Gui/ShowPost.fxml"));
          root = FXMLLoader.load(getClass().getResource("/Gui/CategoryControlPanel.fxml"));
          root = FXMLLoader.load(getClass().getResource("/Gui/PostControlPanel.fxml"));
          //root = FXMLLoader.load(getClass().getResource("/Gui/LikeChart.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("ArTounsi");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
