package com.example.userjfx;

import Models.AllUsers;
import Services.AllUsersService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class AffichUsers {
    @FXML
    private GridPane citiesGril;
    private List<AllUsers> Users;
    AllUsersService as = new AllUsersService();

    @FXML
    public void initialize(URL url, ResourceBundle rb) throws IOException {
        System.out.println("AFFICHUSER");
        Users = new ArrayList<>(as.fetchAU());
        int column = 0;
        int row = 1;
        for (AllUsers User : Users) {
            System.out.println("AFFICHUSER");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Useritem.fxml"));
            Pane pane = fxmlLoader.load();
            Useritem ui = fxmlLoader.getController();
            ui.loadUsers(User);
            if (column == 1) {
                column = 0;
                ++row;
            }
            citiesGril.add(pane, column++, row);
            GridPane.setMargin(pane, new Insets(20));
        }


    }
}

