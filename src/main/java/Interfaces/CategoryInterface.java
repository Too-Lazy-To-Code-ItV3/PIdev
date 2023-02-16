/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Category;
import java.util.List;

/**
 *
 * @author amine
 */
public interface CategoryInterface {
    //add
        public void addCategory(Category c);
        public void addCategory2(Category c);
        public void modifyCategory(Category c,String newName);
        public void deleteCategory(String name);
        
//    
//    //list : select
       public List<Category> fetchCategories();
       
       
       public Category fetchCategoryById(int id);
       
       
}
