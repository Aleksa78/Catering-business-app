/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Actions.OpenDrinksPanel;
import Actions.OpenLayout;
import Drinks.Alcohol;
import Drinks.Coffe;
import Drinks.Drink;
import Drinks.Juice;
import javafx.scene.image.Image;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import projekat.Projekat;
import javax.swing.JPanel;

/**
 *
 * @author Incognito
 */
public class DrinksPanel extends VBox {
   
   
     
    ObservableList<Drink> drinks = FXCollections.observableArrayList();
    
    private TableView<Drink> tabela;
    private Button izmeni;
    private Button dodaj;
    private Button obrisi;
    private Button nalozi;
    private HBox hbox;
    private Button nazad;
    
    public DrinksPanel() throws FileNotFoundException {

        setPadding(new Insets(15));
        setAlignment(Pos.CENTER);
        
        postaviElemente();

        this.getChildren().addAll( tabela, hbox, nazad);

    }

    private void postaviElemente() throws FileNotFoundException {
        
        
        TableColumn<Drink, String> tipColumn = new TableColumn<>("Tip");
        tipColumn.setMinWidth(180);
        tipColumn.setCellValueFactory(new PropertyValueFactory<>("tip"));

        TableColumn<Drink, String> nazivColumn = new TableColumn<>("Naziv");
        nazivColumn.setMinWidth(180);
        nazivColumn.setCellValueFactory(new PropertyValueFactory<>("naziv"));

        TableColumn<Drink, Double> cenaColumn = new TableColumn<>("Cena");
        cenaColumn.setMinWidth(180);
        cenaColumn.setCellValueFactory(new PropertyValueFactory<>("cena"));

        tabela = new TableView<>();
        ucitaj();
        tabela.setItems(drinks);
        tabela.getColumns().addAll(tipColumn, nazivColumn, cenaColumn);
        
        izmeni = new Button("Izmeni");
        dodaj = new Button("Dodaj");
        obrisi = new Button("Obrisi");
        nalozi = new Button("Nalozi");
        hbox = new HBox(izmeni, dodaj, nalozi, obrisi);
        nazad = new Button("Nazad");
        nazad.setOnAction(new OpenLayout());
        obrisi.setOnAction(e -> {
            Drink selectedItem = tabela.getSelectionModel().getSelectedItem();
            try {
                tabela.getItems().remove(selectedItem);
                izbaciArtikal(selectedItem);
                sacuvaj();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Fajl nije pronadjen");
            }
        });
        izmeni.setOnAction(new IzmeniGUI());
        dodaj.setOnAction(new DodajGUI());
        nalozi.setOnAction(new ZaposleniGUI());
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(15));
    }

    public TableView<Drink> getTabela() {
        return tabela;
    }

    public Button getIzmeni() {
        return izmeni;
    }

    public Button getDodaj() {
        return dodaj;
    }

    public Button getObrisi() {
        return obrisi;
    }

    public Button getNalozi() {
        return nalozi;
    }

    public ObservableList<Drink> getDrinks() {
        return drinks;
    }

    public void setTabela(TableView<Drink> tabela) {
        this.tabela = tabela;
    }

    public Drink getArtikal(int i) {
        return drinks.get(i);
    }

    public void setArtikal(Drink drink) {

    }

    public void izbaciArtikal(Drink drink) {
        drinks.remove(drink);
    }

    public int getBrojArtikala() {
        return drinks.size();
    }

    public void  ucitaj() throws FileNotFoundException {
        File datoteka = new File("Drinks.dat");
        Scanner scanner = new Scanner(datoteka);
        scanner.useDelimiter(";");

        while (scanner.hasNext()) {
            Drink drink = null;
            String tip = scanner.next();
            System.out.println(tip);
            String naziv = scanner.next();
            System.out.println(naziv);
            

            int cena = scanner.nextInt();
            System.out.println(cena);

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

    public void sacuvaj() throws FileNotFoundException {
        File datoteka = new File("Drinks.dat");
        PrintWriter output = new PrintWriter(datoteka);

        for (Drink artikal : drinks) {
            output.print(artikal.getTip());
            output.print(";");

            output.print(artikal.getNaziv());
            output.print(";");
            output.print(artikal.getCena());
            output.print(";");
        }

        output.close();
    }

}
