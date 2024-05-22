package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import gamestatus.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TurnController implements Initializable {
    private GameStatus gameStatus;

    @FXML
    private Label turnLabel;

    private int numberOfTurn;

    @FXML
    public void updateTurnLabel() {
//        turnLabel.setText(String.valueOf(numberOfTurn));

    }

    @FXML
    protected void onNextButtonClick() {
//        numberOfTurn++;
//        updateTurnLabel();


    }

    public void setGameStatus(GameStatus gameStatus){
        this.gameStatus = gameStatus;
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.numberOfTurn = gameStatus.turn;
    }
}
