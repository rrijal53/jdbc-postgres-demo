import pojo.Category;
import pojo.Product;

import javax.swing.*;
import java.sql.*;
import java.util.Collection;
import java.util.List;

public class DatabaseDemo {
    public static void main(String[] args) {
        // new Signup();
        try {
            DatabaseService databaseService = new DatabaseService("slycc", "postgres", "slycc@2o2o");
            List<Category> list = databaseService.getCategories();

            Category[] categoryArray = list.toArray(new Category[list.size()]);
            System.out.println( "Category \t\t Image");
           JComboBox cbCountry = new JComboBox<Category>();
            for (Category c : list) {

                System.out.println(c.getCategory() + " " + c.getImage());
                cbCountry.addItem(c);
            }
          Category c = (Category) cbCountry.getSelectedItem();
            Product p = new Product();
            p.setCategory(c);
            p.setCategoryId(c.getId());
            p.setName("");
            String pt = "10.23";
            p.setPrice(Double.parseDouble(pt));
          boolean success =  databaseService.insertProduct(p);
          if(success){

          }else{

          }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error while connecting to databasse");
        }
    }
}
