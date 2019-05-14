package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


import utils.ConnectionUtil;

public class User {
    
//    private SimpleIntegerProperty numUser;

    private SimpleIntegerProperty id_user;
    
    private SimpleIntegerProperty num;
    
    private SimpleStringProperty name;
    
    private SimpleStringProperty username;

    private SimpleStringProperty password;
 
    private SimpleStringProperty reg_date;

    
    private final Pattern hasUppercase = Pattern.compile("[A-Z]");
    
    private final Pattern hasLowercase = Pattern.compile("[a-z]");
            
    private final Pattern hasNumber = Pattern.compile("\\d");
             
    private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");    

     
    //sql variables
    Connection con = null;
    PreparedStatement st = null;
    String sql = null;
    ResultSet rs = null;
            

    
    public User(int id_user,String name,String username,String password,String reg_date){
        
        this.id_user =  new SimpleIntegerProperty(id_user);
        this.username =  new SimpleStringProperty(username);
        this.password =  new SimpleStringProperty(password);
        this.reg_date =  new SimpleStringProperty(reg_date);
        this.name = new SimpleStringProperty(name);
    }
    
    
     public User(String username,String password,String reg_date,int num){
        this.num =  new SimpleIntegerProperty(num);
        this.username =  new SimpleStringProperty(username);
        this.password =  new SimpleStringProperty(password);
        this.reg_date =  new SimpleStringProperty(reg_date);
       
    }
     

    
    public User(){
    }

    public int getId_user() {
        return id_user.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getReg_date() {
        return reg_date.get();
    }
    
    
  public void setId_user(int id_user) {
        this.id_user = new SimpleIntegerProperty(id_user);
}

    public void setUsername(String username) {
        this.username = new SimpleStringProperty(username);
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public int getNum() {
        return num.get();
    }

    public void setNum(int num) {
        this.num = new SimpleIntegerProperty(num);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name =  new SimpleStringProperty(name);
    }

   
    
    public void setReg_date(String reg_date) {
        this.reg_date = new SimpleStringProperty(reg_date);
    }

    public int validateNewPass(String pass1, String pass2) {
        if (pass1 == null || pass2 == null) {
            System.out.println("Passwords = null");
            return -1;
        }
        StringBuilder retVal = new StringBuilder();
        if (pass1.isEmpty() || pass2.isEmpty()) {
            if(pass1.isEmpty())
                return -2;
            return -9;
        }
        
        if (pass1.equals(pass2)) {
            System.out.println(pass1 + " = " + pass2);
            
            if (pass1.length() < 8) {
                System.out.println(pass1 + " is length < 8");
                return -3;
            }
            if (!hasUppercase.matcher(pass1).find()) {
                System.out.println(pass1 + " <-- needs uppercase");
                return -4;
            }
            if (!hasLowercase.matcher(pass1).find()) {
                System.out.println(pass1 + " <-- needs lowercase");
                return -5;
            }
            if (!hasNumber.matcher(pass1).find()) {
                System.out.println(pass1 + "<-- needs a number");
                return -6;
            }
            if (!hasSpecialChar.matcher(pass1).find()) {
                System.out.println(pass1 + "<-- needs a specail character");
                return -7;
            }
        } else {
            System.out.println(pass1 + " != " + pass2);
            return -8;
        }
        if (retVal.length() == 0) {
            
            System.out.println("Password validates");
            return 1;
        }
        
        return 1;
    }
  
  public String validateUsername(String username){
        try {
            if(username==null){
                System.out.println("username is null");
                return "null";
            }else 
            if(username.isEmpty()){
                return "empty";
            }else {
            con = ConnectionUtil.conDB();
            sql = "SELECT * FROM users WHERE username =?";
            st = con.prepareStatement(sql);
            st.setString(1, username);
            if(st.executeQuery().next())
            {
                return "exists";
            }
            else
            {
                return "Success";
            }
            }
        } catch (SQLException ex) {
            System.out.println("SQL ERROR :"+ex.getMessage());
        }finally{
        
        }
        return "";
  } 
  
  
   
}