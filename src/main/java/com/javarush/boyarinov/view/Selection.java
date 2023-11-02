package com.javarush.boyarinov.view;



import com.javarush.boyarinov.commands.Commands;
import java.util.Scanner;

public class Selection {

    private final Scanner scanner;
    private final Options options = new Options();
    private final Commands commands = new Commands();

    public Selection(Scanner scanner) {
        this.scanner = scanner;
    }

    public void selectionCommand() {
        System.out.println("Приветствую. Введите номер команды.");

        System.out.print("""
                1.\tШифрование
                2.\tРасшифровка
                3.\tВыход
                """);
        if (scanner.nextInt() == 1) {
            System.out.println("Введите путь к текстовому файлу/название или нажмите ENTER для text.txt");
            options.setSourceTxt(scanner.next());
            System.out.println("Введите путь для вывода зашифрованного файла/название или нажмите ENTER для encrypt.txt");
            options.setEncryptTxt(scanner.next());
            System.out.println("Введите ключ");
            options.setKey(scanner.nextInt());
            commands.startEncrypt(options);
        }

    }
}
