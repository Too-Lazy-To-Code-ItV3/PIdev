package Interfaces;

import Models.Categorie;

import java.util.List;

public interface CategorieInterface {
    public void addCategorie2(Categorie c);

    public void modifyCategorie(Categorie c, String newName);

    public void deleteCategorie(String name);

    public void deleteCategoryById(int id);

    //
//    //list : select
    public List<Categorie> fetchCategories();


    public Categorie fetchCategorieById(int id);

    public Categorie fetchCategories(String name);


    public void deleteCategorieById(int id);
}
