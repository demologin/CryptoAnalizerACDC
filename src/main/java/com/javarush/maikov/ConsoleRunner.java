package com.javarush.maikov;

import java.util.Scanner;


public class ConsoleRunner {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.MENU);
        System.out.println("Введите ссылку на файл, который вы хотите зашифровать");
        String link = input.next();
        System.out.println("Введите ключ, которым вы хотите зашифровать файл");
        int key = input.nextInt();
        Encode encode = new Encode(link, key);

    }

}


//        public char[] Encode (BufferedReader reader,int key) throws IOException {
//            if (reader == null && key == 0) {
//                throw new RuntimeException();
//            }
//            StringBuilder stringBuilder = new StringBuilder();
//            int intValueOfChar;
//            while ((intValueOfChar = reader.read()) != -1) {
//                stringBuilder.append((char) intValueOfChar);
//            }
//            char[] charArray = stringBuilder.toString().toCharArray();
//
//
//            return charArray;
//        }


