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

    @FXML
    private Player player1;

    @FXML
    private Player player2;

    @FXML
    private Label player1Gulden;

    @FXML
    private Label player2Gulden;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize with default values

        if (player1 != null) this.player1.setGulden(30);
        if (player2 != null) this.player2.setGulden(50);

        this.updatePlayer1Gulden();
        this.updatePlayer2Gulden();
    }
}
