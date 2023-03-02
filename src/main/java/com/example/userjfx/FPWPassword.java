package com.example.userjfx;

import Services.AllUsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class FPWPassword {


    @FXML
    private PasswordField newpassword;

    static private String Email;

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    @FXML
    void UpdatePw(ActionEvent event) {
        AllUsersService as = new AllUsersService();
        as.changePassword(newpassword.getText(),getEmail() );


    }

}
