package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import player.Player;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;

public class FieldController implements Initializable {
    private GameObject gameObject;

    /* Inisiasi Player */
    @FXML private Player player1;
    @FXML private Player player2;

    /* Field Pane */
    @FXML private Pane fieldPane;
    @FXML private Pane targetPane1;
    @FXML private Pane targetPane2;
    @FXML private Pane targetPane3;
    @FXML private Pane targetPane4;
    @FXML private Pane targetPane5;
    @FXML private Pane targetPane6;
    @FXML private Pane targetPane7;
    @FXML private Pane targetPane8;
    @FXML private Pane targetPane9;
    @FXML private Pane targetPane10;
    @FXML private Pane targetPane11;
    @FXML private Pane targetPane12;
    @FXML private Pane targetPane13;
    @FXML private Pane targetPane14;
    @FXML private Pane targetPane15;
    @FXML private Pane targetPane16;
    @FXML private Pane targetPane17;
    @FXML private Pane targetPane18;
    @FXML private Pane targetPane19;
    @FXML private Pane targetPane20;

    /* Deck Pane */
    @FXML private Pane deckPane;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @FXML private Pane pane3;
    @FXML private Pane pane4;
    @FXML private Pane pane5;


    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the deckPane and fieldPane with draggable items
        initializeDragAndDrop(deckPane);
        initializeDragAndDrop(fieldPane);
    }

    private void initializeDragAndDrop(Pane parentPane) {
        for (Node node : parentPane.getChildren()) {
            if (node instanceof Pane) {
                Pane pane = (Pane) node;
                pane.setOnDragDetected(event -> {
                    Dragboard db = pane.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(pane.getId()); // Use an identifier to find the source node
                    db.setContent(content);
                    event.consume();
                });

                pane.setOnDragOver(event -> {
                    if (event.getGestureSource() != pane && event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.MOVE);
                    }
                    event.consume();
                });

                pane.setOnDragDropped(event -> {
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        String draggedPaneId = db.getString();
                        Pane draggedPane = (Pane) parentPane.lookup("#" + draggedPaneId);
                        if (draggedPane == null) {
                            draggedPane = (Pane) deckPane.lookup("#" + draggedPaneId);
                        }
                        if (draggedPane == null) {
                            draggedPane = (Pane) fieldPane.lookup("#" + draggedPaneId);
                        }
                        if (draggedPane != null) {
                            ((Pane) draggedPane.getParent()).getChildren().remove(draggedPane);
                            pane.getChildren().add(draggedPane); // Add the dragged pane to the target pane
                            success = true;
                        }
                    }
                    event.setDropCompleted(success);
                    event.consume();
                });
            }
        }
    }
}