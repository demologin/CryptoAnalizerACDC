package com.javarush.khmelov.view.swing;

import com.javarush.khmelov.constant.Const;
import com.javarush.khmelov.controller.MainController;
import com.javarush.khmelov.entity.Result;
import com.javarush.khmelov.entity.ResultCode;
import com.javarush.khmelov.util.PathBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;

@SuppressWarnings("unused")
public class MainForm extends JFrame {

    private static final int PERCENT_SCREEN = 60;
    public static final int MAX_PERCENT_SCREEN = 100;
    public static final String OK_MESSAGE = "OK";

    private final MainController controller;

    private JPanel panel;
    private JPanel top;
    private JPanel left;
    private JPanel right;
    private JPanel bottom;
    private JPanel content;
    private JTextArea textArea;
    private JButton setText;
    private JButton setEncrypted;
    private JTextField text;
    private JTextField encrypted;
    private JButton setDecrypted;
    private JButton setBruteforce;
    private JButton setAnalyzed;
    private JTextField decrypted;
    private JTextField bruteforce;
    private JTextField analyzed;
    private JButton runEncode;
    private JButton runDecode;
    private JButton runBruteforce;
    private JButton runAnalyze;
    private JButton loadText;
    private JButton loadEncrypted;
    private JButton loadDecrypted;
    private JButton loadBruteforce;
    private JButton loadAnalyzed;
    private JSlider keySlider;
    private JButton swap;
    private JSpinner key;
    private JButton loadDict;
    private JTextField dict;
    private JButton setDict;
    private JTextField ch1;
    private JTextField ch2;
    private JLabel currentFilename;

    public MainForm(MainController controller) {
        this.controller = controller;
    }

    static {
        setLookAndFeel("Nimbus");
    }

    @SuppressWarnings("SameParameterValue")
    private static void setLookAndFeel(String nameLookAndFeel) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (nameLookAndFeel.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
            System.out.println(lookAndFeel);
        }
    }

    public void initialization() {
        setIcon();
        initView();

        initOpenFileDialogs();
        initLoadButtons();
        initCommandListeners();
        initKeyListeners();
        initCharacterSwapListeners();
        initCharacterInputListener();
    }

    private void initView() {
        this.add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setStartPosition();
        setDefaultValues(text, encrypted, decrypted, bruteforce, dict, analyzed);
    }

    private void setIcon() {
        URL png = getClass().getResource("/icon.png");
        Image image = Toolkit.getDefaultToolkit().getImage(png);
        this.setIconImage(image);
    }


    private void initOpenFileDialogs() {
        addDialog(setText, text);
        addDialog(setEncrypted, encrypted);
        addDialog(setDecrypted, decrypted);
        addDialog(setBruteforce, bruteforce);
        addDialog(setDict, dict);
        addDialog(setAnalyzed, analyzed);
    }

    private void initLoadButtons() {
        setLoad(loadText, text);
        setLoad(loadEncrypted, encrypted);
        setLoad(loadDecrypted, decrypted);
        setLoad(loadBruteforce, bruteforce);
        setLoad(loadDict, dict);
        setLoad(loadAnalyzed, analyzed);
    }

    private void initCommandListeners() {
        runEncode.addActionListener(e -> run(Const.ENCODE,
                text.getText(), encrypted.getText(), key.getValue().toString()));
        runDecode.addActionListener(e -> run(Const.DECODE,
                encrypted.getText(), decrypted.getText(), key.getValue().toString()));
        runBruteforce.addActionListener(e -> run(Const.BRUTEFORCE,
                encrypted.getText(), bruteforce.getText()));
        runAnalyze.addActionListener(e -> run(Const.ANALYZE,
                encrypted.getText(), dict.getText(), analyzed.getText()));
    }

    private void initKeyListeners() {

        int startKey = 1;
        key.setValue(startKey);
        keySlider.setValue(startKey);

        keySlider.addChangeListener(e -> {
            int value = keySlider.getValue();
            key.setValue(value);
        });

        key.addChangeListener(e -> {
            int value = Integer.parseInt(key.getValue().toString());
            keySlider.setValue(value);
        });

    }

    private void initCharacterSwapListeners() {
        swap.addActionListener(e -> {
            char ch1 = this.ch1.getText().charAt(0);
            char ch2 = this.ch2.getText().charAt(0);

            String text = textArea.getText();
            text = text.replace(ch1, '~');
            text = text.replace(ch2, ch1);
            text = text.replace('~', ch2);
            textArea.setText(text);
            textArea.setCaretPosition(0);
        });
    }

    private void initCharacterInputListener() {
        ch1.addKeyListener(clearField());
        ch2.addKeyListener(clearField());
    }

    private void setLoad(JButton loadButton, JTextField textField) {
        loadButton.addActionListener(e -> loadText(textField.getText()));
    }

    private void run(String command, String... parameters) {
        Result result = controller.doAction(command, parameters);
        if (result.resultCode == ResultCode.OK) {
            loadText(result.message);
        } else {
            System.out.println(result);
        }
    }

    private void loadText(String filename) {
        try {
            String string = Files.readString(PathBuilder.get(filename));
            textArea.setText(string);
            textArea.setCaretPosition(0);
            currentFilename.setText("View file: " + filename);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Can't load file:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setDefaultValues(JTextField... filenames) {
        for (JTextField filename : filenames) {
            String name = filename.getText();
            filename.setText(PathBuilder.get(name).toString());
        }
    }

    private void setStartPosition() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width * PERCENT_SCREEN / MAX_PERCENT_SCREEN;
        int height = screenSize.height * PERCENT_SCREEN / MAX_PERCENT_SCREEN;
        int offsetX = (screenSize.width - width) / 2;
        int offsetY = (screenSize.height - height) / 2;
        setBounds(offsetX, offsetY, width, height);
    }

    private void addDialog(JButton changeButton, JTextField jTextField) {
        changeButton.addActionListener(e -> {
            File file = new File(jTextField.getText());
            JFileChooser jFileChooser = new JFileChooser(file.getParent());
            jFileChooser.showDialog(this, OK_MESSAGE);
            File selectedFile = jFileChooser.getSelectedFile();
            if (Objects.nonNull(selectedFile)) {
                jTextField.setText(selectedFile.toString());
            }
        });

    }

    private KeyAdapter clearField() {
        return new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                ((JTextField) e.getSource()).setText("");
            }
        };
    }


}
