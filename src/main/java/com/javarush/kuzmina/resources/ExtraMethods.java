package com.javarush.kuzmina.resources;

import java.util.Arrays;


public class ExtraMethods {
    public static char[] lowCaseAlph = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    public static char[] upperCaseAlph = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    public static boolean checkLow (char b){
        int index = Arrays.binarySearch(lowCaseAlph, b);
        boolean ifExists = index >= 0;
        return ifExists;
    }
    public static boolean checkUpper (char b){
        int index = Arrays.binarySearch(upperCaseAlph, b);
        boolean ifExists = index >= 0;
        return ifExists;
    }
    public static int indexOfL(char key) {
        for (int i = 0; i < lowCaseAlph.length; i++)
            if (lowCaseAlph[i] == key)
                return i;
        return 0;
    }
    public static int indexOfU(char key) {
        for (int i = 0; i < upperCaseAlph.length; i++)
            if (upperCaseAlph[i] == key)
                return i;
        return 0;
    }
    public static int rotateL(int key) {
        int leng = lowCaseAlph.length - 1;
        int temp1 = 0;
        if(key > leng) {
            temp1 = key - lowCaseAlph.length;
        } else {
            temp1 = key;
        } return temp1;
    }
    public static int rotateU(int key) {
        int leng = upperCaseAlph.length - 1;
        int temp1 = 0;
        if(key > leng) {
            temp1 = key - upperCaseAlph.length;
        } else {
            temp1 = key;
        } return temp1;
    }
    public static int rotateBackL(int key2){
        int leng2 = lowCaseAlph.length - 1;
        int temp2 = 0;
        if (key2 >= 0){
            temp2 = key2;
        } else {
            temp2 = lowCaseAlph.length + key2;
        } return temp2;
    }
    public static int rotateBackU(int key2){
        int leng2 = upperCaseAlph.length - 1;
        int temp2 = 0;
        if (key2 >= 0){
            temp2 = key2;
        } else {
            temp2 = upperCaseAlph.length + key2;
        } return temp2;
    }
    public static char[] textToArray(String text) {
        char[] textArr2 = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            textArr2[i] = text.charAt(i);
        }
        return textArr2;
    }
}
