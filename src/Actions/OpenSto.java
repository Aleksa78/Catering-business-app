/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import GUI.Sto;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 *
 * @author Incognito
 */
public class OpenSto implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent event) {
        
        try {
            
            Button x = (Button) event.getSource();
           
            Globals.a = Integer.parseInt(x.getText());
            System.out.println(Globals.a+" handle");
            
            
            Sto sto = new Sto();

            Controller.Controller.getInstance().setSto(sto);

            Scene stoScene = new Scene(sto, 800, 600);

            Controller.Controller.getInstance().setSceneSto(stoScene);

            Controller.Controller.getInstance().getPrimaryStage().setScene(
                    Controller.Controller.getInstance().getSceneSto()
            );

            sto.brojStola.setText(x.getText());
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OpenDrinksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
}
