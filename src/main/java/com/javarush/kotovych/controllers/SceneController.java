package com.javarush.kotovych.controllers;

import com.javarush.kotovych.commands.CipherMethods;
import com.javarush.kotovych.constants.Constants;
import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.ActionContainer;
import com.javarush.kotovych.containers.Alphabet;
import com.javarush.kotovych.containers.AlphabetContainer;
import com.javarush.kotovych.exceptions.AppException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class SceneController extends CipherMethods implements Initializable {


    @FXML
    private TextField inputPathTextField;

    @FXML
    private TextField keyInput;

    @FXML
    private ChoiceBox<String> languageChoose;

    @FXML
    private ChoiceBox<String> modeChoose;

    @FXML
    private TextField outputPathTextField;


    @FXML
    private TextArea textPreview;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modeChoose.getItems().addAll(Constants.ENCODE, Constants.DECODE, Constants.BRUTE_FORCE);
        languageChoose.getItems().addAll(Constants.EN, Constants.RU);
    }

    @FXML
    void onStartButtonClick(ActionEvent event) {
        boolean normalInput = checkFile(Path.of(inputPathTextField.getText()));
        boolean normalOutput = checkFile(Path.of(outputPathTextField.getText()));

        if(normalInput && normalOutput) {
            Path inputFilePath = Path.of(inputPathTextField.getText());
            Path ouputFilePath = Path.of(outputPathTextField.getText());
            Action mode = getMode();
            Alphabet language = getLanguage();
            int key = getKey();

            try {
                String text = mode.execute(inputFilePath, key, ouputFilePath, language);
                textPreview.setText(text);
            } catch (AppException ae) {
                showError("An exception occurred while running", ae);
            }
        } else{
            showError("Input or output text field is empty or is a directory");
        }
    }

    @FXML
    void onPreviewOutputButtonClick(ActionEvent event){
        try {
            String text = getTextFromFile(Path.of(outputPathTextField.getText()));
            textPreview.setText(text);
        } catch (AppException e){
            showError("An exception occurred while running", e);
        }
    }

    @FXML
    void onPreviewInputButtonClick(ActionEvent event){
        try {
            String text = getTextFromFile(Path.of(inputPathTextField.getText()));
            textPreview.setText(text);
        } catch (AppException e){
            showError("An exception occurred while running", e);
        }
    }


    @FXML
    void onSwitchPathsButtonClick(ActionEvent event){
        String inputText = inputPathTextField.getText();
        String outputText = outputPathTextField.getText();

        inputPathTextField.setText(outputText);
        outputPathTextField.setText(inputText);
    }


    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private Alphabet getLanguage(){
        try {
            return AlphabetContainer.get(languageChoose.getValue());
        } catch (Exception e){
            showError("Language cannot be null");
            return null;
        }
    }

    private Action getMode(){
        try {
            return ActionContainer.get(modeChoose.getValue());
        } catch (Exception e){
            showError("Mode cannot be null");
            return null;
        }
    }

    private int getKey() {
        try {
            String key = keyInput.getText();
            if(key.isBlank() || key.isEmpty()){
                showError("Key cannot be empty");
                return 0;
            }
            return Integer.parseInt(key);
        } catch (NumberFormatException nfe) {
            showError("Key cannot be a string");
            return 0;
        } catch (NullPointerException npe) {
            showError("Key cannot be null");
            return 0;
        } catch (Exception e) {
            showError("An exception occurred while running", e);
            return 0;
        }
    }

    private boolean checkFile(Path path){
        return Files.exists(path) && Files.isRegularFile(path);
    }

    private void showError(String message, Exception ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
}
