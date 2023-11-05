package Test.commands;


import Test.files.FileProcessor;
import Test.menu.Menu;
import Test.menu.MenuValues;

public class Encrypt extends FileProcessor {
    private final int actionIndex = 0; //index of FileActionEnum
    @Override
    public void runFile() {
        MenuValues parameters = Menu.parameterGetter;
        String sourceFile = parameters.getSourceFile();
        String destFile = parameters.getDestFile();
        int key = parameters.getKey();

        runFileWithKey(sourceFile,destFile,key, actionIndex);
    }

}
