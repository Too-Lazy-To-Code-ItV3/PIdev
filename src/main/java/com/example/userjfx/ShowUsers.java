package com.example.userjfx;

import Models.AllUsers;
import Services.AllUsersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowUsers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    AllUsersService as = new AllUsersService();
    @FXML
    private ListView<AllUsers> UsersLV;
    ObservableList<AllUsers> aul = FXCollections.observableArrayList(as.fetchAU());

    @FXML
    void ShowUsers(ActionEvent event) {
        aul = FXCollections.observableArrayList(as.fetchAU());
        UsersLV.setItems(aul);

    }

    @FXML
    void DeleteUser(ActionEvent event) throws SQLException {
        int selectedIndex = UsersLV.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            AllUsers user = UsersLV.getItems().get(selectedIndex);
            as.DeleteAu(user.getID_User());
            UsersLV.getItems().remove(selectedIndex);
            showAlert("User deleted successfully.");
        } else {
            showAlert("Please select a user to delete.");
        }

    }

    @FXML
    void UpdateUser(ActionEvent event) throws IOException, SQLException {
        AllUsers selectedUser = UsersLV.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateUser.fxml"));
        Parent uuView = loader.load();
        Scene scene = new Scene(uuView);


        UpdateUser updateUser = loader.getController();
        updateUser.setUserId(selectedUser.getID_User());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void BanUser(ActionEvent event) throws IOException, SQLException {
        AllUsers selectedUser = UsersLV.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBan.fxml"));
        Parent uuView = loader.load();
        Scene scene = new Scene(uuView);


        AddBan AddBan = loader.getController();
        AddBan.setUserId(selectedUser.getID_User());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void initialize() {
        aul = FXCollections.observableArrayList(as.fetchAU());
        UsersLV.setItems(aul);

    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
