/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author aouad
 */
public class Categories {
    private int idCategorie;
    private String nomCategorie;

    public Categories(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public Categories() {
    }
    
    //getters

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }
    //setters

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    //toString

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + '}';
    }

  
    
    
}
