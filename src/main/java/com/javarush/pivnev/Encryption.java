package com.javarush.pivnev;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static com.javarush.pivnev.Alphabet.ALPHABET;
public class Encryption {
    public void reading_file(String file_original, String file_encrypted, int shift) {

        try (FileReader reader = new FileReader("text\\" + file_original); FileWriter writer = new FileWriter("text\\" + file_encrypted))
        {
            while ((reader.ready())) {

                char ch = (char) reader.read();
                System.out.print(ch);
                int d = encrypt(ch, shift);
                writer.write(d);
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static char encrypt(char c, int shift) {
        char d = Character.toLowerCase(c);

        int index = findIndex(d);

        if (index != -1) {
            int newIndex = (index + shift) % ALPHABET.length;
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
