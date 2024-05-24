package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class WinnerController implements Initializable {
    @FXML
    private AnchorPane WinnerDialog;
    @FXML
    private Label Winner;

    static AnchorPane SWinnerDialog;
    static Label SWinner;

    public void initialize(URL location, ResourceBundle resources) {
        SWinnerDialog = WinnerDialog;
        SWinnerDialog.setVisible(false);

        SWinner = Winner;
    }
}
