package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import player.Player;

import java.net.URL;

public class PlayerStatusController implements Initializable {
    @FXML
    Player player1 = new Player();

    @FXML
    Player player2 = new Player();

    @FXML
    private Label player1Gulden;

    @FXML
    private Label player2Gulden;

    @FXML
    public void updatePlayer1Gulden() {
        player1Gulden.setText(String.valueOf(player1.getGulden()));
    }

    @FXML
    public void updatePlayer2Gulden() {
        player2Gulden.setText(String.valueOf(player2.getGulden()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1.setGulden(30);
        player2.setGulden(50);

        updatePlayer1Gulden();
        updatePlayer2Gulden();
    }
}