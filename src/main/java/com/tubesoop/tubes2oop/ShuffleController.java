package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import card.Card;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import player.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class ShuffleController implements Initializable {
    GameObject gameObject;
    Player player1;
    Player player2;
    Boolean isPickedFour = false;

    /* 4 Random Cards */
    @FXML Pane card1;
    @FXML Pane card2;
    @FXML Pane card3;
    @FXML Pane card4;

    /* Shuffle Button */
    @FXML Button shuffleButton;

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.player1 = gameObject.getPlayer1();
        this.player2 = gameObject.getPlayer2();
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void shuffleCard() {

    }
}
