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
    /* Deck Pane */
    @FXML private Pane deckPane;

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the deckPane with draggable items
        initializeDeck();

        // Set up the fieldPane to accept drops
        initializeField();
    }

    private void initializeDeck() {
        for (Node node : deckPane.getChildren()) {
            if (node instanceof Pane) {
                Pane child = (Pane) node;
                child.setOnDragDetected(event -> {
                    Dragboard db = child.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(child.getId()); // Use an identifier to find the source node
                    db.setContent(content);
                    event.consume();
                });
            }
        }
    }

    private void initializeField() {
        for (int i = 0; i < fieldPane.getChildren().size(); i++) {
            Node node = fieldPane.getChildren().get(i);
            if (node instanceof Pane) {
                Pane target = (Pane) node;
                final int index = i; // Capture the index for later use

                target.setOnDragOver(event -> {
                    if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.MOVE);
                    }
                    event.consume();
                });

                target.setOnDragDropped(event -> {
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        String draggedPaneId = db.getString();
                        Pane draggedPane = (Pane) deckPane.lookup("#" + draggedPaneId);
                        if (draggedPane != null) {
                            deckPane.getChildren().remove(draggedPane);
                            target.getChildren().add(draggedPane); // Add the dragged pane to the target pane
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