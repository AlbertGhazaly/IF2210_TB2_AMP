package com.tubesoop.tubes2oop;
import com.tubesoop.tubes2oop.TokoController;
import gameobject.GameObject;
import gamestatus.GameStatus;
import javafx.fxml.FXML;
import petakladang.PetakLadang;
import javafx.scene.control.Button;

public class ActionsController {
    private GameObject gameObject;
    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
    public void openToko() {
        TokoController.alandToko.setVisible(true);

    }
    public void save() {
        SaveController.saveModalStatic.setVisible(true);
        SaveController.succesStatic.setVisible(false);
        SaveController.failedStatic.setVisible(false);
    }
    public void load() {
        LoadController.LoadModalStatic.setVisible(true);
        LoadController.succesStatic.setVisible(false);
        LoadController.failedStatic.setVisible(false);
    }
    public void openOpp(){
        if (GameStatus.turn%2==0){
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer1().getPetakLadang();
        }else{
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer2().getPetakLadang();
        }
        FieldController.reloadImage();
    }
    public void openMine(){
        if (GameStatus.turn%2==0){
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer2().getPetakLadang();
        }else{
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer1().getPetakLadang();
        }
        FieldController.reloadImage();
    }
}
