/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import GUI.DrinksPanel;
import GUI.Layout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 *
 * @author Incognito
 */
public class OpenLayout implements EventHandler<ActionEvent> {
    
     @Override
    public void handle(ActionEvent event) {
        String username = Controller.Controller.getInstance().getLogin().getTFusername().getText();
        String pass = Controller.Controller.getInstance().getLogin().getTFpass().getText();
       
        if (username.isEmpty() || pass.isEmpty()) {
            return;
    }else{
       
        
        
        
        
            try {
                BufferedReader reader;
                
                Scanner dat;
                Scanner dat2;
                
                dat = new Scanner(new File("Nalozi.dat"));
                dat2 = new Scanner(new File("Nalozi.dat"));
                
                reader = new BufferedReader(new FileReader("Nalozi.dat"));
                
                String line = reader.readLine();
                String line2 = reader.readLine();
                
                boolean isFound = false;
                boolean isFound2 = false;
                
                while(dat.hasNext()){
                    String linija = dat.nextLine();
                    String []podaci = linija.split(" ");
                    if (username.equals(podaci[0]) && pass.equals(podaci[1])) {
                        isFound = true;
                        isFound2 = true;
                        
                        break;
                    }
                }
                
                
                
                
                
                
                //This is End of File
                
                
                if(!isFound2 | !isFound){Controller.Controller.getInstance().getLogin().getErrorPass().setText("Wrong credentials!");
                Controller.Controller.getInstance().getLogin().getErrorPass().setTextFill(Color.RED);
                return;}
                
                
                
                //Not in file append it at the end of file
                
                if (isFound && isFound2) {
                    
                    Layout layout = new Layout();
                    Controller.Controller.getInstance().setLayout(layout);
                    
                    Scene ceneLayout = new Scene(layout, 300, 300);
                    Controller.Controller.getInstance().setSceneLayout(ceneLayout);
                    
                    
                    Controller.Controller.getInstance().getLayout().getLabel().setText("Ulogovani ste kao: " + Controller.Controller.getInstance().getLogin().getTFusername().getText());
                    if (username.equals("admin")) {
                        
                        Controller.Controller.getInstance().getLayout().getLogout().setVisible(true);
                    }
                    Controller.Controller.getInstance().getPrimaryStage().setScene(
                            Controller.Controller.getInstance().getSceneLayout()
                    )
                            ;}
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OpenLayout.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OpenLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
            
   
    }
        
        
    }
        
    }
    
    
    

   


