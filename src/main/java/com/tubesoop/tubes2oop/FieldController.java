package com.tubesoop.tubes2oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class FieldController implements Initializable {

    @FXML
    private ImageView deckImageView;
    @FXML
    private ImageView targetImageView1;
    @FXML
    private ImageView targetImageView2;
    @FXML
    private Pane targetPane1;
    @FXML
    private Pane targetPane2;
    // tambahkan ImageView lain jika perlu

    public void setupDragAndDrop() {
        // Set drag and drop for deck image view
        deckImageView.setOnDragDetected(event -> {
            Dragboard db = deckImageView.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(deckImageView.getImage());
            db.setContent(content);
            event.consume();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupDragAndDrop();
    }

    @FXML
    private void onDragOver(DragEvent event) {
        if (event.getGestureSource() != targetPane1 && event.getGestureSource() != targetPane2
                && event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }

    @FXML
    private void onDragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasImage()) {
            ImageView imageView = new ImageView(db.getImage());
            // Tentukan posisi ImageView yang baru di dalam pane target
            imageView.setLayoutX(event.getX());
            imageView.setLayoutY(event.getY());
            // tambahkan ImageView ke dalam pane target yang sesuai
            if (event.getTarget() == targetPane1) {
                targetPane1.getChildren().add(imageView);
                success = true;
            } else if (event.getTarget() == targetPane2) {
                targetPane2.getChildren().add(imageView);
                success = true;
            }
            // tambahkan penanganan lainnya jika Anda memiliki lebih banyak pane target
        }
        event.setDropCompleted(success);
        event.consume();
    }
}
