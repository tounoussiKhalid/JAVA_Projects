/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import forms.Login;
import forms.Splash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author oXCToo
 */
public class Main extends Application {

    //define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public  void start(Stage stage) throws Exception {
        int i = 0;
        Splash sp = new Splash();
        
        sp.setLocationRelativeTo(null);
        
        sp.setVisible(true);
        
           try {
                for( i =0;i<=100;i++){
                    Thread.sleep(40);
                    sp.pourcentage.setText(Integer.toString(i)+"%");
                }
                if(i==101){
                    sp.pourcentage.setVisible(false);
                    Login l = new Login();
                    sp.dispose();
                }   
            } catch (InterruptedException ex) {
                    Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    public static void main(String[] args) {
            launch(args);
    }

}
