/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Models.Tutoriel;
import Models.Video;
import interfaces.TutorielInterface;
import interfaces.VideoInterface;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.TutorielService;
import services.VideoService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class FXML_Fetch_TutorielController implements Initializable {

    TutorielInterface ti = new TutorielService();
    VideoInterface vi = new VideoService();
    @FXML
    private ImageView tutoriel_img;
    @FXML
    private Label tutoriel_description;
    @FXML
    private Label tutoriel_title;
    @FXML
    private GridPane video_grid;
    @FXML
    private Label tutoriel_level;
    @FXML
    private HBox addButton;
    
    Tutoriel t;
    @FXML
    private Label tutorial_categorie;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        t = ti.fetchTutorielByID(30);
        tutorial_categorie.setText(t.getCategorie().getNameCategorie());
        tutoriel_title.setText(t.getTitle());
        tutoriel_description.setText(t.getDescription());
        tutoriel_level.setText(String.valueOf(t.getNiveau()));
        Image imageg = new Image(getClass().getResourceAsStream(t.getPathImg()));
        tutoriel_img.setImage(imageg);
        
        afficher_Tutoriel();
    }
    
        private void afficher_Tutoriel() {
        List<Video> videos = vi.fetchVideosByTutoriel(30);
            System.out.println(videos);
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<videos.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VideoItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            VideoItemController videoItemController = fxmlLoader.getController();
            videoItemController.setData(videos.get(i));
            
            if(columns == 2){
                columns = 0 ;
                ++rows;
            }
            
            video_grid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FetchChallengesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void addVideo(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_ADD_Video.fxml"));
        Parent view_2=loader.load();
        FXML_ADD_VideoController add_videoController=loader.getController();
        add_videoController.getTutoriel(t);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modifyTutoriel(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_Modify_Tutoriel.fxml"));
        Parent view_2=loader.load();
        FXML_Modify_TutorielController Modify_TutorielController=loader.getController();
        Modify_TutorielController.getTutoriel(t);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void removeTutoriel(ActionEvent event) {
        ti.deleteTutoriel(30);
    }
    
}
