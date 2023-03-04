package Gui;

import Entity.Comment;
import Interfaces.CommentInterface;
import Service.CommentService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



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
        private Button TranslateToArabic;

        public CommentLabel(Comment comment) {
            this.comment = comment;
            setText(comment.getComment());

            modifyButton = new Button("Modify");
            modifyButton.setPrefHeight(26.0);
            modifyButton.setPrefWidth(80.0);
            modifyButton.setStyle("-fx-background-color: C10C99;");
            modifyButton.setTextFill(Color.WHITE);

            deleteButton = new Button("Delete");
            deleteButton.setPrefHeight(26.0);
            deleteButton.setPrefWidth(80.0);
            deleteButton.setStyle("-fx-background-color: C10C99;");
            deleteButton.setTextFill(Color.WHITE);

           modifyButton.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog(comment.getComment());
            dialog.setTitle("Modify Comment");
            dialog.setHeaderText("Modify your comment:");
            dialog.setContentText("Comment:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                comment.setComment(result.get());
                com.modifyComment(comment);
                setText(comment.getComment());
            }
        });

            deleteButton.setOnAction(event -> {
                com.deleteComment(comment.getId_comment());
                commentVBox.getChildren().remove(this);
            });

            HBox buttons = new HBox(10.0, modifyButton, deleteButton);
            setGraphic(buttons);
            setWrapText(true);
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
    
      @FXML
     public void handleReturn(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/Gui/PostControlPanel.fxml"));
     Scene scene = new Scene(root);
     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     stage.setScene(scene);
     stage.show();
 }
}