package com.javarush.karasenkov;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!'};
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим работы программы и введите нужную цифру :");
        System.out.println("1. Кодирование");
        System.out.println("2. Декодирование");
        int workBranch = scanner.nextInt();
        if ( workBranch == 1 ) {
            System.out.println("Укажите полный путь до исходного файла");
            String src = "/Users/bkarasenkov/IdeaProjects/CryptoAnalizerACDC/text/text.txt";
            //String src = scanner.next();

            System.out.println("Укажите полный путь до файла с результатами");
            String dest = "/Users/bkarasenkov/IdeaProjects/CryptoAnalizerACDC/text/result.txt";
            //String dest = scanner.next();

            System.out.println("Укажите номер ключа шифра в виде числа");
            int cipherKey = scanner.nextInt();

            try(FileReader reader = new FileReader(src);
                FileWriter writer = new FileWriter(dest))
            {
                char[] buffer = new char[65536];
                while (reader.ready())
                {
                    int real = reader.read(buffer);
                    for (int i = 0; i < real; i++) {
                        char letter = buffer[i];
                        char lowerLetter = Character.toLowerCase(letter);
                        for (int j = 0; j < ALPHABET.length; j++) {
                            if (lowerLetter == ALPHABET[j]) {
                                if (j + cipherKey >= ALPHABET.length) {
                                    int newIndex = (j + cipherKey) % ALPHABET.length;
                                    char newLetter = ALPHABET[newIndex];
                                    buffer[i] = newLetter;
                                    continue;
                                }
                                char newLetter = ALPHABET[j + cipherKey];
                                buffer[i] = newLetter;
                            }
                        }
                    }
                    writer.write(buffer, 0, real);
                }
            }
        }
    }
}
