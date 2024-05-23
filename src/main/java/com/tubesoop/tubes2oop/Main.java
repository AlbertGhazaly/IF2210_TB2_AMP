package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import gamestatus.GameStatus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Main extends Application {
    public static Pane fieldPane;
    public static Pane deckPane;
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        try {
            GameStatus gameStatus = new GameStatus();
            gameStatus.getObjek().geToko().load("gamestate.txt");
            gameStatus.getObjek().getPlayer1().load("player1.txt");
            gameStatus.getObjek().getPlayer2().load("player2.txt");

//            System.out.println(gameStatus.turn);
//            System.out.println("A01: "+gameStatus.getObjek().getPlayer1().getDeck().getAktifSize());
//            System.out.println("A01: "+gameStatus.getObjek().getPlayer1().getDeck().getAktifElement(0));

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
                /* Pasang GameStatus di ObjectInfoController */
                if (controllerClass == ObjectInfoController.class) {
                    ObjectInfoController controller = new ObjectInfoController();
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
                /* Pasang GameObject di ActionController */
                if (controllerClass == ActionsController.class ) {
                    ActionsController controller = new ActionsController();
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
