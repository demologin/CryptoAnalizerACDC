package com.javarush.stukalov.view;

public class WelcomeScreen {
    private final String MENU =
        "\nPlease select mode:\n" + """
            1. Encrypt
            2. Decrypt
            3. Brute force
            4. Analyze
            5. Exit
            """;

    public String getMENU() {
        return MENU;
    }
}


