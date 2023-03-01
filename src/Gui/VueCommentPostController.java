package Gui;

import Entity.Comment;
import Interfaces.CommentInterface;
import Service.CommentService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueCommentPostController implements Initializable {

    @FXML
    private VBox commentVBox;
    @FXML
    private ScrollPane commentScrollPane;
    @FXML
    private TextField commentTextField;
    
    private int postID;
    CommentInterface com = new CommentService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
   public void setId_post(int id) {
        postID = id;
        System.out.println("Setting post ID to: " + postID);

        List<Comment> comments = com.fetchCommentByPostId(postID);
        if (!comments.isEmpty()) {
            for (Comment comment : comments) {
                CommentLabel commentLabel = new CommentLabel(comment);
                commentVBox.getChildren().add(commentLabel);
            }
        }
    }
    public class CommentLabel extends Label {
     private Comment comment;
     private Button modifyButton;
     private Button deleteButton;

     public CommentLabel(Comment comment) {
         this.comment = comment;
         setText(comment.getComment());

         modifyButton = new Button("Modify");
         deleteButton = new Button("Delete");

         modifyButton.setOnAction(event -> {
             // handle modify button click
         });

         deleteButton.setOnAction(event -> {
             // handle delete button click
         });

         HBox buttons = new HBox(modifyButton, deleteButton);
         setGraphic(buttons);
     }
 }
    
    @FXML
    private void postComment() {
        // TODO: add the comment to the database and display it in the commentVBox
        String commentText = commentTextField.getText();
        Label commentLabel = new Label(commentText);
        commentVBox.getChildren().add(commentLabel);
        commentTextField.clear();
    }
}