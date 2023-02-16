/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author amine
 */
public class Post {
    private int id_post;
    private int id_user;
    private String title;
    private String description_p;
    private String ImageP;
    private Date date;
    private int likes;
    private Category category_p;
    private String Media;
    private String post_typ;
    private double score;
    public Post() {
    }

    public Post(int id_post, int id_user, String title, String description_p, String ImageP, Date date, int likes, Category category_p, String Media, String post_typ) {
        this.id_post = id_post;
        this.id_user = id_user;
        this.title = title;
        this.description_p = description_p;
        this.ImageP = ImageP;
        this.date = date;
        this.likes = likes;
        this.category_p = category_p;
        this.Media = Media;
        this.post_typ = post_typ;
    }

    public Post(int id_user, String title, String description_p, String ImageP, Date date, int likes, Category category_p, String Media, String post_typ) {
        this.id_user = id_user;
        this.title = title;
        this.description_p = description_p;
        this.ImageP = ImageP;
        this.date = date;
        this.likes = likes;
        this.category_p = category_p;
        this.Media = Media;
        this.post_typ = post_typ;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription_p() {
        return description_p;
    }

    public void setDescription_p(String description_p) {
        this.description_p = description_p;
    }

    public String getImageP() {
        return ImageP;
    }

    public void setImageP(String ImageP) {
        this.ImageP = ImageP;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Category getCategory_p() {
        return category_p;
    }

    public void setCategory_p(Category category_p) {
        this.category_p = category_p;
    }

    public String getMedia() {
        return Media;
    }

    public void setMedia(String Media) {
        this.Media = Media;
    }

    public String getPost_typ() {
        return post_typ;
    }

    public void setPost_typ(String post_typ) {
        this.post_typ = post_typ;
    }

    public void setDate_p(Timestamp timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setScore(double score) {
        this.score = score;
    }

    
   
       
    
    
}

    
   
   
   
   
   
   
   


