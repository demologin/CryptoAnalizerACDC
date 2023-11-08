package com.javarush.kuzmina;

import java.util.Scanner;

import static com.javarush.kuzmina.resources.MethodsMain.*;

public class ProjectRunner {
    public static void main(String[] args) throws NumberFormatException {
        System.out.println(GREETING);
        Scanner scanAnswer = new Scanner(System.in);
        while (scanAnswer.hasNext()){
            String firstAnswer = scanAnswer.nextLine();
            if(firstAnswer.equals("1")){
                ifAnswerCipher();
                break;
                }
            else if(firstAnswer.equals("2")){
                ifAnswerDecipher();
                break;
            }else{
                System.out.println(MISUNDERSTANDING);

            }
        }
    }
}


