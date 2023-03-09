package com.example.userjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Dashboard {

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Button btnUsers;

    @FXML
    private VBox pnItems;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    void handleClicks(ActionEvent event) {
       /* if (event.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (event.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (event.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if (event.getSource() == btnOrders) {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }*/
    }


    @FXML
    void initialize() {

        assert btnMenus != null : "fx:id=\"btnMenus\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnOrders != null : "fx:id=\"btnOrders\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnOverview != null : "fx:id=\"btnOverview\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnSettings != null : "fx:id=\"btnSettings\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnSignout != null : "fx:id=\"btnSignout\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert pnItems != null : "fx:id=\"pnItems\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert pnlCustomer != null : "fx:id=\"pnlCustomer\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert pnlMenus != null : "fx:id=\"pnlMenus\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert pnlOrders != null : "fx:id=\"pnlOrders\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert pnlOverview != null : "fx:id=\"pnlOverview\" was not injected: check your FXML file 'Dashboard.fxml'.";


        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Useritem.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void AfficherUsers(ActionEvent event) {
        try {
            pnItems.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("CRUDuser.fxml"));
            pnItems.getChildren().add(pane);

        } catch (IOException ex) {

        }
    }

}

