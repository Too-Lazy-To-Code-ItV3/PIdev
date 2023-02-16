/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pidev;

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
        Date Date_post = Date.valueOf("2022-10-10");
        //User init
          User u = new User();
          Category c = new Category();
          Post p = new Post();
          Comment co = new Comment();
          
          
         /********************Add Post**************************/
         
//                c.setId_Category(2);
//                c.setName_category("Horror");
//
//               p.setId_user(1); 
//               p.setCategory_p(c); 
//               p.setTitle("My Blog post title");
//               p.setDescription_p("My post description");
//               p.setMedia("C:\\Users\\amine\\Desktop\\icon.jpg"); 
//               p.setPost_typ("Blog");
//               st.addPost(p);
         
         /********************End add Post**************************/
         
         /********************Start add comment**************************/
//                co.setId_user(1);
//                co.setId_post(3);
//                co.setComment("This is a comment");
//                com.addComment(co);
         /********************End Add comment**************************/
         
         /********************Start Modify comment**************************/
//                co.setComment("This is the edit edit comment");
//                co.setId_comment(4);
//                com.modifyComment(co);
         
         /********************End Modify comment**************************/
         
         
         /********************Start fetch Comments By Post Id**************************/
         
//             Comment comment = com.fetchCommentByPostId(3);
//               if (comment == null) {
//               System.out.println("No comment was found for this post ID ");
//           } else {
//               System.out.println("The comment for this post ID  is: " + comment.getComment());
//           }
            
            
            
         /********************End fetch Comments By Post Id**************************/
         
         
         /********************Start Delete comment**************************/
         
//                   com.deleteComment(5);
            
         /********************End Delete comment**************************/
         
         /********************Start Delete Post**************************/
         
             //st.deletePost(4);
         
         /********************End Delete Post**************************/
         
         
         /********************Start Modify Post**************************/
        
            //Post postToModify = st.fetchPostById(1); 
//                    p.setId_post(3);
//                    String newTitle = "New Title";
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
            //c.setName_category("hello");
    
          
          
          /*********Add Like**************/
          
//                p.setId_post(4);
//                p.setId_user(7);
//                st.addLike(p);
          
          /*********End Add Like**************/
          
          /*********start delete Like**************/
          
//                st.deleteLike(2, 3);
            
          /*********end delete Like**************/
          
          
          
          
          /*** Start modify Post  ***/
          
          /**Start post is liked***/
            //List<PostLike> posts = st.isLikedByUser(2, 2);
         /**End post is liked***/
         
         /**Start post is liked***/
         
            //List<PostLike> posts = st.Number_Of_Likes_For_A_Post(2, 2);
         
         /**End post is liked***/
         
         
         
          //String newTitle="newTitle";
          //String newDescription="newDescription";
          //String newCategory="newCategory";
          //int id_post=9;
          //st.modifyPost(p, newTitle, newDescription, newCategory, id_post);
          
          /*** End modify Post  ***/
          //int id_post_delete = 5;
          //st.deletePost(id_post_delete); 
         
          /******* Add category*********/
            //cat.addCategory2(c);
          /******* End category*********/
          
        //stmt.addPost2(p);
      //   cat.modifyCategory(c, newName);
       //     String newName = "Thriller";
        // cat.modifyCategory(c, newName);
        // cat.deleteCategory("3d");
         
        
        
        
        
        
        
        
    }
    
}
