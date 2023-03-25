package com.example.userjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomePage {
    @FXML
    private BorderPane root;

    @FXML
    private AnchorPane contentPane;

    private Node profile;
    private Node page2;

    public void handleprofile() {
        setContent(profile);
    }

    public void handlePage2() {
        setContent(page2);
    }

    private void setContent(Node content) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(content);
    }

    public void initialize() {
        try {
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Profile.fxml"));
            profile = loader1.load();

            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Page2.fxml"));
            page2 = loader2.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
