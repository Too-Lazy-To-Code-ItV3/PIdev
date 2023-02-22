package com.example.userjfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UpdateUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker BirthdayTF;

    @FXML
    private PasswordField CPasswordTF;

    @FXML
    private TextField EmailTF;

    @FXML
    private TextField LastNameTF;

    @FXML
    private TextField NameTF;

    @FXML
    private TextField NationalityTF;

    @FXML
    private TextField NicknameTF;

    @FXML
    private PasswordField PasswordTF;

    @FXML
    private TextField TypeTF;

    @FXML
    void Register(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BirthdayTF != null : "fx:id=\"BirthdayTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert CPasswordTF != null : "fx:id=\"CPasswordTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert EmailTF != null : "fx:id=\"EmailTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert LastNameTF != null : "fx:id=\"LastNameTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert NameTF != null : "fx:id=\"NameTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert NationalityTF != null : "fx:id=\"NationalityTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert NicknameTF != null : "fx:id=\"NicknameTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert PasswordTF != null : "fx:id=\"PasswordTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";
        assert TypeTF != null : "fx:id=\"TypeTF\" was not injected: check your FXML file 'UpdateUser.fxml'.";

    }

}
