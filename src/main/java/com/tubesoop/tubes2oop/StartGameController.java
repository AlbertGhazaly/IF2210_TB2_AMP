package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import com.tubesoop.tubes2oop.ShuffleController;
import com.tubesoop.tubes2oop.FieldController;
import com.tubesoop.tubes2oop.TurnController;
import com.tubesoop.tubes2oop.ActionsController;
import java.net.URL;
import java.util.ResourceBundle;

public class StartGameController implements Initializable {
    @FXML Button startButton;
    static Button SstartButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SstartButton = startButton;
    }

    public void startGameHandler() {
        SstartButton.setVisible(false);
        ShuffleController.SshuffleCard.setVisible(true);
        FieldController.SFieldMain.setVisible(true);
        TurnController.STurnButton.setDisable(false);
        ActionsController.SmyField.setDisable(false);
        ActionsController.SoppField.setDisable(false);
        ActionsController.SshopButton.setDisable(false);
        ActionsController.SsaveStateButton.setDisable(false);
        ActionsController.SloadStateButton.setDisable(false);
        ActionsController.SloadPluginButton.setDisable(false);
    }

}