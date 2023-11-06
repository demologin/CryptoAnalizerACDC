package com.javarush.karasenkov;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encoder {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', ' '};

    public static void encodeText() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите полный путь до исходного файла (не закодированный текст)");
        //String src = "/Users/bkarasenkov/IdeaProjects/CryptoAnalizerACDC/text/text.txt";
        String src = scanner.next();

        System.out.println("Укажите полный путь до файла с результатами (раскодированный текст)");
        //String dest = "/Users/bkarasenkov/IdeaProjects/CryptoAnalizerACDC/text/result.txt";
        String dest = scanner.next();

        System.out.println("Укажите номер ключа шифра в виде числа");
        int cipherKey = scanner.nextInt();

        try (FileReader reader = new FileReader(src);
             FileWriter writer = new FileWriter(dest)) {
            char[] buffer = new char[65536];
            while (reader.ready()) {
                int real = reader.read(buffer);
                for (int i = 0; i < real; i++) {
                    char letter = buffer[i];
                    char lowLetter = Character.toLowerCase(letter);
                    for (int j = 0; j < ALPHABET.length; j++) {
                        if (lowLetter == ALPHABET[j]) {
                            if (j + cipherKey >= ALPHABET.length) {
                                int overIndex = (j + cipherKey) % ALPHABET.length;
                                char newLetter = ALPHABET[overIndex];
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
            System.out.println("Текст успешно зашифрован");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
