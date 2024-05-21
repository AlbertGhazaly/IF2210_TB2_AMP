package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import card.Card;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ShuffleController implements Initializable {
    GameObject gameObject;

    /* 4 Random Cards */
    @FXML Card card1;
    @FXML Card card2;
    @FXML Card card3;
    @FXML Card card4;

    /* Shuffle Button */
    @FXML Button shuffleButton;

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
