package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.tubesoop.tubes2oop.ShuffleController;
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
        turnLabel.setText(String.valueOf(numberOfTurn));
        FieldController.currPlayer = gameStatus.getObjek().getCurrentPlayer();
        FieldController.petakLadangCurr = gameStatus.getObjek().getCurrentPlayer().getPetakLadang();
        FieldController.deckCurr = gameStatus.getObjek().getCurrentPlayer().getDeck();
        FieldController.reloadImage();
    }

    @FXML
    protected void onNextButtonClick() {
        if (numberOfTurn < 20) {
            gameStatus.turn ++;
            numberOfTurn = gameStatus.turn;
            updateTurnLabel();

            ShuffleController.openShuffleCard();
        } else {
            // TO DO : Handle Kemenangan
        }
    }

    public void setGameStatus(GameStatus gameStatus){
        this.gameStatus = gameStatus;
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.numberOfTurn = gameStatus.turn;
        turnLabel.setText(String.valueOf(numberOfTurn));
    }
}
