package com.tubesoop.tubes2oop;

import card.Tanaman;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.tubesoop.tubes2oop.ShuffleController;
import gamestatus.*;
import com.tubesoop.tubes2oop.WinnerController;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class TurnController implements Initializable {
    private GameStatus gameStatus;
    private static final double BERUANG_ATTACK_PROBABILITY = 1;

    @FXML
    private Label turnLabel;

    @FXML
    private Button turnButton;

    private int numberOfTurn;

    static Button STurnButton;

    @FXML
    public void updateTurnLabel() {
        turnLabel.setText(String.valueOf(numberOfTurn));
        FieldController.currPlayer = gameStatus.getObjek().getCurrentPlayer();
        FieldController.petakLadangCurr = gameStatus.getObjek().getCurrentPlayer().getPetakLadang();
        FieldController.deckCurr = gameStatus.getObjek().getCurrentPlayer().getDeck();
        FieldController.reloadImage();
    }

    @FXML
    protected void onNextButtonClick() {
        ActionsController.disableAllButtons();

        if (numberOfTurn < 20) {
            gameStatus.turn++;
            numberOfTurn = gameStatus.turn;
            updateTurnLabel();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if (this.gameStatus.getObjek().getPlayer1().getPetakLadang().getElement(i, j) != null) {
                        if (this.gameStatus.getObjek().getPlayer1().getPetakLadang().getElement(i, j).getKartu() instanceof Tanaman) {
                            ((Tanaman) this.gameStatus.getObjek().getPlayer1().getPetakLadang().getElement(i, j).getKartu()).addUmur(1);
                        }
                    }
                    if (this.gameStatus.getObjek().getPlayer2().getPetakLadang().getElement(i, j) != null) {
                        if (this.gameStatus.getObjek().getPlayer2().getPetakLadang().getElement(i, j).getKartu() instanceof Tanaman) {
                            ((Tanaman) this.gameStatus.getObjek().getPlayer2().getPetakLadang().getElement(i, j).getKartu()).addUmur(1);
                        }
                    }
                }
            }

            ShuffleController.openShuffleCard();

            if (numberOfTurn == 20) {
                STurnButton.setText("Winning!");
            }
        } else {
            WinnerController.SWinnerDialog.setVisible(true);

            if (gameStatus.getObjek().getPlayer1().getGulden() > gameStatus.getObjek().getPlayer2().getGulden()) {
                WinnerController.SWinner.setText("Player 1");
            } else {
                WinnerController.SWinner.setText("Player 2");
            }
        }
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void initialize(URL location, ResourceBundle resources) {
        STurnButton = turnButton;
        this.numberOfTurn = gameStatus.turn;
        turnLabel.setText(String.valueOf(numberOfTurn));
        STurnButton.setDisable(true);
    }
}
