package Test.commands;


import Test.files.FileProcessor;
import Test.menu.MenuValues;

public class Encrypt extends FileProcessor {
    @Override
    public void runFile() {
        MenuValues parameters = DefineAction.getParameters();
        String sourceFile = parameters.getSourceFile();
        String destFile = parameters.getDestFile();
        int key = parameters.getKey();

        runFileWithKey(sourceFile,destFile,key, FileActionEnum.ENCRYPTED);
    }

}
