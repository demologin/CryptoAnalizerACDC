package Test.commands;

import java.nio.file.Path;


public class Encrypt implements Runnable{

    @Override
    public void run(String[] parameters) {
        String sourceFile = parameters[0];
        String destFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);

    }
}
