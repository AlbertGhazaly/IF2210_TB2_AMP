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
import petakladang.KartuLadang;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ObjectInfoController implements Initializable {
    GameStatus gameStatus;
    @FXML AnchorPane StatusCard;
    @FXML Label Nama;
    @FXML ImageView ImagePath;
    @FXML Label BeratOrUmur;
    @FXML HBox ItemAktif;
    @FXML Button BackButton;
    @FXML Button PanenButton;
    @FXML Label Panen;
    @FXML Label Kategori;

    static Label SNama;
    static ImageView SImagePath;
    static Label SBeratOrUmur;
    static HBox SItemAktif;
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

    public static void ObjectInfoCardOnClicked(KartuLadang ladangCard) {
        SItemAktif.getChildren().clear();
        SNama.setText(ladangCard.getKartu().getName());

        Image objectImage = new Image(ladangCard.getKartu().getImgPath());
        SImagePath.setImage(objectImage);

        if (ladangCard.getKartu() instanceof Hewan) {
            SBeratOrUmur.setText("Berat : " + ((Hewan) ladangCard.getKartu()).getBerat());
            SPanen.setText("Berat Panen : " + ((Hewan) ladangCard.getKartu()).getBeratPanen());
        }
        else if (ladangCard.getKartu() instanceof Tanaman) {
            SBeratOrUmur.setText("Umur : " + ((Tanaman) ladangCard.getKartu()).getUmur());
            SPanen.setText("Durasi Panen : " + ((Tanaman) ladangCard.getKartu()).getdurasiPanen());
        }
        for (int i=0;i<ladangCard.getItems().size();i++){
            ImageView newImg = new ImageView(new Image(ladangCard.getItemElement(i).getImgPath()));
            newImg.setFitWidth(50);
            newImg.setFitHeight(50);
            SItemAktif.getChildren().add(newImg);

        }
        CardInfo.setVisible(true);
    }

    public void closeInfoCard() {
        CardInfo.setVisible(false);
    }
}
