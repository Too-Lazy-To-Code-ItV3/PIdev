/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author amine
 */
public class PostLike {
    private int id_post,id_user, id_PostLike;

    public PostLike(int id_post, int id_user, int id_PostLike) {
        this.id_post = id_post;
        this.id_user = id_user;
        this.id_PostLike = id_PostLike;
    }

    public PostLike(int id_user, int id_PostLike) {
        this.id_user = id_user;
        this.id_PostLike = id_PostLike;
    }

    public PostLike() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getId_PostLike() {
        return id_PostLike;
    }

    public void setId_PostLike(int id_PostLike) {
        this.id_PostLike = id_PostLike;
    }

    @Override
    public String toString() {
        return "PostLike{" + "id_post=" + id_post + ", id_user=" + id_user + ", id_PostLike=" + id_PostLike + '}';
    }
    
}