/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Controller.Controller;
import GUI.DrinksPanel;
import GUI.Layout;
import GUI.Login;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 *
 * @author Incognito
 */
public class Logout implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        
     
            
       Login login = new Login();
                Controller.getInstance().setLogin(login);

                Scene sceneLogin = new Scene(login, 300, 300);
                Controller.getInstance().setSceneLayout(sceneLogin);
             Controller.getInstance().getPrimaryStage().setScene(
                    Controller.getInstance().getSceneLayout());
    }
    
}
