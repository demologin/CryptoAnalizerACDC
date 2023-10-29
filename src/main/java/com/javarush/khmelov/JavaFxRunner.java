package com.javarush.khmelov;

import com.javarush.khmelov.controller.MainController;
import com.javarush.khmelov.view.javafx.FxForm;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFxRunner extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MainController controller = new MainController();
        FxForm fxForm = new FxForm(stage, controller);
        fxForm.initialization();
    }
}
