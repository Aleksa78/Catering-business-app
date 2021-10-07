/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Actions.Logout;
import Actions.OpenDrinksPanel;
import Actions.OpenLayout;
import Actions.OpenSto;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import projekat.Projekat;

/**
 *
 * @author Incognito
 */
public final class Layout extends VBox{
    private Label label;
    private Button Logout;
   private String brojStola3;
    private Label sto;
    private Button sto1;
    private Button sto2;
    private Button sto3;
    private Button sto4;
    private Button obrisi;
    private HBox red2;
    
    private Button sto5;
    private Button sto6;
    private Button sto7;
    private Button sto8;
    private HBox red3;
    private Button odjavi;
    public Layout() throws FileNotFoundException{
    super(20);
        setPadding(new Insets(15));
        setAlignment(Pos.CENTER);
        
        postaviElemente();

        this.getChildren().addAll(label, red2, red3, Logout, odjavi,obrisi);
    
    } 
    public void postaviElemente() throws FileNotFoundException{
    label = new Label();
    
    sto = new Label();
    obrisi = new Button("obrisi");
    sto1 = new Button("1");  
    
    sto2 = new Button("2");
    sto3 = new Button("3");
    sto4 = new Button("4");
    red2 = new HBox(20, sto1, sto2, sto3, sto4);
    
    sto5 = new Button("5");    
    sto6 = new Button("6");
    sto7 = new Button("7");
    sto8 = new Button("8");
    red3 = new HBox(20, sto5, sto6, sto7, sto8);
    Logout = new Button("Piće");
    Logout.setVisible(false);
    Logout.setOnAction(new OpenDrinksPanel());
    odjavi = new Button("Odjavi se");
    
            
    odjavi.setOnAction(new Logout());
   
    
    
    
    
    
    sto1.setOnAction(new OpenSto());
    sto2.setOnAction(new OpenSto());
    sto3.setOnAction(new OpenSto());
    sto4.setOnAction(new OpenSto());
    sto5.setOnAction(new OpenSto());
    sto6.setOnAction(new OpenSto());
    sto7.setOnAction(new OpenSto());
    sto8.setOnAction(new OpenSto());
    
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Button getLogout() {
        return Logout;
    }

    public Layout(String brojStola3) {
        this.brojStola3 = brojStola3;
    }

    public String getBrojStola3() {
        return brojStola3;
    }

    public void setBrojStola3(String brojStola3) {
        this.brojStola3 = brojStola3;
    }

    public Layout(Label sto) {
        this.sto = sto;
    }

    public Label getSto() {
        return sto;
    }

    public void setSto(Label sto) {
        this.sto = sto;
    }

    public void setLogout(Button Logout) {
        this.Logout = Logout;
    }

  
    
    

    public HBox getRed3() {
        return red3;
    }

    public void setRed3(HBox red3) {
        this.red3 = red3;
    }

    public HBox getRed2() {
        return red2;
    }

    public void setRed2(HBox red2) {
        this.red2 = red2;
    }

    public Button getSto1() {
        return sto1;
    }

    public Button getSto2() {
        return sto2;
    }

    public Button getSto3() {
        return sto3;
    }

    public Button getSto4() {
        return sto4;
    }

    public Button getSto5() {
        return sto5;
    }

    public Button getSto6() {
        return sto6;
    }

    public Button getSto7() {
        return sto7;
    }

    public Button getSto8() {
        return sto8;
    }
    
    
    
}
