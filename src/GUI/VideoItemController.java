/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Video;
import interfaces.VideoInterface;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import service.VideoService;

/**
 * FXML Controller class
 *
 * @author achref
 */
public class VideoItemController implements Initializable {
    VideoInterface vi = new VideoService();

    @FXML
    private ImageView video_image;
    @FXML
    private Label video_date;
    @FXML
    private Label video_title;
    @FXML
    private Label video_desc;
    
    private Video video;
    @FXML
    private ImageView modifyVideo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setData(Video video) {
        System.out.println(video);
        File file = new File("C:\\xampp\\htdocs\\img\\"+video.getPathImage());
        Image img = new Image(file.toURI().toString());
        
        video_image.setImage(img);
        video_title.setText(video.getTitle());
        video_desc.setText(video.getDescrption());
        video_date.setText(video.getDate_p()); 
        
        this.video = video;
    }

    @FXML
    private void showVideo(MouseEvent event) {
        try {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./VideoView.fxml"));
        Parent view_2=loader.load();
        VideoViewController video_ViewController=loader.getController();
        video_ViewController.setVideo(video.getPathVideo());
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
        //Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void modifyVideo(MouseEvent event) {
                try {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_Modify_Video.fxml"));
        Parent view_2=loader.load();
        FXML_Modify_VideoController modify_VideoController=loader.getController();
        modify_VideoController.setVideo(video);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
        //Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void deleteVideo(MouseEvent event) throws IOException {
        vi.deleteVideo(video.getID_Video());
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML_Fetch_Tutoriels.fxml"));
        Parent view_2=loader.load();
        Scene scene = new Scene(view_2);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
} 
