package com.javarush.stukalov.view;

import com.javarush.stukalov.constant.Messages;
import com.javarush.stukalov.controller.AnalyzerController;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private final AnalyzerController ANALYZER_CONTROLLER = new AnalyzerController();
    private final String MENU = new WelcomeScreen().getMENU();
    private final Scanner SCANNER;
    private int mode;

    public ConsoleApp(Scanner SCANNER) {
        this.SCANNER = SCANNER;
    }
    public void runApp() {
        while (true) {
            mode = getMode();
            ANALYZER_CONTROLLER.run(mode, getParams(mode));
        }

    }
    private int getMode() {
        do {
            System.out.println(MENU);
            String input = SCANNER.nextLine();
            mode = switch (input) {
                case "1" -> 1;
                case "2" -> 2;
                case "3" -> 3;
                case "4" -> 4;
                case "5" -> {
                    System.out.println("Goodbye");
                    System.exit(0);
                    yield 0;
                }
                default -> {
                    System.out.println("Incorrect input.");
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;
    }
    private List<String> getParams(int mode) {
        List<String> params;
        params = switch (mode) {
            case 1 -> Arrays.stream(getEncoderParams()).toList();
            case 2 -> Arrays.stream(getDecoderParams()).toList();
            case 3 -> Arrays.stream(getBruteForcerParams()).toList();
            case 4 -> Arrays.stream(getAnalyzerParams()).toList();
            default -> null;
        };
        return params;
    }
    private String[] getEncoderParams() {
        String[] encoderParams = new String[3];
        String source;
        String destination;
        String key;
        Messages.printTextFile();
        source = SCANNER.nextLine();
        encoderParams[0] = source;
        Messages.printEncodedTextFile();
        destination = SCANNER.nextLine();
        encoderParams[1] = destination;
        Messages.printEncodingKey();
        key = SCANNER.nextLine();
        encoderParams[2] = key;

        return encoderParams;
    }
    private String[] getDecoderParams() {
        String[] decoderParams = new String[3];
        String source;
        String destination;
        String key;
        Messages.printEncodedTextFile();
        source = SCANNER.nextLine();
        decoderParams[0] = source;
        Messages.printDecodedTextFile();
        destination = SCANNER.nextLine();
        decoderParams[1] = destination;
        Messages.printDecodingKey();
        key = SCANNER.nextLine();
        decoderParams[2] = key;

        return decoderParams;
    }
    private String[] getAnalyzerParams() {
        String[] analyzerParams = new String[2];
        String source;
        String destination;
        Messages.printEncodedTextFile();
        source = SCANNER.nextLine();
        analyzerParams[0] = source;
        Messages.printDecodedTextFile();
        destination = SCANNER.nextLine();
        analyzerParams[1] = destination;

        return analyzerParams;
    }
    private String[] getBruteForcerParams() {
        String[] bruteForcerParams = new String[2];
        String source;
        String destination;
        Messages.printEncodedTextFile();
        source = SCANNER.nextLine();
        bruteForcerParams[0] = source;
        Messages.printDecodedTextFile();
        destination = SCANNER.nextLine();
        bruteForcerParams[1] = destination;

        return bruteForcerParams;
    }
}
