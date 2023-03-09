package com.example.userjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CRUDuser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane CRUD;

    @FXML
    private AnchorPane CRUD1;

    @FXML
    private AnchorPane afficherUsers;

    @FXML
    private Button ajouter1;


    @FXML
    void ajout(ActionEvent event) {

    }

    @FXML
    void initialize() throws IOException {
        assert CRUD != null : "fx:id=\"CRUD\" was not injected: check your FXML file 'CRUDuser.fxml'.";
        assert CRUD1 != null : "fx:id=\"CRUD1\" was not injected: check your FXML file 'CRUDuser.fxml'.";
        assert afficherUsers != null : "fx:id=\"afficherUsers\" was not injected: check your FXML file 'CRUDuser.fxml'.";
        assert ajouter1 != null : "fx:id=\"ajouter1\" was not injected: check your FXML file 'CRUDuser.fxml'.";

        Pane pane = FXMLLoader.load(getClass().getResource("AffichUsers.fxml"));
        System.out.println("CRUDUSER");
        afficherUsers.getChildren().setAll(pane);

    }

}

