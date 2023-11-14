package com.javarush.kugusheva.helpers;

import com.javarush.khmelov.constant.Const;
import com.javarush.khmelov.util.PathBuilder;

import java.io.File;
import java.nio.file.Path;

public class PathMaker {
    static String FILE_PATH = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    public static Path getPath(String path, int mode) {
        if (path.equals("") && (mode == 1))
            return Path.of(FILE_PATH + "text.txt");
        else if (path.equals("") && (mode == 2))
            return Path.of(FILE_PATH +"encrypted.txt");
        else if (path.equals("") && (mode == 3))
            return Path.of(FILE_PATH +"decrypted.txt");
        else {
            return Path.of(path);
        }
    }
}
