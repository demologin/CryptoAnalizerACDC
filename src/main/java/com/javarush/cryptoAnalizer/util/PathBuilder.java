package com.javarush.cryptoAnalizer.util;

import java.nio.file.Path;

public class PathBuilder {

    public static Path pathname(String path){

        return Path.of(path).isAbsolute() ? Path.of(path) : Path.of(path).toAbsolutePath();
    }
}