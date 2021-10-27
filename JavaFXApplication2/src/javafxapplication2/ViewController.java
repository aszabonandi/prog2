/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author aszab
 */
public class ViewController implements Initializable {

    //OsztályVáltozók
    Character maincharter = new Character();
    Hahu hahu = new Hahu();
    boolean hahuOpened = false;
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
    @FXML
    private Pane hahuPane;

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
    private Label chartacterNameLabel;
    @FXML
    private Label showName;
    @FXML
    private Label showMoney;
    @FXML
    private Label showHappiness;
    @FXML
    private Label showRespect;
    @FXML
    private Label noNameLabel;
    //HahuOfferLabels
    @FXML
    private Pane poorPopUp;
    @FXML
    private Pane hahuCarPane11;
    @FXML
    private Pane hahuCarPane111;
    @FXML
    private Pane hahuCarPane1111;
    @FXML
    private Label hahuCarName11;
    @FXML
    private Label hahuCarName111;
    @FXML
    private Label hahuCarName1111;
    @FXML
    private Label hahuCarPaintJob11;
    @FXML
    private Label hahuCarPaintJob111;
    @FXML
    private Label hahuCarPaintJob1111;
    @FXML
    private Label hahuCarRust11;
    @FXML
    private Label hahuCarRust111;
    @FXML
    private Label hahuCarRust1111;
    @FXML
    private Label hahuCarCondition11;
    @FXML
    private Label hahuCarCondition111;
    @FXML
    private Label hahuCarCondition1111;
    @FXML
    private Label hahuCarPrice11;
    @FXML
    private Label hahuCarPrice111;
    @FXML
    private Label hahuCarPrice1111;
    //HahuOfferButtons

    //Hahu Offer Images
    @FXML
    private ImageView hahuCarImage11;
    @FXML
    private ImageView hahuCarImage111;
    @FXML
    private ImageView hahuCarImage1111;
    //popUp Button
    @FXML
    private Button poorButton;
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

