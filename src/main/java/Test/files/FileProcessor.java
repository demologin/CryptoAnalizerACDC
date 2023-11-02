package Test.files;

import Test.constant.Alphabet;
import Test.constant.Constant;
import Test.exceptions.TextException;
import Test.util.PathBuilder;
import com.javarush.berezovskiy.cryptoanalizer.constant.Const;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileProcessor {

    public void runFile(String sourceFile, String destFile, int key) {
        Path source = PathBuilder.pathname(sourceFile);
        Path target = PathBuilder.pathname(destFile);
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
            int value;
            int length = Alphabet.ALPHABET.length;
            while ((value = reader.read()) > -1) {
                char fileCharacter = (char) value;
                fileCharacter = Character.toLowerCase(fileCharacter);
                if (Alphabet.letterIndex.containsKey(fileCharacter)) {
                    int index = Alphabet.letterIndex.get(fileCharacter);
                    index = (index + key + Math.abs(key) * length) % length;
                    writer.write(Alphabet.ALPHABET[index]);
                } else if (fileCharacter == '\n') {
                    writer.write(fileCharacter);
                }
            }
        } catch (IOException e) {
            throw new TextException(Constant.FILE_EXCEPTION);
        }

    }

}
