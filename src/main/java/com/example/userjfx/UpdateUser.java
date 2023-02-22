package com.example.userjfx;

import Models.AllUsers;
import Services.AllUsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    private int userId;

    public void setUserId(int userId) throws SQLException {

        this.userId = userId;
        AllUsers user = as.fetchAUbyID(userId);
        System.out.println("init ID USER = " + userId);
        NameTF.setText(user.getName());
        LastNameTF.setText(user.getLast_Name());
        EmailTF.setText(user.getEmail());
        NicknameTF.setText(user.getNickname());
        NationalityTF.setText(user.getNationality());
        PasswordTF.setText(user.getPassword());
        CPasswordTF.setText(user.getPassword());
        BirthdayTF.setValue(user.getBirthday());
        TypeTF.setText(user.getType());
    }

    AllUsersService as = new AllUsersService();

    @FXML
    void initialize()  {

    }

    @FXML
    void Update(ActionEvent event) throws SQLException {
        AllUsers u = new AllUsers();
        u.setName(NameTF.getText());
        u.setLast_Name(LastNameTF.getText());
        u.setEmail(EmailTF.getText());
        u.setBirthday(BirthdayTF.getValue());
        u.setPassword(PasswordTF.getText());
        u.setNationality(NationalityTF.getText());
        u.setType(TypeTF.getText());
        u.setNickname(NicknameTF.getText());
        System.out.println("in the update scene" + u.getID_User());
        as.ModifyAu(u,userId);


    }


}
