/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import models.Category;
import java.sql.Timestamp;
import java.util.Date;


/**
 *
 * @author aouad
 */
public class Produits {
    
    private int idProduit;
    private int ID_User;
    private String nom;
    private String description;
    private String image;
    private double prix;
    private Date dateAjout;
    private Category categorieProduit;

    public Produits(int idProduit,int ID_User, Category categorieProduit,String nom, String description, String image , double prix, Date dateAjout) {
        this.idProduit = idProduit;
        this.ID_User = ID_User;
        this.categorieProduit=categorieProduit;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix;
        this.dateAjout =dateAjout ;
       
    }
     public Produits() {
    }

    public Produits(int idProduit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produits(int aInt, String string, String string0, String string1, int aInt0, int aInt1, java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produits(int aInt, int aInt0, String string, String string0, String string1, String string2, int aInt1, int aInt2, java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

// getters
    
    public int getID_User() {
        return ID_User;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

  
    public String getImage() {
        return image;
    }

 

    public double getPrix() {
        return prix;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

   
    public Category getCategorieProduit() {
        return categorieProduit;
    }
    
    
    
// Setters

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

  
    public void setCategorieProduit(Category categorieProduit) {
        this.categorieProduit = categorieProduit;
    }
    
    
//toString

    @Override
    public String toString() {
        return "Produits{" + "idProduit=" + idProduit + ", nom=" + nom + ", description=" + description + ", image=" + image + ", prix=" + prix + ", dateAjout=" + dateAjout + ", categorieProduit=" + categorieProduit + '}';
    }

   

    
    
}
