package com.tubesoop.tubes2oop;

import card.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import player.Player;

public class HelloController {
    private static int numberOfTurn = 1;

    // FXML Attributes
    @FXML
    private Label turnLabel;
    @FXML
    private Label player1GuldenLabel;
    @FXML
    private Label player2GuldenLabel;

    // FXML Methods
    @FXML
    public void updateTurnLabel() {
        turnLabel.setText(String.valueOf(numberOfTurn));
    }

    @FXML
    protected void onNextButtonClick() {
        numberOfTurn++;
        updateTurnLabel();
    }

    public void initialize() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setGulden(30);
        player2.setGulden(50);

//        player1GuldenLabel.setText(String.valueOf(player1.getGulden()));
//        player2GuldenLabel.setText(String.valueOf(player2.getGulden()));
    }

}