package com.tubesoop.tubes2oop;

import card.Card;
import gamestatus.GameStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import card.Hewan;
import card.Tanaman;

public class ObjectInfoController implements Initializable {
    GameStatus gameStatus;
    @FXML AnchorPane StatusCard;
    @FXML Label Nama;
    @FXML ImageView ImagePath;
    @FXML Label BeratOrUmur;
    @FXML Label ItemAktif;
    @FXML Button BackButton;
    @FXML Button PanenButton;
    @FXML Label Panen;
    @FXML Label Kategori;

    static Label SNama;
    static ImageView SImagePath;
    static Label SBeratOrUmur;
    static Label SItemAktif;
    static Label SPanen;
    static Label SKategori;

    static AnchorPane CardInfo;

    public void initialize(URL location, ResourceBundle resources) {
        CardInfo = StatusCard;
        CardInfo.setVisible(false);
        SNama = Nama;
        SImagePath = ImagePath;
        SBeratOrUmur = BeratOrUmur;
        SItemAktif = ItemAktif;
        SPanen = Panen;
        SKategori = Kategori;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static void ObjectInfoCardOnClicked(Card card) {
        SNama.setText(card.getName());

        Image objectImage = new Image(card.getImgPath());
        SImagePath.setImage(objectImage);

        if (card instanceof Hewan) {
            SBeratOrUmur.setText("Berat : " + ((Hewan) card).getBerat());
            SPanen.setText("Berat Panen : " + ((Hewan) card).getBeratPanen());
        }
        else if (card instanceof Tanaman) {
            SBeratOrUmur.setText("Umur : " + ((Tanaman) card).getUmur());
            SPanen.setText("Durasi Panen : " + ((Tanaman) card).getdurasiPanen());
        }

        CardInfo.setVisible(true);
    }

    public void closeInfoCard() {
        CardInfo.setVisible(false);
    }
}
