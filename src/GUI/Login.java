/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Actions.OpenLayout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Incognito
 */
public class Login extends VBox{
   
    private Label username;
    private Label pass;
    private VBox labele;
    private Label errorUsername;
    private Label errorPass;
    private VBox errori;

   

    public TextField getTFusername() {
        return TFusername;
    }

    public TextField getTFpass() {
        return TFpass;
    }

    public Label getErrorUsername() {
        return errorUsername;
    }

    public Label getErrorPass() {
        return errorPass;
    }

    public void setErrorUsername(Label errorUsername) {
        this.errorUsername = errorUsername;
    }

    public void setErrorPass(Label errorPass) {
        this.errorPass = errorPass;
    }

 
    
    private TextField TFusername;
    private TextField TFpass;
    private VBox tf;
    
    private HBox HBforma;
    
    private Button login;
    
    public Login(){
    super(20);
        setPadding(new Insets(15));
        setAlignment(Pos.CENTER);

        postaviElemente();

        this.getChildren().addAll(HBforma, login);
    
    }
    private void postaviElemente(){
    
    username = new Label("Username:");
    pass = new Label("Password:");
    labele = new VBox(20, username, pass);
    
    TFusername = new TextField("");
    TFpass = new TextField("");
    tf = new VBox(20, TFusername, TFpass);
    
    
    
    errorUsername = new Label();
    errorPass = new Label();
    errori = new VBox(20, errorUsername, errorPass);
    
    HBforma = new HBox(20, labele, tf, errori);
    
    login = new Button("Login");
    login.setOnAction(new OpenLayout());
    }
}
