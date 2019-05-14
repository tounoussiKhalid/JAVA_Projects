
package controllers;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import forms.Login;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundFill;

import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import models.Category;
import models.Classe;
import models.Enseignant;
import models.Etudiant;
import models.Log;
import models.User;
import utils.ConnectionUtil;


 
public class DashboardController1 implements Initializable {
    
   static int currentIdUser = 1;
   static String name = "";

    
       @FXML
    private FontAwesomeIconView dashIcon;
    //charts
    
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    
    ObservableList<String> stateList = FXCollections.observableArrayList("functional","dysfunctional");
    
    ObservableList<Enseignant> data = null;
    
    ObservableList<Classe> listClass = null;
    
    ObservableList<User> listUser = null;
    
    ObservableList<Category> listCategory = null;
    
    ObservableList<Etudiant> listEtudiant = null; 
     
    ObservableList<Log> listOperation= null;
    
    DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

    //LOG 
    @FXML
    private TableView<Log> tblJournal;
    
     
    @FXML
    private TableColumn<Category, String> colIdOperation;
    
    @FXML
    private TableColumn<Category, Integer> colNumberOpe;
     
    @FXML
    private TableColumn<Category, String> colDateRegOpe;
      
    @FXML
    
    private TableColumn<Category, String> colOperation;
    
    @FXML
    private TableColumn<Category, Integer> colIdMaker;
    
    @FXML
    private TextField txtSearchJournal;    
    
    
    
    /////////////////
    @FXML 
    private Label usersNbr ;
    
    
     @FXML 
    private Label etudiantsNbr;
     
   
             @FXML 
    private Label coursNbr;
             
            @FXML 
    private Label  OperationsNbr;
             
    //USERS
    
    
    @FXML
    private TextField txtSearchUser;
    
    @FXML
    private Label  lblName;
   
    @FXML
    private TextField txtNameUser;
    
    @FXML
    private Label lblStatusUsers;        
            
    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPass1;

    @FXML
    private TextField txtPass2;

    @FXML
    private Button btnAddUser;

    @FXML
    private Button btnRemUser;

    @FXML
    private Button btnCleUser;

    @FXML
    private Button btnSaveUser;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPass;
    
     @FXML
    private Label lblPass2;
     
     

     //enseignants 
     
    @FXML
    private TextField txtNomEns;

    @FXML
    private TextField txtPreEns;

    @FXML
    private TextField txtNumTel;


    @FXML
    private DatePicker txtReg;
    
    
    @FXML
    private TableColumn<Enseignant,Integer> colIdEnseignant;

    @FXML
    private TableColumn<Enseignant, String> colNomEns;

    @FXML
    private TableColumn<Enseignant,String> colPrenomEns;

    @FXML
    private TableColumn<Enseignant,String> colNumTel;
    
    @FXML
    private TableColumn<Enseignant,String> ColRegDate;
    
    
   // @FXML
    //private TableColumn<User, Integer> colNum;

    @FXML
    private TableColumn<User,Integer>  colIdUser;
    
    @FXML
    private TableColumn<User, String> colName;  

    @FXML
    private TableColumn<User, String> colUsername;

    @FXML
    private TableColumn<User, String> colPassword;

    @FXML
    private TableColumn<User, String> ColRegDateUser;
    
    @FXML
    private TableColumn<User, Integer> colNumUser;
    
    @FXML
    private GridPane pnlEtudiants;
    
    @FXML
    private GridPane pnlClasses;
    
    @FXML
    private GridPane pnlEnseignants;

    @FXML
    private GridPane pnlUsers;

    @FXML
    private GridPane pnlDashboard;
    
    @FXML
    private GridPane pnlJournal;

    @FXML
    private GridPane pnlCategories;
    
    
    @FXML
    private Button btnRem;
    
    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnEnseignants;

    @FXML
    private Button btnEtudiants;

    @FXML
    private Button btnJournal;

    @FXML
    private Pane pnlStatus;

    @FXML
    private Label lblStatus;
    
    @FXML 
    private Button btnClose;
    
    @FXML
    private Button btnAddArticle;
    
    @FXML
    private TableView<Enseignant> tblEnseignants;
    
    @FXML
    private TableView<User> tblUsers;
    
     @FXML
    private TableView<Etudiant> tblEtudiant;
    
    @FXML
    private Label lblNomEns;

    @FXML
    private Label lblPreEns;

    @FXML
    private Label lblNumTel;

    @FXML
    private Label lblRegi;

     @FXML
    private Label statusEns;
     
     @FXML
    private TextField txtSearch;
    
     
     //Classess table
      @FXML
    private TableView<Classe> tblClasses;
     
    @FXML
    private TableColumn<Class, Integer> colIdClass;
     
    
    @FXML
    private TableColumn<Class, String> colLibClass;
    
      @FXML
    private TableColumn<Class, Integer> colNbrEtud;

    
    @FXML
    private TableColumn<Class, String> colDateRegClass; 
    
    @FXML
    private TextField txtLibelleClass;
    
    @FXML
    private Label lblClasse;
    
    @FXML
    private TextField txtSearchClass;
    
    
    @FXML
    private Label statusClass;
    
    @FXML
    private Button btnClass;
    
    @FXML
    private Button btnAddClass;
     @FXML
    private Button btnRemCl;
     @FXML
    private Button btnCleCl;
     @FXML
    private Button btnSaveCl;
     
     
    //sql variables
    Connection con = null;
     
    String sql = "";
    
    PreparedStatement st = null;
    
    ResultSet rs = null;
    
    
    //etudiant table:
    
    ArrayList modified_items = new ArrayList();
    
    
    @FXML
    private Label lblStatusEtud;
    
    
    ObservableList<String> payement = FXCollections.observableArrayList("payé","non payé");

     @FXML
    private TableColumn<Etudiant, Integer> colIdEtudi;

    @FXML
    private TableColumn<Etudiant, String> colNomEtud;

    @FXML
    private TableColumn<Etudiant, String> colPrenEtu;

    @FXML
    private TableColumn<Etudiant, String> colDateNaissEtu;

    @FXML
    private TableColumn<Etudiant, String> colClassEtu;

    @FXML
    private TableColumn<Etudiant, String> colRegDateEtu;

    @FXML
    private TableColumn<Etudiant, String> colPayment;

    @FXML
    private TextField txtSearchEtud;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private DatePicker date_naiss;

    @FXML
    private ComboBox<Classe> classe_id_cmb;

    @FXML
    private ChoiceBox<String> payment;

    @FXML
    private Button btnAddEtudiant;
    
    
    @FXML
    private Button btnCours;
    
    
    @FXML
    private Button btnRemEtu;

