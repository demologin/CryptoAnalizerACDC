package com.javarush.kramorenko.util;


import com.javarush.kramorenko.constants.Const;

import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {
    }

    public static Path get(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute() ? path : Path.of(Const.TXT_FOLDER + filename);
    }

    public static Path getPath(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute() ? path : Path.of(Const.TXT_ENCRYPTED + filename);
    }
        public static Path getPathDec(String filename){
            Path path = Path.of(filename);
            return path.isAbsolute() ? path : Path.of(Const.TXT_DECRYPTED + filename);
        }
    }