    //Meglévő Játék Folytatása
    @FXML
    private void continueGame(ActionEvent event) throws FileNotFoundException {
        loadGame();
        charterCreater.setVisible(false);
        gamePane.setVisible(true);
        showName.setText(maincharter.getName());
        showMoney.setText("Píz: " + maincharter.getMoney() + " Ft");
        showHappiness.setText("Boldogság: " + maincharter.getHappiness() + " %");
        showRespect.setText("Tiszteletreméltóságosság: " + maincharter.getRespect() + " 8)");
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
    @FXML
    private void realStart(ActionEvent event) throws IOException {
        noNameLabel.setVisible(false);
        if (charterName.getText().equals("")) {
            noNameLabel.setVisible(true);
        } else {
            charterCreater.setVisible(false);
            gamePane.setVisible(true);
            maincharter.setName(charterName.getText());
            saveGame();
            showName.setText(maincharter.getName());
            showMoney.setText("Píz: " + maincharter.getMoney() + " Ft");
            showHappiness.setText("Boldogság: " + maincharter.getHappiness() + " %");
            showRespect.setText("Tiszteletreméltóságosság: " + maincharter.getRespect() + " 8)");
            FileWriter fw = new FileWriter("hahu.txt");
            fw.write("nemnyitotta");
            fw.close();
        }

    }

    //Fő Játék Menüpontjai
    //HaHu Gomb Függvényei És Metódusai
    @FXML
    private void openHahu(ActionEvent event) throws IOException {
        hahuPane.setVisible(true);
        File f = new File("hahu.txt");
        Scanner sc = new Scanner(f);
        if (sc.nextLine().equals("megnyitotta")) {
            System.out.println("Már megvolt nyitva");
        } else {
            int seged = (int) (Math.random() * 6);
            String carName = hahu.getCarNames()[seged];
            seged = (int) (Math.random() * 8);
            int pj = hahu.getPaintJob()[seged];
            seged = (int) (Math.random() * 8);
            int r = hahu.getRust()[seged];
            int cond = (pj + r) / 2;
            int price = 0;
            if (cond == 10) {
                price = (int) (Math.random() * 100000) + 50000;
            }
            if (cond > 10 && cond <= 30) {
                price = (int) (Math.random() * 300000) + 150000;
            }
            if (cond > 30 && cond <= 60) {
                price = (int) (Math.random() * 650000) + 450000;
            }
            if (cond > 60 && cond <= 90) {
                price = (int) (Math.random() * 2000000) + 1000000;
            }
            if (cond > 90) {
                price = (int) (Math.random() * 3000000) + 3000000;
            }
            hahuCarPrice11.setText("Ár: " + price + "Ft");
            hahuCarName11.setText(carName);
            hahuCarPaintJob11.setText("Fényezés: " + pj + "%");
            hahuCarRust11.setText("Rozsda: " + r + "%");
            hahuCarCondition11.setText("Állapot: " + cond + "%");

            if (hahuCarName11.getText().equals("3-as Cápa")) {

            }

            seged = (int) (Math.random() * 6);
            carName = hahu.getCarNames()[seged];
            seged = (int) (Math.random() * 8);
            pj = hahu.getPaintJob()[seged];
            seged = (int) (Math.random() * 8);
            r = hahu.getRust()[seged];
            cond = (pj + r) / 2;
            price = 0;
            if (cond == 10) {
                price = (int) (Math.random() * 100000) + 50000;
            }
            if (cond > 10 && cond <= 30) {
                price = (int) (Math.random() * 300000) + 150000;
            }
            if (cond > 30 && cond <= 60) {
                price = (int) (Math.random() * 650000) + 450000;
            }
            if (cond > 60 && cond <= 90) {
                price = (int) (Math.random() * 2000000) + 1000000;
            }
            if (cond > 90) {
                price = (int) (Math.random() * 3000000) + 3000000;
            }
            hahuCarPrice111.setText("Ár: " + price + "Ft");
            hahuCarName111.setText(carName);
            hahuCarPaintJob111.setText("Fényezés: " + pj + "%");
            hahuCarRust111.setText("Rozsda: " + r + "%");
            hahuCarCondition111.setText("Állapot: " + cond + "%");

            seged = (int) (Math.random() * 6);
            carName = hahu.getCarNames()[seged];
            seged = (int) (Math.random() * 8);
            pj = hahu.getPaintJob()[seged];
            seged = (int) (Math.random() * 8);
            r = hahu.getRust()[seged];
            cond = (pj + r) / 2;
            price = 0;
            if (cond == 10) {
                price = (int) (Math.random() * 100000) + 50000;
            }
            if (cond > 10 && cond <= 30) {
                price = (int) (Math.random() * 300000) + 150000;
            }
            if (cond > 30 && cond <= 60) {
                price = (int) (Math.random() * 650000) + 450000;
            }
            if (cond > 60 && cond <= 90) {
                price = (int) (Math.random() * 2000000) + 1000000;
            }
            if (cond > 90) {
                price = (int) (Math.random() * 3000000) + 3000000;
            }
            hahuCarPrice1111.setText("Ár: " + price + "Ft");
            hahuCarName1111.setText(carName);
            hahuCarPaintJob1111.setText("Fényezés: " + pj + "%");
            hahuCarRust1111.setText("Rozsda: " + r + "%");
            hahuCarCondition1111.setText("Állapot: " + cond + "%");
        }
        sc.close();

        hahuOpened = true;
        FileWriter hahu = new FileWriter("hahu.txt");
        hahu.write("megnyitotta");
        hahu.close();
    }

    @FXML
    private void generateOffer(ActionEvent event) {
        if (maincharter.getMoney() > 50000) {
            int seged = (int) (Math.random() * 6);
            String carName = hahu.getCarNames()[seged];
            seged = (int) (Math.random() * 8);
            int pj = hahu.getPaintJob()[seged];
            seged = (int) (Math.random() * 8);
            int r = hahu.getRust()[seged];
            int cond = (pj + r) / 2;
            int price = 0;
            if (cond == 10) {
                price = (int) (Math.random() * 100000) + 50000;
            }
            if (cond > 10 && cond <= 30) {
                price = (int) (Math.random() * 300000) + 150000;
            }
            if (cond > 30 && cond <= 60) {
                price = (int) (Math.random() * 650000) + 450000;
            }
            if (cond > 60 && cond <= 90) {
                price = (int) (Math.random() * 2000000) + 1000000;
            }
            if (cond > 90) {
                price = (int) (Math.random() * 3000000) + 3000000;
            }
            hahuCarPrice11.setText("Ár: " + price + "Ft");
            hahuCarName11.setText(carName);
            hahuCarPaintJob11.setText("Fényezés: " + pj + "%");
            hahuCarRust11.setText("Rozsda: " + r + "%");
            hahuCarCondition11.setText("Állapot: " + cond + "%");

            seged = (int) (Math.random() * 6);
            carName = hahu.getCarNames()[seged];
            seged = (int) (Math.random() * 8);
            pj = hahu.getPaintJob()[seged];
            seged = (int) (Math.random() * 8);
            r = hahu.getRust()[seged];
            cond = (pj + r) / 2;
            price = 0;
            if (cond == 10) {
                price = (int) (Math.random() * 100000) + 50000;
            }
            if (cond > 10 && cond <= 30) {
                price = (int) (Math.random() * 300000) + 150000;
            }
            if (cond > 30 && cond <= 60) {
                price = (int) (Math.random() * 650000) + 450000;
            }
            if (cond > 60 && cond <= 90) {
                price = (int) (Math.random() * 2000000) + 1000000;
            }
            if (cond > 90) {
                price = (int) (Math.random() * 3000000) + 3000000;
            }
            hahuCarPrice111.setText("Ár: " + price + "Ft");
            hahuCarName111.setText(carName);
            hahuCarPaintJob111.setText("Fényezés: " + pj + "%");
            hahuCarRust111.setText("Rozsda: " + r + "%");
            hahuCarCondition111.setText("Állapot: " + cond + "%");

            seged = (int) (Math.random() * 6);
            carName = hahu.getCarNames()[seged];
            seged = (int) (Math.random() * 8);
            pj = hahu.getPaintJob()[seged];
            seged = (int) (Math.random() * 8);
            r = hahu.getRust()[seged];
            cond = (pj + r) / 2;
            price = 0;
            if (cond == 10) {
                price = (int) (Math.random() * 100000) + 50000;
            }
            if (cond > 10 && cond <= 30) {
                price = (int) (Math.random() * 300000) + 150000;
            }
            if (cond > 30 && cond <= 60) {
                price = (int) (Math.random() * 650000) + 450000;
            }
            if (cond > 60 && cond <= 90) {
                price = (int) (Math.random() * 2000000) + 1000000;
            }
            if (cond > 90) {
                price = (int) (Math.random() * 3000000) + 3000000;
            }
            hahuCarPrice1111.setText("Ár: " + price + "Ft");
            hahuCarName1111.setText(carName);
            hahuCarPaintJob1111.setText("Fényezés: " + pj + "%");
            hahuCarRust1111.setText("Rozsda: " + r + "%");
            hahuCarCondition1111.setText("Állapot: " + cond + "%");

            maincharter.setMoney(maincharter.getMoney() - 50000);
            showMoney.setText("Píz: " + maincharter.getMoney() + " Ft");
        } else {
            poorPopUp.setVisible(true);
        }
    }

    //PopUp Metódus
    @FXML
    private void closePopUp(ActionEvent event) {
        poorPopUp.setVisible(false);
    }

    //VisszaLépés A Főmenübe
    @FXML
    private void backToHome(ActionEvent event) {
        gamePane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Játék Mentésének Metódusai
    @FXML
    private void saveGame(ActionEvent event) throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter("mentes.txt");
        fw.write(maincharter.getName() + "," + maincharter.getMoney() + "," + maincharter.getHappiness() + "," + maincharter.getCars() + "," + maincharter.getRespect() + "," + maincharter.getFriends());
        fw.close();
        System.out.print("Sikeres Mentés: ");
        System.out.println (maincharter.getName() + "," + maincharter.getMoney() + "," + maincharter.getHappiness() + "," + maincharter.getCars() + "," + maincharter.getRespect() + "," + maincharter.getFriends());
    }
    private void saveGame() throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter("mentes.txt");
        fw.write(maincharter.getName() + "," + maincharter.getMoney() + "," + maincharter.getHappiness() + "," + maincharter.getCars() + "," + maincharter.getRespect() + "," + maincharter.getFriends());
        fw.close();
    }

    private void loadGame() throws FileNotFoundException {
        File f = new File("mentes.txt");
        Scanner s = new Scanner(f);
        String nn = s.nextLine();
        System.out.println(nn);
        String nnParts[] = nn.split(",");

        maincharter.setName(nnParts[0]);
        maincharter.setMoney(Integer.parseInt(nnParts[1]));
        maincharter.setHappiness(Integer.parseInt(nnParts[2]));
        maincharter.setCars(Integer.parseInt(nnParts[3]));
        maincharter.setRespect(Integer.parseInt(nnParts[4]));
        maincharter.setFriends(Integer.parseInt(nnParts[5]));

    }

}