    @FXML
    private Button btnCleEtu;

    @FXML
    private Button btnSaveEtu;

    @FXML
    private Label lblNom;

    @FXML
    private Label lblPrenom;

    @FXML
    private Label lblDateNaiss;

    @FXML
    private Label lblClass;

    @FXML
    private Label lblPayment;
    
         @FXML 
    private void handleAddCours(ActionEvent event) throws SQLException{
        
    if(handleInputEtud()){
            sql = "INSERT INTO etudiant(prenom,nom,date_naissance,id_class,payment) VALUES(?,?,?,?,?) ";
           String Prenom = prenom.getText();
           String Nom = nom.getText() ;
           String date_naissance = txtNumTel.getText() ;           
            java.sql.Date Date_naiss  =java.sql.Date.valueOf(date_naiss.getValue());
            int id_class = classe_id_cmb.getValue().getId_class();
            String Payment = payment.getValue();
       try{

            st = con.prepareStatement(sql);

            st.setString(1,Prenom);
            st.setString(2,Nom);
            st.setDate(3,Date_naiss);
            st.setInt(4,id_class);
            st.setString(5,Payment);
            
            
            int i = st.executeUpdate();

                 if(i==1){
                    System.out.println("Data inserted successfully");
                    lblStatusEtud.setTextFill(Color.GREEN);
                    lblStatusEtud.setText("Data inserted Successfully"); 
                    
                    //adding too in the log table and Journal tableView
                    PreparedStatement st2 = con.prepareStatement("INSERT INTO log(id_maker, operation) VALUES(?,?)");
                    st2.setInt(1,currentIdUser);
                    st2.setString(2, "a ajouté un nouveau etudiant : "+Nom.toUpperCase()+" "+prenom);
                    
                    if(st2.executeUpdate()==1){
                        System.out.println("ligne inséré dans la table log");
                    }
                }else {
                     System.out.println("Error");
                     lblStatusEtud.setTextFill(Color.TOMATO);
                    lblStatusEtud.setText("Failed to insert");
                    
                 }
                
                loadDataEtudiant();
                loadDataClass();
                loadDataLog();
                addNbrDash();
           }catch(SQLException ex){
               System.out.println("SQL EXCEPTION FOUND :"+ex.getMessage());
           }
           finally{
               st.close();
           }
       }
      }
    
    @FXML
    public void ClearFieldsClass(ActionEvent event){
        
         txtLibelleClass.setText("");
         txtLibelleClass.requestFocus();
         
    }
    
        private void deleteClasse(Classe ar){    
        sql = "DELETE from Class where id_class=?";
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, ar.getId_class());
            
            st.executeUpdate();
            
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    @FXML
    public void handleDeleteClass(ActionEvent event){
        if(!data.isEmpty()){
            System.out.println("Button Delete clicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING,"Confirm", ButtonType.YES,ButtonType.CANCEL);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this item?\nthe deletion is irreversible");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            System.out.println(" Number of items "+data.size());
            if(deleteAlert.getResult()==ButtonType.YES){
                
                deleteClasse((Classe)tblClasses.getSelectionModel().getSelectedItem());
                                listClass.remove(tblClasses.getSelectionModel().getSelectedItem());
                tblClasses.getSelectionModel().clearSelection();
            }
            else {
                deleteAlert.close();
            }
        }
    }
    
    
     private void loadDataClass() {
        
        boolean found = false;
        listClass.clear();
        sql = "SELECT * FROM class ";
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+dateformat.format(rs.getDate(3)));
                int id_class = rs.getInt(1);
                // *******************this is below change to || String sql2 = "SELECT COUNT(*) FROM etudiant where id_class =?";||after creating ETUDIANT TABLE

                String sql2 = "SELECT COUNT(*) FROM class where id_class =?";
                PreparedStatement st2 = con.prepareCall(sql2);
                st2.setInt(1, id_class);
                ResultSet rs2 = st2.executeQuery();
                int nbrEtud =0;
                while(rs2.next()){
                   nbrEtud = rs2.getInt(1);
                }
                listClass.add(new Classe(rs.getInt(1),rs.getString("libelle_class"),nbrEtud,String.valueOf(rs.getDate(3))));                   

