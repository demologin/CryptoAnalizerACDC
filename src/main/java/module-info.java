module com.javarush.kotovych.cryptoanalyzer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.javarush.kotovych.cryptoanalyzer to javafx.fxml;
    exports com.javarush.kotovych.cryptoanalyzer;

    exports com.javarush.kotovych.controllers;
    opens com.javarush.kotovych.controllers;
}