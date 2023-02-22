/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.Categorie;
import models.offreTravail;
import service.CategoryService;
import service.offreTravailService;

/**
 * FXML Controller class
 *
 * @author nour2
 */
public class ModifierOffreController implements Initializable {

    @FXML
    private TextField titreOffre;
    @FXML
    private TextField descriptionOffre;
    @FXML
    private ChoiceBox<Categorie> listeCategorie;
    @FXML
    private ChoiceBox<String> listetypes;
    @FXML
    private ChoiceBox<String> villeliste;
    @FXML
    private Button modifier;
   CategoryService c = new CategoryService();
   offreTravailService offs= new   offreTravailService();
    offreTravail of = new offreTravail();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      getdata();
    }       

public void getdata()
        
{
    listeCategorie.getItems().addAll(c.fetchCategories());
       String[]types={"freelance","contract","other"};
       String[]villes = {"tunis","ariana","manouba","ben arous"};
       listetypes.getItems().addAll(types);
      villeliste.getItems().addAll(villes);
   
}
public void getid(int i,String titre,String desc,String type,String loc,String categ){
             modifier.setId(Integer.toString(i));
titreOffre.setText(titre);
descriptionOffre.setText(desc);
listetypes.setValue(type);
villeliste.setValue(loc);
listeCategorie.setValue(c.fetchCategoryByNom("2d art"));
}
  

    @FXML
    private void modifierOffre(ActionEvent event) {
          int id= Integer.parseInt(modifier.getId());
           of.setIdOffre(id);
        of.setTitreOffre(titreOffre.getText());
       
        of.setDescriptionOffre(descriptionOffre.getText());
        of.setCategorieOffre(listeCategorie.getValue());
        of.setLocalisationOffre(villeliste.getValue());
        of.setTypeOffre(listetypes.getValue());
        of.setIdStudio(2);
      
           offs.modifierOffre(of);
    }

}
