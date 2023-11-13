package com.javarush.shvetsov;


import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.shvetsov.isCorrectKeyClass.isCorrectKey;
import static com.javarush.shvetsov.isCorrectPathClass.*;

public class Runner {

    public static int modeNumber = 0;

    public static void main(String[] args) {
        System.out.println(Dialog.MESSAGEHELLO);
        Scanner scanner = new Scanner(System.in);
        modeNumber = scanner.nextInt();

        if (modeNumber == 1) {

            //Указание путей и проверка являются ли пути верными
            isCorrectPath(scanner);
            System.out.println(Dialog.MESSAGEFILEPATH2);
            isCorrectPathTwo(scanner);
            //проверка ключа шифрования
            isCorrectKey(scanner);
            //Занесение в файл
            WriteInFile.writeInFile();
            System.out.println(Dialog.MESSAGECOMPLETE + "\nРезультат в " + Path.of(pathTwo).getFileName());

        } else if (modeNumber == 2) {

            System.out.println(Dialog.MESSAGEFILEPATH);
            isCorrectPathTwo(scanner);
            System.out.println(Dialog.MESSAGEFILEPATH2);
            isCorrectPathThree(scanner);
            isCorrectKey(scanner);
            WriteInFile.writeInFile();
            System.out.println(Dialog.MESSAGECOMPLETE + "\nРезультат в " + Path.of(pathThree).getFileName());
        } else if (modeNumber == 3) {
            System.out.println(Dialog.MESSAGEBYE);
        } else {
            System.out.println("Неправильное значение. Повторите попытку.");
        }
    }


}


