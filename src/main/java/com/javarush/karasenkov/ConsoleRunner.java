package com.javarush.karasenkov;


import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим работы программы и введите нужную цифру :");
        System.out.println("1. Кодирование");
        System.out.println("2. Декодирование");
        int workBranch = scanner.nextInt();
        switch (workBranch) {
            case 1: {
                Coder.codingText();
                break;
            }
            case 2: {
                Decoder.decodeText();
                break;
            }
        }
    }
}
