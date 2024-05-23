package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import gamestatus.GameStatus;
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
            GameStatus gameStatus = new GameStatus();
            gameStatus.getObjek().getPlayer1().load("player1.txt");
            gameStatus.getObjek().getPlayer2().load("player2.txt");
            gameStatus.getObjek().geToko().load("gamestate.txt");


            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            loader.setControllerFactory(controllerClass -> {
                /* Pasang GameStatus di TurnController */
                if (controllerClass == TurnController.class) {
                    TurnController controller = new TurnController();
                    controller.setGameStatus(gameStatus);
                    return controller;
                }
                /* Pasang GameStatus di TokoController */
                if (controllerClass == TokoController.class) {
                    TokoController controller = new TokoController();
                    controller.setGameStatus(gameStatus);
                    return controller;
                }
                /* Pasang GameObject di PlayerStatusController */
                if (controllerClass == PlayerStatusController.class) {
                    PlayerStatusController controller = new PlayerStatusController();
                    controller.setGameObject(gameStatus.getObjek());
                    return controller;
                }
                /* Pasang GameObject di FieldController */
                if (controllerClass == FieldController.class ) {
                    FieldController controller = new FieldController();
                    controller.setGameObject(gameStatus.getObjek());
                    return controller;
                }
                /* Pasang GameObject di ShuffleController */
                if (controllerClass == ShuffleController.class) {
                    ShuffleController controller = new ShuffleController();
                    controller.setGameObject(gameStatus);
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

            Parent root = loader.load();

            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Game");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
