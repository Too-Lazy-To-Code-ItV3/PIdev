/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev_3eme;

import Entity.Category;
import Entity.Comment;
import Entity.Post;
import Entity.PostLike;
import Entity.User;
import Interfaces.CategoryInterface;
import Interfaces.CommentInterface;
import Interfaces.PostInterface;
import Interfaces.UserInterface;
import Service.CategoryService;
import Service.CommentService;
import Service.PostService;

import Service.UserService;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author amine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // service init
        UserInterface ps = new UserService();
        CategoryInterface cat = new CategoryService();
        CommentInterface com = new CommentService();
        //PostInterface stmt = new PostService();

        PostInterface st = new PostService();
        //User init
          User u = new User();
          Category c = new Category();
          Post p = new Post();
          Comment co = new Comment();
          
          
      // Create a Comment object with some sample data
//    Comment comment = new Comment();
//    comment.setId_user(1);
//    comment.setComment("This is a new comment");
//    Post post = new Post();
//    post.setId_post(10);
//    comment.setPost_c(post);
//
//    // Call the addComment() method
//    CommentInterface comm = new CommentService();
//    comm.addComment(comment);          
//          
          
//           String title = "My trying post title";
//        Post post = st.fetchPostByTitle(title);
//        if (post == null) {
//            System.out.println("No post found with title: " + title);
//        } else {
//            System.out.println("Post found with title: " + title);
//            System.out.println("Post details:");
//            System.out.println("ID: " + post.getId_user());
//            System.out.println("Title: " + post.getTitle());
//            System.out.println("Description: " + post.getDescription_p());
//            System.out.println("Media: " + post.getMedia());
//            System.out.println("Post type: " + post.getPost_typ());
//        }
          
          
          
          
         /********************Add Post**************************/
         
//                c.setId_Category(2);
//                c.setName_category("Horror");
//
//               p.setId_user(1); 
//               p.setCategory_p(c); 
//               p.setTitle("My trying post title");
//               p.setDescription_p("My post description");
//               p.setMedia("C:\\Users\\amine\\Desktop\\icon.jpg"); 
//               p.setPost_typ("Blog");
//               st.addPost(p);
         
         /********************End add Post**************************/
         
         /********************Start add comment**************************/
//                co.setId_user(1);
//                co.setId_post(11);
//                co.setComment("This is a comment 2");
//                com.addComment(co);
         /********************End Add comment**************************/
         
         /********************Start Modify comment**************************/
//                co.setComment("This is the edit edit comment");
//                co.setId_comment(4);
//                com.modifyComment(co);
         
         /********************End Modify comment**************************/
         
         
       
         
         
         /********************Start Delete comment**************************/
         
//                   com.deleteComment(5);
            
         /********************End Delete comment**************************/
         
         /********************Start Delete Post**************************/
         
             //st.deletePost(4);
         
         /********************End Delete Post**************************/
         
         
         /********************Start Modify Post**************************/
        

//                    p.setTitle("New Title");
//                    String newTitle = "New New Title";
//                    String newDescription = "New Description";
//                    st.modifyPost(p, newTitle, newDescription);
         
         /********************End Modify Post**************************/
          
         /********************Start fetch Portfolio Post**************************/
            
//                List<String> portfolioPostDetails = st.fetchPortfolioPostDetails();
//
//                // print the portfolio post details
//                   for (String postDetail : portfolioPostDetails) {
//                       System.out.println(postDetail);
//                   }

         /********************End fetch Portfolio Post**************************/
         
           /********************Start fetch Comments By Post Id**************************/
         
//             Comment comment = com.fetchCommentByPostId(10);
//               if (comment == null) {
//               System.out.println("No comment was found for this post ID ");
//           } else {
//               System.out.println("The comment for this post ID  is: " + comment.getComment());
//           }
            
//            List<Comment> comments = com.fetchCommentsByPostId(11);
//            for (Comment comment : comments) {
//                //System.out.println("Comment ID: " + comment.getId_comment());
//               // System.out.println("User ID: " + comment.getId_user());
//                System.out.println("Post ID: " + comment.getId_post());
//                System.out.println("Comment: " + comment.getComment());
//                System.out.println("Date: " + comment.getDatec());
//                System.out.println();
//            }
            
            
            
         /********************End fetch Comments By Post Id**************************/
         
         /********************Start fetch Blog Post**************************/
//                   List<String> portfolioPostDetails = st.fetchPostBlogPostDetails();
//         
//                    // print the portfolio post details
//                   for (String postDetail : portfolioPostDetails) {
//                       System.out.println(postDetail);
//                   }
         
         /********************End fetch Blog Post**************************/
         
         
         
         /********************Start fetch Post By Id**************************/
          
         
         
//          List<Post> posts = st.fetchPostByCategory(2);
//         // Loop through the list of posts and print out their details
//        for (Post post : posts) {
//            //System.out.println("Post ID: " + post.getId_post());
//            System.out.println("Title: " + post.getTitle());
//            System.out.println("Description: " + post.getDescription_p());
//            //System.out.println("Date: " + post.getDate_p());
//            System.out.println("Post Type: " + post.getPost_typ());
//            System.out.println("Category: " + post.getCategory_p().getName_category());
//            System.out.println("User ID: " + post.getId_user());
//            System.out.println();
//        }
         
         /********************End fetch Post By Id**************************/
         
         
          /**Start fetchCategoryById**/
          
//          Category category = cat.fetchCategoryById(39);
//            if (category != null) {
//                System.out.println(category.getName_category());
//            } else {
//                System.out.println("Category not found");
//            }
           
          
          /**End fetchCategoryById**/
          
          /**Start fetchCategories**/
          
//          List<Category> categories = cat.fetchCategories();
//          for(Category category: categories) {
//                System.out.println(category.getName_category());
//            }

//            List<Post> posts = st.fetchPosts();
//            for(Post post: posts){
//                 System.out.println(post.getTitle());
//            }
          
          /**End fetchCategories**/
          
          /**Start Display category**/
          
         //Category c_test = new cat.DisplayCategory(2);
         //System.out.println(c_test.getName_category());
         
          /**End Display category**/
          
          /*****Start add User******/
          
          //u.setName("samir");
          //u.setNumber(23);
          //u.setAge(22);
          
          /*****End add User******/
          
          /*****Start add category******/
//            c.setName_category("2D");
//            cat.addCategory2(c);
          
          
          /*********Add Like**************/
          
//                p.setId_post(15);
//                p.setId_user(1);
//                st.addLike(p);
          
          /*********End Add Like**************/
          
          /*********start delete Like**************/
          
//                st.deleteLike(2, 3);
            
          /*********end delete Like**************/
          
          
          
          
       
          
          /**Start post is liked***/
            //List<PostLike> posts = st.isLikedByUser(2, 2);
         /**End post is liked***/
         
         /**Start post is liked***/
         
//           List<PostLike> posts = st.Number_Of_Likes_For_A_Post(15, 1);
        //List<PostLike> posts = st.Number_Of_Likes_For_A_Post_Post(15);
       // List<Comment> comments = com.fetchCommentByPostId(10);
           //List<Post> posts = st.fetchBlogPosts();
           //List<Post> postss = st.fetchPortfolioPostDetails();
           
           
          
           //st.getPostWithHighestLikes();
           
           
           
           
         /**End post is liked***/
         
         
         

        
        
        
        
        
        
        
    }
    
}
