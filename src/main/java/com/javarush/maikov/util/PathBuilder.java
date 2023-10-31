package com.javarush.maikov.util;
import com.javarush.maikov.constatns.Constants;

import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {
    }
    public static Path getPath (String fileName){
        Path path = Path.of(fileName);
        return path.isAbsolute() ?  path : Path.of(Constants.TXT_FOLDER + fileName);

    }

}
