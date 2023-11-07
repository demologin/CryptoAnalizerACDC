package com.javarush.bogomolov.util;



import com.javarush.bogomolov.application.Messages;

import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {
    }
public static Path get(String filename){
    Path path = Path.of(filename);
    return path.isAbsolute()
            ? path
            : Path.of(Messages.DEFAULT_PATH + filename);
}
}
