/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Models.Categorie;
import interfaces.CategorieInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class FXML_DocumentController implements Initializable {

    CategorieInterface ci = new CategorieService();
    
    @FXML
    private TextField NomC;
    @FXML
    private TextArea DescC;
    
    //var
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddC(ActionEvent event) {
        Categorie c = new Categorie();
        c.setNameCategorie(NomC.getText());
        c.setDescription(DescC.getText());
        ci.addCategorie(c);
    }
    
}
