/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Comment;
import java.util.List;

/**
 *
 * @author amine
 */
public interface CommentInterface {
    //add
    public void addComment(Comment co);
    public void deleteComment(int commentId);
    public void modifyComment(Comment co);
    public Comment fetchCommentByPostId(int id_post);
    

    
    //list : select
//    public List<Comment> fetchComments();
}
