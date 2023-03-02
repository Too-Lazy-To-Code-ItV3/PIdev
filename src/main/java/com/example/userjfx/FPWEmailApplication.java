package com.example.userjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FPWEmailApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegisterApplication.class.getResource("FPWEmail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Register Form WORKING !");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
