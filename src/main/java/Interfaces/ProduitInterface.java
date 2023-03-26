package Interfaces;

import Models.Categorie;
import Models.Produits;
import javafx.collections.ObservableList;

import java.util.List;

public interface ProduitInterface {
    public void addProduit(Produits p);

    //list : select
    public List<Produits> fetchProduits();

    // //supprimer
//    public void  spprimerProduit(String nom);
//    public void spprimerProduit(Produits p);
    public void spprimerProduit(int idProduit);
//    //modifier

    public void modifierProduit(Produits p);
//
//   //afficher

//   public void afficherProduit(Produits p, int id);

    //chercher par nom
    public ObservableList<Produits> chercherProduitParCateg(String nomCategorie);

    //   public Produits chercherProduitParNom(String nom);
    public ObservableList<Produits> chercherProduitParNom(String nom);

    public void chercherProduitParCategorie(Categorie CategorieProduit);

    public Produits readById(int id);

    public Produits readByName(String nom);
}

