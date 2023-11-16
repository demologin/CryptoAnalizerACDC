package com.javarush.levchuk.mods;


import java.nio.file.Path;
import static com.javarush.levchuk.constant.UtilConstants.*;
import static com.javarush.levchuk.mods.tools.Coding.enterKey;

import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;


public class Encode {
    public void runEncode() {
        System.out.printf(CONTEXT_MESSAGES[0], DEFAULT_INITIAL_FILE_NAME);
        Path source = PathMaker.makePath(DEFAULT_INITIAL_FILE_NAME);

        System.out.printf(CONTEXT_MESSAGES[1], DEFAULT_ENCRYPT_FILE_NAME);
        Path target = PathMaker.makePath(DEFAULT_ENCRYPT_FILE_NAME);

        System.out.printf(CONTEXT_MESSAGES[2], DEFAULT_KEY);
        int key = enterKey();
        Coding.processingToFile(source, target, key);

    }
}