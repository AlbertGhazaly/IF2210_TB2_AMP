package com.tubesoop.tubes2oop;

import gameobject.GameObject;
import card.Card;
import gamestatus.GameStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import player.Player;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import state.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import gamestatus.*;
public class ShuffleController implements Initializable {
    GameObject gameObject;
    GameStatus gameStatus;
    Player player1;
    Player player2;
    Boolean isPickedFour = false;
    int selectedNum;
    Shuffle gameShuffle;
    boolean isCard1Selected;
    boolean isCard2Selected;
    boolean isCard3Selected;
    boolean isCard4Selected;

    /* 4 Random Cards */
    @FXML Pane card1;
    @FXML Pane card2;
    @FXML Pane card3;
    @FXML Pane card4;
    @FXML ImageView ImageCard1;
    @FXML ImageView ImageCard2;
    @FXML ImageView ImageCard3;
    @FXML ImageView ImageCard4;

    /* Shuffle Button */
    @FXML Button shuffleButton;
    @FXML Button shuffleButton1;

    /* Shuffle Card Pane */
    @FXML AnchorPane shuffleCard;

    static AnchorPane SshuffleCard;

    public void setGameObject(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        this.gameObject = this.gameStatus.getObjek();
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
        this.gameShuffle = (Shuffle) this.gameStatus.getStatus();
    }

    public void initialize(URL location, ResourceBundle resources) {
        SshuffleCard = shuffleCard;

        try {
            this.shuffleCard.setVisible(false);
            this.gameStatus.execute();

            this.selectedNum = 0;
            this.isCard1Selected = false;
            this.isCard2Selected = false;
            this.isCard3Selected = false;
            this.isCard4Selected = false;
            ImageCard1.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(0).getImgPath())));
            ImageCard2.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(1).getImgPath())));
            ImageCard3.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(2).getImgPath())));
            ImageCard4.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(3).getImgPath())));
        } catch (Exception ex) {
            System.out.println("Invalid URL or unable to load image.");
        }
    }

    public static void openShuffleCard() {
        SshuffleCard.setVisible(true);
    }

    @FXML
    public void shuffleCard() {
        try {
            ImageCard1.setImage(null);
            ImageCard2.setImage(null);
            ImageCard3.setImage(null);
            ImageCard4.setImage(null);
            this.gameShuffle.insertCardBack(this.gameObject);
            gameStatus.execute();


            this.selectedNum = 0;
            this.isCard1Selected = false;
            this.isCard2Selected = false;
            this.isCard3Selected = false;
            this.isCard4Selected = false;
            ImageCard1.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(0).getImgPath())));
            ImageCard2.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(1).getImgPath())));
            ImageCard3.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(2).getImgPath())));
            ImageCard4.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(3).getImgPath())));
        } catch (Exception ex) {
            System.out.println("Invalid URL or unable to load image.");
        }


    }

    @FXML
    public void selectCard1toDeck(MouseEvent event){
        if (!this.isCard1Selected){
            System.out.println(this.selectedNum);
            System.out.println(this.gameObject.getCurrentPlayer().getDeck().getAktifSize());
            if (this.selectedNum < 6 - this.gameObject.getCurrentPlayer().getDeck().getAktifSize()){
                this.isCard1Selected = true;
                this.selectedNum++;
                card1.setStyle("-fx-border-color: green; -fx-border-width: 5px;");
            }
        }else{
            this.isCard1Selected = false;
            selectedNum--;
            card1.setStyle("-fx-background-radius: 10;");
        }
    }

    @FXML
    public void selectCard2toDeck(MouseEvent event){
        if (!isCard2Selected){
            if (selectedNum < 6 - gameObject.getCurrentPlayer().getDeck().getAktifSize()){
                isCard2Selected = true;
                selectedNum++;
                card2.setStyle("-fx-border-color: green; -fx-border-width: 5px;");
            }
        }else{
            isCard2Selected = false;
            selectedNum--;
            card2.setStyle("-fx-background-radius: 10;");
        }
    }
    @FXML
    public void selectCard3toDeck(MouseEvent event){
        if (!isCard3Selected){
            if (selectedNum < 6 - gameObject.getCurrentPlayer().getDeck().getAktifSize()){
                isCard3Selected = true;
                selectedNum++;
                card3.setStyle("-fx-border-color: green; -fx-border-width: 5px;");
            }
        }else{
            isCard3Selected = false;
            selectedNum--;
            card3.setStyle("-fx-background-radius: 10;");
        }
    }
    @FXML
    public void selectCard4toDeck(MouseEvent event){
        if (!isCard4Selected){
            if (selectedNum < 6 - gameObject.getCurrentPlayer().getDeck().getAktifSize()){
                isCard4Selected = true;
                selectedNum++;
                card4.setStyle("-fx-border-color: green; -fx-border-width: 5px;");
            }
        }else{
            isCard4Selected = false;
            selectedNum--;
            card4.setStyle("-fx-background-radius: 10;");
        }
    }
    @FXML
    public void handleFinish() {
        // Hide the shuffleCard pane
        if (isCard1Selected){
            System.out.println("insert card 1");
            System.out.println(this.gameShuffle.getCards().get(0).getName());
            this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(0));
        }
        if (isCard2Selected){
            System.out.println("insert card 2");
            System.out.println(this.gameShuffle.getCards().get(1).getName());
            this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(1));
        }
        if (isCard3Selected){
            System.out.println("insert card 3");
            System.out.println(this.gameShuffle.getCards().get(2).getName());
            this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(2));
        }
        if (isCard4Selected){
            System.out.println("insert card 4");
            System.out.println(this.gameShuffle.getCards().get(3).getName());
            this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(3));

        }
//        for (int i=0;i<this.gameObject.getCurrentPlayer().getDeck().getAktifSize();i++){
//            System.out.println(this.gameObject.getCurrentPlayer().getDeck().getAktifElement(i).getName());
//        }
        System.out.println(this.gameObject.getCurrentPlayer().getDeck().getAktifSize());
        FieldController.reloadImage();
        card1.setStyle("-fx-border-color: none;");
        card2.setStyle("-fx-border-color: none;");
        card3.setStyle("-fx-border-color: none;");
        card4.setStyle("-fx-border-color: none;");
        shuffleCard.setVisible(false);
//        this.gameObject.getCurrentPlayer().
    }
}
