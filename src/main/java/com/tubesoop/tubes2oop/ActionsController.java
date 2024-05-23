package com.tubesoop.tubes2oop;

public class ActionsController {
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
}
