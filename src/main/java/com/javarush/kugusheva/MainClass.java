package com.javarush.kugusheva;

import com.javarush.kugusheva.command.Encrypter;
import com.javarush.kugusheva.command.Decrypter;
import com.javarush.kugusheva.resources.Console_messages;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        mainConsoleMessage();
        Scanner scanner = new Scanner(System.in);
        int readOption = scanner.nextInt();
        while (readOption!=3){
            if (readOption==1){
                Encrypter.encrypt();
            }
            else if(readOption==2){
                Decrypter.decrypt();
            }
            else {
                System.out.println(Console_messages.WRONG_INPUT_MESSAGE);
            }
            mainConsoleMessage();
            readOption=scanner.nextInt();
        }
    }

    public static void mainConsoleMessage(){
        System.out.println(Console_messages.HELLO_MESSAGE);
        for (String option:Console_messages.OPTION_ARRAY) {
            System.out.println(option);
        }
    }
}
