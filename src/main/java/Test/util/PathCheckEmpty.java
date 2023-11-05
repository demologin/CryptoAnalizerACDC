package Test.util;

import Test.commands.FileActionEnum;
import Test.constant.Constant;

public class PathCheckEmpty {

    private String sourcePath;
    private String destPath;
    private int action;


    public PathCheckEmpty(String sourcePath, String destPath, int actionIndex){
        this.sourcePath = sourcePath;
        this.destPath = destPath;
        this.action = actionIndex;
    }

    public String defaultSourceFilePath(){
        if(sourcePath.equals("")){
            switch (action){
                case 0 -> sourcePath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_ORIGINAL_FILEPATH;
                case 1 -> sourcePath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_ENCRYPTED_FILEPATH;
            }
        }
        return sourcePath;
    }
    public String defaultDestinationFilePath(){
        if(destPath.equals("")){
            switch (action){
                case 0 -> destPath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_ENCRYPTED_FILEPATH;
                case 1 -> destPath = Constant.TXT_FOLDER + Constant.EMPTY_STRING_DECRYPTED_FILEPATH;
            }
        }
        return destPath;
    }
}
