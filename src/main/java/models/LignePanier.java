/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import models.Panier;
/**
 *
 * @author aouad
 */
public class LignePanier {


    private int IdLignePanier;
    private Panier panier;
    private Produits produit;
    private Date dateAjout;

    public LignePanier(int IdLignePanier, Panier panier, Produits produit, Date dateAjout) {
        this.IdLignePanier = IdLignePanier;
        this.panier = panier;
        this.produit = produit;
        this.dateAjout = dateAjout;
    }

    public LignePanier() {
    }

    public int getIdLignePanier() {
        return IdLignePanier;
    }

    public void setIdLignePanier(int IdLignePanier) {
        this.IdLignePanier = IdLignePanier;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Produits getProduit() {
        return produit;
    }

    public void setProduit(Produits produit) {
        this.produit = produit;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }



}