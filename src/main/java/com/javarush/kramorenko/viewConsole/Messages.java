package com.javarush.kramorenko.viewConsole;

public interface Messages {
    String MENU = """
            Выберите действие, введя его номер:
            1) Зашифровать файл.
            2) Расшифровать файл с помощью ключа.
            3) Расшифровать файл с помощью BruteForce.
            4) Выход из программы.
            """;
String INCORRECT_ACTION = "Некорректное действие";
String PATH_FOR_ENCODE = "Введите полный путь или нажмите ЕNTER для использования файла по умолчанию.";
String PATH_TARGET = "Введите полный путь или нажмите ЕNTER для создания файла по умолчанию.";
String INCORRECT_FILE = "Некорректный файл.";
String ENTER_KEY = "Введите ключ: ";
String PATH_FOR_DECODE = "Введите полный путь к файлу,содержимое которого хочешь расшифровать или нажмите ENTER для encrypted.txt.";
}
