package Models;

import java.util.Date;

public class Produits {
    private int idProduit;
    private int ID_User;
    private String nom;
    private String description;
    private String image;
    private double prix;
    private Date dateAjout;
    private Categorie categorieProduit;
    private AllUsers User;

    public Produits(int idProduit, int ID_User, AllUsers User, Categorie categorieProduit, String nom, String description, String image , double prix, Date dateAjout) {
        this.idProduit = idProduit;
        this.ID_User = ID_User;
        this.categorieProduit=categorieProduit;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.prix = prix;
        this.dateAjout =dateAjout ;
        this.User=User;

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

    public AllUsers getUser() {
        return User;
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


    public Categorie getCategorieProduit() {
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

    public void setUser(AllUsers User) {
        this.User = User;
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


    public void setCategorieProduit(Categorie categorieProduit) {
        this.categorieProduit = categorieProduit;
    }


//toString

    @Override
    public String toString() {
        return "Produits{" + "idProduit=" + idProduit + ", nom=" + nom + ", description=" + description + ", image=" + image + ", prix=" + prix + ", dateAjout=" + dateAjout + ", categorieProduit=" + categorieProduit + '}';
    }


}
