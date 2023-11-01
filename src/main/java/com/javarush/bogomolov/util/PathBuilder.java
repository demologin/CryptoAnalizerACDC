package com.javarush.bogomolov.util;



import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {
    }
public static Path get(String filename){
    return Path.of(filename);
}
}
