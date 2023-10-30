package com.javarush.levchuk.mods;

import java.io.File;
import java.nio.file.Path;

public  interface PathMaker {
    public static Path makePath(String enterName, String defaultName){
        Path path=Path.of(System.getProperty("user.dir") + File.separator + "text" + File.separator + defaultName);
        if (!enterName.equals("")) {
             path=Path.of(enterName);
        }
        return path;
    }
}
