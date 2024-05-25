package com.tubesoop.tubes2oop;

import gamestatus.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.*;

public class SaveController implements Initializable {
    public GameStatus gameStatus;

    @FXML
    private ButtonBase Kembali;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField Folder;

    @FXML
    private Label succes;
    @FXML
    private Label failed;

    @FXML
    AnchorPane saveModal;

    static Label succesStatic;
    static Label failedStatic;
    static AnchorPane saveModalStatic;
    static ChoiceBox<String> choiceBoxStatic;

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxStatic = choiceBox;
        succesStatic = succes;
        failedStatic = failed;
        succesStatic.setVisible(false);
        failedStatic.setVisible(false);
        saveModalStatic = saveModal;
        saveModalStatic.setVisible(false);
        ChoiceBox<String> BoxPilihan = choiceBox;

        List<String> choice = new ArrayList<>() ;
        choice.add("txt");

        BoxPilihan.getItems().addAll(choice);
        ObservableList<String> Items = BoxPilihan.getItems();
        String defaultChoice = Items.get(0);

        if (!Items.isEmpty()) {
            BoxPilihan.setValue(defaultChoice);
        }
    }
    public void kembali() {
        saveModalStatic.setVisible(false);
        succes.setVisible(false);
        failed.setVisible(false);
    }

    public void execute() {
        failed.setVisible(false);
        succes.setVisible(false);
        String folder = Folder.getText();
        String Ext = choiceBox.getSelectionModel().getSelectedItem();
        if (!(folder.length()==0)) {
            try {
                gameStatus.saveState(folder,Ext);
                succes.setVisible(true);
            } catch (Exception e) {
                failed.setVisible(true);
        }
        } else {
            failed.setVisible(true);
        }
    }

    public void setExitMerah(){
        Kembali.setStyle("-fx-background-color: red;");
    }
    public void setExitNormal(){
        Kembali.setStyle("");
    }
}
