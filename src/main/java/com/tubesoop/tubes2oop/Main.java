package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            GameObject gameObject = new GameObject();

            // Set up the FXMLLoader for the main FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));

            // Set the controller factory
            loader.setControllerFactory(controllerClass -> {
                if (controllerClass == PlayerStatusController.class) {
                    PlayerStatusController controller = new PlayerStatusController();
                    controller.setGameObject(gameObject);
                    return controller;
                }
                if (controllerClass == FieldController.class ) {
                    FieldController controller = new FieldController();
                    controller.setGameObject(gameObject);
                    return controller;
                }
                else {
                    try {
                        return controllerClass.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            // Load the main FXML
            Parent root = loader.load();

            // Set up the stage
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Game");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
