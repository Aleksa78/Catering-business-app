/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Actions.Globals;
import Actions.OpenDrinksPanel;
import Actions.OpenLayout;
import Drinks.Alcohol;
import Drinks.Coffe;
import Drinks.Drink;
import Drinks.Juice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Incognito
 */
public class Sto extends VBox {
public Label brojStola = new Label("");

    
    
    

    
    
    ObservableList<Drink> drinks = FXCollections.observableArrayList();
    ObservableList<String> pice = FXCollections.observableArrayList();
    private TableView<Drink> tabela;
    private Button dodaj;
    private ListView<String> izabrano;
    private HBox hbox1;
    private Button obrisi;
    private Button nazad;
    private Label label;
    private TextField tf;
    private HBox hbox2;
    private VBox vbox;
    private Button sacuvaj;

    public Sto() throws FileNotFoundException {

        setPadding(new Insets(15));
        setAlignment(Pos.CENTER);
        postaviElemente();
        hbox1.setAlignment(Pos.CENTER);
        this.getChildren().addAll(brojStola, hbox1);

    }

    private void postaviElemente() throws FileNotFoundException {
        
        label = new Label();
        brojStola.setTextFill(Color.RED);
      
        TableColumn<Drink, String> tipColumn = new TableColumn<>("Tip");
        tipColumn.setMinWidth(120);
        tipColumn.setCellValueFactory(new PropertyValueFactory<>("tip"));

        TableColumn<Drink, String> nazivColumn = new TableColumn<>("Naziv");
        nazivColumn.setMinWidth(120);
        nazivColumn.setCellValueFactory(new PropertyValueFactory<>("naziv"));

        TableColumn<Drink, Double> cenaColumn = new TableColumn<>("Cena");
        cenaColumn.setMinWidth(120);
        cenaColumn.setCellValueFactory(new PropertyValueFactory<>("cena"));

        tabela = new TableView<>();
        ucitaj();
        tabela.setItems(drinks);
        tabela.getColumns().addAll(tipColumn, nazivColumn, cenaColumn);
        izabrano = new ListView<>();
        
            
         pice.clear();
        izabrano.getItems().clear();
       
        ucitajListu();
        
        
        izabrano.setItems(pice);
        dodaj = new Button("Dodaj");
        obrisi = new Button("Obrisi");
        nazad = new Button("Nazad");
        label = new Label("Racun:");
        tf = new TextField();
        tf.setText("");
        sacuvaj = new Button("Sacuvaj");
        hbox2 = new HBox(20, label, tf);
        vbox = new VBox(20, izabrano, hbox2, obrisi, nazad, sacuvaj);
        hbox1 = new HBox(20, tabela, dodaj, vbox);

        

        dodaj.setOnAction(e -> {
            Drink d = tabela.getSelectionModel().getSelectedItem();
            String ds = d.getNaziv()+(", ")+d.getCena()+("\n");
            
            izabrano.getItems().add(ds);
            
            int cena = Integer.parseInt(tf.getText());

            tf.setText(cena + d.getCena() + "");

        });

        obrisi.setOnAction(e -> {
            pice.clear();
            izabrano.getItems().clear();
            tf.setText("0");
            PrintWriter writer = null;
        try {
            writer = new PrintWriter(Globals.a+ ".dat");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Layout.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }

        });

        sacuvaj.setOnAction(e -> {
            try {
                sacuvaj();
                sacuvajCenu();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Sto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
        
        nazad.setOnAction(new OpenLayout());
       
       

    }

    public void ucitaj() throws FileNotFoundException {

        File datoteka = new File("Drinks.dat");

        // String trenutanBrojStola = "1";
        //File brojStola = new File(trenutanBrojStola + ".dat");
        //Scanner skenerArtikla = new Scanner(brojStola);
        //Scanner skenerPodatkaOArtiklu = new Scanner(brojStola);
        //skenerArtikla.useDelimiter(":");
        // mozda i neki delimiter po zarezu
        //skenerPodatkaOArtiklu.useDelimiter(";");
        Scanner scanner = new Scanner(datoteka);
        scanner.useDelimiter(";");

        while (scanner.hasNext()) {
            Drink drink = null;
            String tip = scanner.next();
            
            String naziv = scanner.next();

            

            int cena = scanner.nextInt();
            

            switch (tip) {
                case Alcohol.TIP:
                    drink = new Alcohol(cena, naziv);
                    break;
                case Coffe.TIP:
                    drink = new Coffe(cena, naziv);
                    break;
                case Juice.TIP:
                    drink = new Juice(cena, naziv);
                    break;
            }

            drinks.add(drink);

        }

    }

    public ObservableList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ObservableList<Drink> drinks) {
        this.drinks = drinks;
    }

    public TableView<Drink> getTabela() {
        return tabela;
    }

    public void setTabela(TableView<Drink> tabela) {
        this.tabela = tabela;
    }

    public Button getDodaj() {
        return dodaj;
    }

    public void setDodaj(Button dodaj) {
        this.dodaj = dodaj;
    }

  

    public Button getObrisi() {
        return obrisi;
    }

    public void setObrisi(Button obrisi) {
        this.obrisi = obrisi;
    }

    public TextField getTf() {
        return tf;
    }

    public void setTf(TextField tf) {
        this.tf = tf;
    }

    public void sacuvaj() throws FileNotFoundException {
        File datoteka = new File(Globals.a+ ".dat");
        PrintWriter output = new PrintWriter(datoteka);

        pice = izabrano.getItems();
        for (String p : pice) {
            output.print(p);
            
       

        }
        
        output.close();
    }

   
    public String sacuvajCenu(){
    String cena = tf.getText();
    return cena;
    }
    
    public void ucitajListu() throws FileNotFoundException {
        System.out.println(Globals.a+" metoda");
        if (Globals.a > 0) {
             File datoteka = new File(Globals.a+ ".dat");
        Scanner scanner = new Scanner(datoteka);
        scanner.useDelimiter("\n");
        
        while (scanner.hasNext()) {
            
            String naziv = scanner.next();
            pice.add(naziv);
        
            
           
            
            

            

            

        }

    }

    }

   
}


