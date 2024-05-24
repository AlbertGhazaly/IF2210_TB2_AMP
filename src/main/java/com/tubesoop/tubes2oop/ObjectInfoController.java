package com.tubesoop.tubes2oop;

import card.Card;
import card.Produk;
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
import javafx.scene.control.Alert;
import com.tubesoop.tubes2oop.FieldController;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.application.Platform;

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
    @FXML Card KartuPilihan;
    @FXML int row;
    @FXML int col;

    static Label SNama;
    static ImageView SImagePath;
    static Label SBeratOrUmur;
    static HBox SItemAktif;
    static Label SPanen;
    static Label SKategori;
    static Card SKartuPilihan;
    static int Srow;
    static int Scol;

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
        SKartuPilihan = KartuPilihan;
        Srow = row;
        Scol = col;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static void ObjectInfoCardOnClicked(KartuLadang ladangCard, int row, int col) {
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

        Srow = row;
        Scol = col;
        SKartuPilihan = ladangCard.getKartu();
        CardInfo.setVisible(true);
    }

    public void panenKartu() {
        if (gameStatus.getObjek().getCurrentPlayer().getPetakLadang() == FieldController.petakLadangCurr) {

            if (SKartuPilihan instanceof Hewan) {
                Hewan hewan = (Hewan) SKartuPilihan;
                if (hewan.getBerat() >= hewan.getBeratPanen()) {
                    if (gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize() < 6) {
                        Produk produk = convertToProduct(SKartuPilihan);
                        gameStatus.getObjek().getCurrentPlayer().getDeck().addAktifElement(produk);
                        gameStatus.getObjek().getCurrentPlayer().getPetakLadang().removeElement(Srow, Scol);

                        FieldController.reloadImage();
                    } else {
                        // Alert deck aktif sudah penuh
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error Menyimpan Produk");
                        alert.setHeaderText("Tidak Dapat Menyimpan Produk");
                        alert.setContentText("Tidak ada slot tersisa di deck aktif!");
                        alert.showAndWait();
                    }
                } else {
                    // Alert tidak cukup berat untuk panen
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error Panen");
                    alert.setHeaderText("Tidak Dapat Memanen Hewan");
                    alert.setContentText("Berat Hewan Tidak Cukup Untuk Dipanen");
                    alert.showAndWait();
                }
            } else if (SKartuPilihan instanceof Tanaman) {
                Tanaman tanaman = (Tanaman) SKartuPilihan;
                if (tanaman.getUmur() >= tanaman.getdurasiPanen()) {
                    if (gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize() < 6) {
                        Produk produk = convertToProduct(SKartuPilihan);
                        gameStatus.getObjek().getCurrentPlayer().getDeck().addAktifElement(produk);
                        gameStatus.getObjek().getCurrentPlayer().getPetakLadang().removeElement(Srow, Scol);

                        FieldController.reloadImage();
                    } else {
                        // Alert deck aktif sudah penuh
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error Menyimpan Produk");
                        alert.setHeaderText("Tidak Dapat Menyimpan Produk");
                        alert.setContentText("Tidak ada slot tersisa di deck aktif!");
                        alert.showAndWait();
                    }
                } else {
                    // Alert tidak cukup umur untuk panen
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error Panen");
                    alert.setHeaderText("Tidak Dapat Memanen Tanaman");
                    alert.setContentText("Umur Tanaman Tidak Cukup Untuk Dipanen");
                    alert.showAndWait();
                }
            }

        } else {
            // Alert tidak dapat menanam pada petak ladang lawan
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Panen");
            alert.setHeaderText("Tidak Dapat Memanen Petak Ladang");
            alert.setContentText("Kamu tidak dapat memanen dari petak ladang musuh");
            alert.showAndWait();
        }

        CardInfo.setVisible(false);
        SKartuPilihan = null;
        Srow = -1;
        Scol = -1;
    }

    public Produk convertToProduct(Card card) {
        switch (card.getName()) {
            case "HIU_DARAT":
                return new Produk("SIRIP_HIU", "assets/produk/shark-fin.png", 500, 12, "HIU_DARAT");
            case "SAPI":
                return new Produk("SUSU", "assets/produk/susu.png", 100, 4, "SAPI");
            case "DOMBA":
                return new Produk("DAGING_DOMBA", "assets/produk/Daging_Domba.png", 120, 6, "DOMBA");
            case "KUDA":
                return new Produk("DAGING_KUDA", "assets/produk/Daging_Kuda.png", 150, 8, "KUDA");
            case "AYAM":
                return new Produk("TELUR", "assets/produk/telur.png", 50, 2, "AYAM");
            case "BERUANG":
                return new Produk("DAGING_BERUANG", "assets/produk/Daging_Beruang.png", 500, 12, "BERUANG");
            case "BIJI_LABU":
                return new Produk("LABU", "assets/produk/pumpkin.png", 500, 10, "BIJI_LABU");
            case "BIJI_JAGUNG":
                return new Produk("JAGUNG", "assets/produk/corn.png", 150, 3, "BIJI_JAGUNG");
            case "BIJI_STROBERI":
                return new Produk("STROBERI", "assets/produk/stawberry.png", 350, 5, "BIJI_STROBERI");
            default:
                return new Produk();
        }
    }

    public void closeInfoCard() {
        SKartuPilihan = null;
        CardInfo.setVisible(false);
    }
}
