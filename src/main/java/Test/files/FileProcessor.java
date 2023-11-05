package Test.files;

import Test.commands.FileAction;
import Test.commands.FileActionEnum;
import Test.constant.Alphabet;
import Test.exceptions.ConsoleException;
import Test.messages.Message;
import Test.util.PathBuilder;
import Test.util.PathCheckEmpty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public abstract class FileProcessor implements FileAction {
    public void runFileWithKey(String sourceFile, String destFile, int key, int actionIndex) {
        PathCheckEmpty pathCheckEmpty = new PathCheckEmpty(sourceFile, destFile, actionIndex);
        String sourcePath = pathCheckEmpty.defaultSourceFilePath();
        String destPath = pathCheckEmpty.defaultDestinationFilePath();

        Path source = PathBuilder.pathname(sourcePath);
        Path target = PathBuilder.pathname(destPath);
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
            throw new ConsoleException(Message.FILE_EXCEPTION);
        }

    }

}
