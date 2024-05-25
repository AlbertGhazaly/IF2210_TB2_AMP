module com.tubesoop.tubes2oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires java.compiler;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.xml;
    requires jdk.compiler;

    opens com.tubesoop.tubes2oop to javafx.fxml;
    exports com.tubesoop.tubes2oop;
}