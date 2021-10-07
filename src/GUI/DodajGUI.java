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
import java.awt.BorderLayout;


import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Incognito
 */
public class DodajGUI implements EventHandler<ActionEvent>{
    private VBox vbox;
    private ComboBox<String> box;
    private Label naziv;
    private TextField nazivTf;
    private HBox nazivHb;
    private Label cena;
    private TextField cenaTf;
    private HBox cenaHb;
    private Button dodaj;
    
    
    @Override
    public void handle(ActionEvent event) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Controller.Controller.getInstance().getPrimaryStage());
        
        box = new ComboBox<>();
        box.getItems().addAll(Juice.TIP, Alcohol.TIP, Coffe.TIP);
        box.getSelectionModel().selectFirst();
        naziv = new Label("Naziv:");
        nazivTf = new TextField();
        nazivHb = new HBox(naziv, nazivTf);
        cena = new Label("Cena:");
        cenaTf = new TextField();
        cenaHb = new HBox(cena, cenaTf);
        dodaj = new Button("Dodaj");
        vbox = new VBox(20, box, nazivHb, cenaHb, dodaj);
         Scene dialogScene = new Scene(vbox, 300, 200);

        dialog.setScene(dialogScene);
        dialog.show();
    
        dodaj.setOnAction(e -> {
        Drink drink = null;
            
           
            String naziv = nazivTf.getText();
            int cena = Integer.parseInt(cenaTf.getText());
            int selection = box.getSelectionModel().getSelectedIndex();
            
            switch (selection) {
                case 0:
                    drink = new Juice(cena, naziv);
                    break;
                case 1:
                    drink = new Alcohol(cena, naziv);
                    break;
                case 2:
                    drink = new Coffe(cena, naziv);
                    break;
            }
            
           
            
            Controller.Controller.getInstance().getDrinksPanel().getDrinks().add(drink);
            
            
            Controller.Controller.getInstance().getDrinksPanel().getTabela().getColumns().get(0).setVisible(false);
            Controller.Controller.getInstance().getDrinksPanel().getTabela().getColumns().get(0).setVisible(true);
            
             try {
                Controller.Controller.getInstance().getDrinksPanel().sacuvaj();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IzmeniGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
    }

   

    
  
    }

