package com.javarush.kudra;

import com.javarush.kudra.constants.Constant;

import java.nio.file.Path;

public class PathBuilder {
    public PathBuilder() {

    }
public static Path getAbsoluteName(String fileName) {
    Path path = Path.of(fileName);
    return path.isAbsolute()? path:Path.of(Constant.PARENT_DIRECTORY + fileName);
}
}
