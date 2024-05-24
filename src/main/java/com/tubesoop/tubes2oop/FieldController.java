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
import petakladang.*;
import javafx.scene.control.Label;
import deck.*;
import card.*;
import java.util.List;
import java.net.URL;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import exception.*;
import javafx.scene.media.*;
import java.io.File;
import com.tubesoop.tubes2oop.ObjectInfoController;

public class FieldController implements Initializable {
    private static GameObject gameObject;
    public static Player currPlayer;

    /* Inisiasi Player */
    @FXML private static Player player1;
    @FXML private static Player player2;
    public static Deck deckCurr;
    public static PetakLadang petakLadangCurr;

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
    @FXML private  Label labelDeck;
    private static Label labelDeckStatic;
    /* Deck Pane */
    @FXML private Pane deckPane;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @FXML private Pane pane3;
    @FXML private Pane pane4;
    @FXML private Pane pane5;
    @FXML private Pane pane6;

    @FXML Pane FieldMain;
    static Pane SFieldMain;

    private static FieldController instance;

    public FieldController() {
        instance = this;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.player1 = this.gameObject.getPlayer1();
        this.player2 = this.gameObject.getPlayer2();
        currPlayer = gameObject.getCurrentPlayer();
        deckCurr = currPlayer.getDeck();
        petakLadangCurr = currPlayer.getPetakLadang();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SFieldMain = FieldMain;
        SFieldMain.setVisible(false);
        labelDeckStatic = labelDeck;
        initializeDragAndDrop(fieldPane);
        initializeDragAndDrop(deckPane);

            for (int i = 0; i < 6; i++){
                Pane kartu = new Pane();
                kartu.setPrefSize(103,104);

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
//        for (int i = 0; i < 6; i++) {
//            Pane parent = ((Pane) Main.deckPane.getChildren().get(i));
//            if (parent != null) {
//                parent.setOnMouseClicked(event -> {
//                    showObjectDataDialog(parent);
//                });
//            }
//        }
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 5; j++) {
//                Pane parent = ((Pane) Main.fieldPane.getChildren().get(i * 5 + j));
//                if (parent != null) {
//                    parent.setOnMouseClicked(event -> {
//                        showObjectDataDialog(parent);
//                    });
//                }
//            }
//        }
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
                KartuLadang insideCard = (KartuLadang) petakLadangCurr.getElement(i,j);
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
        labelDeckStatic.setText(String.valueOf(currPlayer.getDeck().getPasifSize()) + "/40");
    }

    public static void showErrorDialog(Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("An Exception Occurred");
        alert.setContentText(e.getMessage());

        // Print the stack trace to the console (optional)
        e.printStackTrace();

        alert.showAndWait();
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
                                Pane sumber_parent = (Pane) nampan_sumber.getParent();
                                Pane target_parent = (Pane) pane.getParent();
                                if (sumber_parent.getChildren().size()==6 && target_parent.getChildren().size()==20){
//                                    tanam
                                        Pattern pattern = Pattern.compile("pane(\\d+)");
                                        Matcher matcher = pattern.matcher(nampan_sumber.getId());
                                        int id1,id2;
                                        matcher.find();
                                        String number = matcher.group(1);
                                        id1 = Integer.parseInt(number);
                                        pattern = Pattern.compile("Pane(\\d+)");
                                        matcher = pattern.matcher(pane.getId());
                                        matcher.find();
                                        number = matcher.group(1);
                                        id2 = Integer.parseInt(number);
                                        Card deckCard = (Card) deckCurr.getAktifElement(id1-1);
                                        KartuLadang ladangCard = (KartuLadang) petakLadangCurr.getElement((id2-1)/5,(id2-1)%5);
                                        try{
                                            System.out.println(ladangCard);
                                            if (ladangCard == null) {
//                                                tanam
                                                if (deckCard instanceof Item || deckCard instanceof Produk){
                                                    throw new InappropriateObjectInsertion();
                                                }

                                                if (petakLadangCurr != gameObject.getCurrentPlayer().getPetakLadang()){
                                                    throw new FieldInAccessible();
                                                }else{
                                                    KartuLadang newLadangCard = new KartuLadang(deckCard);
                                                    petakLadangCurr.addElement(newLadangCard,(id2-1)/5,(id2-1)%5);
//                                                    System.out.println("Item size: "+newLadangCard.getItems().size());
                                                }

                                                deckCurr.removeAktifElement(id1-1);

                                            }else{
//                                              insert item/ makan
                                                if (deckCard instanceof Item){
                                                    if (((Item) deckCard).getName().equals("INSTANT_HARVEST")){
                                                        if (petakLadangCurr != currPlayer.getPetakLadang()){
                                                            throw new FieldInAccessible();
                                                        }
                                                        List<Produk> produkHasil= new ArrayList<>();
                                                        for (int i=0;i<GameObject.produkList.size();i++){
                                                            if (GameObject.produkList.get(i).getOrisinil().equals(ladangCard.getKartu().getName())){
                                                                produkHasil.add(new Produk((Produk) GameObject.produkList.get(i)));
                                                            }
                                                        }
                                                        if (produkHasil.size()>(7-deckCurr.getAktifSize())){
                                                            throw new DeckAktifFullException();
                                                        }
                                                        deckCurr.removeAktifElement(id1-1);
                                                        for (int n=0;n<produkHasil.size();n++){
                                                            deckCurr.addAktifElementRandom(produkHasil.get(n));
                                                        }
                                                        petakLadangCurr.removeElement((id2-1)/5,(id2-1)%5);
                                                    }else if (deckCard.getName().equals("DESTROY")){
                                                        if (petakLadangCurr == currPlayer.getPetakLadang()){
                                                            throw new FieldInAccessible();
                                                        }
                                                        List<Item> itemInCard= ladangCard.getItems();
                                                        for (int k=0;k<itemInCard.size();k++){
                                                            if (itemInCard.get(k).getName().equals("PROTECT")){
                                                                ladangCard.getItems().remove(k);
                                                                deckCurr.removeAktifElement(id1-1);
                                                                return;
                                                            }
                                                        }
                                                        petakLadangCurr.removeElement((id2-1)/5,(id2-1)%5);
                                                        deckCurr.removeAktifElement(id1-1);
                                                    }else if (deckCard.getName().equals("DELAY")){
                                                        if (petakLadangCurr == currPlayer.getPetakLadang()){
                                                            throw new FieldInAccessible();
                                                        }
                                                        List<Item> itemInCard= ladangCard.getItems();
                                                        for (int k=0;k<itemInCard.size();k++){
                                                            if (itemInCard.get(k).getName().equals("PROTECT")){
                                                                ladangCard.getItems().remove(k);
                                                                deckCurr.removeAktifElement(id1-1);
                                                                return;
                                                            }
                                                        }
                                                        if (ladangCard.getKartu() instanceof Hewan){
                                                            if (((Hewan) ladangCard.getKartu()).getBerat()<=5){
                                                                ((Hewan) ladangCard.getKartu()).setBerat(0);
                                                            }else{
                                                                ((Hewan) ladangCard.getKartu()).addBerat(-5);
                                                            }
                                                        } else if (ladangCard.getKartu() instanceof Tanaman){
                                                            if (((Tanaman) ladangCard.getKartu()).getUmur()<=2){
                                                                ((Tanaman) ladangCard.getKartu()).addUmur(-1*((Tanaman) ladangCard.getKartu()).getUmur());
                                                            }else{
                                                                ((Tanaman) ladangCard.getKartu()).addUmur(-2);
                                                            }
                                                        }
                                                        deckCurr.removeAktifElement(id1-1);
                                                    }else if(deckCard.getName().equals("ACCELERATE")){
                                                        if (petakLadangCurr != currPlayer.getPetakLadang()){
                                                            throw new FieldInAccessible();
                                                        }
                                                        if (ladangCard.getKartu() instanceof Hewan){
                                                            ((Hewan) ladangCard.getKartu()).addBerat(8);
                                                        }else if (ladangCard.getKartu() instanceof Tanaman){
                                                            ((Tanaman) ladangCard.getKartu()).addUmur(2);
                                                        }
                                                        deckCurr.removeAktifElement(id1-1);
                                                    }else {
                                                        if (petakLadangCurr != currPlayer.getPetakLadang()){
                                                            throw new FieldInAccessible();
                                                        }
                                                        petakLadangCurr.getElement((id2-1)/5,(id2-1)%5).addItems((Item) deckCard);
                                                        deckCurr.removeAktifElement(id1-1);
                                                    }

                                                }else if(deckCard instanceof Produk){
                                                        if (currPlayer.getPetakLadang() != petakLadangCurr){
                                                            throw new FieldInAccessible();
                                                        }
                                                        if (ladangCard.getKartu() instanceof Hewan){
                                                            if (((Hewan) ladangCard.getKartu()).getKategori().equals("karnivora")) {
                                                                if (deckCard.getName().equals("JAGUNG") || deckCard.getName().equals("LABU") || deckCard.getName().equals("STROBERI")) {
                                                                    throw new InappropriateFood();
                                                                }

                                                            }
                                                            if(((Hewan) ladangCard.getKartu()).getKategori().equals("herbivora")){
                                                                System.out.println("herbivora");
                                                                if (!(deckCard.getName().equals("JAGUNG") || deckCard.getName().equals("LABU") || deckCard.getName().equals("STROBERI"))){
                                                                    throw new InappropriateFood();
                                                                }
                                                            }
                                                            ((Hewan)((KartuLadang) petakLadangCurr.getElement((id2-1)/5,(id2-1)%5)).getKartu()).addBerat(((Produk) deckCard).getAddedBerat());
                                                            deckCurr.removeAktifElement(id1-1);
                                                        }else{
                                                            throw new InappropriateObjectInsertion();
                                                        }
                                                }else{
                                                    throw new InsertNonItemException();
                                                }
                                            }
                                        }catch (Exception e){
                                            e.printStackTrace();
                                            showErrorDialog(e);
                                        }
                                        reloadImage();

                                }else if (sumber_parent.getChildren().size()==20 && target_parent.getChildren().size()==6){
                                    return;
                                }else if (sumber_parent.getChildren().size()==6 && target_parent.getChildren().size()==6){
//                                  swap deck to deck
                                    Pattern pattern = Pattern.compile("pane(\\d+)");
                                    Matcher matcher = pattern.matcher(pane.getId());
                                    int id1,id2;
                                    matcher.find();
                                    String number = matcher.group(1);
                                    id1 = Integer.parseInt(number);
                                    matcher = pattern.matcher(nampan_sumber.getId());
                                    matcher.find();
                                    number = matcher.group(1);
                                    id2 = Integer.parseInt(number);
                                    System.out.println(id1+" "+id2);
                                    deckCurr.swapIndex(id1-1,id2-1);
                                }else{
                                    try{
                                        if (currPlayer.getPetakLadang()!=petakLadangCurr){
                                            throw new FieldInAccessible();
                                        }
//                                    swap petakLadang to PetakLadang
                                        Pattern pattern = Pattern.compile("Pane(\\d+)");
                                        Matcher matcher = pattern.matcher(pane.getId());
                                        int id1,id2;
                                        matcher.find();
                                        String number = matcher.group(1);
                                        id1 = Integer.parseInt(number);
                                        matcher = pattern.matcher(nampan_sumber.getId());
                                        matcher.find();
                                        number = matcher.group(1);
                                        id2 = Integer.parseInt(number);
                                        System.out.println(id1+" "+id2);
                                        petakLadangCurr.swapElement(id1-1,id2-1);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                        showErrorDialog(e);
                                    }

                                }
//                                Pane temp = null;
//                                if (!pane.getChildren().isEmpty()){
////                                    if ((Pane) nampan_sumber.getParent().)
//                                    temp = (Pane) pane.getChildren().get(0);
//                                }
//                                pane.getChildren().add(hvs);
//
//                                draggedPane.getChildren().clear();// Add the dragged pane to the target pane
//                                if (temp != null) {
//                                    draggedPane.getChildren().add(temp);
//                                }
                                success = true;
                            }
                        }
                        event.setDropCompleted(success);
                        event.consume();
                    });

                    // Setiap pane akan memiliki fungsi ketika di klik
                    pane.setOnMouseClicked(event -> {
                        showObjectDataDialog(pane);
                    });
                }
            }
        }
    }

    private void showObjectDataDialog(Pane pane) {
        int index = ((Pane) pane.getParent()).getChildren().indexOf(pane);
        int row = index / 5;
        int col = index % 5;

        KartuLadang kartuLadang = (KartuLadang) petakLadangCurr.getElement(row, col);
        if (kartuLadang != null && (kartuLadang.getKartu() instanceof Hewan || kartuLadang.getKartu() instanceof Tanaman)) {
            ObjectInfoController.ObjectInfoCardOnClicked(kartuLadang, row, col);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Data Tidak Ditemukan");
            alert.setHeaderText("Tidak Dapat Melihat Informasi Petak ");

            if (kartuLadang == null) {
                alert.setContentText("Petak Kosong!");
            }
            else if (!(kartuLadang.getKartu() instanceof Hewan) && !(kartuLadang.getKartu() instanceof Tanaman)) {
                alert.setContentText("Kartu Bukan Merupakan Hewan atau Tumbuhan");
            }

            alert.showAndWait();
        }
    }
}

