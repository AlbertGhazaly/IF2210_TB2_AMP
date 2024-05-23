package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import player.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerStatusController implements Initializable {
    private GameObject gameObject;

    @FXML private Player player1;
    @FXML private Player player2;
    @FXML private Label player1Gulden;
    @FXML private Label player2Gulden;

    static Player SPlayer1;
    static Player SPlayer2;
    static Label Splayer1Gulden;
    static Label Splayer2Gulden;

    @FXML
    public void updatePlayer1Gulden() {
        if (this.player1 != null) {
            player1Gulden.setText(String.valueOf(this.player1.getGulden()));
        }
    }

    @FXML
    public void updatePlayer2Gulden() {
        if (this.player2 != null) {
            player2Gulden.setText(String.valueOf(this.player2.getGulden()));
        }
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
    }

    @FXML
    public static void updatePlayersGulden() {
        Splayer1Gulden.setText(String.valueOf(SPlayer1.getGulden()));
        Splayer2Gulden.setText(String.valueOf(SPlayer2.getGulden()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SPlayer1 = player1;
        SPlayer2 = player2;
        Splayer1Gulden = player1Gulden;
        Splayer2Gulden = player2Gulden;

        this.updatePlayer1Gulden();
        this.updatePlayer2Gulden();
    }
}
