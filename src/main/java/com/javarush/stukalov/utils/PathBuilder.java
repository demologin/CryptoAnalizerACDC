package com.javarush.stukalov.utils;

import java.io.File;
import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {

    }
    public static Path get(String filename) {
        Path path = Path.of(filename);
        String userDir = System.getProperty("user.dir");
        return path.isAbsolute() ? path : Path.of(userDir + File.separator + "texts" + filename);
    }
}
