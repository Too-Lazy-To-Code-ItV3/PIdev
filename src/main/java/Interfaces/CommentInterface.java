package Interfaces;

import Models.Comment;
import Models.Post;

import java.util.List;

public interface CommentInterface {
    public void addComment(Comment co);

    public void deleteComment(int commentId);

    //public void modifyComment(Comment co);
    public void modifyComment(Comment c, String newComment);

    //public Comment fetchCommentByPostId(int id_post);
    //public List<Comment> fetchCommentsByPostId(int id_post);
    public Post fetchPost(int id_post);

    public List<Post> fetchPosts();

    public Comment fetchCommentByPostId(String title);


    // i use this :
    public List<Comment> fetchCommentByPostId(int postId);
}
