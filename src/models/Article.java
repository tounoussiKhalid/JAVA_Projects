
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Article {
    
    private SimpleIntegerProperty code_bare;
    private SimpleStringProperty designation;
    private SimpleIntegerProperty quantite;
    private SimpleIntegerProperty id_categorie;
    private SimpleStringProperty category;
    private SimpleStringProperty etat;
    private SimpleStringProperty date_enreg;
        
        //sql variables
    String sql = "";
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement st = null;
    
    
      public Article( String designation,int quantite,  int id_categorie , String etat,String date_enreg) {
        this.designation = new SimpleStringProperty(designation);
        this.quantite = new SimpleIntegerProperty(quantite);
        this.id_categorie = new SimpleIntegerProperty(id_categorie);
        this.etat = new SimpleStringProperty(etat);
        this.date_enreg =   new SimpleStringProperty(date_enreg) ;
    }
    
      public Article(int code_bare, String designation,int quantite,  int id_categorie , String etat,String date_enreg) {
        this.code_bare = new SimpleIntegerProperty(code_bare);
        this.designation = new SimpleStringProperty(designation);
        this.quantite = new SimpleIntegerProperty(quantite);
        this.id_categorie = new SimpleIntegerProperty(id_categorie);
        this.etat = new SimpleStringProperty(etat);
        this.date_enreg =   new SimpleStringProperty(date_enreg) ;
    }
      
     public Article(int code_bare, String designation,int quantite,  String categorie , String etat,String date_enreg) {
        this.code_bare = new SimpleIntegerProperty(code_bare);
        this.designation = new SimpleStringProperty(designation);
        this.quantite = new SimpleIntegerProperty(quantite);
        this.category = new SimpleStringProperty(categorie);
        this.etat = new SimpleStringProperty(etat);
        this.date_enreg =   new SimpleStringProperty(date_enreg) ;
    }
  
    public Article() {
    }  
    
    public Article allData() throws SQLException{
        Article ar = null;
        sql = "SELECT * FROM articles";
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
//              ar = new Article(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDate(6));
              return ar;
            }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
               return null;
            } finally {
                st.close();
                rs.close();
            }
        return null;
    }
    

    public void setCode_bare(int code_bare) {
        this.code_bare =new SimpleIntegerProperty(code_bare);
    }

    public void setDesignation(String designation) {
        this.designation = new SimpleStringProperty(designation);
    }

    public void setQuantite(int quantite) {
        this.quantite = new SimpleIntegerProperty(quantite);
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie =new SimpleIntegerProperty(id_categorie);
    }

    public void setEtat(String etat) {
        this.etat =new SimpleStringProperty(etat);
    }

    public void setDate_enreg(String date_enreg) {
        this.date_enreg = new SimpleStringProperty(date_enreg);
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category = new SimpleStringProperty(category);
    }
    
    public int getCode_bare() {
        return code_bare.get();
    }

    public String getDesignation() {
        return designation.get();
    }

    public int getQuantite() {
        return quantite.get();
    }

    public int getId_categorie() {
        return id_categorie.get();
    }

    public String getEtat() {
        return etat.get();
    }

    public String getDate_enreg() {
        return date_enreg.get();
    }
}
