package com.javarush.malyshev;

import java.io.IOException;

public class Choice {

    public static void makeStartingChoice(int number) throws IOException {
            switch (number) {
                case (1):
                    ReadAndWrite.readAndWrite.enterTheFiles();
                    EncryptAndDecrypt.encryptAndDecrypt.EnterKey();
                    System.out.println("Starting encryption..");
                    EncryptAndDecrypt.encryptAndDecrypt.Encryption();
                    break;
                case (2):
                    ReadAndWrite.readAndWrite.enterTheFiles();
                    EncryptAndDecrypt.encryptAndDecrypt.EnterKey();
                    System.out.println("Starting decryption..");
                    EncryptAndDecrypt.encryptAndDecrypt.Decrypt();
                    break;
                case (3):
                    ReadAndWrite.readAndWrite.enterTheFiles();
                    System.out.println("Starting brute force..");
                    BruteForce.bruteForce.bruteForce();
                    break;
                case (4):
                    System.out.println("Doesn't work");
                    break;
                case (5):
                    System.out.println("Ok:\\ bye");
                    break;
                default:
                    System.out.println("Enter a number from 1 to 5:");
                    break;
        }
    }
}
