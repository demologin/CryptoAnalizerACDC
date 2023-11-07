package com.javarush.cryptoAnalizer.util;

import com.javarush.cryptoAnalizer.commands.FileActionEnum;
import com.javarush.cryptoAnalizer.constant.Constant;

public class PathCheckEmpty {

    private String sourcePath;
    private String destPath;
    private String bruteForcePath;
    private FileActionEnum action;


    public PathCheckEmpty(String sourcePath, String destPath, FileActionEnum action){
        this.sourcePath = sourcePath;
        this.destPath = destPath;
        this.action = action;
    }
    public PathCheckEmpty(String originalTextPath, String encryptedTextPath, String bruteForcedPath, FileActionEnum action){
        this.sourcePath = originalTextPath;
        this.destPath = encryptedTextPath;
        this.bruteForcePath = bruteForcedPath;
        this.action = action;
    }

    public String defaultSourceFilePath(){
        if(sourcePath.equals("")){
            switch (action){
                case ENCRYPTED, BRUTEFORCE -> sourcePath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_ORIGINAL_FILEPATH;
                case DECRYPTED -> sourcePath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_ENCRYPTED_FILEPATH;
            }
        }
        return sourcePath;
    }
    public String defaultDestinationFilePath(){
        if(destPath.equals("")){
            switch (action){
                case ENCRYPTED, BRUTEFORCE -> destPath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_ENCRYPTED_FILEPATH;
                case DECRYPTED -> destPath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_DECRYPTED_FILEPATH;
            }
        }
        return destPath;
    }
    public String defaultDestinationBruteForcePath(){
        if(bruteForcePath.equals("")){
            bruteForcePath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_BRUTEFORCE_FILEPATH;
        }
        return bruteForcePath;
    }
}
