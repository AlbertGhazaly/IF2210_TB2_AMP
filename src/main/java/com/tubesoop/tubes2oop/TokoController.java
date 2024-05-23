package com.tubesoop.tubes2oop;

import card.Card;
import gamestatus.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import  javafx.scene.control.Label;
import javafx.util.Duration;

public class TokoController implements Initializable {
    GameStatus gameStatus;

    @FXML public AnchorPane TokoPane;
    @FXML public Button CloseButton;

    @FXML public Label guldenCurrentPlayer;

    @FXML public ImageView imageDeck1;
    @FXML public ImageView imageDeck2;
    @FXML public ImageView imageDeck3;
    @FXML public ImageView imageDeck4;
    @FXML public ImageView imageDeck5;
    @FXML public ImageView imageDeck6;


    /* Jumlah Item pada Toko */
    @FXML public Label jumlahHiu;
    @FXML public Label jumlahDagingBeruang;
    @FXML public Label jumlahSusu;
    @FXML public Label jumlahDagingDomba;
    @FXML public Label jumlahDagingKuda;
    @FXML public Label jumlahTelur;
    @FXML public Label jumlahJagung;
    @FXML public Label jumlahLabu;
    @FXML public Label jumlahStroberi;

    static AnchorPane alandToko;

    public void  closeToko() {
        TokoPane.setVisible(false);
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void updateToko() {
        Label[] jumlahLabels = {jumlahHiu, jumlahDagingBeruang, jumlahSusu, jumlahDagingDomba, jumlahDagingKuda, jumlahTelur, jumlahJagung, jumlahLabu, jumlahStroberi};
        ImageView[] imageDecks = {imageDeck1, imageDeck2, imageDeck3, imageDeck4, imageDeck5, imageDeck6};
        int gulden = gameStatus.getObjek().getCurrentPlayer().getGulden();
        guldenCurrentPlayer.setText(String.valueOf(gulden));

        // Assume jumlahLabels order matches the order of stock keys
        String[] stockKeys = new String[] {"SIRIP_HIU", "DAGING_BERUANG", "SUSU", "DAGING_DOMBA", "DAGING_KUDA", "TELUR", "JAGUNG", "LABU", "STROBERI"};
        for (int i = 0; i < jumlahLabels.length; i++) {
            int stock = gameStatus.getObjek().geToko().getStok(stockKeys[i]);
            jumlahLabels[i].setText(String.valueOf(stock));
        }

        // Update images for decks
        for (int i = 0; i < imageDecks.length; i++) {
            Card card = gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifElement(i);
            if (card != null) {
                imageDecks[i].setImage(new Image(card.getImgPath()));
            }
            else{
                imageDecks[i].setImage(null);
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

        TokoPane.setVisible(false);
        alandToko = TokoPane;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            updateToko();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}