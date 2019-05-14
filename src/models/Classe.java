
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Classe {
    
   private SimpleIntegerProperty id_class ;
   private SimpleStringProperty libelle_class;
   private SimpleIntegerProperty nbr_etud ;
   private SimpleStringProperty reg_date;

   public Classe(int id_class,String libelle_class ){
        this.id_class =  new SimpleIntegerProperty(id_class);
        this.libelle_class = new SimpleStringProperty(libelle_class);
   }
   
    public Classe(int id_class, String libelle_class, int nbr_etud, String reg_date) {
        this.id_class =  new SimpleIntegerProperty(id_class);
        this.libelle_class = new SimpleStringProperty(libelle_class);
        this.nbr_etud = new SimpleIntegerProperty(nbr_etud);
        this.reg_date = new SimpleStringProperty(reg_date);
    }

    public int getId_class() {
        return id_class.get();
    }

    public void setId_class(int id_class) {
        this.id_class =new SimpleIntegerProperty( id_class);
    }

    public String getLibelle_class() {
        return libelle_class.get();
    }

    public void setLibelle_class(String libelle_class) {
        this.libelle_class = new SimpleStringProperty(libelle_class);
    }

    public int getNbr_etud() {
        return nbr_etud.get();
    }

    public void setNbr_etud(int nbr_etud) {
        this.nbr_etud = new SimpleIntegerProperty(nbr_etud);
    }

    public String getReg_date() {
        return reg_date.get();
    }

    public void setReg_date(String reg_date) {
        this.reg_date = new SimpleStringProperty(reg_date);
    }

    @Override
    public String toString() {
        return getLibelle_class();
    }
   
   
   
    
}
