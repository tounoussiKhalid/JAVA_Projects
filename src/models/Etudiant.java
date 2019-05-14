
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Etudiant {
    
    private SimpleIntegerProperty id_etudiant ;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty date_naissance;
    private SimpleIntegerProperty id_classe;
    private SimpleStringProperty classe;
    private SimpleStringProperty register_date;
    private SimpleStringProperty payment;

    public Etudiant(int id_etudiant, String nom, String prenom, String date_naissance, String classe, String register_date, String payment) {
        this.id_etudiant = new SimpleIntegerProperty(id_etudiant);
        this.nom = new SimpleStringProperty(nom);
        this.prenom =new SimpleStringProperty( prenom);
        this.date_naissance = new SimpleStringProperty(date_naissance);
        this.classe = new SimpleStringProperty(classe);
        this.register_date = new SimpleStringProperty(register_date);
        this.payment =new SimpleStringProperty( payment);
    }

    public Etudiant(int id_etudiant, String nom, String prenom, String date_naissance, int id_classe, String register_date, String payment) {
           this.id_etudiant = new SimpleIntegerProperty(id_etudiant);
        this.nom = new SimpleStringProperty(nom);
        this.prenom =new SimpleStringProperty( prenom);
        this.date_naissance = new SimpleStringProperty(date_naissance);
        this.id_classe =  new SimpleIntegerProperty(id_classe);
        this.register_date = new SimpleStringProperty(register_date);
        this.payment =new SimpleStringProperty( payment);
    
    
    }

    public int getId_etudiant() {
        return id_etudiant.get();
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = new SimpleIntegerProperty(id_etudiant);
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
        this.prenom = new SimpleStringProperty(prenom);
    }

    public String getDate_naissance() {
        return date_naissance.get();
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = new SimpleStringProperty(date_naissance);
    }

    public int getId_classe() {
        return id_classe.get();
    }

    public void setId_classe(int id_classe) {
        this.id_classe = new SimpleIntegerProperty(id_classe);
    }

    public String getClasse() {
        return classe.get();
    }

    public void setClasse(String category) {
        this.classe = new SimpleStringProperty(category);
    }

    public String getRegister_date() {
        return register_date.get();
    }

    public void setRegister_date(String register_date) {
        this.register_date = new SimpleStringProperty(register_date);
    }

    public String getPayment() {
        return payment.get();
    }

    public void setPayment(String payment) {
        this.payment =  new SimpleStringProperty(payment);
    }
    
    
    
    
}
