package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import plugin.PluginLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PluginController implements Initializable {


    @FXML
    private AnchorPane PluginModal;
    @FXML
    private Label succes;
    @FXML
    private Label failed;
    @FXML
    private Label path;

    @FXML
    private ButtonBase Kembali;

    static Label succesStatic;
    static Label failedStatic;
    static AnchorPane pluginModalStatic;


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
    public void setExitMerah(){
        Kembali.setStyle("-fx-background-color: red;");
    }
    public void setExitNormal(){
        Kembali.setStyle("");
    }

    public void execute() {
        failed.setVisible(false);
        succes.setVisible(false);
        String pathFile = path.getText();
        System.out.println(pathFile);
        String kelas = "";
        if (pathFile.length()!=0) {
            try {
                System.out.println(1);
                kelas = PluginLoader.loadAndInvoke(path.getText());
                succes.setVisible(true);
                if ("XML".equals(kelas)){
                    SaveController.choiceBoxStatic.getItems().add("xml");
                    LoadController.choiceBoxStatic.getItems().add("xml");
                }
                if ("JSON".equals(kelas)){
                    SaveController.choiceBoxStatic.getItems().add("json");
                    LoadController.choiceBoxStatic.getItems().add("json");
                }
            } catch (Exception e) {
                System.out.println(-1);
                failed.setVisible(true);
            }
        } else {
            System.out.println(0);
            failed.setVisible(true);
        }
    }

    public void handleChooseFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src"));
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
