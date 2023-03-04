package Gui;

import Entity.Post;
import Entity.PostLike;
import Interfaces.PostInterface;
import Service.PostService;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ViewBlogController implements Initializable {

    @FXML
    private VBox tfpostlist;
    private PostService postService;
    private Label lab;
    
    

    public ViewBlogController() {
        postService = new PostService();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Post> posts = postService.fetchPostBlogPostDetails();
        for (Post post : posts) {
            VBox postBox = new VBox();
            postBox.setStyle("-fx-border-color: black; -fx-padding: 5px;");
            Label titleLabel = new Label("Title: " + post.getTitle());
            Label descriptionLabel = new Label("Description: " + post.getDescription_p());

            // Load the image from the file system based on the file path stored in the database
            String mediaPath = post.getMedia();
            if (mediaPath != null && !mediaPath.isEmpty()) {
                File mediaFile = new File(mediaPath);
                if (mediaFile.exists() && mediaFile.isFile()) {
                    ImageView mediaView = new ImageView(new Image(mediaFile.toURI().toString()));
                    mediaView.setFitWidth(400); // set the width of the image view as needed
                    mediaView.setFitHeight(400); // set the height of the image view as needed
                    postBox.getChildren().add(mediaView);
                } else {
                    Label mediaLabel = new Label("Media: " + mediaPath);
                    postBox.getChildren().add(mediaLabel);
                }
            }

            HBox titleBox = new HBox    ();
            titleBox.getChildren().addAll(titleLabel);
            postBox.getChildren().add(titleBox);

            HBox descriptionBox = new HBox();
            descriptionBox.getChildren().addAll(descriptionLabel);
            postBox.getChildren().add(descriptionBox);

            // Get the number of likes for this post
            List<PostLike> likes = postService.Number_Of_Likes_For_A_Post_Post(post.getId_post());
            int numberOfLikes = likes.size();
            Label likesLabel = new Label("Likes: " + numberOfLikes); // create a Label object to display the number of likes
            postBox.getChildren().add(likesLabel);

            Button addCommentButton = new Button("Add Comment");
            
            addCommentButton.setLayoutX(1039.0);
            addCommentButton.setLayoutY(612.0);
            addCommentButton.setPrefHeight(46.0);
            addCommentButton.setPrefWidth(202.0);
            addCommentButton.setStyle("-fx-background-color: C10C99;");
            addCommentButton.setTextFill(Color.WHITE);
            
            
            addCommentButton.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gui/AddAComment.fxml"));
                    Parent addCommentView = loader.load();
                    AddACommentController addCommentController = loader.getController();
                    addCommentController.setId_post(post.getId_post());
                    addCommentController.setId_user(1);
                    Scene scene = new Scene(addCommentView);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            postBox.getChildren().add(addCommentButton);
            
            

            Button button1 = new Button("View Comments");
            
            button1.setLayoutX(1039.0);
            button1.setLayoutY(612.0);
            button1.setPrefHeight(46.0);
            button1.setPrefWidth(202.0);
            button1.setStyle("-fx-background-color: C10C99;");
            button1.setTextFill(Color.WHITE);
            
        button1.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gui/VueCommentPost.fxml"));
                Parent root = loader.load();
                VueCommentPostController controller = loader.getController();
                controller.setId_post(post.getId_post()); // set the postId in the VueCommentPostController instance

                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();         
            } catch (IOException e)  {
                e.printStackTrace();
            }
        });






            Button button2 = new Button("like");
            
            button2.setLayoutX(1039.0);
            button2.setLayoutY(612.0);
            button2.setPrefHeight(46.0);
            button2.setPrefWidth(202.0);
            button2.setStyle("-fx-background-color: C10C99;");
            button2.setTextFill(Color.WHITE);
            
            button2.setOnAction((ActionEvent e) -> {
                Post p = new Post();
                p.setId_post(post.getId_post());
                p.setId_user(3); // set the user ID of the user who liked the post  
                postService.addLike(p); // call the addLike method to add the like
                // update the label displaying the number of likes
                //List<PostLike> likes = postService.Number_Of_Likes_For_A_Post_Post(post.getId_post());
               // int numberOfLikes = likes.size();
               updateLikesLabel(likesLabel, post.getId_post()); // update the label displaying the number of likes
            });
            Button button3 = new Button("Unlike");
            
            button3.setLayoutX(1039.0);
            button3.setLayoutY(612.0);
            button3.setPrefHeight(46.0);
            button3.setPrefWidth(202.0);
            button3.setStyle("-fx-background-color: C10C99;");
            button3.setTextFill(Color.WHITE);
            
            button3.setOnAction((ActionEvent e) -> {
                Post p = new Post();
                p.setId_post(post.getId_post());
                p.setId_user(3); // set the user ID of the user who unliked the post
                postService.deleteLike(p.getId_post(), p.getId_user()); // call the deleteLike method to remove the like
                // update the label displaying the number of likes
                //List<PostLike> likes = postService.Number_Of_Likes_For_A_Post_Post(post.getId_post());
                //int numberOfLikes = likes.size();
                //likesLabel.setText("Likes: " + numberOfLikes);
                updateLikesLabel(likesLabel, post.getId_post());
            });
            
             Button deletePostButton = new Button("Delete Post");
             
             deletePostButton.setLayoutX(1039.0);
            deletePostButton.setLayoutY(612.0);
            deletePostButton.setPrefHeight(46.0);
            deletePostButton.setPrefWidth(202.0);
            deletePostButton.setStyle("-fx-background-color: C10C99;");
            deletePostButton.setTextFill(Color.WHITE);
             
                deletePostButton.setOnAction(event -> {
                    postService.deletePost(post.getId_post()); // call the deletePost method to delete the post
                    tfpostlist.getChildren().remove(postBox); // remove the VBox representing the deleted post from the main VBox
                });
                postBox.getChildren().add(deletePostButton);
            
                
                 Button ModifyPostButton = new Button("Modify Post");
            ModifyPostButton.setLayoutX(1039.0);
            ModifyPostButton.setLayoutY(612.0);
            ModifyPostButton.setPrefHeight(46.0);
            ModifyPostButton.setPrefWidth(202.0);
            ModifyPostButton.setStyle("-fx-background-color: C10C99;");
            ModifyPostButton.setTextFill(Color.WHITE);
            
