package Test;

import Test.constant.Constant;
import Test.files.FileProcessor;
import Test.menu.Menu;
import Test.menu.MenuValuesGetter;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
//        FileProcessor file = new FileProcessor();
//        String source = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/text.txt";
//        String dest = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/dest.txt";
       // /Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/encrypted.txt
//        String decrypt = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/decrypt.txt";
//        int key = 12;
//        file.runFile(source,dest,key);
//        file.runFile(dest, decrypt, -1*key);
        Scanner console = new Scanner(System.in);
        Menu menu = new Menu(console);
        menu.run();
    }
}
