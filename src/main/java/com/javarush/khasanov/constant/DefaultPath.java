package com.javarush.khasanov.constant;

import java.io.File;

public class DefaultPath {
    public static final String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;
}
