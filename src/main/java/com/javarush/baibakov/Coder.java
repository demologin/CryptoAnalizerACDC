package com.javarush.baibakov;


import java.util.Scanner;

public class Coder {
    public Coder(Scanner console) {
        System.out.println(Const.MENU);
        String option = console.nextLine();
        Boolean breakTmp = false;
        while (!option.equals(Const.EXIT)) {
            switch (option) {
                case Const.MODE_ENCRYPT: {
                    encrypt(console, false);
                    breakTmp = true;
                    break;
                }
                case Const.MODE_DECRYPT: {
                    encrypt(console, true);
                    breakTmp = true;
                    break;
                }
            }
            if (breakTmp) {
                break;
            } else {
                option = console.nextLine();
            }
        }
    }


    public static void encrypt(Scanner sc, boolean flagKey) {
        System.out.println(Const.SOURCE_FILE);
        String source = sc.next();
        System.out.println(Const.TARGET_FILE);
        String target = sc.next();
        System.out.println(Const.KEY);
        int key = Integer.parseInt(sc.next());
        TextEdit text = new TextEdit();
        text.getTextSource(source);
        if (!flagKey) {
            text.editText(key, Const.CHARS);
        } else {
            text.editText((-1) * key, Const.CHARS);
        }
        text.setTextTarget(target);
        System.out.println(Const.COMPLETED);
    }


}


