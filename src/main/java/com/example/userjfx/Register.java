package com.example.userjfx;

import Models.AllUsers;
import Services.AllUsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Register {

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

    AllUsersService as=new AllUsersService();

    @FXML
    void Register(ActionEvent event) {
        AllUsers u=new AllUsers();
        u.setName(NameTF.getText());
        u.setLast_Name(LastNameTF.getText());
        u.setEmail(EmailTF.getText());
        u.setBirthday(BirthdayTF.getValue());
        u.setPassword(PasswordTF.getText());
        u.setNationality(NationalityTF.getText());
        u.setType(TypeTF.getText());
        u.setNickname(NicknameTF.getText());
        as.AddAu(u);


    }

    @FXML
    void initialize() {
        assert BirthdayTF != null : "fx:id=\"BirthdayTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert CPasswordTF != null : "fx:id=\"CPasswordTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert EmailTF != null : "fx:id=\"EmailTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert LastNameTF != null : "fx:id=\"LastNameTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert NameTF != null : "fx:id=\"NameTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert NationalityTF != null : "fx:id=\"NationalityTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert NicknameTF != null : "fx:id=\"NicknameTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert PasswordTF != null : "fx:id=\"PasswordTF\" was not injected: check your FXML file 'Register.fxml'.";
        assert TypeTF != null : "fx:id=\"TypeTF\" was not injected: check your FXML file 'Register.fxml'.";

    }

}
