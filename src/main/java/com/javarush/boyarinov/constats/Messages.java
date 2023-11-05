package com.javarush.boyarinov.constats;

public interface Messages {

    String GREETINGS = "Приветствую! Введите номер команды:";
    String SOURCE_TEXT = "Введите путь к текстовому файлу/название или нажмите ENTER для text.txt";
    String TARGET_ENCRYPT = "Введите путь для вывода зашифрованного файла/название или нажмите ENTER для encrypt.txt";
    String SOURCE_ENCRYPT = "Введите путь к зашифрованному текстовому файлу/название или нажмите ENTER для encrypt.txt";
    String TARGET_DECRYPT = "Введите путь для вывода расшифрованного файла/название или нажмите ENTER для decrypt.txt";
    String ENTER_KEY = "Введите ключ";
    String INVALID_INPUT = "Введите номер команды из списка меню.";
    String MENU = """
            1.\tШифрование
            2.\tРасшифровка
            3.\tВыход
            """;
}
