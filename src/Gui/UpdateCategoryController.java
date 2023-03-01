package Gui;

import Entity.Category;
import Interfaces.CategoryInterface;
import Service.CategoryService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateCategoryController implements Initializable {

    //var
    CategoryInterface cat = new CategoryService();
    //widgets
    @FXML 
    private TextField OldCategoryName;
    @FXML
    private TextField NewCategoryName;
    String newname;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void UpdateCategory(ActionEvent event) {
        if (OldCategoryName.getText().isEmpty() || NewCategoryName.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Input cannot be empty!");
            alert.showAndWait();
            return;
        }
        
        Category c = new Category();
        String newName = NewCategoryName.getText();

        c.setName_category(OldCategoryName.getText());
        cat.modifyCategory(c, newName);
    }
              @FXML
     public void handleReturn(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/Gui/CategoryControlPanel.fxml"));
     Scene scene = new Scene(root);
     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     stage.setScene(scene);
     stage.show();
 }
}