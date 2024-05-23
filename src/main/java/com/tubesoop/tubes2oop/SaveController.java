package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.*;

public class SaveController{
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    AnchorPane saveModal;

    static AnchorPane saveModalStatic;

    public void initialize(URL location, ResourceBundle resources) {
        saveModalStatic = saveModal;
        saveModalStatic.setVisible(true);

        // Create a HashMap and populate it with some data
        List<String> choice = new ArrayList<>() ;
        choice.add("TXT");;

        // Add keys of the HashMap to the ChoiceBox
        choiceBox.getItems().addAll(choice);

        // Optionally, set a default selected item
        if (!choiceBox.getItems().isEmpty()) {
            choiceBox.setValue(choiceBox.getItems().get(0));
        }
    }
}
