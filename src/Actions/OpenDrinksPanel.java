/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import GUI.DrinksPanel;
import GUI.Layout;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 *
 * @author Incognito
 */
public class OpenDrinksPanel implements EventHandler<ActionEvent> {

    

    @Override
    public void handle(ActionEvent event) {
         
       
            
        try {
            
            DrinksPanel drinksPanel = new DrinksPanel();
            
            Controller.Controller.getInstance().setDrinksPanel(drinksPanel);
            
            Scene sceneDrinksPanel = new Scene(drinksPanel, 600, 500);
            Controller.Controller.getInstance().setSceneLayout(sceneDrinksPanel);
            
            
            
            
            Controller.Controller.getInstance().getPrimaryStage().setScene(
                    Controller.Controller.getInstance().getSceneLayout()
            )
                    ;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OpenDrinksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}}
    

    

