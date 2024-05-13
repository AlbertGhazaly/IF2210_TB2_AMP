package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TurnController {
    @FXML
    private Label turnLabel;

    private static int numberOfTurn = 1;

    @FXML
    public void updateTurnLabel() {
        turnLabel.setText(String.valueOf(numberOfTurn));
    }

    @FXML
    protected void onNextButtonClick() {
        numberOfTurn++;
        updateTurnLabel();
    }
}
