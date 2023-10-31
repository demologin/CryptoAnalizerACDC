package com.javarush.afanasenko;

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
        try {
            this.path = Path.of(path);
        }catch(RuntimeException ex){
            throw new CryptoException("Ошибка при создании пути к файлу");
        }
    }
}
