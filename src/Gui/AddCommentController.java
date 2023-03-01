package Gui;

import Entity.Comment;
import Entity.Post;
import Interfaces.CommentInterface;
import Interfaces.PostInterface;
import Service.CommentService;
import Service.PostService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddCommentController implements Initializable {

    @FXML
    private ComboBox<Post> postsComboBox;

    @FXML
    private TextField commentTextField;

    @FXML
    private TextField userIdTextField;

    private ObservableList<Post> postsObservableList;

    private PostInterface postService;

    private CommentInterface commentService;

    private Comment comment;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the services and the observable list of posts
        postService = new PostService();
        commentService = new CommentService();
        postsObservableList = FXCollections.observableArrayList();

        // Fetch the posts and add their titles to the combo box
        List<Post> posts = postService.fetchPosts();
        if (posts != null) {
            postsObservableList.addAll(posts);
            postsComboBox.setItems(postsObservableList);
            if (postsComboBox != null) { // check if the comboBox is not null
                postsComboBox.setConverter(new PostConverter());
            }
        }
    }
@FXML
void addComment(ActionEvent event) {
    // Check if comment text field and user ID text field are not empty
    if (commentTextField.getText().isEmpty() || userIdTextField.getText().isEmpty()) {
        // Show an alert if either field is empty
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Missing fields");
        alert.setContentText("Please enter a comment and a user ID.");
        alert.showAndWait();
        return;
    }
    
    Post ppost = new Post();
    PostInterface postService = new PostService();
    // Create a new comment with the data from the form
    comment = new Comment();
    comment.setComment(commentTextField.getText());
    comment.setId_user(Integer.parseInt(userIdTextField.getText()));

    // Get the selected post from the combo box
    Post selectedPost = postsComboBox.getValue();
    String postTitle = selectedPost.getDescription_p();
    
    //System.out.println("hey" + selectedPost.getTitle());

    // Search for the corresponding post in the database
    Post post = postService.fetchPostByTitle(postTitle);
    //System.out.println(postTitle);
    //System.out.println(postTitle);
    //System.out.println("ola amigo" + post);
    //System.out.println("ola amigo" + comment.getComment());
    
    
    ppost.setId_post(Integer.parseInt(postTitle));
    comment.setPost_c(ppost);
    //System.out.println(comment);
    String theComment = comment.getComment();
    // Add the comment to the database
    commentService.addComment(comment);
}

    /**
     * A custom converter that displays the title of a post in the combo box.
     */
    private class PostConverter extends javafx.util.StringConverter<Post> {

        @Override
        public String toString(Post post) {
            return (post != null) ? post.getTitle() : "";
        }

        @Override
        public Post fromString(String string) {
            return null; // not used
        }
    }
    
    
}