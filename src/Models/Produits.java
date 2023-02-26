/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;
import java.util.Date;


/**
 *
 * @author aouad
 */
public class Produits {
    
    private int idProduit;
    private String nom;
    private String description;
    private String image;
    private int quantiteDispo;
    private double prix;
        private Date dateAjout;
    
    private Categories categorieProduit;

    public Produits(int idProduit, Categories categorieProduit,String nom, String description, String image,int quantiteDispo, double prix, Date dateAjout) {
        this.idProduit = idProduit;
        this.categorieProduit=categorieProduit;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.quantiteDispo=quantiteDispo;
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

    public int getQuantiteDispo() {
        return quantiteDispo;
    }

    public double getPrix() {
        return prix;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

   
    public Categories getCategorieProduit() {
        return categorieProduit;
    }
    
    
    
// Setters

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

    public void setQuantiteDispo(int quantiteDispo) {
        this.quantiteDispo = quantiteDispo;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

  
    public void setCategorieProduit(Categories categorieProduit) {
        this.categorieProduit = categorieProduit;
    }
    
    
//toString

    @Override
    public String toString() {
        return "Produits{" + "idProduit=" + idProduit +  ",\n categorieProduit=" + categorieProduit + ",\n nom=" + nom + ", \n description=" + description + ", \n image=" + image + ",\n quantiteDispo=" + quantiteDispo + ",\n prix=" + prix + ",\n dateAjout=" + dateAjout  + '}';
    }

   

    
    
}
