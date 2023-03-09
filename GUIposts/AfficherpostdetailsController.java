/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIposts;

import Entity.Post;
import Entity.PostLike;
import Service.PostService;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.grosMots;

/**
 * FXML Controller class
 *
 * @author amine
 */
 

public class AfficherpostdetailsController implements Initializable {

    @FXML
    private ImageView imgProd;
    @FXML
    private Label dateAj;

    /**
     * Initializes the controller class.
     */
    
    private Post post;
    @FXML
    private Label TitrePost;
    @FXML
    private Label Description;
    @FXML
    private Label JaimePost;
    private PostService postService;
     public void initData(Post post) {
        this.post = post;
        //PostTitle.setText(post.getTitle());
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
      ;
        
         }
       public void loaddata(Post g) throws SQLException {
        TitrePost.setText(g.getTitle());
        Description.setText(g.getDescription_p());
        String mediaPath = g.getMedia();
        
        File mediaFile = new File(mediaPath);
        if (mediaFile.exists() && mediaFile.isFile()) {
            imgProd.setImage(new Image(mediaFile.toURI().toString()));
        }
    }
        
//          File file = new File("C:\\xampp\\htdocs\\img"+g.getImagePath());
//       System.out.println("fprod"+file);
//        Image img = new Image(file.toURI().toString());
//       System.out.println("nmgProd"+img);
//        imgProd.setImage(img);
          
         
         
           /*List<PostLike> likes = postService.Number_Of_Likes_For_A_Post_Post(post.getId_post());
        int numberOfLikes = likes.size();
         Label JaimePost = new Label("Likes: " + numberOfLikes);*/
        
   }   
    

