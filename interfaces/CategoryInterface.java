

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Categorie;
import java.util.List;

/**
 *
 * @author amine
 */
public interface CategoryInterface {
    //add
        public void addCategory(Categorie c);
        public void addCategory2(Categorie c);
        public void modifyCategory(Categorie c,String newName);
        public void deleteCategory(String name);
        
//    
//    //list : select
       public List<Categorie> fetchCategories();
       
       
       public Categorie fetchCategoryById(int id);
       
       public Categorie fetchCategoryByNom(String nom) ;
}
