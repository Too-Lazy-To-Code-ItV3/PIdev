/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Models.Challenge;
import interfaces.CategorieInterface;
import interfaces.ChallengeInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import services.CategorieService;
import services.ChallengeService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class FetchChallengesController implements Initializable {

    //ChallengeInterface ci = new ChallengeService();
    //List<Challenge> Challenges = ci.fetchChallenges();
    ChallengeInterface chi = new ChallengeService();

    ObservableList list = FXCollections.observableArrayList();

    private ListView<Challenge> listView;
    @FXML
    private ScrollPane challengesPane;
    @FXML
    private GridPane challengeGrid;
    private List<Challenge> challenges;
    @FXML
    private HBox addButton;
    @FXML
    private TextField search;

    CategorieInterface ci = new CategorieService();
    @FXML
    private CheckComboBox<String> cat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        afficher_Challenge();
        list.removeAll(list);
        ci.fetchCategorie().stream().forEach(e -> list.add(e.getNameCategorie()));
        cat.getItems().addAll(list);

    }

    @FXML
    private void afficher_Challenge() {

        String checkedCategories = cat.getCheckModel().getCheckedItems().stream().reduce("(", (a, b) -> a + "'" + b + "',");
        checkedCategories = checkedCategories.substring(0, checkedCategories.length() - 1) + ")";
        System.out.println(checkedCategories);
        challengeGrid.getChildren().clear();
        if (search.getText() == "" && checkedCategories.equals(")")) {
            challenges = chi.fetchChallenges();
        } else if (!checkedCategories.equals(")")) {
            challenges = chi.fetchChallengeByCategorie(checkedCategories);
        } else {
            challenges = chi.fetchChallengeByName(search.getText());
        }
        int columns = 0;
        int rows = 0;
        try {
            for (int i = 0; i < challenges.size(); i++) {
                AnchorPane item;
                if (challenges.get(i).getCreator().getID_user() == 1) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("item.fxml"));

                    item = fxmlLoader.load();

                    ItemController itemController = fxmlLoader.getController();
                    itemController.setData(challenges.get(i));
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("item2.fxml"));

                    item = fxmlLoader.load();

                    Item2Controller itemController = fxmlLoader.getController();
                    itemController.setData(challenges.get(i));
                }

                if (columns == 1) {
                    columns = 0;
                    ++rows;
                }

                challengeGrid.add(item, columns++, rows);
            }
        } catch (IOException ex) {
            Logger.getLogger(FetchChallengesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addChallenge(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXML_ADD_Challenge.fxml"));
        Parent view_2=loader.load();
        FXML_ADD_ChallengeController c=loader.getController();
        c.setNum(challenges.size());
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }

}
