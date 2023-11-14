package com.javarush.khmelov.view.javafx;

import com.javarush.khmelov.constant.Alphabet;
import com.javarush.khmelov.constant.Const;
import com.javarush.khmelov.controller.MainController;
import com.javarush.khmelov.entity.Result;
import com.javarush.khmelov.entity.ResultCode;
import com.javarush.khmelov.util.PathBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.khmelov.view.javafx.FixedFileNames.*;

public class FxForm {

    public static final String TITLE = "Java FX (demo - only fixed filenames)";
    public static final String DEFAULT_FONT = "System";
    public static final String SHOW_TXT = "Original";

    public static final Insets PADDING = new Insets(5);
    public static final int DEFAULT_FONT_SIZE = 14;
    public static final int W_SIZE = 16;
    public static final int H_SIZE = 9;
    public static final int SCALE = 50;

    private final Stage stage;
    private final MainController mainController;

    private TextArea textArea;
    private Label message;
    private Slider key;
    private Label keyLabel;

    public FxForm(Stage stage, MainController mainController) {
        this.stage = stage;
        this.mainController = mainController;
        Scene scene = buildSceneAndAddActions();
        stage.setScene(scene);
        stage.setTitle(TITLE);
    }

    public void initialization() {
        stage.show();
    }

    private Scene buildSceneAndAddActions() {
        BorderPane pane = new BorderPane();
        pane.setTop(getTopNode());
        pane.setCenter(getCenterNode());
        pane.setBottom(getBottomNode());
        updateKeyLabel();
        return new Scene(pane, W_SIZE * SCALE, H_SIZE * SCALE);
    }

    private GridPane getTopNode() {
        GridPane topPanel = new GridPane();
        Button[] buttons = createTopPanelButtons();
        topPanel.setHgap(PADDING.getLeft());
        topPanel.setVgap(PADDING.getTop());
        topPanel.setPadding(PADDING);
        int rowIndex = 0;
        for (int colIndex = 0; colIndex < buttons.length; colIndex++) {
            topPanel.add(buttons[colIndex], colIndex, rowIndex);
        }
        return topPanel;
    }

    private Parent getCenterNode() {
        textArea = new TextArea();
        return textArea;
    }

    private Node getBottomNode() {
        message = new Label();
        message.setPadding(PADDING);
        message.setFont(Font.font(DEFAULT_FONT, FontWeight.BOLD, DEFAULT_FONT_SIZE));
        keyLabel = new Label();
        key = new Slider(1, Alphabet.charsArray.length - 1, 1);
        key.valueProperty().addListener(e -> updateKeyLabel());
        VBox vBox = new VBox(keyLabel, key, message);
        vBox.setPadding(PADDING);
        return vBox;
    }

    private void updateKeyLabel() {
        keyLabel.setText("Key: " + getKey());
    }

    private String getKey() {
        return String.valueOf(Math.round(key.getValue()));
    }


    private Button[] createTopPanelButtons() {
        Button original = createButton(SHOW_TXT, e -> showTextFromFile(TEXT_TXT));
        Button encode = createButton(Const.ENCODE, TEXT_TXT, ENCODE_TXT);
        Button decode = createButton(Const.DECODE, ENCODE_TXT, DECODE_TXT);
        Button bruteForce = createButton(Const.BRUTEFORCE, ENCODE_TXT, BRUTE_FORCE_TXT);
        Button analyze = createButton(Const.ANALYZE, ENCODE_TXT, DICTIONARY_TXT, ANALYZE_TXT);
        return new Button[]{original, encode, decode, bruteForce, analyze};
    }

    private Button createButton(String action, String... parameters) {
        return createButton(action, e -> executeActionAndShowResult(action, parameters));
    }

    private Button createButton(String name, EventHandler<ActionEvent> eventHandler) {
        Button button = new Button(capitalizeFirst(name));
        button.setOnAction(eventHandler);
        return button;
    }

    private String capitalizeFirst(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private void executeActionAndShowResult(String command, String... parameters) {
        if (command.equals(Const.ENCODE) || command.equals(Const.DECODE)) {
            parameters = new String[]{parameters[0], parameters[1], getKey()};
        }
        Result result = mainController.doAction(command, parameters);
        if (result.resultCode == ResultCode.OK) {
            for (int i = parameters.length - 1; i >= 0; i--) {
                String filename = parameters[i];
                if (filename.endsWith(".txt")) {
                    showTextFromFile(parameters[i]);
                    break;
                }
            }
        } else {
            message.setTextFill(Color.DARKRED);
            message.setText(result.message);
        }
    }

    private void showTextFromFile(String filename) {
        Path path = PathBuilder.get(filename);
        try {
            textArea.setText(Files.readString(path));
            message.setTextFill(Color.BLUE);
            message.setText(path.toString());
        } catch (IOException e) {
            message.setTextFill(Color.RED);
            message.setText(e.getMessage());
        }
    }
}
