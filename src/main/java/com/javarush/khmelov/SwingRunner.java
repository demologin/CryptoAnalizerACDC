package com.javarush.khmelov;

import com.javarush.khmelov.controller.MainController;
import com.javarush.khmelov.view.swing.MainForm;

public class SwingRunner {
    public static void main(String[] args) {
        //build swing app
        MainController controller = new MainController();
        MainForm mainForm = new MainForm(controller);

        //run swing app
        mainForm.initialization();
    }
}
