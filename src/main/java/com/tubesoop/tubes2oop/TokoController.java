package com.tubesoop.tubes2oop;
import gamestatus.GameStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class TokoController implements Initializable {
    GameStatus gameStatus;

    @FXML public AnchorPane TokoPane;
    @FXML public Button CloseButton;

    /* Deck Pane */
    @FXML ImageView deck1;
    @FXML ImageView deck2;
    @FXML ImageView deck3;
    @FXML ImageView deck4;
    @FXML ImageView deck5;

    static AnchorPane alandToko;

    public void  closeToko() {
        TokoPane.setVisible(false);
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void initialize(URL location, ResourceBundle resources) {
        TokoPane.setVisible(false);
        alandToko = TokoPane;


    }
}