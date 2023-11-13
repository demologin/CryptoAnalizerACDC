package com.javarush.levchuk.mods;

import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.*;

public class Decode {
    public void runDecode() {

        System.out.printf(CONTEXT_MESSAGES[0],DEFAULT_ENCRYPT_FILE_NAME);
        Path source = PathMaker.makePath(DEFAULT_ENCRYPT_FILE_NAME);

        System.out.printf(CONTEXT_MESSAGES[1],DEFAULT_DECRYPT_FILE_NAME);
        Path target = PathMaker.makePath(DEFAULT_DECRYPT_FILE_NAME);

        System.out.printf(CONTEXT_MESSAGES[2], DEFAULT_KEY);
        int key = Coding.enterKey();
        Coding.processingToFile(source, target, -1 * key);

    }
}
