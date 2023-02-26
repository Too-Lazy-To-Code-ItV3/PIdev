/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Categories;
import java.util.List;

/**
 *
 * @author aouad
 */
public interface CategoriesInterface {
      public void addCategorie(Categories c);
      
      
       public Categories readByNom(String nom) ;
       
       
       public Categories readById(int id) ;

      
      //list : select 
      
      public List<Categories> fetchCategories();

     
    
   
}
