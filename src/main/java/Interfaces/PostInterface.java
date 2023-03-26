package Interfaces;

import Models.Categorie;
import Models.Post;
import Models.PostLike;

import java.util.List;

public interface PostInterface {
    public void addPost(Post p);
    public void deletePost(int postId);
    public void modifyPost(Post p, String newTitle, String newDescription);
    public void addLike(Post p);
    public void deleteLike(int id_post, int id_user);
    public List<Post> fetchPortfolioPostDetails();
    public List<Post> fetchPostBlogPostDetails();
    public List<Post> fetchPostByCategorie(int CategorieId);
    public List<Post> fetchPortfolioPostDetailsOfThePortfolioCreater();
    /*************End new code****************/
    public Categorie getCategorieByName(String CategorieName);



    public List<PostLike> isLikedByUser(int id_post, int id_user);
    public List<PostLike> Number_Of_Likes_For_A_Post(int id_post, int id_user);
    public List<String> getPostTitles();
    public int getPostIdByTitle(String title);
    public String getPostTitleById(int postId);
    public List<Categorie> fetchCategories();
    public List<Post> fetchPosts();
    public List<PostLike> Number_Of_Likes_For_A_Post_Post(int id_post);

    //
//public List<Post> getLikesByUser(int userId);
//
    Post fetchPostByTitle(String title);
    public Post getPostById(int postId);
    //using it

    public PostLike getPostWithHighestLikes();

    public int getNumLikes(int postId);

    public List<Integer> getLikeIdsForPost(int postId);
}
