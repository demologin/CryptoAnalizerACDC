package com.javarush.berezovskiy.cryptoanalizer;

import com.javarush.berezovskiy.cryptoanalizer.controller.MainController;
import com.javarush.berezovskiy.cryptoanalizer.view.swing.MainForm;

public class SwingRunner {
    public static void main(String[] args) {
        //build swing app
        MainController controller = new MainController();
        MainForm mainForm = new MainForm(controller);

        //run swing app
        mainForm.initialization();
    }
}
