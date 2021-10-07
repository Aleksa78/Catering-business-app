/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Drinks.Alcohol;
import Drinks.Coffe;
import Drinks.Drink;
import Drinks.Juice;
import java.awt.AWTEventMulticaster;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JComboBox;

/**
 *
 * @author Incognito
 */
public class IzmeniGUI implements EventHandler<ActionEvent> {
    
   
  
   private Label naziv;
   private TextField nazivTF;
   private HBox nazivHb;
   private Label cena;
   private TextField cenaTf;
   private HBox cenaHb;
   private Button izmeni;
   private VBox glavni;
    @Override
    public void handle(ActionEvent event) {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Controller.Controller.getInstance().getPrimaryStage());
         
        naziv = new Label("Naziv:");
       nazivTF = new TextField("");
         nazivHb = new HBox(20, naziv, nazivTF);
         cena = new Label("Cena:");
         cenaTf = new TextField("");
        cenaHb = new HBox(20, cena, cenaTf);
       izmeni = new Button("Izmeni");
       glavni = new VBox(20, nazivHb, cenaHb, izmeni);

        Scene dialogScene = new Scene(glavni, 300, 200);

        dialog.setScene(dialogScene);
        dialog.show();
        
        
        
        
       izmeni.setOnAction(e -> {
           Drink izabraniRed = Controller.Controller.getInstance().getDrinksPanel().getTabela().getSelectionModel().getSelectedItem();
           int cena = Integer.parseInt(cenaTf.getText());
           izabraniRed.setCena(cena);
           String naziv = nazivTF.getText();
           izabraniRed.setNaziv(naziv);
           
            try {
                Controller.Controller.getInstance().getDrinksPanel().sacuvaj();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IzmeniGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            Controller.Controller.getInstance().getDrinksPanel().getTabela().getColumns().get(0).setVisible(false);
            Controller.Controller.getInstance().getDrinksPanel().getTabela().getColumns().get(0).setVisible(true);
   });

        

    }

}
