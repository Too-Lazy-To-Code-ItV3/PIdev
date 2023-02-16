/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Comment;
import Interfaces.CommentInterface;
import Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            java.sql.Timestamp sqldate = new java.sql.Timestamp(datec.getTime());;
            String req = "insert into comment(id,Id_post,Date_Comment,Comment) values(?, ?, ?,?);";
            PreparedStatement com = cnx.prepareStatement(req);

            // Check if the Id_post value exists in the post table
            String checkPostQuery = "SELECT COUNT(*) FROM post WHERE Id_post = ?";
            PreparedStatement checkPostStmt = cnx.prepareStatement(checkPostQuery);
            checkPostStmt.setInt(1, co.getId_post());
            ResultSet checkPostResult = checkPostStmt.executeQuery();
            checkPostResult.next();
            int count = checkPostResult.getInt(1);

            if (count == 0) {
                System.out.println("No such post exists");
                return;
            }

            com.setInt(1, co.getId_user());
            com.setInt(2, co.getId_post());
            com.setTimestamp(3, sqldate);
            com.setString(4, co.getComment());
            int result = com.executeUpdate();
            System.out.println("Comment Added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
    public Comment fetchCommentByPostId(int id_post) {
        Comment comment = null;
            try {
                String req = "SELECT * FROM comment WHERE Id_post=?";
                PreparedStatement ps = cnx.prepareStatement(req);
                ps.setInt(1, id_post);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    comment = new Comment();
                    comment.setId_comment(rs.getInt(1));
                    comment.setId_post(rs.getInt(2));
                    comment.setId_user(rs.getInt(3));
                    comment.setDatec(rs.getDate(4));
                    comment.setComment(rs.getString(5));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return comment;
    }

    

    
}
