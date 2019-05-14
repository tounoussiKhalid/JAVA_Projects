
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Cours {
    
    private SimpleIntegerProperty num_cours;
    private SimpleStringProperty libelle_cours;
    private SimpleStringProperty date_deb;
    private SimpleStringProperty date_fin;


    public Cours(int num_cours, String libelle_cours, String date_deb, String date_fin) {
        this.num_cours = new SimpleIntegerProperty(num_cours);
        this.libelle_cours = new SimpleStringProperty(libelle_cours);
        this.date_deb = new SimpleStringProperty(date_deb);
        this.date_fin = new SimpleStringProperty(date_fin);
    }
    
    
    public int getNum_cours() {
        return num_cours.get();
    }

    public void setNum_cours(int num_cours) {
        this.num_cours =  new SimpleIntegerProperty(num_cours);
    }

    public String getLibelle_cours() {
        return libelle_cours.get();
    }

    public void setLibelle_cours(String libelle_cours) {
        this.libelle_cours = new SimpleStringProperty(libelle_cours);
    }

    public String getDate_deb() {
        return date_deb.get();
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = new SimpleStringProperty(date_deb);
    }

    public String getDate_fin() {
        return date_fin.get();
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = new SimpleStringProperty(date_fin);
    }
    
    
    
    
}
