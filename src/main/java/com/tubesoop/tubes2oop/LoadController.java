package com.tubesoop.tubes2oop;

import gamestatus.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.*;

public class LoadController implements Initializable {
    public GameStatus gameStatus;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField Folder;

    @FXML
    private Label succes;
    @FXML
    private Label failed;

    @FXML
    AnchorPane LoadModal;

    static Label succesStatic;
    static Label failedStatic;
    static AnchorPane LoadModalStatic;

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void initialize(URL location, ResourceBundle resources) {
        succesStatic = succes;
        failedStatic = failed;
        succesStatic.setVisible(false);
        failedStatic.setVisible(false);
        LoadModalStatic = LoadModal;
        LoadModalStatic.setVisible(false);
        ChoiceBox<String> BoxPilihan = choiceBox;
        // Create a HashMap and populate it with some data
        List<String> choice = new ArrayList<>() ;
        choice.add("txt");

        // Add keys of the HashMap to the ChoiceBox
        BoxPilihan.getItems().addAll(choice);
        ObservableList<String> Items = BoxPilihan.getItems();
        String defaultChoice = Items.get(0);
        // Optionally, set a default selected item
        if (!Items.isEmpty()) {
            BoxPilihan.setValue(defaultChoice);
        }
    }
    public void kembali() {
        LoadModalStatic.setVisible(false);
        succes.setVisible(false);
    }

    public void execute() {
        failed.setVisible(false);
        succes.setVisible(false);
        String folder = Folder.getText();
        String Ext = choiceBox.getSelectionModel().getSelectedItem();
        if (!(folder.length()==0)) {
            try {
                gameStatus.loadState(folder,Ext);
                succes.setVisible(true);
            } catch (Exception e) {
                failed.setVisible(true);
            }
        } else {
            failed.setVisible(true);
        }
    }
}
