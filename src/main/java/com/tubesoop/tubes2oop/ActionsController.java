package com.tubesoop.tubes2oop;
import com.tubesoop.tubes2oop.TokoController;
import gameobject.GameObject;
import gamestatus.GameStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import petakladang.PetakLadang;
import javafx.scene.control.Button;
import toko.Toko;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ActionsController implements Initializable {
    private GameObject gameObject;
    @FXML Button myField;
    @FXML Button oppField;
    @FXML Button shopButton;
    @FXML Button saveStateButton;
    @FXML Button loadStateButton;
    @FXML Button loadPluginButton;

    static Button SmyField;
    static Button SoppField;
    static Button SshopButton;
    static Button SsaveStateButton;
    static Button SloadStateButton;
    static Button SloadPluginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SmyField = myField;
        SoppField = oppField;
        SshopButton = shopButton;
        SsaveStateButton = saveStateButton;
        SloadStateButton = loadStateButton;
        SloadPluginButton = loadPluginButton;

        SmyField.setDisable(true);
        SoppField.setDisable(true);
        SshopButton.setDisable(true);
        SsaveStateButton.setDisable(true);
        SloadStateButton.setDisable(true);
        SloadPluginButton.setDisable(true);
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
    public void openToko() {
        String musicFile = "src/main/resources/assets/clickSound.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        TokoController.alandToko.setVisible(true);

    }
    public void save() {
        String musicFile = "src/main/resources/assets/clickSound.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        SaveController.saveModalStatic.setVisible(true);
        SaveController.succesStatic.setVisible(false);
        SaveController.failedStatic.setVisible(false);
    }
    public void load() {
        String musicFile = "src/main/resources/assets/clickSound.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        LoadController.LoadModalStatic.setVisible(true);
        LoadController.succesStatic.setVisible(false);
        LoadController.failedStatic.setVisible(false);
    }
    public  void plugin(){
        String musicFile = "src/main/resources/assets/clickSound.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        PluginController.pluginModalStatic.setVisible(true);
        PluginController.failedStatic.setVisible(false);
        PluginController.succesStatic.setVisible(false);
    }
    public void openOpp(){
        String musicFile = "src/main/resources/assets/clickSound.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        if (GameStatus.turn%2==0){
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer1().getPetakLadang();
        }else{
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer2().getPetakLadang();
        }
        myField.setStyle("-fx-background-color: white; -fx-background-radius: 5px; -fx-text-fill: black;");
        oppField.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-text-fill: white;");
        FieldController.reloadImage();
    }
    public void openMine(){
        String musicFile = "src/main/resources/assets/clickSound.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        if (GameStatus.turn%2==0){
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer2().getPetakLadang();
        }else{
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer1().getPetakLadang();
        }
        oppField.setStyle("-fx-background-color: white; -fx-background-radius: 5px; -fx-text-fill: black;");
        myField.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-text-fill: white;");
        FieldController.reloadImage();
    }

    public static void enableAllButtons() {
        TurnController.STurnButton.setDisable(false);
        ActionsController.SmyField.setDisable(false);
        ActionsController.SoppField.setDisable(false);
        ActionsController.SshopButton.setDisable(false);
        ActionsController.SsaveStateButton.setDisable(false);
        ActionsController.SloadStateButton.setDisable(false);
        ActionsController.SloadPluginButton.setDisable(false);
    }

    public static void disableAllButtons() {
        TurnController.STurnButton.setDisable(true);
        ActionsController.SmyField.setDisable(true);
        ActionsController.SoppField.setDisable(true);
        ActionsController.SshopButton.setDisable(true);
        ActionsController.SsaveStateButton.setDisable(true);
        ActionsController.SloadStateButton.setDisable(true);
        ActionsController.SloadPluginButton.setDisable(true);
    }
}
