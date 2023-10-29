package com.javarush.nkuzmischev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class CaesarCipher {
    public static void main(String[] args) {
        char[] russianAlphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', ':', '!', '?', ' '};
        int shift = getShiftFromConsole();
        String inputFilename = "input.txt";
        String outputFilename = "output.txt";

        try {
            String plaintext = readFromFile(inputFilename);
            String ciphertext = encrypt(plaintext, shift, russianAlphabet);
            writeToFile(outputFilename, ciphertext);
            System.out.println("Шифрованный текст успешно записан в файл " + outputFilename);

            String decryptedText = decrypt(ciphertext, shift, russianAlphabet);
            System.out.println("Расшифрованный текст: " + decryptedText);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    //функция getShiftFromConsole(), позволяет пользователю ввести размер сдвига с консоли
    public static int getShiftFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер сдвига: ");
        int shift = scanner.nextInt();
        scanner.close();
        return shift;
    }
    //Для работы с файлами используются методы readFromFile и writeToFile, которые считывают данные из файла и записывают данные в файл соответственно.
    public static String readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();
        return stringBuilder.toString();
    }

    public static void writeToFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

    public static String encrypt(String plaintext, int shift, char[] alphabet) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char encryptedChar = alphabet[(indexOf(alphabet, currentChar) + shift) % alphabet.length];
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift, char[] alphabet) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char decryptedChar = alphabet[(indexOf(alphabet, currentChar) - shift + alphabet.length) % alphabet.length];
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(currentChar);
            }
        }
        return plaintext.toString();
    }

    public static int indexOf(char[] array, char element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
}


