package com.javarush.maikov.decode;

import java.util.Scanner;

public class Decoder {
    public Decoder() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите ссылку на файл, который вы хотите расшифровать");
        String linkIn = input.next();
        System.out.println("Введите ссылку на файл или имя файла, в который вы хотите записать расшифрованный текст. " +
                "если файла с таким именем не существует, он будет создан.");
        String linkOut = input.next();
        System.out.println("Введите ключ, для расшифровки");
        int key = input.nextInt();
        Decode decode = new Decode(linkIn, linkOut, key);
    }
}
