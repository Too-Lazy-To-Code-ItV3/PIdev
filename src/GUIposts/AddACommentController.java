package GUIposts;

import models.Comment;
import models.Post;
import Service.CommentService;
import Service.PostService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import models.Logged;

public class AddACommentController implements Initializable {
private PostService postService;
private CommentService commentServce;
Post p = new Post();
    @FXML
    private TextField commentTextField;

    private CommentService commentService;
   // private PostService postService;

    private int id_post;
    private int id_user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        commentService = new CommentService();
         commentService = new CommentService();
        postService = new PostService();
    }

    @FXML
    void addComment(ActionEvent event) {
        if (commentService == null || postService == null) {
        // Display an error message and return
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Failed to add comment. Services are not available.");
        alert.showAndWait();
        return;
    }
        // Check if comment text field is not empty
        if (commentTextField.getText().isEmpty()) {
            // Show an alert if the comment field is empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing comment");
            alert.setContentText("Please enter a comment.");
            alert.showAndWait();
            return;
        }

        Comment comment = new Comment();
        comment.setComment(commentTextField.getText());
        comment.setId_user(Logged.get_instance().getUser().getID_User());

        Post post = postService.getPostById(id_post);
        comment.setPost_c(post);

        commentService.addComment(comment);

        // Show a confirmation alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Comment added");
        alert.setContentText("The comment was successfully added.");
        alert.showAndWait();
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}