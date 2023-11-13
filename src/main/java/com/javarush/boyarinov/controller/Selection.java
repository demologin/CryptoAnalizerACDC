package com.javarush.boyarinov.controller;


import com.javarush.boyarinov.commands.StartCommands;
import com.javarush.boyarinov.constats.Messages;
import com.javarush.boyarinov.container.Options;

import java.util.Scanner;

public class Selection {

    private final Scanner scanner;
    private final Options options;
    private final StartCommands startCommands;

    public Selection(Scanner scanner, Options options, StartCommands startCommands) {
        this.scanner = scanner;
        this.options = options;
        this.startCommands = startCommands;
    }

    public void commandSelections() {
        System.out.println(Messages.GREETINGS);
        System.out.print(Messages.MENU);

        boolean stop = false;
        while (!stop) {
            int numberCommand = Integer.parseInt(scanner.nextLine()); //потому что некорректно работают следующие nextLine, если здесь nextInt
            switch (numberCommand) {
                case 1 -> stop = encrypt();
                case 2 -> stop = decrypt();
                case 3 -> stop = bruteForce();
                case 4 -> stop = exit();
                default -> System.out.println(Messages.INVALID_INPUT);
            }
        }
    }

    private boolean encrypt() {
        System.out.println(Messages.SOURCE_TEXT);
        String source = scanner.nextLine();
        options.setSourceTxt(source);
        System.out.println(Messages.TARGET_ENCRYPT);
        String target = scanner.nextLine();
        options.setTargetEncryptTxt(target);
        System.out.println(Messages.ENTER_KEY);
        int key = Integer.parseInt(scanner.nextLine());
        options.setKey(key);
        startCommands.startEncrypt(options);
        return true;
    }

    private boolean decrypt() {
        System.out.println(Messages.SOURCE_ENCRYPT);
        String source = scanner.nextLine();
        options.setSourceEncryptTxt(source);
        System.out.println(Messages.TARGET_DECRYPT);
        String target = scanner.nextLine();
        options.setTargetDecryptTxt(target);
        System.out.println(Messages.ENTER_KEY);
        int key = Integer.parseInt(scanner.nextLine());
        options.setKey(key);
        startCommands.startDecrypt(options);
        return true;
    }

    private boolean bruteForce() {
        System.out.println(Messages.SOURCE_ENCRYPT);
        String source = scanner.nextLine();
        options.setSourceEncryptTxt(source);
        System.out.println(Messages.TARGET_BRUTE_FORCE);
        String target = scanner.nextLine();
        options.setTargetBruteForceTxt(target);
        startCommands.startBruteForce(options);
        return true;
    }

    private boolean exit() {
        startCommands.startExit();
        return true;
    }
}
