package com.javarush.pivnev;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.javarush.pivnev.Alphabet.ALPHABET;
public class Decoding {

    public void reading_file(String file_original, String file_encrypted, int shift) {

        try (FileReader reader = new FileReader("text\\" + file_original); FileWriter writer = new FileWriter("text\\" + file_encrypted))
        {
            while ((reader.ready())) {

                char ch = (char) reader.read();
                System.out.print(ch);
                int d = decrypt(ch, shift);
                writer.write(d);

            }
            System.out.println("Файл расшифрован");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static char decrypt(char c, int shift) {
        char d = Character.toLowerCase(c);

        int index = findIndex(d);

        if (index != -1) {
            int newIndex = (index - shift) % ALPHABET.length;
            if (newIndex < 0) {
                newIndex = ALPHABET.length - Math.abs(newIndex);
            }
            d = ALPHABET[newIndex];
        }
        System.out.println(d);
        return d;
    }

    private static int findIndex(char ch) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ch == ALPHABET[i]) {
                return i;
            }
        }
        return -1;
    }
}
