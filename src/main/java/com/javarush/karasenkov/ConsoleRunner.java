package com.javarush.karasenkov;


import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим работы программы и введите нужную цифру :");
        System.out.println("1. Кодирование");
        System.out.println("2. Декодирование");
        System.out.println("3. Выход");
        int workBranch = scanner.nextInt();
        switch (workBranch) {
            case 1: {
                Encoder.encodeText();
                break;
            }
            case 2: {
                Decoder.decodeText();
                break;
            }
            case 3: {
                System.out.println("Работа программы завершена");
                break;
            }
        }
    }
}
