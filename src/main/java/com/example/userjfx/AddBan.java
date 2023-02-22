package com.example.userjfx;

import Models.Ban;
import Services.BanService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddBan {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField IDUSERTF;

    @FXML
    private TextField ReasonTF;
    private int userId;

    public void setUserId(int userId) throws SQLException {

        this.userId = userId;
        IDUSERTF.setText(String.valueOf(userId));


    }

    BanService bs=new BanService();

    @FXML
    void addBan(ActionEvent event) throws SQLException {
        Ban b=new Ban();
        b.setID_User(Integer.parseInt(IDUSERTF.getText()));
        b.setReason(ReasonTF.getText());
        bs.AddBan(b);

    }

    @FXML
    void initialize() {
        assert IDUSERTF != null : "fx:id=\"IDUSERTF\" was not injected: check your FXML file 'AddBan.fxml'.";
        assert ReasonTF != null : "fx:id=\"ReasonTF\" was not injected: check your FXML file 'AddBan.fxml'.";

    }

}
