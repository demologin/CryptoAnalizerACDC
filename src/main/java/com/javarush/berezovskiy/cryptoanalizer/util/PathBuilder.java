package com.javarush.berezovskiy.cryptoanalizer.util;

import com.javarush.berezovskiy.cryptoanalizer.constant.Const;

import java.nio.file.Path;

public class PathBuilder {

    private PathBuilder() {
    }

    public static Path get(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute()
                ? path
                : Path.of(Const.TXT_FOLDER + filename);
    }
}

