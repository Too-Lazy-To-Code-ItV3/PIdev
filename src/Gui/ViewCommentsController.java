/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Post;
import Interfaces.PostInterface;
import Service.PostService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class ViewCommentsController implements Initializable {
    
    @FXML
    private ListView<?> CommentsListview;
    @FXML
    private ComboBox<?> Posts;
    ObservableList list1 = FXCollections.observableArrayList();
    
    PostInterface st = new PostService();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         List<Post> posts = st.fetchPosts();
         
         if (posts != null) {
             st.fetchPosts().stream().forEach(e->list1.add(e.getTitle()));
             //cat.fetchCategories().stream().forEach(e->list1.add(e.getName_category()));
             Posts.getItems().addAll(list1);
         }
    }

    
    
}
