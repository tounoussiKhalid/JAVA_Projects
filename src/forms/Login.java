package forms;

import java.io.IOException;
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


public class Login extends Application{
      //define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;
    public Login(){
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hideWindow(){
        this.hideWindow();
    }
    
    public void ShowWindow(){
        this.ShowWindow();
    }
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
         Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
//we gonna remove the borderless thingie.  
        stage.initStyle(StageStyle.DECORATED);
        stage.setMaximized(false);
        //grab your root here
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void launch(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}