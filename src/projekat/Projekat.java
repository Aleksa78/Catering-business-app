/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat;

import Controller.Controller;
import GUI.Login;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;


/**
 *
 * @author Incognito
 */
public class Projekat extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         
        Controller.getInstance().setPrimaryStage(primaryStage);
        Login login = new Login();
        Controller.getInstance().setLogin(login);
        Scene sceneLogin = new Scene(login, 400, 250);
        Controller.getInstance().setSceneLogin(sceneLogin);
        
        
        
        primaryStage.setTitle("Caffe");
        primaryStage.setScene(sceneLogin);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
