package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import player.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class FieldController implements Initializable {
    GameObject gameObject;

    @FXML
    Player player1;

    @FXML
    Player player2;

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}