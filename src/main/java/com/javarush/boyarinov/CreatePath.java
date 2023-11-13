package com.javarush.boyarinov;

import com.javarush.boyarinov.constats.Constant;

import java.nio.file.Path;

public class CreatePath {

    public Path getPath(String source) {
        Path path = Path.of(source);
        return path.isAbsolute() ? path : Path.of(Constant.LOCATION_TXT + source);
    }
}
