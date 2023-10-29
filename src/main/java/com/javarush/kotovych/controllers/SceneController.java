package com.javarush.kotovych.controllers;

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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

    @FXML
    private Button outputFilePathPreviewButton;

    @FXML
    private Button inputFilePathPreviewButton;

    @FXML
    private TextField char1Input;

    @FXML
    private TextField char2Input;

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
    private Button startButton;

    @FXML
    private Button swapButton;

    @FXML
    private TextArea textPreview;

    String previewing;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modeChoose.getItems().addAll(Constants.ENCODE, Constants.DECODE, Constants.BRUTE_FORCE);
        languageChoose.getItems().addAll(Constants.EN, Constants.RU);
    }

    @FXML
    void onStartButtonClick(ActionEvent event) {
        boolean normal = checkFile(Path.of(inputPathTextField.getText()));
        if(normal) {
            Path inputFilePath = Path.of(inputPathTextField.getText());
            Path ouputFilePath = Path.of(outputPathTextField.getText());
            Action mode = getMode();
            Alphabet language = getLanguage();
            int key = getKey();

            try {
                mode.execute(inputFilePath, key, ouputFilePath, language);
            } catch (AppException | NullPointerException npe) {
                showError("Error", "Something went wrong");
            }
        }
    }

    @FXML
    void onSwapButtonClick(ActionEvent event) {
        Path path = Path.of(previewing.equals("Output") ? outputPathTextField.getText() : inputPathTextField.getText());
        try(BufferedWriter writer = Files.newBufferedWriter(path)){

            char[] text = textPreview.getText().toCharArray();
            char[] chars = getCharToSwap();
            List<Integer> indexesOfChanging = getIndexes(chars[0], text);
            for(int i = 0; i < indexesOfChanging.size(); i++){
                text[indexesOfChanging.get(i)] = chars[1];
            }

            writer.write(new String(text));
            onPreviewInputButtonClick(new ActionEvent());

        } catch (NullPointerException npe){
            showError("Error", "Chars cannot be null");
        } catch (Exception e){
            showError("Error", "Something went wrong");
            e.printStackTrace();
        }
    }

    @FXML
    void onPreviewOutputButtonClick(ActionEvent event){
        String text = getTextFromFile(Path.of(outputPathTextField.getText()));
        textPreview.setText(text);
        previewing = "Output";
    }

    @FXML
    void onPreviewInputButtonClick(ActionEvent event){
        String text = getTextFromFile(Path.of(inputPathTextField.getText()));
        textPreview.setText(text);
        previewing = "Input";
    }

    private void showError(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private Alphabet getLanguage(){
        try {
            Alphabet language = AlphabetContainer.get(languageChoose.getValue());
            return language;
        } catch (Exception e){
            showError("Language", "Language cannot be null");
            return null;
        }
    }

    private Action getMode(){
        try {
            Action mode = ActionContainer.get(modeChoose.getValue());
            return mode;
        } catch (Exception e){
            showError("Mode", "Mode cannot be null");
            return null;
        }
    }

    private int getKey(){
        try {
            int key = Integer.parseInt(keyInput.getText());
            return key;
        } catch (NumberFormatException nfe){
            showError("Type error", "Key cannot be a string");
            return 0;
        } catch (Exception e){
            showError("Key", "Key cannot be null");
            return 0;
        }
    }

    private String getTextFromFile(Path path){
        try(BufferedReader reader = Files.newBufferedReader(path)){
            StringBuilder builder = new StringBuilder();
            List<String> lines = reader.lines().toList();
            for(String line : lines){
                builder.append(line).append('\n');
            }
            String text = builder.toString();
            return text;
        } catch (Exception e){
            showError("Error", "Something went wrong");
            return null;
        }
    }

    private char[] getCharToSwap(){
        try {
            char[] chars = new char[2];
            chars[0] = char1Input.getText().charAt(0);
            chars[1] = char2Input.getText().charAt(0);
            return chars;
        } catch (Exception e){
            showError("Error", "Something went wrong");
        }
        return null;
    }

    private List<Integer> getIndexes(char ch, char[] text){
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < text.length; i++){
            if(text[i] == ch){
                indexes.add(i);
            }
        }
        return indexes;
    }

    private boolean checkFile(Path path){
        if(Files.exists(path) && Files.isRegularFile(path)){
            return true;
        } else {
            showError("Error", "There is a problem with file");
            return false;
        }
    }
}
