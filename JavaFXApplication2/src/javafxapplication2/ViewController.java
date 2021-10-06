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
import javafx.scene.layout.AnchorPane;
/**
 * @author aszab
 */
public class ViewController implements Initializable {
    //JavaFx Elemek Összekötése A Controller-el//
        //Panes 
            @FXML
            private AnchorPane rootPane;
        //Buttons
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
        //Labels
            @FXML
            private Label label;
    
    
    //Új Játék Kezdete
    @FXML
    private void newGame(ActionEvent event) {
        try {
            System.out.println("Az Új Játék Sikeresen Elkezdődött");
        } catch (Exception e) {
            System.out.println(" "+ System.err);
        }
    }
    //Meglévő Játék Folytatása
    @FXML
    private void continueGame(ActionEvent event) {
        try {
            System.out.println("Játék Folytatása ...");
        } catch (Exception e) {
            System.out.println(" "+ System.err);
        }
    }
    //Beállítások Menüpont Megnyitása
    @FXML
    public void openSettings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(root);

    }
    
    //KILÉPÉS A Programból
    @FXML
    private void closeApplication(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
