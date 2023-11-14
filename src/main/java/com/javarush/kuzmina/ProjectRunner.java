package com.javarush.kuzmina;

import java.util.Scanner;

import static com.javarush.kuzmina.resources.MethodsMain.*;
import static com.javarush.kuzmina.resources.Dialogue.*;

public class ProjectRunner {
    static boolean projectRun = true;

    public static void main(String[] args) {
        System.out.println(GREETING);
        while (projectRun){
            System.out.println(CHOICE);
            Scanner answer = new Scanner(System.in);
            String firstAnswer = answer.nextLine();
            switch (firstAnswer){
                case "1":
                    ifAnswerCipher();
                    break;
                case "2":
                    ifAnswerCipherFromFile();
                    break;
                case "3":
                    ifAnswerDecipher();
                    break;
                case "4":
                    ifAnswerDecipherFromFile();
                    break;
                case "5":
                    System.out.println(THANKYOU);
                    answer.close();
                    projectRun = false;
                    break;
                default:
                    System.out.println(MISUNDERSTANDING);
            }
        }
    }
}


