package com.javarush.afanasenko;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathBuilder {
   private Path path;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public PathBuilder(String path) {
        this.path = Path.of(path);
        if(!Files.exists(this.path)) throw new CryptoException("По данному пути файла не существует");

    }
}
