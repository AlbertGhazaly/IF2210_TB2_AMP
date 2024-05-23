package com.tubesoop.tubes2oop;

import gamestatus.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import  javafx.scene.control.Label;

public class TokoController implements Initializable {
    GameStatus gameStatus;

    @FXML public AnchorPane TokoPane;
    @FXML public Button CloseButton;

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

    private void updateStokToko() {
        // Contoh: mengambil data dari model stok toko
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
    }


    public void initialize(URL location, ResourceBundle resources) {
        TokoPane.setVisible(false);
        alandToko = TokoPane;
        updateStokToko();
    }
}