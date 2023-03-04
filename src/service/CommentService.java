/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entity.Category;
import Entity.Comment;
import Entity.Post;
import Interfaces.CommentInterface;
import Interfaces.PostInterface;
import Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amine
 */
public class CommentService implements CommentInterface{
    
    //var
    Connection cnx = MyConnection.getInstance().getCnx();
    
@Override
public void addComment(Comment co) {
    try {
        Date datec = new Date();
        java.sql.Timestamp sqldate = new java.sql.Timestamp(datec.getTime());
        
        // Check if the post exists
        String checkPostQuery = "SELECT COUNT(*) FROM post WHERE id_post = ?";
        PreparedStatement checkPostStmt = cnx.prepareStatement(checkPostQuery);
        checkPostStmt.setInt(1, co.getPost_c().getId_post());
        ResultSet checkPostResult = checkPostStmt.executeQuery();
        checkPostResult.next();
        int postCount = checkPostResult.getInt(1);
        if (postCount == 0) {
            System.out.println("Error adding comment: Post does not exist");
            return;
        }
        
        String insertCommentQuery = "INSERT INTO comment(id, Id_post, Date_Comment, Comment) VALUES (?, ?, ?, ?)";
        PreparedStatement insertCommentStmt = cnx.prepareStatement(insertCommentQuery);
        insertCommentStmt.setInt(1, co.getId_user());
        insertCommentStmt.setInt(2, co.getPost_c().getId_post());
        insertCommentStmt.setTimestamp(3, sqldate);
        insertCommentStmt.setString(4, co.getComment());
        int result = insertCommentStmt.executeUpdate();
        if (result > 0) {
            System.out.println("Comment added successfully");
        } else {
            System.out.println("Error adding comment: No rows affected");
        }
    } catch (SQLException ex) {
        System.out.println("Error adding comment: " + ex.getMessage());
    }
}

    @Override
    public void deleteComment(int commentId) {
            try {
            String req = "DELETE FROM comment WHERE Id_comment = ?";
            PreparedStatement com = cnx.prepareStatement(req);
            com.setInt(1, commentId);
            int result = com.executeUpdate();
            if (result > 0) {
                System.out.println("Comment deleted");
            } else {
                System.out.println("No comment found with Id_comment " + commentId);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifyComment(Comment co) {
            try {
            String req = "UPDATE comment SET Comment = ? WHERE Id_comment = ?";
            PreparedStatement com = cnx.prepareStatement(req);
            com.setString(1, co.getComment());
            com.setInt(2, co.getId_comment());
            int result = com.executeUpdate();
            if (result > 0) {
                System.out.println("Comment modified");
            } else {
                System.out.println("No comment found with Id_comment " + co.getId_comment());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
       public List<Post> fetchPosts() {
            List<Post> posts = new ArrayList<>();
            try {

               String req = "SELECT * FROM post";
               Statement st = cnx.createStatement();
               ResultSet rs = st.executeQuery(req);
               while (rs.next()) {                
                   Post p = new Post();
                   p.setDescription_p(rs.getString(1));
                   p.setMedia(rs.getString(2));
                   p.setTitle(rs.getString(3));
                   p.setPost_typ(rs.getString(4));
                   posts.add(p);
               }

           } catch (SQLException ex) {
               ex.printStackTrace();
           }

           return posts;
       }
 

    
        @Override
        public Post fetchPost(int id_post) {
            Post po = null;
            try {
                String req = "SELECT * FROM post WHERE id_post = ?";
                PreparedStatement st = cnx.prepareStatement(req);
                st.setInt(1, id_post);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    po = new Post();
                    po.setId_post(rs.getInt("id_post"));
                    po.setTitle(rs.getString("Title_p"));
                    po.setMedia(rs.getString("Media"));
                    po.setDescription_p(rs.getString("Description_p"));
                    po.setPost_typ(rs.getString("post_type"));
                    //po.setDate_p(rs.getDate("Date_p"));
                    Category cat = new Category();
                    cat.setId_Category(rs.getInt("Id_Category"));
                    po.setCategory_p(cat);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return po;
        }

    @Override
    public Comment fetchCommentByPostId(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public List<Comment> fetchCommentByPostId(int postId) {
        List<Comment> comments = new ArrayList<>();
        try {
            String query = "SELECT * FROM comment WHERE Id_post = ?";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, postId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Comment comment = new Comment();
                comment.setId_user(result.getInt("id"));
                Post post = new Post();
                post.setId_post(result.getInt("Id_post"));
                comment.setPost_c(post);
                //comment.setDate_comment(result.getTimestamp("Date_Comment"));
                comment.setComment(result.getString("Comment"));
                comments.add(comment);
            }
            if (comments.isEmpty()) {
                System.out.println("No comments found for post with ID " + postId);
            } else {
                System.out.println("Comments for post with ID " + postId + ":");
                for (Comment comment : comments) {
                    System.out.println("- " + comment.getComment());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching comments: " + ex.getMessage());
        }
        return comments;
    }        

        }
    

    


