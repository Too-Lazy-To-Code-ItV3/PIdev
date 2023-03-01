package com.example.userjfx;

import Models.AllUsers;
import Services.AllUsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
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

    AllUsersService as = new AllUsersService();

    @FXML
    void Register(ActionEvent event) {
        AllUsers u = new AllUsers();

        // Check and set name
        String name = NameTF.getText().trim();
        if (name.isEmpty() || !name.matches("^[a-zA-Z ]+$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Name");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid name (letters and spaces only).");
            alert.showAndWait();
            return;
        }
        u.setName(name);

        // Check and set last name
        String lastName = LastNameTF.getText().trim();
        if (lastName.isEmpty() || !lastName.matches("^[a-zA-Z ]+$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Last Name");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid last name (letters and spaces only).");
            alert.showAndWait();
            return;
        }
        u.setLast_Name(lastName);

        // Check and set email
        String email = EmailTF.getText().trim();
        if (email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Email");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
            return;
        }
        u.setEmail(email);

        // Check and set birthday
        LocalDate birthday = BirthdayTF.getValue();
        if (birthday == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Birthday");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid date of birth.");
            alert.showAndWait();
            return;
        }
        u.setBirthday(birthday);

        // Check and set password
        String password = PasswordTF.getText();
        String Cpassword = CPasswordTF.getText();
        if (password.isEmpty() || password.length() < 6 || !password.matches("^[a-zA-Z0-9]+$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Password");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a password with at least 6 characters, containing only letters and numbers.");
            alert.showAndWait();
            return;
        }
        if (!Cpassword.equals(password)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password Must Matches the confirm Password");
            alert.setHeaderText(null);
            alert.setContentText("Make sure password same as password confirm");
            alert.showAndWait();
            return;
        }
        u.setPassword(password);


        // Check and set nationality
        String nationality = NationalityTF.getText().trim();
        if (nationality.isEmpty() || !nationality.matches("^[a-zA-Z ]+$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Nationality");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid nationality (letters and spaces only).");
            alert.showAndWait();
            return;
        }
        u.setNationality(nationality);

        // Check and set user type
        String type = TypeTF.getText().trim();
        if (type.isEmpty() || !type.matches("^[a-zA-Z ]+$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid User Type");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid user type (letters and spaces only).");
            alert.showAndWait();
            return;
        }
        u.setType(type);
        u.setNickname(NicknameTF.getText());
        as.CreateAU(u);
    }





    /*@FXML
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


    }*/

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
