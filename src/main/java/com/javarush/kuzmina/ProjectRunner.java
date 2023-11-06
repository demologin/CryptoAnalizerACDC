package com.javarush.kuzmina;

import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javarush.kuzmina.resources.MethodsCipher.cipher;
import static com.javarush.kuzmina.resources.MethodsCipher.textToArray;
import static com.javarush.kuzmina.resources.MethodsDecipher.decipher;


public class ProjectRunner {

    public static void main(String[] args) {
        System.out.println("Пожалуйста введите свой текст для шифрования");
        Scanner scanText = new Scanner(System.in);
        String text = scanText.nextLine();
        char[] textArr = textToArray(text);
        System.out.println("Пожалуйста, введите число от 1 до 31");
        Scanner scanNumber = new Scanner(System.in);
        int number = 0;
        while (scanNumber.hasNextInt()) {
                number = scanNumber.nextInt();
                if (number > 0 && number < 32) {
                    char[] textCipher = cipher(textArr, number);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < textCipher.length; i++) {
                        stringBuilder.append(textCipher[i]);
                    }
                    String joinedString = stringBuilder.toString();
                    System.out.println(joinedString);
                    System.out.println("\n Поздравляем! Вы только что зашифровали свой текст. Хотите его расшифровать обратно?\n да\n нет");
                    String answer = "привет";
                    String yes = "да";
                    String no = "нет";
                    String cipherText = joinedString;
                    while (!answer.equals(yes) || !answer.equals(no)) {
                        Scanner scanner2 = new Scanner(System.in);
                        String answer2 = scanner2.nextLine();
                        answer = answer2.toLowerCase();
                        if (answer.equals("да")) {

                            char[] cipherArr = textToArray(cipherText);
                            char[] textDecipher = decipher(cipherArr, number);
                            StringBuilder stringBuilder2 = new StringBuilder();
                            for (int i = 0; i < textDecipher.length; i++) {
                                stringBuilder2.append(textDecipher[i]);
                            }
                            String newString = stringBuilder2.toString();
                            System.out.println(newString);
                            break;
                        } else if (answer.equals("нет")) {
                            System.out.println("Спасибо, что воспользовались системой шифрования!");
                            break;
                        } else {
                            System.out.println("Я Вас не понимаю. Повторите свой ответ.");
                        }
                    }
                    break;
                } else {
                    System.out.println("Пожалуйста, попробуйте ещё раз");
                }
            }


        }
    }

