package com.tubesoop.tubes2oop;

import gamestatus.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.*;

public class PluginController implements Initializable {
    public GameStatus gameStatus;
    @FXML
    private AnchorPane PluginModal;
    @FXML
    private Label succes;
    @FXML
    private Label failed;
    @FXML
    private Label path;

    @FXML
    AnchorPane saveModal;

    static Label succesStatic;
    static Label failedStatic;
    static AnchorPane pluginModalStatic;

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }


    public void initialize(URL location, ResourceBundle resources) {
        succesStatic = succes;
        failedStatic = failed;
        succesStatic.setVisible(false);
        failedStatic.setVisible(false);
        pluginModalStatic = PluginModal;
        pluginModalStatic.setVisible(false);


    }
    public void kembali() {
        pluginModalStatic.setVisible(false);
        succes.setVisible(false);
        failed.setVisible(false);
    }

    public void execute() {
        failed.setVisible(false);
        succes.setVisible(false);
        String pathFile = path.getText();
        if (pathFile.length()!=0) {
            try {
                succes.setVisible(true);
            } catch (Exception e) {
                failed.setVisible(true);
            }
        } else {
            failed.setVisible(true);
        }
    }

    public void handleChooseFile(javafx.event.ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        // Set extension filters
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("JAR Files", "*.jar"));

        // Show open file dialog
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            path.setText(file.getAbsolutePath());
        }
    }
}
