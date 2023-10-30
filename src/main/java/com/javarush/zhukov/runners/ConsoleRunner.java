package com.javarush.zhukov.runners;

import com.javarush.zhukov.command.BruteForce;
import com.javarush.zhukov.command.Decode;
import com.javarush.zhukov.command.Encode;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-".repeat(14) + "MENU" + "-".repeat(14) +
                    "\n\t1.  Encode\n" +
                    "\t2.  Decode\n" +
                    "\t3.  BruteForce\n\n" +
                    "\t0.  Exit\n");
            switch (scanner.next()) {
                case "1" -> Encode.encodingCaesar();
                case "2" -> Decode.decodingCaesar();
                case "3" -> BruteForce.decodeBruteForce();
                case "0" -> {
                    System.out.println("\nGood Bye");
                    return;
                }
            }
        }
    }
}
