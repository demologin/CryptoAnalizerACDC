package com.javarush.zhukov.inputOut;

import com.javarush.zhukov.constant.AlphaBet;

import java.util.Scanner;

public class KeyForCode {
    public static int getKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите ключ шифрования(допустимое значение от 0 до %d\n"
                , AlphaBet.arrayAlphaBet.length);
        return InputAndCheckingKey(scanner);
    }

    private static int InputAndCheckingKey(Scanner scanner) {
        try {
            int key = scanner.nextInt();
            if (key < AlphaBet.arrayAlphaBet.length && key > 0) {
                return key;
            }
            System.out.println("Вы ввели ключ выходящий за грани допустимого значения");
            return getKey();
        } catch (Exception e) {
            System.out.println("Вы ввели не корректный ключ попробуёте ещё раз");
            return getKey();
        }
    }
}
