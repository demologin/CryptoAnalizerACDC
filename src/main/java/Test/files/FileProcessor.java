package Test.files;

import Test.commands.FileAction;
import Test.commands.FileActionEnum;
import Test.constant.Alphabet;
import Test.constant.Constant;
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
    public void runFileWithKey(String sourceFile, String destFile, int key, FileActionEnum action) {
        PathCheckEmpty pathCheckEmpty = new PathCheckEmpty(sourceFile, destFile, action);
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
    public void runBruteForce(String originalText, String encryptedText, String bruteForcedText, FileActionEnum action) {
        PathCheckEmpty source = new PathCheckEmpty(originalText, encryptedText, bruteForcedText, action);
        String sourcePath = source.defaultSourceFilePath();
        String encryptedPath = source.defaultDestinationFilePath();
        String brutePath = source.defaultDestinationBruteForcePath();

        Path originalTextPath = PathBuilder.pathname(sourcePath);
        Path encryptedTextPath = PathBuilder.pathname(encryptedPath);
        Path bruteForcedTextPath = PathBuilder.pathname(brutePath);

        try (BufferedReader originalFile = Files.newBufferedReader(originalTextPath);
             BufferedReader encryptedFile = Files.newBufferedReader(encryptedTextPath);
             BufferedWriter bruteForcedFile = Files.newBufferedWriter(bruteForcedTextPath)
        ){
            StringBuilder origText = new StringBuilder();
            StringBuilder encryptText = new StringBuilder();
            int StringCountLines = 6;
            while(StringCountLines > 0){
                origText.append(originalFile.readLine().toLowerCase());
                StringCountLines--;
            }
            StringCountLines = 6;
            while(StringCountLines > 0){
                encryptText.append(encryptedFile.readLine());
                StringCountLines--;
            }
            int key = returnKey(origText, encryptText);
            runFileWithKey(encryptedPath, brutePath, key, action);

        } catch (IOException e) {
            throw new ConsoleException(Message.FILE_EXCEPTION);
        }

    }
    public int returnKey(StringBuilder sourFile, StringBuilder encFile){
        StringBuilder bruteforceText = new StringBuilder();
        char[] encryptChar = encFile.toString().toCharArray();
        int key;
        int length = Alphabet.ALPHABET.length;
        String bruteforce;
        String orText = sourFile.toString();

        for (key = 0; key > -1 * Constant.KEY; key--) {
            for (int i = 0; i < encryptChar.length; i++) {
                char fileCharacter = encryptChar[i];
                if (Alphabet.letterIndex.containsKey(fileCharacter)) {
                    int index = Alphabet.letterIndex.get(fileCharacter);
                    index = (index + key + Math.abs(key) * length) % length;
                    bruteforceText.append(Alphabet.ALPHABET[index]);
                } else if (fileCharacter == '\n') {
                    bruteforceText.append(fileCharacter);
                }

            }
            bruteforce = bruteforceText.toString();
            if (orText.equals(bruteforce)) {
                break;
            }
            bruteforceText = new StringBuilder();
        }
        return key;
    }

}
