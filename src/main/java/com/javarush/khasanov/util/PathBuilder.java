package com.javarush.khasanov.util;

import com.javarush.khasanov.constant.DefaultPath;

import java.nio.file.Path;

public class PathBuilder {
    public static Path getPath(String pathFromArg) {
        Path path = Path.of(pathFromArg);
        return path.isAbsolute() ? path : Path.of(DefaultPath.TXT_FOLDER + pathFromArg);
    }

}
