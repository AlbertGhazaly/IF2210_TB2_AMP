package com.tubesoop.tubes2oop;
import com.tubesoop.tubes2oop.TokoController;
import gameobject.GameObject;
import gamestatus.GameStatus;
import petakladang.PetakLadang;

public class ActionsController {
    private GameObject gameObject;
    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
    public void openToko() {
        TokoController.alandToko.setVisible(true);
    }
    public void openOpp(){
        if (GameStatus.turn%2==0){
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer1().getPetakLadang();
        }else{
            FieldController.petakLadangCurr = (PetakLadang) this.gameObject.getPlayer2().getPetakLadang();
        }
    }
}
