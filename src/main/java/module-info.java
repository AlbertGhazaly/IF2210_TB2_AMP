module com.tubesoop.tubes2oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.tubesoop.tubes2oop to javafx.fxml;
    exports com.tubesoop.tubes2oop;
}