//
//            ModifyPostButton.setOnAction(event -> {
//                try {
//                    Parent modifyPostView = FXMLLoader.load(getClass().getResource("/Gui/ModifyPost.fxml"));
//                    Scene scene = new Scene(modifyPostView);
//                    Stage stage = new Stage();
//                    stage.setScene(scene);
//                    stage.show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            postBox.getChildren().add(ModifyPostButton);
//            
            ModifyPostButton.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gui/ModifyPost.fxml"));
                    Parent modifyPostView = loader.load();
                    Scene scene = new Scene(modifyPostView);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    ModifyPostController modifyPostController = loader.getController();
                   // modifyPostController.initData(post);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
                
            HBox buttonBox = new HBox();
            buttonBox.getChildren().addAll(addCommentButton, button1, button2, button3 , deletePostButton, ModifyPostButton);

            buttonBox.setSpacing(10); // Set the spacing between the buttons
            

            VBox likesBox = new VBox();
            likesBox.getChildren().addAll(likesLabel, buttonBox);
            postBox.getChildren().add(likesBox);

            tfpostlist.getChildren().add(postBox);
        }
    }
    
    
       public void handleAddComment(ActionEvent event) {
    try {
        // Load the AddAComment.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gui/AddAComment.fxml"));
        Parent root = loader.load();

        // Create a new scene and display it in a new window
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        // Handle the exception here
        e.printStackTrace();
    }
}
public void viewAddPostPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Post.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
 public void viewModifyPostPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ModifyPost.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
               public void viewDeletePostPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DeletePost.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        public void viewPortfolioPostPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ViewPortfolio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
               public void viewPostControllePanel(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PostControlPanel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        public void viewlikedchart(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LikeChart.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        
    // Helper method to update the label displaying the number of likes
    private void updateLikesLabel(Label likesLabel, int postId) {
        List<PostLike> likes = postService.Number_Of_Likes_For_A_Post_Post(postId);
        int numberOfLikes = likes.size();
        likesLabel.setText("Likes: " + numberOfLikes);
    }
    
    
    
    
}