/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * @author aszab
 */
public class ViewController implements Initializable {
    //JavaFx Elemek Összekötése A Controller-rel//
        //Panes 
            @FXML
            private AnchorPane rootPane;
            @FXML
            private Pane settingsPane;
            @FXML
            private SplitPane gamePane;
            @FXML
            private Pane charterCreater;
        //Buttons
            //Main Menu Buttons
            @FXML
            private Button continueGameButton;
            @FXML
            private Button newGameButton;
            @FXML
            private Button settingsButton;
            @FXML
            private Button exitButton;
            //Elemek A Beállítások Menüpontból
            @FXML
            private Button backButton;
            //Charter Creater Buttons
            @FXML
            private Button STARTbutton;
        //Labels
            @FXML
            private Label label;
        //TextFields
            @FXML
            private TextField charterName;
            @FXML
            private TextField charterAge;
    
    
            //Főmenü Menüpontjainak Kezelése
    //Új Játék Kezdete
    @FXML
    private void newGame(ActionEvent event) {
            charterCreater.setVisible(true);
            System.out.println("Az Új Játék Sikeresen Elkezdődött");
    }
    @FXML
    private void realStart(ActionEvent event){
        charterCreater.setVisible(false);
        gamePane.setVisible(true);
    }
    
    //Meglévő Játék Folytatása
    @FXML
    private void continueGame(ActionEvent event) {
            gamePane.setVisible(true);
    }
    
    //Beállítások Menüpont Megnyitása
    @FXML
    public void openSettings(ActionEvent event) throws IOException {
        settingsPane.setVisible(true);
    }
    
    //Beállítások Menüpont Bezárása
    @FXML
    public void closeSettings(ActionEvent event) throws IOException {
        settingsPane.setVisible(false);
    }
    
    //KILÉPÉS A Programból
    @FXML
    private void closeApplication(ActionEvent event) {
        System.exit(0);
    }
    
    //Karakter Készítő Függvényei és Metódusai

    
    //Fő Játék Menüpontjai
        //VisszaLépés A Főmenübe
    @FXML
    private void backToHome(ActionEvent event){
        gamePane.setVisible(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
