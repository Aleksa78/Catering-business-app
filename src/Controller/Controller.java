/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import GUI.DrinksPanel;
import GUI.IzmeniGUI;

import GUI.Layout;
import GUI.Login;
import GUI.Sto;
import GUI.ZaposleniGUI;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Incognito
 */
public class Controller {
    private static Controller onlyController = null;
    
    private Stage primaryStage;
    
    private Login login;
    private Scene sceneLogin;
    
    private ZaposleniGUI zaposleniGui;
    private Scene sceneZaposleniGui;
    
    private Layout layout;
    private Scene sceneLayout;
    
    private DrinksPanel drinksPanel;
    private Scene sceneDrinksPanel;
    
    private IzmeniGUI izmeniGui;
    private Scene sceneIzmeniGui;
    
    private Sto sto;
    private Scene sceneSto;
    
    private String trenutanBrojStola;
    
    
     public static Controller getInstance() {
        if (onlyController == null) { 
            onlyController = new Controller();
        }
        
        return onlyController;
    }



    public static void setOnlyController(Controller onlyController) {
        Controller.onlyController = onlyController;
    }

   

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Scene getSceneLogin() {
        return sceneLogin;
    }

    public void setSceneLogin(Scene sceneLogin) {
        this.sceneLogin = sceneLogin;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Scene getSceneLayout() {
        return sceneLayout;
    }

    public void setSceneLayout(Scene sceneLayout) {
        this.sceneLayout = sceneLayout;
    }

    public DrinksPanel getDrinksPanel() {
        return drinksPanel;
    }

    public void setDrinksPanel(DrinksPanel drinksPanel) {
        this.drinksPanel = drinksPanel;
    }

    public Scene getSceneDrinksPanel() {
        return sceneDrinksPanel;
    }

    public void setSceneDrinksPanel(Scene sceneDrinksPanel) {
        this.sceneDrinksPanel = sceneDrinksPanel;
    }

 

    public Scene getSceneIzmeniGui() {
        return sceneIzmeniGui;
    }

    public void setSceneIzmeniGui(Scene sceneIzmeniGui) {
        this.sceneIzmeniGui = sceneIzmeniGui;
    }

    public IzmeniGUI getIzmeniGui() {
        return izmeniGui;
    }

    public void setIzmeniGui(IzmeniGUI izmeniGui) {
        this.izmeniGui = izmeniGui;
    }

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    public Scene getSceneSto() {
        return sceneSto;
    }

    public void setSceneSto(Scene sceneSto) {
        this.sceneSto = sceneSto;
    }

    public String getTrenutanBrojStola() {
        return trenutanBrojStola;
    }

    public void setTrenutanBrojStola(String trenutanBrojStola) {
        this.trenutanBrojStola = trenutanBrojStola;
    }

    public ZaposleniGUI getZaposleniGui() {
        return zaposleniGui;
    }

    public void setZaposleniGui(ZaposleniGUI zaposleniGui) {
        this.zaposleniGui = zaposleniGui;
    }

    public Scene getSceneZaposleniGui() {
        return sceneZaposleniGui;
    }

    public void setSceneZaposleniGui(Scene sceneZaposleniGui) {
        this.sceneZaposleniGui = sceneZaposleniGui;
    }

   

    

     
     
}
