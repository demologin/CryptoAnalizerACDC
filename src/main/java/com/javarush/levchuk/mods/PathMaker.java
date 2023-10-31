package com.javarush.levchuk.mods;

import com.javarush.levchuk.constant.UtilConstants;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.DEFAULT_FOLDER;

public interface PathMaker {

    static Path makePath(String defaultName) {
        Scanner scanner = new Scanner(System.in);
        String enterName = scanner.nextLine();
        Path path = Path.of(DEFAULT_FOLDER + defaultName);
        if (!enterName.equals("")) {
            Path userPath = Path.of(enterName);
            if (userPath.isAbsolute()) {
                path=userPath;
            } else {
                path = Path.of(DEFAULT_FOLDER + enterName + ".txt");
            }
        }
        return path;
    }
}


