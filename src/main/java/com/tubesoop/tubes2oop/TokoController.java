package com.tubesoop.tubes2oop;

import card.Card;
import gamestatus.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import  javafx.scene.control.Label;

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
        // Contoh: mengambil data dari model stok toko
        int gulden = gameStatus.getObjek().getCurrentPlayer().getGulden();
        guldenCurrentPlayer.setText(String.valueOf(gulden));
        int jumlahStokSiripHiu = gameStatus.getObjek().geToko().getStok("SIRIP_HIU"); // Misalkan "namaProduk" adalah kunci produk yang relevan
        jumlahHiu.setText(String.valueOf(jumlahStokSiripHiu));
        int jumlahStokDagingBeruang = gameStatus.getObjek().geToko().getStok("DAGING_BERUANG");
        jumlahDagingBeruang.setText(String.valueOf(jumlahStokDagingBeruang));
        int jumlahStokSusu = gameStatus.getObjek().geToko().getStok("SUSU");
        jumlahSusu.setText(String.valueOf(jumlahStokSusu));
        int jumlahStokDagingDomba = gameStatus.getObjek().geToko().getStok("DAGING_DOMBA");
        jumlahDagingDomba.setText(String.valueOf(jumlahStokDagingDomba));
        int jumlahStokDagingKuda = gameStatus.getObjek().geToko().getStok("DAGING_KUDA");
        jumlahDagingKuda.setText(String.valueOf(jumlahStokDagingKuda));
        int jumlahStokTelur = gameStatus.getObjek().geToko().getStok("TELUR");
        jumlahTelur.setText(String.valueOf(jumlahStokTelur));
        int jumlahStokJagung = gameStatus.getObjek().geToko().getStok("JAGUNG");
        jumlahJagung.setText(String.valueOf(jumlahStokJagung));
        int jumlahStokLabu = gameStatus.getObjek().geToko().getStok("LABU");
        jumlahLabu.setText(String.valueOf(jumlahStokLabu));
        int jumlahStokStroberi = gameStatus.getObjek().geToko().getStok("STROBERI");
        jumlahLabu.setText(String.valueOf(jumlahStokStroberi));
        Card card1 = gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifElement(0);
        if (card1 != null){
            imageDeck1.setImage(new Image(card1.getImgPath()));
        }
        Card card2 = gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifElement(1);
        if (card2 != null){
            imageDeck1.setImage(new Image(card2.getImgPath()));
        }
        Card card3 = gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifElement(2);
        if (card3 != null){
            imageDeck1.setImage(new Image(card3.getImgPath()));
        }
        Card card4 = gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifElement(3);
        if (card4 != null){
            imageDeck1.setImage(new Image(card4.getImgPath()));
        }
        Card card5 = gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifElement(4);
        if (card5 != null){
            imageDeck1.setImage(new Image(card5.getImgPath()));
        }
        Card card6 = gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifElement(5);
        if (card6 != null){
            imageDeck1.setImage(new Image(card6.getImgPath()));
        }
    }


    public void initialize(URL location, ResourceBundle resources) {
        TokoPane.setVisible(false);
        alandToko = TokoPane;
        updateToko();
    }
}