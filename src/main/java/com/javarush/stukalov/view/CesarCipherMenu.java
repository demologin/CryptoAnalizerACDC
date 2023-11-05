package com.javarush.stukalov.view;

import com.javarush.stukalov.services.Encoder;

public class CesarCipherMenu extends AbstractMenu{
    private static CesarCipherMenu instance;
    private final String MENU =
        "\nPlease select mode:\n" + """
            1. Encrypt
            2. Decrypt
            3. Brute force
            4. Analyze
            5. Exit
            """;

    private CesarCipherMenu() {
    }
    public static CesarCipherMenu getInstance() {
        if (instance == null) {
            instance = new CesarCipherMenu();
        }
        return instance;
    }

    @Override
    public void runMenu() {
        System.out.println(MENU);
    }
}


