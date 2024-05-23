package com.tubesoop.tubes2oop;

import gamestatus.GameStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ObjectInfoController implements Initializable {
    GameStatus gameStatus;
    @FXML AnchorPane StatusCard;
    @FXML Label Nama;
    @FXML Label BeratOrUmur;
    @FXML Label ItemAktif;
    @FXML Button BackButton;
    @FXML Button PanenButton;

    static AnchorPane CardInfo;

    public void initialize(URL location, ResourceBundle resources) {
        CardInfo = StatusCard;
        CardInfo.setVisible(false);
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    /*
    * Parameter :
    * 1. Nama Objek
    * 2. Umur atau Berat (Tergantung Tipenya; Hewan atau Tumbuhan)
    * 3. Item Aktif
    * 4. Gambar Objek
    */
    public void ObjectInfoCardOnClicked() {

    }

    public void closeInfoCard() {
        CardInfo.setVisible(false);
    }
}