                found = true;
            }
            if(found == true) 
                tblClasses.setItems(listClass);
        } catch (SQLException ex) {
            System.out.println("SQL DATABASE ERROR "+ex.getMessage());
        } finally{
            try {
                st.close();
                 rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
 
    private boolean handleInputClass(){
        boolean mark = true;         
            if(handleOneTxtField(txtLibelleClass)){
                lblClasse.setTextFill(Color.TOMATO);
                lblNomEns.setText("* Required Field");
                mark = false;
                txtNomEns.requestFocus();
            }else if(!handleOneTxtField(txtNomEns)){
                 lblNomEns.setText("");
            };
            
        return mark;
    }
    
     
    @FXML 
    private void handleAddCLass(ActionEvent event){
    
            if(handleInputClass()){ 
            sql = "INSERT INTO class(libelle_class) VALUES(?)";
           String libelle_class = txtLibelleClass.getText();

                       
       try{

            st = con.prepareStatement(sql);

            st.setString(1,libelle_class);

            int i = st.executeUpdate();

                 if(i==1){
                    System.out.println("Data inserted successfully");
                    statusClass.setTextFill(Color.GREEN);
                    statusClass.setText("Data inserted Successfully"); 
                    
                     System.out.println("current id_user *** : "+currentIdUser);
                    //adding too in the log table and Journal tableView
                    PreparedStatement st2 = con.prepareStatement("INSERT INTO log(id_maker, operation) VALUES(?,?)");
                    st2.setInt(1,currentIdUser);
                    st2.setString(2, "a ajouté une nouvelle Classe  : "+libelle_class);
                    
                    if(st2.executeUpdate()==1){
                        System.out.println("ligne inséré dans la table log");
                    }
                }else {
                     System.out.println("Error");
                     statusClass.setTextFill(Color.TOMATO);
                    statusClass.setText("Failed to insert");
                    
                 }
                loadDataClass();
                loadDataLog();
                addNbrDash();
           }catch(SQLException ex){
               System.out.println("SQL EXCEPTION FOUND :"+ex.getMessage());
           }
           finally{
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DashboardController1.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
       }
        
        
    }
    
        
    @FXML
    private void handleClicks(ActionEvent event){
        
        if(event.getSource()==btnDashboard){
            lblStatus.setText("Dashboard");
            pnlDashboard.toFront();
            
        }else if(event.getSource()==btnUsers){
            lblStatus.setText("Users");
            pnlUsers.toFront();
            txtSearchUser.requestFocus();
            
        }else if(event.getSource()==btnEnseignants){
             lblStatus.setText("Enseignants");
            pnlEnseignants.toFront();
            txtSearch.requestFocus();
            
       
        }else if(event.getSource()==btnJournal){
             lblStatus.setText("Journal");
            pnlJournal.toFront();
            txtSearchJournal.requestFocus();
        } else if(event.getSource()==btnClass){
             lblStatus.setText("Classes");
            pnlClasses.toFront();
            txtSearchClass.requestFocus();
        }    else if(event.getSource()==btnEtudiants){
             lblStatus.setText("Etudiants");
            pnlEtudiants.toFront();
            txtSearchEtud.requestFocus();
        }  
    }
    
     private boolean handleOneAreaFiedl(TextArea t){
        boolean mark = true;
        if(t!=null&&!t.getText().isEmpty()){
            mark = false;
        }
        return mark;
    }
    
    private boolean handleOneTxtField(TextField t){
        boolean mark = true;
        if(t!=null&&!t.getText().isEmpty()){
            mark = false;
        }
        return mark;
    }
    
     private boolean handleTextBox(ChoiceBox t){
        boolean mark = true;
        if(t!=null&&t.getValue()!=null &&String.valueOf(t.getValue())!= ""){
            mark = false;
        }
        return mark;
    }
    
     private boolean handleTextComboBox(ComboBox t){
        boolean mark = true;
        if(t!=null&&t.getValue()!=null &&String.valueOf(t.getValue())!= ""){
            mark = false;
        }
        return mark;
    }
    private boolean handleInput(){
        boolean mark = true;
            
            if(handleOneTxtField(txtReg.getEditor())){
                lblRegi.setTextFill(Color.TOMATO);
                lblRegi.setText("* Required Field");
                mark = false;
                txtReg.requestFocus();
            }else if(!handleOneTxtField(txtReg.getEditor())){
                 lblRegi.setText("");
            }
            

            if(handleOneTxtField(txtNumTel)){
                lblNumTel.setTextFill(Color.TOMATO);
                lblNumTel.setText("* Required Field");
                mark = false;
                txtNumTel.requestFocus();
            }else if(!handleOneTxtField(txtNumTel)){
                 lblNumTel.setText("");
            };
            
              if(handleOneTxtField(txtPreEns)){
                lblPreEns.setTextFill(Color.TOMATO);
                lblPreEns.setText("* Required Field");
                mark = false;
                txtPreEns.requestFocus();
            }else if(!handleOneTxtField(txtPreEns)){
                 lblPreEns.setText("");
            };
            
            
            if(handleOneTxtField(txtNomEns)){
                lblNomEns.setTextFill(Color.TOMATO);
                lblNomEns.setText("* Required Field");
                mark = false;
                txtNomEns.requestFocus();
            }else if(!handleOneTxtField(txtNomEns)){
                 lblNomEns.setText("");
            };
            
        return mark;
    }
    
    @FXML 
    private void handleAddUsers(ActionEvent event) throws SQLException{
        User u = new User();
        //u.validateNewPass(txtPass1.getText(), txtPass2.getText());
        
        if(txtNameUser!=null&&txtUsername!=null&&txtPass1!=null&&txtPass2!=null)
        {  if(!handleOneTxtField(txtNameUser)&&u.validateUsername(txtUsername.getText())=="Success"&&u.validateNewPass(txtPass1.getText(), txtPass2.getText())==1){
                if(!handleOneTxtField(txtNameUser))
                    lblName.setText("");
                    
                if(u.validateUsername(txtUsername.getText())=="Success")
                     lblUsername.setText("");
                if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==1)
                    lblPass.setText(""); 
                con = ConnectionUtil.conDB();
                
                st = con.prepareStatement("INSERT INTO users(username,password,name) VALUES(?,?,?)");
                st.setString(1, txtUsername.getText());
                st.setString(2, txtPass1.getText());
                st.setString(3,txtNameUser.getText());
                
                
                
                
                if(st.executeUpdate()==1){
                    
                     //adding too in the log table and Journal tableView
                    PreparedStatement st2 = con.prepareStatement("INSERT INTO log(id_maker,operation) VALUES(?,?)");
                    st.setInt(1,currentIdUser);
                    st.setString(2, "a ajouté un nouveau utilisateur :"+txtNameUser.getText());
                    
                    //success
                    loadDataUsers();
                    lblStatusUsers.setTextFill(Color.GREEN);
                    lblStatusUsers.setText("User Added Successfully");
                    
                    addNbrDash();
               
                   
                }
            }else{
            
            
                if(handleOneTxtField(txtNameUser)){
                   setLabels(lblName,"*Name is required",-1);
                }
            
                if(u.validateUsername(txtUsername.getText())=="Success")
                     lblUsername.setText("");
                if(u.validateUsername(txtUsername.getText())=="exists")
                {
                    setLabels(lblUsername,"Username already exists!",-1);
                }else if(u.validateUsername(txtUsername.getText())=="empty")
                     setLabels(lblUsername,"*Username is required",-1);
                if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-1){
                    lblPass.setTextFill(Color.TOMATO);
                    lblPass.setText("One or both passwords are null");
                }else if(u.validateNewPass(txtPass1.getText(),txtPass2.getText())==-2||u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-9){
                    if(u.validateNewPass(txtPass1.getText(),txtPass2.getText())==-2){
                        lblPass.setTextFill(Color.TOMATO);
                        lblPass.setText("*Password is required");}
                    if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-9){
                        lblPass.setText("");
                        lblPass2.setTextFill(Color.TOMATO);
                        lblPass2.setText("*Password confirmation is required");}
                }else if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-8){
                    lblPass.setTextFill(Color.TOMATO);
                    lblPass2.setText("");
                     lblPass.setText( "Passwords don't match");

                }else if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-3){
                    lblPass.setTextFill(Color.TOMATO);
                    lblPass.setText("Needs 8 characters at least");
                }else if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-4){
                    lblPass.setTextFill(Color.TOMATO);
                    lblPass.setText("Password needs an upper case ");

                }else if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-5){
                                lblPass.setTextFill(Color.TOMATO);
                lblPass.setText("Password needs a lowercase ");

                }else if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-6){
                                lblPass.setTextFill(Color.TOMATO);
                lblPass.setText("Password needs a number ");
                }else if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==-7){
                      setLabels(lblPass,"Password needs a special character i.e. !,@,#, etc.  ",-1);
                      lblPass.setTextFill(Color.TOMATO);
                }else {
                     if(u.validateNewPass(txtPass1.getText(), txtPass2.getText())==1)
                    lblPass.setText("");
                     lblPass2.setText("");

                }
            
            }
        st.close();
    }else{
            if(txtUsername==null){
                lblUsername.setTextFill(Color.TOMATO); 
                lblUsername.setText("Username is required");
            }
            if(txtPass1==null){
                lblPass.setTextFill(Color.TOMATO); 
                lblPass.setText("Password is required");
            }
            if(txtPass2==null){
                lblPass2.setTextFill(Color.TOMATO); 
                 lblPass2.setText("Password is required");
            }
        }
    }
    
    
    //using flags
    //flag == -1 : error
    //flag = 0 means succes for lblStatusUsers
    //flag = 1 means success for lbl status textfields
    
    public void setLabels(Label id,String message,int flag){
        if(flag==1){
            id.setTextFill(Color.GREEN); 
            id.setText("");
        }else if(flag == -1) {
            id.setTextFill(Color.TOMATO); 
            id.setText(message);
        }
    }
    
    @FXML 
    private void handleSaveEtud(ActionEvent event) throws SQLException{
    
    }
    
    
    
    @FXML 
    private void handleClearEtud(ActionEvent event) throws SQLException{
        nom.setText("");
        prenom.setText("");
        date_naiss.setValue(null);
        classe_id_cmb.setValue(null);
        payment.setValue(null);
    
    }
    
    
            
         private void deleteEtudiant(Etudiant ar){    
        sql = "DELETE from etudiant where id_etudiant=?";
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, ar.getId_etudiant());
            
            st.executeUpdate();
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML 
    private void handleDeleteEtudiant(ActionEvent event) throws SQLException{
        
             if(!listUser.isEmpty()){
            System.out.println("Button Delete clicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING,"Confirm", ButtonType.YES,ButtonType.CANCEL);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this item?\nthe deletion is irreversible");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            System.out.println(" Number of items "+data.size());
            if(deleteAlert.getResult()==ButtonType.YES){
                
                deleteEtudiant((Etudiant)tblEtudiant.getSelectionModel().getSelectedItem());
                                listEtudiant.remove(tblEtudiant.getSelectionModel().getSelectedItem());
                tblEtudiant.getSelectionModel().clearSelection();
            }
            else {
                deleteAlert.close();
            }
        }
    
    }
    
    
     private boolean handleInputEtud(){
        boolean mark = true;
             if(handleTextBox(payment)){
                lblPayment.setTextFill(Color.TOMATO);
                lblPayment.setText("* Required Field");
                mark = false;
                payment.requestFocus();
            }else if(!handleTextBox(payment)){
                 lblPayment.setText("");
            }
         
            if(handleTextComboBox(classe_id_cmb)){
             lblClass.setTextFill(Color.TOMATO);
             lblClass.setText("* Required Field");
             mark = false;
             classe_id_cmb.requestFocus();
            }else if(!handleTextComboBox(classe_id_cmb)){
                 lblClass.setText("");
            };
            
             if(handleOneTxtField(date_naiss.getEditor())){
                 System.out.println("ici");
                lblDateNaiss.setTextFill(Color.TOMATO);
                lblDateNaiss.setText("* Required Field");
                mark = false;
                date_naiss.requestFocus();
            }else if(!handleOneTxtField(date_naiss.getEditor())){
                 lblDateNaiss.setText("");
            }
            
              if(handleOneTxtField(prenom)){
                lblPrenom.setTextFill(Color.TOMATO);
                lblPrenom.setText("* Required Field");
                mark = false;
                prenom.requestFocus();
            }else if(!handleOneTxtField(prenom)){
                 lblPrenom.setText("");
            };
            
            
            if(handleOneTxtField(nom)){
                lblNom.setTextFill(Color.TOMATO);
                lblNom.setText("* Required Field");
                mark = false;
                nom.requestFocus();
            }else if(!handleOneTxtField(nom)){
                 lblNom.setText("");
            };
            
        return mark;
    }
    
    
    
     @FXML 
    private void handleAddEtudiant(ActionEvent event) throws SQLException{
        
    if(handleInputEtud()){ 
            sql = "INSERT INTO etudiant(prenom,nom,date_naissance,id_class,payment) VALUES(?,?,?,?,?) ";
           String Prenom = prenom.getText();
           String Nom = nom.getText() ;
           String date_naissance = txtNumTel.getText() ;           
            java.sql.Date Date_naiss  =java.sql.Date.valueOf(date_naiss.getValue());
            int id_class = classe_id_cmb.getValue().getId_class();
            String Payment = payment.getValue();
       try{

            st = con.prepareStatement(sql);

            st.setString(1,Prenom);
            st.setString(2,Nom);
            st.setDate(3,Date_naiss);
            st.setInt(4,id_class);
            st.setString(5,Payment);
            
            
            int i = st.executeUpdate();

                 if(i==1){
                    System.out.println("Data inserted successfully");
                    lblStatusEtud.setTextFill(Color.GREEN);
                    lblStatusEtud.setText("Data inserted Successfully"); 
                    
                    //adding too in the log table and Journal tableView
                    PreparedStatement st2 = con.prepareStatement("INSERT INTO log(id_maker, operation) VALUES(?,?)");
                    st2.setInt(1,currentIdUser);
                    st2.setString(2, "a ajouté un nouveau etudiant : "+Nom.toUpperCase()+" "+prenom);
                    
                    if(st2.executeUpdate()==1){
                        System.out.println("ligne inséré dans la table log");
                    }
                }else {
                     System.out.println("Error");
                     lblStatusEtud.setTextFill(Color.TOMATO);
                    lblStatusEtud.setText("Failed to insert");
                    
                 }
                
                loadDataEtudiant();
                loadDataClass();
                loadDataLog();
           }catch(SQLException ex){
               
               System.out.println("SQL EXCEPTION FOUND :"+ex.getMessage());
           }
           finally{
               st.close();
           }
       }
      } 
            
            
    @FXML 
    private void handleDeleteUser(ActionEvent event) throws SQLException{
       
    }
    
    @FXML 
    private void ClearFieldsUser(ActionEvent event) throws SQLException{
        txtUsername.setText("");
        txtPass1.setText("");
        txtPass2.setText("");
    }
    
    @FXML 
    private void handleSaveUser(ActionEvent event) throws SQLException{
       
    }
    
    @FXML 
    private void handleAddEnseignants(ActionEvent event) throws SQLException{
        
    if(handleInput()){ 
            sql =  "INSERT INTO enseignant(prenom,nom,num_telephone,date_embauche) VALUES(?,?,?,?) ";
           String prenom = txtPreEns.getText();
           String nom = txtNomEns.getText() ;
           String num_telephone = txtNumTel.getText() ;
                       
            java.sql.Date regDate  =java.sql.Date.valueOf(txtReg.getValue());
       try{

            st = con.prepareStatement(sql);

            st.setString(1,prenom);
            st.setString(2,nom);
            st.setString(3, num_telephone);
            st.setDate(4,regDate);

            int i = st.executeUpdate();

                 if(i==1){
                    System.out.println("Data inserted successfully");
                    statusEns.setTextFill(Color.GREEN);
                    statusEns.setText("Data inserted Successfully"); 
                    
                     System.out.println("current id_user *** : "+currentIdUser);
                    //adding too in the log table and Journal tableView
                    PreparedStatement st2 = con.prepareStatement("INSERT INTO log(id_maker, operation) VALUES(?,?)");
                    st2.setInt(1,currentIdUser);
                    st2.setString(2, "a ajouté un nouveau Enseignant : "+nom.toUpperCase()+" "+prenom);
                    
                    if(st2.executeUpdate()==1){
                        System.out.println("ligne inséré dans la table log");
                    }
                }else {
                     System.out.println("Error");
                     statusEns.setTextFill(Color.TOMATO);
                    statusEns.setText("Failed to insert");
                    
                 }
                
                loadDataEnseignant();
                loadDataLog();
               addNbrDash();
                fillChart();
           }catch(SQLException ex){
               System.out.println("SQL EXCEPTION FOUND :"+ex.getMessage());
           }
           finally{
               st.close();
           }
       }
      } 
    
  
        
    public void handleClose(MouseEvent event){
        if(event.getSource()==btnClose){
            System.exit(0);
        }
    }
    
    
    


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                 
        con = ConnectionUtil.conDB();
        
        //charts
        fillChart() ;   
        
        // pnlStatus.setBackground(new BackgroundFill(new rgb(#9C9AA6), CornerRadii.EMPTY, Insets.EMPTY));

        
          txtSearch.textProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterEnseignantList((String)oldValue,(String)newValue);
            }  
        });
          
           txtSearchUser.textProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterUserList((String)oldValue,(String)newValue);
            }  
        });
           
         txtSearchEtud.textProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterEtudiantList((String)oldValue,(String)newValue);
            }  
        });
        
             txtSearchClass.textProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterClassList((String)oldValue,(String)newValue);
            }  
        });
  
           txtSearchJournal.textProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterJournalList((String)oldValue,(String)newValue);
            }  
        });
           

             
             
          
        data = FXCollections.observableArrayList();
        listClass = FXCollections.observableArrayList();
        listUser = FXCollections.observableArrayList();
        listCategory = FXCollections.observableArrayList();
        listOperation = FXCollections.observableArrayList();
        listEtudiant = FXCollections.observableArrayList();
        
        
        //Set All items Editable in our FX
        setEditable();
       
        
        //setValuesColumns
        setCellTable();
        
        //loadDataArticles from database to tableView of Article
        loadDataEnseignant();
        
        //loadDataUsers from database to tableView of users
        loadDataUsers();
        
        //loadDataUsers from database to tableView of log
        loadDataLog();
        ;
        //loadDataClass from database to tableView of class
        loadDataClass();
        
        //loadDataClass from database to tableView of class
        loadDataEtudiant();
        
        //load the comboBox that contains categories
        loadCombo();
        
        addNbrDash();
    }
    
    
    private void setEditable(){
        
         tblEnseignants.setEditable(true);
         tblUsers.setEditable(true);
         
         
         //edit commit : tblArticles
        // colCodeBare.setOnEditCommit(e->codebare_OnEditCommit(e));
         //colNomEns.setOnEditCommit(e->designation_OnEditCommit(e) );
         //col.setOnEditCommit(e->category__OnEditCommit(e));
         //ColQuantity.setOnEditCommit(e->quantity_OnEditCommit(e));
        // ColRegDate.setOnEditCommit(e->regdate_OnEditCommit(e));
         //ColState.setOnEditCommit(e->state_OnEditCommit(e));
         
         //edit commit : tblUsers
 /*        colPassword.setOnEditCommit(e->password_OnEditCommit(e));
         colUsername.setOnEditCommit(e->username_OnEditCommit(e));
         colName.setOnEditCommit(e->username_OnEditCommit(e));
        // add here  col for number
         
        //edit commit : tblCategories
        colCategory.setOnEditCommit(e->category__OnEditCommit(e));
        colDescription.setOnEditCommit(e->description_OnEditCommit(e));*/
        
        ///////////////////////////////////////////////////////////////////////////////
        // STYLE NEED TO ADD EDIT FOR LOG AND ACTIVATE FUNCTIONS FOR OTHER TABLES USERS AND CATEGORIES******************************************
        //////////////////////////////////////////////////////////////////
        
         //cellFactory Articles:
        // colCodeBare.setCellFactory(TextFieldTableCell.forTableColumn());
         colNomEns.setCellFactory(TextFieldTableCell.forTableColumn());
         colPrenomEns.setCellFactory(TextFieldTableCell.forTableColumn());
         colNumTel.setCellFactory(TextFieldTableCell.forTableColumn());
         ColRegDate.setCellFactory(TextFieldTableCell.forTableColumn());
         
         //cellFactory Users :
         //colNum.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
         //colIdUser.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
         colName.setCellFactory(TextFieldTableCell.forTableColumn());
         colUsername.setCellFactory(TextFieldTableCell.forTableColumn());
         colPassword.setCellFactory(TextFieldTableCell.forTableColumn());
         ColRegDateUser.setCellFactory(TextFieldTableCell.forTableColumn());    
         
         colLibClass.setCellFactory(TextFieldTableCell.forTableColumn()); 
         
         
         //etudiants
        colNomEtud.setCellFactory(TextFieldTableCell.forTableColumn());
        colPrenEtu.setCellFactory(TextFieldTableCell.forTableColumn());
        colPayment.setCellFactory(TextFieldTableCell.forTableColumn());
        colRegDateEtu.setCellFactory(TextFieldTableCell.forTableColumn());
        colDateNaissEtu.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    
    private void setCellTable(){
        
        //articles
        colIdEnseignant.setCellValueFactory(new PropertyValueFactory<>("id_enseignant"));
        colNomEns.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenomEns.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colNumTel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        ColRegDate.setCellValueFactory(new PropertyValueFactory<>("date_emb"));


        colIdEnseignant.setVisible(false);
        
        //users
        //colNum.setCellValueFactory(new PropertyValueFactory<>("numUser"));
         colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colIdUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        ColRegDateUser.setCellValueFactory(new PropertyValueFactory<>("reg_date"));
         
        colIdUser.setVisible(false);
        colNumUser.setVisible(false);
        
   
        
        //log
        
        colIdOperation.setCellValueFactory(new PropertyValueFactory<>("id_operation"));
        colOperation.setCellValueFactory(new PropertyValueFactory<>("operation"));
        colDateRegOpe.setCellValueFactory(new PropertyValueFactory<>("date_register"));
        colIdMaker.setCellValueFactory(new PropertyValueFactory<>("id_maker"));
        colNumberOpe.setCellValueFactory(new PropertyValueFactory<>("num"));
        
        colIdOperation.setVisible(false);
        colIdMaker.setVisible(false);
        
        
        //classes
        
        colIdClass.setCellValueFactory(new PropertyValueFactory<>("id_class"));
        colLibClass.setCellValueFactory(new PropertyValueFactory<>("libelle_class"));
        colDateRegClass.setCellValueFactory(new PropertyValueFactory<>("reg_date"));
        colNbrEtud.setCellValueFactory(new PropertyValueFactory<>("nbr_etud"));
        
        colIdClass.setVisible(false);         
        
        //Etudiant
        
        colIdEtudi.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
        colNomEtud.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenEtu.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colClassEtu.setCellValueFactory(new PropertyValueFactory<>("classe"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        colRegDateEtu.setCellValueFactory(new PropertyValueFactory<>("register_date"));
        colDateNaissEtu.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
        payment.setItems(payement);
        payment.getSelectionModel().select(0);
        colIdEtudi.setVisible(false);
        
       btnCours.setVisible(false);
    
    }
        
    private void loadDataEtudiant() {
        
        boolean found = false;
        listEtudiant.clear();
        sql = "SELECT * FROM etudiant e  LEFT OUTER JOIN class c  ON  e.id_class=c.id_class";
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getString(9)+" : "+String.valueOf(rs.getDate(7))+" "+rs.getString(6));
                
                listEtudiant.add(new Etudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(9),dateformat.format(rs.getDate(7)),rs.getString(6)));
                found = true;
            }
            if(found == true) 
                tblEtudiant.setItems(listEtudiant);
        } catch (SQLException ex) {
            System.out.println("SQL DATABASE ERROR "+ex.getMessage());
        } finally{
            try {
                st.close();
                 rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    @FXML
    private void logOut(ActionEvent event){
         Alert deleteAlert = new Alert(Alert.AlertType.WARNING,"Confirm", ButtonType.YES,ButtonType.CANCEL);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you Sure you want to logout?");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            if(deleteAlert.getResult()==ButtonType.YES){
                
               Stage st = (Stage)((Node) event.getSource()).getScene().getWindow();
               st.close();
               Login l = new Login();
            }
            else {
                deleteAlert.close();
            }
        
    }
    
    private void loadDataEnseignant() {
        
        System.out.println("id user ="+currentIdUser);
        
        boolean found = false;
        data.clear();
        sql = "SELECT * FROM enseignant";
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+dateformat.format(rs.getDate(5)));
                
                data.add(new Enseignant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),String.valueOf(rs.getDate(5))));
                found = true;
            }
            if(found == true) 
                tblEnseignants.setItems(data);
        } catch (SQLException ex) {
            System.out.println("SQL DATABASE ERROR "+ex.getMessage());
        } finally{
            try {
                st.close();
                 rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
        private void loadDataUsers() {
        boolean found = false;
        listUser.clear();
        sql = "SELECT * FROM users";
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
//            int i=0و
            while(rs.next()){
                System.out.println(" "+rs.getString("name")+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+dateformat.format(rs.getDate(4)));
                listUser.add(new User(rs.getInt(1),rs.getString("name"),rs.getString(2),rs.getString(3),dateformat.format(rs.getDate(4))));
                
                found = true;
            }
            if(found == true) 
                tblUsers.setItems(listUser);
        } catch (SQLException ex) {
            System.out.println("SQL DATABASE ERROR "+ex.getMessage());
        } finally{
            try {
                st.close();
                 rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
        
      private void loadDataLog() {
        boolean found = false;
        listOperation.clear();
        sql = "SELECT id_operation,id_maker,operation,date_register,name FROM log,users WHERE id_maker=id_user";
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            int i=0;
            while(rs.next()){
                System.out.println(++i+" "+rs.getInt("id_operation")+" "+rs.getInt(2)+" "+rs.getString(3)+" "+dateformat.format(rs.getDate(4)));
                String operation = rs.getString("name")+" "+rs.getString(3);
                listOperation.add(new Log(rs.getInt("id_operation"),i,operation,dateformat.format(rs.getDate(4)),rs.getInt(2)));
                found = true;
            }
            if(found == true) 
                tblJournal.setItems(listOperation);
        } catch (SQLException ex) {
            System.out.println("SQL DATABASE ERROR "+ex.getMessage());
        } finally{
            try {
                st.close();
                 rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }   
        
        
    @FXML
    public void ClearFields(ActionEvent event){

        txtNomEns.setText("");
        txtPreEns.setText("");
        txtNumTel.setText("");
        txtReg.setValue(null);
        txtNomEns.requestFocus();
        
    }
    
    
    @FXML
    private void filterEnseignantList(String oldVal,String newVal){
        
            ObservableList<Enseignant> obsList = FXCollections.observableArrayList();
            int i = 0;
            if(txtSearch == null||newVal.length()<oldVal.length()){
                tblEnseignants.setItems(data);
            }
            else {
                newVal = newVal.toUpperCase();
                for(Enseignant ar : tblEnseignants.getItems()){
                    i++;
                    String filtredNom = ar.getNom();
                    System.out.println("NewVal : "+newVal+" Filtred :"+ ar.getNom().toUpperCase()+ " : "+i);
                    String filtredPrenom = ar.getPrenom();
                    String filtredNumTel = ar.getNumTel();
                    String filtredRegDate = ar.getDate_emb();
                    if(filtredNom.toUpperCase().contains(newVal)||  filtredPrenom.toUpperCase().contains(newVal)|| filtredNumTel.toUpperCase().contains(newVal)|| filtredRegDate.toUpperCase().contains(newVal)){
                        obsList.add(ar);
                    }
                }
                tblEnseignants.setItems(obsList);
            }
    }
    
      @FXML
    private void filterUserList(String oldVal,String newVal){
        
            ObservableList<User> obsList = FXCollections.observableArrayList();
            if(txtSearchUser == null||newVal.length()<oldVal.length()){
                tblUsers.setItems(listUser);
            }
            else {
                newVal = newVal.toUpperCase();
                for(User us : tblUsers.getItems()){
                    String filtredName = us.getName();
                    String filtredUsername = us.getUsername();
                    String filtredPassword = us.getPassword();
                    String filtredRegDate = us.getReg_date();
                    if(filtredName.toUpperCase().contains(newVal) || filtredUsername.toUpperCase().contains(newVal)|| filtredPassword.contains(newVal)|| filtredRegDate.toUpperCase().contains(newVal)){
                        obsList.add(us);
                    }
                }
                tblUsers.setItems(obsList);
            }
    }
    
    
    @FXML
    private void filterEtudiantList(String oldVal,String newVal){
        
            ObservableList<Etudiant> obsList = FXCollections.observableArrayList();
            if(txtSearchEtud == null||newVal.length()<oldVal.length()){
                tblEtudiant.setItems(listEtudiant);
            }
            else {
                newVal = newVal.toUpperCase();
                for(Etudiant cat : tblEtudiant.getItems()){
                    String nom = cat.getNom();
                    String prenom = cat.getPrenom();
                    String date_naissance = cat.getDate_naissance();
                    String classe = cat.getClasse();
                    String regDate = cat.getRegister_date();
                    String payement = cat.getPayment();
                    
                    if(nom.toUpperCase().contains(newVal) || prenom.toUpperCase().contains(newVal)|| regDate.toUpperCase().contains(newVal)|| date_naissance.toUpperCase().contains(newVal) || classe.toUpperCase().contains(newVal) ||payement.toUpperCase().contains(newVal) ){
                        obsList.add(cat);
                    }
                }
                tblEtudiant.setItems(obsList);
            }
    }
    
         
    @FXML
    private void filterClassList(String oldVal,String newVal){
        
            ObservableList<Classe> obsList = FXCollections.observableArrayList();
            if(txtSearchClass == null||newVal.length()<oldVal.length()){
                tblClasses.setItems(listClass);
            }
            else {
                newVal = newVal.toUpperCase();
                for(Classe cat : tblClasses.getItems()){
                    String libele = cat.getLibelle_class();
                    String nbr_etud = String.valueOf(cat.getNbr_etud());
                    String date_creation = cat.getReg_date();
                    if(libele.toUpperCase().contains(newVal) || date_creation.toUpperCase().contains(newVal)|| nbr_etud.toUpperCase().contains(newVal) ){
                        obsList.add(cat);
                    }
                }
                tblClasses.setItems(obsList);
            }
    }        
            
     @FXML
    private void filterJournalList(String oldVal,String newVal){
        
            ObservableList<Log> obsList = FXCollections.observableArrayList();
            if(txtSearchJournal == null||newVal.length()<oldVal.length()){
                tblJournal.setItems(listOperation);
            }
            else {
                newVal = newVal.toUpperCase();
                for(Log cat : tblJournal.getItems()){
                    String Number = String.valueOf(cat.getNum());
                    String Operation = cat.getOperation();
                    String opeDate = cat.getDate_register();
                    if(Number.toUpperCase().contains(newVal) || Operation.toUpperCase().contains(newVal)|| opeDate.toUpperCase().contains(newVal) ){
                        obsList.add(cat);
                    }
                }
                tblJournal.setItems(obsList);
            }
    }
    
   /* @FXML
    void codebare_OnEditCommit(Event event) {
        
        TableColumn.CellEditEvent<Article,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Article,String>)event;
        Article article = cellEditEvent.getRowValue();
        article.setCode_bare(cellEditEvent.getNewValue());
    
    }*/
    /*
    @FXML
    void category__OnEditCommit(Event event) {
        TableColumn.CellEditEvent<Article,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Article,String>)event;
        Article article = cellEditEvent.getRowValue();
        article.setId_categorie(Integer.valueOf(cellEditEvent.getNewValue()));
    }

    
    @FXML
    void designation_OnEditCommit(Event event) {
         TableColumn.CellEditEvent<Article,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Article,String>)event;
        Article article = cellEditEvent.getRowValue();
        article.setDesignation(cellEditEvent.getNewValue());
    }
    
    
    @FXML
    void quantity_OnEditCommit(Event event) {
         TableColumn.CellEditEvent<Article,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Article,String>)event;
        Article article = cellEditEvent.getRowValue();
        article.setQuantite(Integer.valueOf(cellEditEvent.getNewValue()));
    }

    @FXML
    void regdate_OnEditCommit(Event event) {
        TableColumn.CellEditEvent<Article,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Article,String>)event;
        Article article = cellEditEvent.getRowValue();
        article.setDate_enreg(cellEditEvent.getNewValue());
    }

    @FXML
    void state_OnEditCommit(Event event) {
         TableColumn.CellEditEvent<Article,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Article,String>)event;
        Article article = cellEditEvent.getRowValue();
        article.setEtat(cellEditEvent.getNewValue());
    }
    
 */  
    
  /*  public void handleSaveEnseignant(ActionEvent event){
        
        String sql = "UPDATE enseignant set prenom=? ,nom=?,num_telephone=?,date_embauche=? WHERE id_enseignant=?";
       try {
           st = con.prepareStatement(sql);
           st.setString(1, sql);
           
           int i = st.executeUpdate();
           if(i>0){
               
           }

       } catch (SQLException ex) {
           Logger.getLogger(DashboardController1.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
        String sql = "DELETE FROM enseignant ";
        
    }
    */
    public void handleDeleteButton(ActionEvent event){
        if(!data.isEmpty()){
            System.out.println("Button Delete clicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING,"Confirm", ButtonType.YES,ButtonType.CANCEL);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this item?\nthe deletion is irreversible");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            System.out.println(" Number of items "+data.size());
            if(deleteAlert.getResult()==ButtonType.YES){
                
                deleteEnseignant((Enseignant)tblEnseignants.getSelectionModel().getSelectedItem());
                                data.remove(tblEnseignants.getSelectionModel().getSelectedItem());
                tblEnseignants.getSelectionModel().clearSelection();
            }
            else {
                deleteAlert.close();
            }
        }
    }
   
    
    private void deleteEnseignant(Enseignant ar){    
        sql = "DELETE from Enseignant where id_enseignant=?";
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, ar.getId_enseignant());
            
            st.executeUpdate();
            
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void loadCombo(){
        
        ObservableList<Classe> classe = FXCollections.observableArrayList();    
        
        sql = "SELECT * from class";     
        con=ConnectionUtil.conDB();
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                 classe.add(new Classe(rs.getInt(1),rs.getString(2)));
            }
            
        classe_id_cmb.setItems(classe);
        classe_id_cmb.getSelectionModel().select(0);
        
        classe_id_cmb.setConverter(new StringConverter<Classe>() {
        @Override
        public String toString(Classe object) {
            return object.getLibelle_class();
        }

        @Override
        public Classe fromString(String string) {
            return classe_id_cmb.getItems().stream().filter(ap -> 
                ap.getLibelle_class().equals(string)).findFirst().orElse(null);
        }
        });
       
        classe_id_cmb.valueProperty().addListener((obs, oldval, newval) -> {
        if(newval != null)
        System.out.println("Selected category: " + newval.getLibelle_class()
            + ". ID: " + newval.getId_class());
        });   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML
    private void password_OnEditCommit(Event event) {
        TableColumn.CellEditEvent<User,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User,String>)event;
        User user = cellEditEvent.getRowValue();
        user.setPassword(cellEditEvent.getNewValue());
        
    }
    
    @FXML
    private void username_OnEditCommit(Event event) {
        TableColumn.CellEditEvent<User,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User,String>)event;
        User user = cellEditEvent.getRowValue();
        user.setUsername(cellEditEvent.getNewValue());
         
        String sql = "UPDATE users set username=? WHERE id_user =?";
       try {
           st = con.prepareStatement(sql);
           st.setString(1, user.getUsername());
           st.setInt(2, user.getId_user());
           
           int i = st.executeUpdate();
           if(i>0){
               System.out.println("Username Modified Successfully");
               lblStatusUsers.setTextFill(Color.GREEN);
               lblStatusUsers.setText("Username Modified Successfully");
           }

       } catch (SQLException ex) {
           Logger.getLogger(DashboardController1.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    //edit functions for categories:
    
     @FXML
    private void category_OnEditCommit(Event event)
    {
        TableColumn.CellEditEvent<Category,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Category,String>)event;
        Category cat = cellEditEvent.getRowValue();
        cat.setCategory(cellEditEvent.getNewValue());
    }
    
      @FXML
    private void description_OnEditCommit(Event event) {
       TableColumn.CellEditEvent<Category,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Category,String>)event;
        Category cat = cellEditEvent.getRowValue();
        cat.setDescription(cellEditEvent.getNewValue());
    } 
    

    public  static void setIdUser(int currentId,String name){
        DashboardController1.currentIdUser =currentId;
        DashboardController1.name = name;
    }
    
    
    private void addNbrDash() {
       try {
           st = con.prepareCall("SELECT COUNT(*) FROM etudiant");
           rs =  st.executeQuery();
           while(rs.next()){
               usersNbr.setText(String.valueOf(rs.getInt(1)));
               
           }
           PreparedStatement st2 = con.prepareCall("SELECT COUNT(*) FROM log");
           ResultSet rs2 =  st2.executeQuery();
           while(rs2.next()){
               OperationsNbr.setText(String.valueOf(rs2.getInt(1)));
               
           }
           
           PreparedStatement st3 = con.prepareCall("SELECT COUNT(*) FROM cours");
           ResultSet rs3 =  st3.executeQuery();
           while(rs3.next()){
               coursNbr.setText(String.valueOf(rs3.getInt(1)));
               
           }
           
           PreparedStatement st4 = con.prepareCall("SELECT COUNT(*) FROM etudiant");
           ResultSet rs4 =  st4.executeQuery();
           while(rs4.next()){
               etudiantsNbr.setText(String.valueOf(rs4.getInt(1)));
               
           }
       } catch (SQLException ex) {
           Logger.getLogger(DashboardController1.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    
    private void fillChart() {
        
        XYChart.Series series = new XYChart.Series();
        PreparedStatement st3 = null;
        PreparedStatement st2 = null;
        
        String[] days = {"Mon","Tue","Wed","Thu","Fri","sat","Sun"};
            Date date =  new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int dys = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
            c.add(Calendar.DATE, -dys - 6);
            Date start = c.getTime();
            

        con = ConnectionUtil.conDB();
        
       
        try{
            
            st = con.prepareStatement("SELECT COUNT(*) FROM etudiant WHERE trunc(register_date)=?");
           
            for(int i =0;i<7;i++){
                
                st.setDate(1,new java.sql.Date( c.getTime().getTime()));
                
                rs = st.executeQuery();
                c.add(Calendar.DATE, 1);
                if(rs!=null){
                    while(rs.next()){
                    
                        System.out.println("rs1 = "+rs.getInt(1));
                          series.getData().add(new XYChart.Data(days[i], rs.getInt(1)));
                   
                    }
                }else{
                    series.getData().add(new XYChart.Data(days[i], 0));

                }

            }
           
        } catch(SQLException ex){
            System.out.println("SQLERROR "+ex.getMessage());
            
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DashboardController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         c.setTime(date);
         c.add(Calendar.DATE, -dys - 7);
          XYChart.Series series2 = new XYChart.Series();
         try{
        
             ResultSet rs2 = null;
             st2 = con.prepareStatement("SELECT COUNT(*) FROM LOG WHERE trunc(date_register)=?");
           
            
            for(int i =0;i<7;i++){
                st2.setDate(1,new java.sql.Date( c.getTime().getTime()));
                rs2 = st2.executeQuery();
                c.add(Calendar.DATE, 1);
                
                if(rs2!=null){
                    while(rs2.next()){
                                      System.out.println("rs2 = "+rs2.getInt(1));

                             series2.getData().add(new XYChart.Data(days[i], rs2.getInt(1)));
                   }
                }else{

                            series2.getData().add(new XYChart.Data(days[i], 0));
                }

            }
                c.setTime(date);
                c.add(Calendar.DATE, -dys - 6);
             }catch(SQLException ex){
            System.out.println("SQLERROR 2"+ex.getMessage());
            
        }finally{
            try {
                st2.close();
            } catch (SQLException ex) {
                Logger.getLogger(DashboardController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         XYChart.Series series3 = new XYChart.Series();
         try{    
             st3 = con.prepareStatement("SELECT COUNT(*) FROM class WHERE trunc(reg_date_class)=?");
            ResultSet rs3 = null;
            
            for(int i =0;i<7;i++){
                st3.setDate(1,new java.sql.Date( c.getTime().getTime()));
                System.out.println("days :  "+c.getTime());
                rs3 = st3.executeQuery();
                c.add(Calendar.DATE, 1);
                if(rs3!=null){
                    while(rs3.next()){
                            System.out.println("rs3 ="+rs3.getInt(1));
                             series3.getData().add(new XYChart.Data(days[i], rs3.getInt(1)));
                       }
                }else{
                            series3.getData().add(new XYChart.Data(days[i], 0));
                }
            }
         }catch(SQLException ex){
            System.out.println("SQLERROR 3"+ex.getMessage());
            
        }finally{
            try {

                st3.close();
            } catch (SQLException ex) {
                Logger.getLogger(DashboardController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        series.setName("Etudiants");
        series2.setName("Opérations");
        series3.setName("Classes");
        
        lineChart.getData().addAll(series,series2,series3);
       
    }}

