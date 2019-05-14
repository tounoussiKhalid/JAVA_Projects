package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.ConnectionUtil;
/**
 *
 * @author oXCToo
 */
public class LoginController implements Initializable {

    @FXML
    private Label lblErrors;
    
    private int id_user;
    private String username;
    private String password;
    private String name ="";

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignin;

    /// -- 
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btnSignin) {
            //login here
            if (logIn().equals("Success")) {
                try {

                    Thread.sleep(2000);
                    
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Dashboard_1.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                } catch (InterruptedException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
    }

    public LoginController() {
        con = ConnectionUtil.conDB();

    }

    //we gonna use string to check for status
    private String logIn() {

         username = txtUsername.getText();
         password = txtPassword.getText();

        //query
         String sql = "SELECT * FROM users Where username = ? and password = ?";

        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                sql = "SELECT * FROM users Where username = ?";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()){
                    lblErrors.setTextFill(Color.TOMATO);
                lblErrors.setText("Enter Correct Username");
                System.err.println("Wrong Username --///");
                return "ErrorL";
                }else {
                lblErrors.setTextFill(Color.TOMATO);
                lblErrors.setText("Enter Correct Password");
                System.err.println("Wrong Password --///");
                return "ErrorLP";
                    
                    
                }
                
            } else {
                DashboardController1 d = new DashboardController1();
                lblErrors.setTextFill(Color.GREEN);
                id_user = resultSet.getInt(1);
                username = resultSet.getString(2);
                password = resultSet.getString(3);
                System.out.println("id_user = "+id_user);
                this.name = resultSet.getString("name");                
                this.id_user = id_user;
                DashboardController1.setIdUser(id_user,name);
                lblErrors.setText("Login Successful..Redirecting..");
                System.out.println("Successfull Login");
                return "Success";
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        } finally{
             try {
                 preparedStatement.close();
             } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
             }
        }
    }
    
    public int getIdUser(){
        return id_user;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }

}
