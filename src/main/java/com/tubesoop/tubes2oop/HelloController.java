package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private static int numberOfTurn = 1;
    private Label turnLabel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void updateTurnLabel() {
        turnLabel.setText(String.valueOf(numberOfTurn));
    }

    @FXML
    protected void onNextButtonClick() {
        numberOfTurn++;
        updateTurnLabel();
    }

}