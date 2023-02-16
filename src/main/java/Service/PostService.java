/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Category;
import Entity.Post;
import Entity.PostLike;
import Interfaces.PostInterface;
import Utils.MyConnection;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amine
 */
public class PostService implements PostInterface{

     //var
    Connection cnx = MyConnection.getInstance().getCnx();
    
/******************************************************************************/

    @Override
    public void addPost(Post p) {
        try {
            Date date = new Date();
            java.sql.Timestamp sqldate = new java.sql.Timestamp(date.getTime());

            // check if the category exists in the database
            String checkCategory = "SELECT * FROM category WHERE Id_Category=?";
            PreparedStatement checkCategoryStmt = cnx.prepareStatement(checkCategory);
            checkCategoryStmt.setInt(1, p.getCategory_p().getId_Category());
            ResultSet rs = checkCategoryStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Category does not exist in the database");
                return;
            }

            // check if the post_type is valid
            if (!p.getPost_typ().equals("Portfolio") && !p.getPost_typ().equals("Blog")) {
                System.out.println("Invalid post_type value");
                return;
            }

            // add the post to the database
            String req = "INSERT INTO post (id, Description_p, Media, Title_p, Date_p, Id_Category, post_type) VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            FileInputStream videoFile = new FileInputStream(p.getMedia());
            byte[] png_post = new byte[videoFile.available()];
            videoFile.read(png_post);
            st.setInt(1, p.getId_user());
            st.setString(2, p.getDescription_p());
            st.setBytes(3, png_post);
            st.setString(4, p.getTitle());
            st.setTimestamp(5, sqldate);
            st.setInt(6, p.getCategory_p().getId_Category());
            st.setString(7, p.getPost_typ());
            int result = st.executeUpdate();
            if (result > 0) {
                System.out.println("Post added successfully!");
            } else {
                System.out.println("Post not added");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
                public void modifyPost(Post p, String newTitle, String newDescription) {
            try {
                // check if the post exists in the database
                String checkPost = "SELECT * FROM post WHERE Id_post=?";
                PreparedStatement checkPostStmt = cnx.prepareStatement(checkPost);
                checkPostStmt.setInt(1, p.getId_post());
                ResultSet rs = checkPostStmt.executeQuery();
                if (!rs.next()) {
                    System.out.println("Post does not exist in the database");
                    return;
                }

                // update the post in the database
                String req = "UPDATE post SET Title_p=?, Description_p=? WHERE Id_post=?";
                PreparedStatement st = cnx.prepareStatement(req);
                st.setString(1, newTitle);
                st.setString(2, newDescription);
                st.setInt(3, p.getId_post());
                int result = st.executeUpdate();
                if (result > 0) {
                    System.out.println("Post modified successfully!");
                } else {
                    System.out.println("Post not modified");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    
          
          @Override
            public void deletePost(int postId) {
                        try {
                // delete the comments associated with the post from the database
                String req1 = "DELETE FROM comment WHERE Id_post=?";
                PreparedStatement st1 = cnx.prepareStatement(req1);
                st1.setInt(1, postId);
                st1.executeUpdate();

                // delete the post likes associated with the post from the database
                String req2 = "DELETE FROM post_like WHERE Id_post=?";
                PreparedStatement st2 = cnx.prepareStatement(req2);
                st2.setInt(1, postId);
                st2.executeUpdate();

                // delete the post from the database
                String req3 = "DELETE FROM post WHERE Id_post=?";
                PreparedStatement st3 = cnx.prepareStatement(req3);
                st3.setInt(1, postId);
                int result = st3.executeUpdate();
                if (result > 0) {
                    System.out.println("Post deleted successfully!");
                } else {
                    System.out.println("Post not found");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                
}
          

    @Override
    public void addLike(Post p) {
         try {            
            String req = "INSERT INTO `post_like`(`id_post`, `id`) VALUES (?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, p.getId_post());
            st.setInt(2, p.getId_user());
            st.executeUpdate();
            System.out.println("Like Added Successfully!");
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @Override
    public void deleteLike(int id_post, int id_user) {
           try {
          String req = "DELETE FROM post_like WHERE id_post = ? and id = ?";
          PreparedStatement st = cnx.prepareStatement(req);
          st.setInt(1, id_post);
          st.setInt(2, id_user);
          st.executeUpdate();
          System.out.println("Like Deleted Successfully!");
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
    }

   public List<PostLike> isLikedByUser(int id_post, int id_user) {
        List<PostLike> posts = new ArrayList<>();
        String req = "SELECT * FROM post_like WHERE id_post = ? and id = ?";
        try (PreparedStatement st = cnx.prepareStatement(req)) {
            st.setInt(1, id_post);
            st.setInt(2, id_user);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    int post_id = rs.getInt("id_post");
                    int user_id = rs.getInt("id");
                    PostLike p = new PostLike(post_id, user_id);
                    posts.add(p);
                }
            }
            System.out.println("this post is like by the user " );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
}
    
   @Override
    public List<PostLike> Number_Of_Likes_For_A_Post(int id_post, int id_user) {
             List<PostLike> postLikes = new ArrayList<>();
            String req = "SELECT * FROM post_like WHERE id_post = ? AND id = ?";
            try (PreparedStatement st = cnx.prepareStatement(req)) {
                st.setInt(1, id_post);
                st.setInt(2, id_user);
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        //int id_PostLike = resultSet.getInt("id_PostLike");
                        int post_id = resultSet.getInt("id_post");
                        int user_id = resultSet.getInt("id");
                        PostLike postLike = new PostLike(post_id, user_id);
                        postLikes.add(postLike);
                    }
                    int count = postLikes.size();
                    System.out.println("Number of Likes for this post is  " +count);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return postLikes;
    }
    
     @Override
    public List<String> fetchPortfolioPostDetails() {
        List<String> postDetails = new ArrayList<>();
        try {
            String req = "SELECT Description_p, Title_p FROM post WHERE post_type=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, "Portfolio");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String description = rs.getString("Description_p");
                String title = rs.getString("Title_p");
                postDetails.add(description + " - " + title);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postDetails;
    }
    
      @Override
        public List<String> fetchPostBlogPostDetails() {
            List<String> postDetails = new ArrayList<>();
            try {
                String req = "SELECT Description_p, Title_p FROM post WHERE post_type=?";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setString(1, "Blog");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String description = rs.getString("Description_p");
                    String title = rs.getString("Title_p");
                    postDetails.add(description + " - " + title);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return postDetails;
        }

    @Override
        public List<Post> fetchPostByCategory(int categoryId) {
            List<Post> posts = new ArrayList<>();
            try {
                // check if the category exists in the database
                String checkCategory = "SELECT * FROM category WHERE Id_Category=?";
                PreparedStatement checkCategoryStmt = cnx.prepareStatement(checkCategory);
                checkCategoryStmt.setInt(1, categoryId);
                ResultSet rs = checkCategoryStmt.executeQuery();
                if (!rs.next()) {
                    System.out.println("Category does not exist in the database");
                    return posts;
                }

                // fetch posts for the specified category ID
                String req = "SELECT * FROM post WHERE Id_Category=?";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setInt(1, categoryId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Post post = new Post();
                    post.setId_user(rs.getInt("id"));
                    //post.setId_post(rs.getInt("Id_post"));
                    post.setDescription_p(rs.getString("Description_p"));
                    post.setTitle(rs.getString("Title_p"));
                    //post.setDate_p(rs.getTimestamp("Date_p"));
                    post.setPost_typ(rs.getString("post_type"));
                    Category category = fetchCategoryById(rs.getInt("Id_Category"));
                    post.setCategory_p(category);
                    posts.add(post);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return posts;
        }
        private Category fetchCategoryById(int categoryId) {
            Category category = null;
            try {
                String req = "SELECT * FROM category WHERE Id_Category=?";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setInt(1, categoryId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    category = new Category();
                    category.setId_Category(rs.getInt(1));
                    category.setName_category(rs.getString(2));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return category;
        }

    }

    

  


    

  


    

    
    

