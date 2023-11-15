package com.javarush.kudra;

import java.nio.file.Path;

public class PathBuilder {
    public PathBuilder() {

    }
public static Path getAbsoluteName(String fileName) {
    Path path = Path.of(fileName);
    return path.isAbsolute()? path:path.toAbsolutePath();
}
}
