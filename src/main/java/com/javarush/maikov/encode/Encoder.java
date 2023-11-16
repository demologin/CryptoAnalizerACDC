package com.javarush.maikov.encode;
import static com.javarush.maikov.ConsoleRunner.input;

public class Encoder {
    public Encoder() {
        System.out.println("Введите ссылку на файл, который вы хотите зашифровать");
        String linkIn = input.next();
        System.out.println("Введите ссылку на файл или имя файла, в который вы хотите записать зашифрованнй текст. " +
                "если файла с таким именем не существует, он будет создан.");
        String linkOut = input.next();
        System.out.println("Введите ключ, которым вы хотите зашифровать файл");
        int key = Integer.parseInt(input.next());
        Encode encode = new Encode(linkIn, linkOut, key);
    }
}
