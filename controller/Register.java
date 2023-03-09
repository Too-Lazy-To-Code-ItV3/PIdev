package controller;


import models.AllUsers;
import service.AllUsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @FXML
    private TextField BioTF;

    @FXML
    private TextArea DescriptionTF;

    private String uploadedFileName;

    static FileChooser fileChooser = new FileChooser();
    static FileChooser fileChooser1 = new FileChooser();

    static File file;
    static File file1;


    AllUsersService as = new AllUsersService();

    @FXML
    void Uploadbg(ActionEvent event) throws IOException {
        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        //Show open file dialog
        file = fileChooser.showOpenDialog(null);


    }

    @FXML
    void UploadAv(ActionEvent event) {
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser1.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        //Show open file dialog
        file1 = fileChooser1.showOpenDialog(null);

    }


    @FXML
    void Register(ActionEvent event) throws IOException {
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
        if (file != null) {
            String fileName = file.getName();
            try {
                // Copy the file to the XAMPP htdocs directory
                Path sourcePath = file.toPath();
                Path targetPath = Paths.get("C:/xampp2/htdocs/uploads/" + fileName);
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                u.setBackground(fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("background JAWOU MOCH BEHY");
            alert.setHeaderText(null);
            alert.setContentText("background PROBLEMO");
            alert.showAndWait();
        }
        if (file1 != null) {
            String fileName1 = file1.getName();
            try {
                // Copy the file to the XAMPP htdocs directory
                Path sourcePath = file1.toPath();
                Path targetPath = Paths.get("C:/xampp2/htdocs/uploads/" + fileName1);
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
            }
            u.setAvatar(fileName1);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AVATR JAWOU MOCH BEHY");
            alert.setHeaderText(null);
            alert.setContentText("AVATAR PROBLEMO");
            alert.showAndWait();
        }
        u.setBio(BioTF.getText());
        u.setDescription(DescriptionTF.getText());
        as.CreateAU(u);
        //as.AddAu(u);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Login.fxml"));
        Parent uuView = loader.load();
        Scene scene1 = new Scene(uuView, 1380, 700);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene1);
        stage.show();

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


