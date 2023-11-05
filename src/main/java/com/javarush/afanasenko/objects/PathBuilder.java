package com.javarush.afanasenko.objects;

import com.javarush.afanasenko.exception.CryptoException;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathBuilder {
    private final Path path;

    public Path getPath() {
        return path;
    }

    public PathBuilder(String path) throws CryptoException {
        this.path = Path.of(path);
        if (!Files.exists(this.path)) throw new CryptoException("По данному пути файла не существует");

    }
}
