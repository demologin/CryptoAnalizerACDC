package com.javarush.KGurov.command;

import java.io.IOException;

public class Cases {
123
    public static void cases(int number) throws IOException {
        switch (number) {
            case (1):
                FileReaderWriter.fileReaderWriter.enterFiles();
                Encoder.encode.EnterKey();
                System.out.println("Starting encoding...");
                Encoder.encode.Encoding();
                break;
            case (2):
                FileReaderWriter.fileReaderWriter.enterFiles();
                Decoder.decode.EnterKey();
                System.out.println("Starting decoding...");
                Decoder.decode.Decoding();
                break;
            case (3):
                System.out.println("Ok:\\ bye");
                break;
            default:
                System.out.println("Select the option from 1 to 3:");
                break;
        }
    }
}
