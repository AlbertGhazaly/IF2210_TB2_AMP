package com.tubesoop.tubes2oop;

import exception.SelectShuffleCardLessException;
import exception.SelectShuffleCardOverException;
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
    private static GameStatus gameStatus;
    Player player1;
    Player player2;
    Boolean isPickedFour = false;
    static int selectedNum;
    static Shuffle gameShuffle;
    static boolean isCard1Selected;
    static boolean isCard2Selected;
    static boolean isCard3Selected;
    static boolean isCard4Selected;

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
    @FXML AnchorPane shuffleCard;
    @FXML Button shuffleButton;
    @FXML Button shuffleButton1;

    /* Shuffle Card Pane */

    static AnchorPane SshuffleCard;
    static ImageView dImageCard1;
    static ImageView dImageCard2;
    static ImageView dImageCard3;
    static ImageView dImageCard4;
    public void setGameObject(GameStatus gamestatus) {
        gameStatus = gamestatus;
        this.gameObject = gameStatus.getObjek();
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
        gameShuffle = (Shuffle) gameStatus.getStatus();
    }

    public void initialize(URL location, ResourceBundle resources) {
        SshuffleCard = shuffleCard;
        dImageCard1 = ImageCard1;
        dImageCard2 = ImageCard2;
        dImageCard3 = ImageCard3;
        dImageCard4 = ImageCard4;
        try {
            this.shuffleCard.setVisible(false);

            gameStatus.execute();

            this.selectedNum = 0;
            this.isCard1Selected = false;
            this.isCard2Selected = false;
            this.isCard3Selected = false;
            this.isCard4Selected = false;
            dImageCard1.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(0).getImgPath())));
            dImageCard2.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(1).getImgPath())));
            dImageCard3.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(2).getImgPath())));
            dImageCard4.setImage(new Image(getClass().getClassLoader().getResourceAsStream(this.gameShuffle.getCards().get(3).getImgPath())));
        } catch (Exception ex) {
            System.out.println("Invalid URL or unable to load image.");
        }
    }
    public void shuffle(){
        this.shuffleCard();

    }
    public static void openShuffleCard() {
        selectedNum = 0;
        isCard1Selected = false;
        isCard2Selected = false;
        isCard3Selected = false;
        isCard4Selected = false;
        SshuffleCard.setVisible(true);
        shuffleCard();

    }

    @FXML
    public static void shuffleCard() {
        try {
            dImageCard1.setImage(null);
            dImageCard2.setImage(null);
            dImageCard3.setImage(null);
            dImageCard4.setImage(null);
            gameShuffle.insertCardBack(gameStatus.getObjek());
            gameStatus.execute();
            System.out.println("Deck pasif: "+gameStatus.getObjek().getCurrentPlayer().getDeck().getPasifSize());

            dImageCard1.setImage(new Image(Main.class.getClassLoader().getResourceAsStream(gameShuffle.getCards().get(0).getImgPath())));
            dImageCard2.setImage(new Image(Main.class.getClassLoader().getResourceAsStream(gameShuffle.getCards().get(1).getImgPath())));
            dImageCard3.setImage(new Image(Main.class.getClassLoader().getResourceAsStream(gameShuffle.getCards().get(2).getImgPath())));
            dImageCard4.setImage(new Image(Main.class.getClassLoader().getResourceAsStream(gameShuffle.getCards().get(3).getImgPath())));
        } catch (Exception ex) {
            System.out.println("Invalid URL or unable to load image.");
        }


    }

    @FXML
    public void selectCard1toDeck(MouseEvent event){
        if (!this.isCard1Selected){
            if (this.selectedNum < 6 - gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize()){
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
            if (selectedNum < 6 - gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize()){
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
            if (selectedNum < 6 - gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize()){
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
            if (selectedNum < 6 - gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize()){
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
        TurnController.STurnButton.setDisable(false);
        ActionsController.SmyField.setDisable(false);
        ActionsController.SoppField.setDisable(false);
        ActionsController.SshopButton.setDisable(false);
        ActionsController.SsaveStateButton.setDisable(false);
        ActionsController.SloadStateButton.setDisable(false);
        ActionsController.SloadPluginButton.setDisable(false);

        try {
            if ((6-gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize()) >= 4){
                if (selectedNum != 4){
                    throw new SelectShuffleCardLessException();
                }
            }else{
                if (selectedNum > (6-gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize())){
                    throw new SelectShuffleCardOverException();
                }else if (selectedNum < (6-gameStatus.getObjek().getCurrentPlayer().getDeck().getAktifSize())){
                    throw new SelectShuffleCardLessException();
                }
            }
            // Hide the shuffleCard pane
            if (isCard1Selected){
                System.out.println("insert card 1");
                System.out.println(this.gameShuffle.getCards().get(0).getName());
                this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(0));
            }else{
                this.gameObject.getCurrentPlayer().getDeck().addPasifElement(this.gameShuffle.getCards().get(0));
            }
            if (isCard2Selected){
                System.out.println("insert card 2");
                System.out.println(this.gameShuffle.getCards().get(1).getName());
                this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(1));
            }else{
                this.gameObject.getCurrentPlayer().getDeck().addPasifElement(this.gameShuffle.getCards().get(1));
            }
            if (isCard3Selected){
                System.out.println("insert card 3");
                System.out.println(this.gameShuffle.getCards().get(2).getName());
                this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(2));
            }else{
                this.gameObject.getCurrentPlayer().getDeck().addPasifElement(this.gameShuffle.getCards().get(2));
            }
            if (isCard4Selected){
                System.out.println("insert card 4");
                System.out.println(this.gameShuffle.getCards().get(3).getName());
                this.gameObject.getCurrentPlayer().getDeck().addAktifElementRandom(this.gameShuffle.getCards().get(3));
            }else{
                this.gameObject.getCurrentPlayer().getDeck().addPasifElement(this.gameShuffle.getCards().get(3));
            }
//        for (int i=0;i<this.gameObject.getCurrentPlayer().getDeck().getAktifSize();i++){
//            System.out.println(this.gameObject.getCurrentPlayer().getDeck().getAktifElement(i).getName());
//        }

            System.out.println(this.gameObject.getCurrentPlayer().getDeck().getAktifSize());
            System.out.println(this.gameObject.getCurrentPlayer().getDeck().getPasifSize());
            this.selectedNum = 0;
            gameShuffle.getCards().clear();
            FieldController.reloadImage();
            card1.setStyle("-fx-border-color: none;");
            card2.setStyle("-fx-border-color: none;");
            card3.setStyle("-fx-border-color: none;");
            card4.setStyle("-fx-border-color: none;");
            shuffleCard.setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
            FieldController.showErrorDialog(e);
        }

//        this.gameObject.getCurrentPlayer().
    }
}
