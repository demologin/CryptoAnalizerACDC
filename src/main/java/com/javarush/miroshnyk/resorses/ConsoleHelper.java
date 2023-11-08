package com.javarush.miroshnyk.resorses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.javarush.miroshnyk.Runner.exit;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void print(String str){
        System.out.println(str);
    }

    public static void printMenu(){
        print("Print number of action you want to choose.");
        print("1. Read");
        print("2. Encrypt");
        print("3. Decrypt");
        print("4. Exit");
    }
    public static String readString(){
        try {
            String text = bis.readLine();
            return text;
        } catch (IOException ignored) {
        }
        return null;
    }
    public void askOperation(){

            while (!exit){
                try{
                printMenu();
                Integer i = Integer.parseInt(ConsoleHelper.readString().trim());
                ConsoleHelper.print(String.valueOf(i));
                try{
                    Operation.getAllowableOperation(i);
                } catch (IllegalArgumentException e){
                    ConsoleHelper.print("Please, specify valid data");
                }
            }catch (IllegalArgumentException e1 ){
                    ConsoleHelper.print("Please, specify valid data");
            }
        }
    }

    public static String askFilename(String str){
        while (true){
            print(str);
            String fileName = ConsoleHelper.readString();
            if (fileName == null) {
                ConsoleHelper.print("No file name");
                continue;
            } else if (fileName.equals("exit")) {
                continue;
            }
            return fileName;
        }
    }

    public static int askCipherKey(String str){
        while (true){
            print(str);
            int key;
            try {
                key = Integer.parseInt(ConsoleHelper.readString());
            } catch (IllegalArgumentException e){
                ConsoleHelper.print("Please, verify given data");
                continue;
            }
            return key;
        }
    }
}
