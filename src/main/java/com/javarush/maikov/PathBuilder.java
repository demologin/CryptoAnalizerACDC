package com.javarush.maikov;

import java.net.URI;
import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {
    }
    public static Path getPath (String fileName){
        Path path = Path.of(fileName);
        return path.isAbsolute() ?  path : Path.of(URI.create(Constants.TXT_FOLDER + fileName));

    }

}
