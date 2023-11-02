package com.javarush.boyarinov.commands;

import com.javarush.boyarinov.view.Options;

public class Commands {


    public void startEncrypt (Options options) {
        Encrypt encrypt = new Encrypt();
        encrypt.encode(options.getSourceTxt(), options.getTargetTxt(), options.getKey());
    }

    public void startDecrypt (Options options) {
        Decrypt decrypt = new Decrypt();
        decrypt.decode(options.getSourceTxt(), options.getTargetTxt(), options.getKey());
    }
}
