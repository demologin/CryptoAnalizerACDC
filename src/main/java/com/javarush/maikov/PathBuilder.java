package com.javarush.maikov;

import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {
    }
    public static Path getPath (String link){
        Path path = Path.of(link);
        return path.isAbsolute() ?  path : Path.of(Constants.TXT_FOLDER + link);
    }

}
