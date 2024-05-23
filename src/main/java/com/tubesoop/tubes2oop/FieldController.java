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
import java.util.*;
import petakladang.*;
import deck.*;
import card.*;
import javax.crypto.spec.PSource;
import java.net.URL;
import java.io.InputStream;
import java.util.ResourceBundle;

public class FieldController implements Initializable {
    private GameObject gameObject;
    public static Player currPlayer;
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
    @FXML private Pane pane6;


    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
        currPlayer = gameObject.getCurrentPlayer();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the deckPane and fieldPane with draggable items
//        for (int i=0;i<20;i++){
//            Pane pane = (Pane) fieldPane.lookup("#targetPane"+(i+1));
//            setUpDragAndDrop(pane);
//        }
//        for (int i=0;i<6;i++){
//            Pane pane = (Pane) deckPane.lookup("#pane"+(i+1));
//            setUpDragAndDrop(pane);
//        }

        initializeDragAndDrop(fieldPane);
        initializeDragAndDrop(deckPane);
//        for (int i=0;i<4;i++){
//            for (int j=0;j<5;j++){
//                Pane pane = (Pane) fieldPane.lookup("#targetPane"+(i*5+j));
//                ImageView imgv = (ImageView) pane.getChildren()[0];
//            }
//        }
            for (int i = 0; i < 6; i++){
                Pane kartu = new Pane();
                kartu.setPrefSize(103,104);
//            prefHeight="103.0" prefWidth="104.0" style="-fx-background-radius: 10;" styleClass="glassBackground"
//            kartu.setStyle("-fx-background-radius: 10;-fx-background-color: rgba(255, 255, 255, 1)" );
                // tambahin kartu ke deck
                Pane parent = ((Pane) deckPane.getChildren().get(i));
                if (parent!=null){
                    parent.getChildren().add(kartu);
                    Card insideCard =  currPlayer.getDeck().getAktifElement(i);
                    if (insideCard != null) {
                        parent = (Pane) parent.getChildren().get(0);
                        parent.getChildren().add(new ImageView(new
                                Image(
                                getClass().getClassLoader().getResourceAsStream(insideCard.getImgPath()
                                ))));
                        ( (ImageView) parent.getChildren().get(0)).setFitHeight(85);
                        ( (ImageView) parent.getChildren().get(0)).setFitWidth(85);
                    }
                }
             }
            for (int i=0;i<4;i++){
                for (int j=0;j<5;j++){
                    Pane kartu = new Pane();
                    kartu.setPrefSize(103,104);
                    Pane parent = ((Pane) fieldPane.getChildren().get(i*5+j));
                    parent.getChildren().add(kartu);
                    KartuLadang insideCard = (KartuLadang) currPlayer.getPetakLadang().getElement(i,j);
                    if (insideCard != null) {
                        parent = (Pane) parent.getChildren().get(0);
                        parent.getChildren().add(new ImageView(new
                                Image(
                                getClass().getClassLoader().getResourceAsStream(insideCard.getKartu().getImgPath()
                                ))));
                        ( (ImageView) parent.getChildren().get(0)).setFitHeight(85);
                        ( (ImageView) parent.getChildren().get(0)).setFitWidth(85);
                    }
                }

            }
        Main.fieldPane = this.fieldPane;
        Main.deckPane = this.deckPane;

    }

    public static void reloadImage(){
            for (int i = 0; i < 6; i++){
                Pane parent = ((Pane) Main.deckPane.getChildren().get(i));
                if (parent!=null){
                    parent.getChildren().clear();
                    Pane kartu = new Pane();
                    kartu.setPrefSize(103,104);
                    parent.getChildren().add(kartu);
                    Card insideCard =  (Card) currPlayer.getDeck().getAktifElement(i);
                    if (insideCard != null) {
                        parent = (Pane) parent.getChildren().get(0);
                        InputStream img = Main.class.getClassLoader().getResourceAsStream(insideCard.getImgPath());
                        if (img != null) {
                            parent.getChildren().add(new ImageView(new
                                    Image(
                                    img)));
                            ( (ImageView) parent.getChildren().get(0)).setFitHeight(85);
                            ( (ImageView) parent.getChildren().get(0)).setFitWidth(85);

                        }

                    }
                }

            }
        for (int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                Pane kartu = new Pane();
                kartu.setPrefSize(103,104);
                Pane parent = ((Pane) Main.fieldPane.getChildren().get(i*5+j));
                parent.getChildren().clear();
                parent.getChildren().add(kartu);
                KartuLadang insideCard = (KartuLadang) currPlayer.getPetakLadang().getElement(i,j);
                if (insideCard != null) {
                    parent = (Pane) parent.getChildren().get(0);
                    parent.getChildren().add(new ImageView(new
                            Image(
                            Main.class.getClassLoader().getResourceAsStream(insideCard.getKartu().getImgPath()
                            ))));
                    ( (ImageView) parent.getChildren().get(0)).setFitHeight(85);
                    ( (ImageView) parent.getChildren().get(0)).setFitWidth(85);
                }
            }

        }

    }
    private void initializeDragAndDrop(Pane parent) {
        Pane parentPane = (Pane) parent;
        if (parentPane != null){
            for (Node node : parentPane.getChildren()) {

                if (node instanceof Pane) {
                    Pane pane = (Pane) node;
                    pane.setOnDragDetected(event -> {
                        if (pane.getChildren().isEmpty()) return;
                        Dragboard db = pane.startDragAndDrop(TransferMode.ANY);
                        ClipboardContent content = new ClipboardContent();
                        content.putString(pane.getId()); // Use an identifier to find the source node
                        db.setContent(content);
                        event.consume();
                        System.out.println("source: "+pane.getId());
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
                            System.out.println(draggedPaneId);
                            Pane draggedPane = (Pane) parentPane.lookup("#" + draggedPaneId);
                            if (draggedPane == null) {
                                draggedPane = (Pane) deckPane.lookup("#" + draggedPaneId);
                            }
                            if (draggedPane == null) {
                                draggedPane = (Pane) fieldPane.lookup("#" + draggedPaneId);
                            }
                            if (draggedPane != null) {
                                System.out.println(draggedPane.getId());
//                            ((Pane) draggedPane.getParent()).getChildren().remove(draggedPane);

                                System.out.println("target: "+pane.getId());

                                Pane sourceCard = (Pane) draggedPane.getChildren().get(0);


                                Pane nampan_sumber = (Pane) draggedPane;
                                Pane hvs = (Pane) nampan_sumber.getChildren().get(0);

                                // var pane adalah nampan target
                                Pane temp = null;
                                if (!pane.getChildren().isEmpty()){
                                    temp = (Pane) pane.getChildren().get(0);
                                }
                                pane.getChildren().add(hvs);

                                draggedPane.getChildren().clear();// Add the dragged pane to the target pane
                                if (temp != null) {
                                    draggedPane.getChildren().add(temp);
                                }
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

}