package Test;

import Test.files.FileProcessor;

import java.io.File;
import java.nio.file.Path;

public class Console {
    public static void main(String[] args) {
//        FileProcessor file = new FileProcessor();
//        String source = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/text.txt";
//        String dest = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/dest.txt";
//        String decrypt = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/decrypt.txt";
//        int key = 12;
//        file.runFile(source,dest,key);
//        file.runFile(dest, decrypt, -1*key);

        System.out.println(System.getProperty("user.dir")+ File.separator+ Path.of("text").normalize());
    }
}
