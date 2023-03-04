package javaapplication1;

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

 
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../gui/FetchChallenges.fxml"));
            //root = FXMLLoader.load(getClass().getResource("../gui/FXML_Fetch_Tutoriels.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("workshopJavaFx");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }
     
    public static void main(String[] args) {
        launch(args);
    }
    
}
