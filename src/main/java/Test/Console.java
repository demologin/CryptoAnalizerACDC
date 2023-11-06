package Test;

import Test.commands.BruteForce;
import Test.commands.Decrypt;
import Test.commands.FileActionEnum;
import Test.constant.Alphabet;
import Test.constant.Constant;
import Test.exceptions.ConsoleException;
import Test.files.FileProcessor;
import Test.menu.Menu;
import Test.messages.Message;
import Test.util.PathBuilder;
import Test.util.PathCheckEmpty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
//        FileProcessor file = new FileProcessor();
       String source = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/text.txt";
//        String dest = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/dest.txt";
        String encrypt = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/encrypted.txt";
        String bruteForced = "/Users/sergeyberezovskiy/IdeaProjects/CryptoAnalizerACDC/text/bruteForced.txt";
//
        //TODO String[] for parameters
        Scanner console = new Scanner(System.in);
        Menu menu = new Menu(console);
        menu.run();
    }


}
