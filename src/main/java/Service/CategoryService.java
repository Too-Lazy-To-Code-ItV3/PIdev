/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Category;
import Entity.User;
import Interfaces.CategoryInterface;
import Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amine
 */
public class CategoryService implements CategoryInterface{
        //var
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addCategory(Category c) {
         try {
            String req = "INSERT INTO `category`(`name_category`) VALUES ('"+c.getName_category()+")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Category Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addCategory2(Category c) {
        try {
            
            String req = "INSERT INTO `category`(`name_category`) VALUES (?)";
            PreparedStatement cat = cnx.prepareStatement(req);
            cat.setString(1, c.getName_category());
            cat.executeUpdate();
            System.out.println("cat Added Successfully!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void modifyCategory(Category c,String newName) {
        try {
        String req = "UPDATE `category` SET `name_category`=? WHERE `name_category`=?";
        PreparedStatement cat = cnx.prepareStatement(req);
        cat.setString(1, newName);
        cat.setString(2, c.getName_category());
        cat.executeUpdate();
        System.out.println("Category Modified Successfully!");
        } catch (SQLException ex) {
         ex.printStackTrace();
         }
    }
    
       @Override
    public void deleteCategory(String name) {
        try {
                String req = "DELETE FROM category WHERE name_category = ?";
                PreparedStatement cat = cnx.prepareStatement(req);
                cat.setString(1, name);
                cat.executeUpdate();
                System.out.println("Category deleted successfully!");
                } catch (SQLException ex) {
                ex.printStackTrace();
}
    }
    
    

    @Override
    public List<Category> fetchCategories() {
         List<Category> categories = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM category";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Category c = new Category();
                c.setId_Category(rs.getInt(1));
                c.setName_category(rs.getString(2));
                categories.add(c);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return categories;
    }

    //fetch by id

    @Override
    public Category fetchCategoryById(int id) {
        Category category = null;
        try {
            String req = "SELECT * FROM category WHERE id_Category=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId_Category(rs.getInt(1));
                category.setName_category(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return category;
    }
    

    
    
}
