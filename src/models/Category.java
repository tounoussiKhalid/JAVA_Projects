
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Category {
    
    private SimpleIntegerProperty id_category;
    private SimpleStringProperty category;
    private SimpleStringProperty description;
    private SimpleIntegerProperty quantity;
    private SimpleStringProperty reg_date;
    private SimpleIntegerProperty ArticlesNumber;
    
      public Category(int id_category, String category, String description) {
        this.id_category =new SimpleIntegerProperty( id_category);
        this.category = new SimpleStringProperty(category);
        this.description = new SimpleStringProperty(description);
    }
    
    public Category(int id_category, String category, String description,String reg_date,int ArticlesNumber,int quantity) {
        this.id_category = new SimpleIntegerProperty(id_category);
        this.category = new SimpleStringProperty(category);
        this.description = new SimpleStringProperty(description);
        this.reg_date = new SimpleStringProperty(reg_date);
        this.quantity= new SimpleIntegerProperty(quantity);
        this.ArticlesNumber = new SimpleIntegerProperty(ArticlesNumber);
    }
    
     public Category(int id_category, String category, String description,int quantity) {
        this.id_category = new SimpleIntegerProperty(id_category);
        this.category = new SimpleStringProperty(category);
        this.description = new SimpleStringProperty(description);
        this.quantity= new SimpleIntegerProperty(quantity);
    } 
    
    public Category(){}

    public int getArticlesNumber() {
        return ArticlesNumber.get();
    }

    public void setArticlesNumber(int ArticlesNumber) {
        this.ArticlesNumber =new SimpleIntegerProperty( ArticlesNumber);
    }

    
    
    public String getReg_date() {
        return reg_date.get();
    }

    public void setReg_date(String reg_date) {
        this.reg_date =  new SimpleStringProperty(reg_date);
    }
    
    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity = new SimpleIntegerProperty( quantity);
    }
    
    public int getId_category() {
        return id_category.get();
    }

    public String getCategory() {
        return category.get();
    }

    public String getDescription() {
        return description.get();
    }

    public void setId_category(int id_category) {
        this.id_category =  new SimpleIntegerProperty(id_category);
    }

    public void setCategory(String category) {
        this.category =new SimpleStringProperty( category);
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }
    
    
    
    
    @Override
    public String toString(){
        return getCategory();
    }
    
    
}
