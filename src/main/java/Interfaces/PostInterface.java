/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Post;
import Entity.PostLike;
import java.io.File;
import java.util.List;

/**
 *
 * @author amine
 */
public interface PostInterface {
    
    /*************New code****************/
    public void addPost(Post p);
    public void deletePost(int postId);
    public void modifyPost(Post p, String newTitle, String newDescription);
    public void addLike(Post p);
    public void deleteLike(int id_post, int id_user);
    public List<String> fetchPortfolioPostDetails();
    public List<String> fetchPostBlogPostDetails();
    
    public List<Post> fetchPostByCategory(int categoryId);
    
    /*************End new code****************/

  
   
public List<PostLike> isLikedByUser(int id_post, int id_user);
public List<PostLike> Number_Of_Likes_For_A_Post(int id_post, int id_user);

}
