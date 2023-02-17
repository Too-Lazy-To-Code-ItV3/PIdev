/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author MediaStudio
 */
public class Categorie {
    
    private int ID_Categorie ;
    private String NameCategorie;
    private String Description;

    public Categorie() {
    }

    public Categorie(String NameCategorie, String Description) {
        this.NameCategorie = NameCategorie;
        this.Description = Description;
    }
    
    public int getID_Categorie() {
        return ID_Categorie;
    }

    public void setID_Categorie(int ID_Categorie) {
        this.ID_Categorie = ID_Categorie;
    }

    public String getNameCategorie() {
        return NameCategorie;
    }

    public void setNameCategorie(String NameCategorie) {
        this.NameCategorie = NameCategorie;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Categorie{" + "ID_Categorie=" + ID_Categorie + ", NameCategorie=" + NameCategorie + ", Description=" + Description + '}';
    }
    
}