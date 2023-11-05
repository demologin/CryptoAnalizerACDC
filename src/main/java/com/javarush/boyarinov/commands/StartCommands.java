package com.javarush.boyarinov.commands;

import com.javarush.boyarinov.container.Options;

public class StartCommands {


    public void startEncrypt (Options options) {
        Encrypt encrypt = Encrypt.getInstance();
        encrypt.encode(options.getSourceTxt(), options.getTargetTxt(), options.getKey());
    }

    public void startDecrypt (Options options) {
        Decrypt decrypt = Decrypt.getInstance();
        decrypt.decode(options.getSourceTxt(), options.getTargetTxt(), options.getKey());
    }

    public void startExit () {
        Exit exit = Exit.getInstance();
        exit.stopApp();
    }
}
