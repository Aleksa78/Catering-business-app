/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Actions.OpenDrinksPanel;
import Drinks.Drink;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import zaposleni.Zaposleni;

/**
 *
 * @author Incognito
 */
public class ZaposleniGUI  implements EventHandler<ActionEvent> {
    private ListView<Zaposleni> zaposleni;
    ObservableList<Zaposleni> lista = FXCollections.observableArrayList();
    private HBox dugmici;
    private Button dodaj;
    private Button obrisi;
    private Label username;
    private TextField usernameTf;
    private TextField passTf;
    private Label pass;
    private Button dodaj2;
    private HBox hbox1;
    private HBox hbox2;
    private VBox vbox;
    
    @Override
    public void handle(ActionEvent event) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Controller.Controller.getInstance().getPrimaryStage());
        
        zaposleni = new ListView<>();
        try {
            ucitajizFajla();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ZaposleniGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        dodaj = new Button("Dodaj");
        obrisi = new Button("Obrisi");
        username = new Label("Ime:");
        username.setVisible(false);
        pass = new Label("Sifra:");
        pass.setVisible(false);
        usernameTf = new TextField();
        usernameTf.setVisible(false);
        
        passTf = new TextField();
        passTf.setVisible(false);
        dodaj2 = new Button("Dodaj");
        dodaj2.setVisible(false);
        hbox1 = new HBox(20,username, usernameTf);
        hbox2 = new HBox(20, pass, passTf, dodaj2);
        dugmici = new HBox(20, dodaj, obrisi);
        vbox = new VBox(20, zaposleni, dugmici, hbox1, hbox2);
        vbox.setSpacing(20);
        obrisi.setOnAction(e-> {
        
        Zaposleni d = zaposleni.getSelectionModel().getSelectedItem();
        
        zaposleni.getItems().remove(d);
        lista.remove(d);
            try {
                sacuvaj();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ZaposleniGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        dodaj.setOnAction(e->{
        username.setVisible(true);
        pass.setVisible(true);
        usernameTf.setVisible(true);
        passTf.setVisible(true);
        dodaj2.setVisible(true);
            if (dodaj.isPressed()) {
                 username.setVisible(false);
        pass.setVisible(false);
        usernameTf.setVisible(false);
        passTf.setVisible(false);
        dodaj2.setVisible(false);
            }
        });
        dodaj2.setOnAction(e->{
       Zaposleni d = new Zaposleni(usernameTf.getText(), passTf.getText());
       zaposleni.getItems().add(d);
       
            try {
                sacuvaj();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ZaposleniGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            username.setVisible(false);
        pass.setVisible(false);
        usernameTf.setVisible(false);
        passTf.setVisible(false);
        dodaj2.setVisible(false);
        });
        
        
        
        Scene dialogScene = new Scene(vbox, 400, 300);

        dialog.setScene(dialogScene);
        dialog.show();
        
        
    }
    
    public void sacuvaj() throws FileNotFoundException {
        File datoteka = new File("Nalozi.dat");
        PrintWriter output = new PrintWriter(datoteka);

        lista = zaposleni.getItems();
        for (Zaposleni p : lista) {
            output.print(p);
            output.print("\n");

        }
        
        output.close();
    }
    
    private void ucitajizFajla() throws FileNotFoundException{
       
    
    Scanner dat = new Scanner(new File("Nalozi.dat"));
            while(dat.hasNext()){
                String linija = dat.nextLine();
                String []podaci = linija.split(" ");
                Zaposleni zap = new Zaposleni(podaci[0],podaci[1]);
                zap.toString();
                zaposleni.getItems().add(zap);
                lista.add(zap);
            }
            
            
    }
}
