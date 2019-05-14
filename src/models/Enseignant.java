
package models;

import java.sql.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Enseignant {
    
    private SimpleIntegerProperty id_enseignant;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty numTel;
    private SimpleStringProperty date_emb;

        
        //sql variables
  /*  String sql = "";
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement st = null;*/

    public Enseignant(int id_enseignant, String nom, String prenom, String numTel, String date_emb) {
        this.id_enseignant =  new SimpleIntegerProperty(id_enseignant);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty( prenom);
        this.numTel = new SimpleStringProperty(numTel);
        this.date_emb = new SimpleStringProperty(date_emb);
    }
    
    

    public int getId_enseignant() {
        return id_enseignant.get();
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant =new SimpleIntegerProperty(id_enseignant);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom =new SimpleStringProperty(prenom);
    }

    public String getNumTel() {
        return numTel.get();
    }

    public void setNumTel(String numTel) {
        this.numTel =new SimpleStringProperty(numTel);
    }

    public String getDate_emb() {
        return date_emb.get();
    }

    public void setDate_emb(String date_emb) {
        this.date_emb = new SimpleStringProperty( date_emb);
    }
    
    
    
    
    
}
