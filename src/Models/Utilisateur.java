/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author achref
 */
public class Utilisateur {
    private int ID_user;
    private String Nom,Prenom,Date_Naissance,Email,Location,type,pathImage;

    public Utilisateur() {
    }

    public Utilisateur(int ID_user, String Nom, String Prenom, String Date_Naissance, String Email, String Location, String type, String pathImage) {
        this.ID_user = ID_user;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Date_Naissance = Date_Naissance;
        this.Email = Email;
        this.Location = Location;
        this.type = type;
        this.pathImage = pathImage;
    }

    public int getID_user() {
        return ID_user;
    }

    public void setID_user(int ID_user) {
        this.ID_user = ID_user;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getDate_Naissance() {
        return Date_Naissance;
    }

    public void setDate_Naissance(String Date_Naissance) {
        this.Date_Naissance = Date_Naissance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "ID_user=" + ID_user + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Date_Naissance=" + Date_Naissance + ", Email=" + Email + ", Location=" + Location + ", type=" + type + ", pathImage=" + pathImage + '}';
    }

}
