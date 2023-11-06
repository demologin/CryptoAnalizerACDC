package Test.commands;

import Test.files.FileProcessor;
import Test.menu.MenuValues;

public class Decrypt extends FileProcessor {
    @Override
    public void runFile() {
        MenuValues parameters = DefineAction.getParameters();
        String sourceFile = parameters.getSourceFile();
        String destFile = parameters.getDestFile();
        int key = Integer.parseInt(parameters.getKey());

        runFileWithKey(sourceFile,destFile,-1*key, FileActionEnum.DECRYPTED);
    }
}
