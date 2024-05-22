package com.tubesoop.tubes2oop;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class TokoController implements Initializable {
    @FXML public AnchorPane TokoPane;
    @FXML public Button CloseButton;

    static AnchorPane alandToko;

    public void  closeToko() {
        TokoPane.setVisible(false);
    }

    public void initialize(URL location, ResourceBundle resources) {
        TokoPane.setVisible(false);
        alandToko = TokoPane;
    }
}