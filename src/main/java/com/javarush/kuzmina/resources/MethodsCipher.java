package com.javarush.kuzmina.resources;
//import static com.javarush.kuzmina.resources.Alphabet.alphabet;
//import static com.javarush.kuzmina.resources.Alphabet.lowCaseAlph;

import java.util.Arrays;

public class MethodsCipher {
    public static char[] lowCaseAlph = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    public static char[] upperCaseAlph = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    public static char[] textToArray(String text) {
        char[] textArr2 = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            textArr2[i] = text.charAt(i);
        }
        return textArr2;

    }

    public static char[] cipher(char[] textArr, int turn) {
        char[] textArrTemp = new char[textArr.length];
        for (int i = 0; i < textArr.length; i++) {
            char tempo = textArr[i];
            boolean check = check(tempo);
            if (check) {
                int ind = indexOf(tempo);
                int sum = turn + ind;
                int temp = rotate(sum);
                textArrTemp[i] = lowCaseAlph[temp];
            } else {
                textArrTemp[i] = textArr[i];

            }
        }return textArrTemp;
    }

    public static int rotate(int key) {
        int leng = lowCaseAlph.length - 1;
        int temp1 = 0;
        if(key > leng) {
            temp1 = key - lowCaseAlph.length;
        } else{
            temp1 = key;
        }return temp1;
    }

    public static boolean check (char b){
        int index=Arrays.binarySearch(lowCaseAlph, b);
        boolean ifExists = index >= 0;
        return ifExists;
    }

        public static int indexOf(char key) {
        for (int i = 0; i < lowCaseAlph.length; i++)
        if (lowCaseAlph[i] == key)
        return i;
        return 0;
        }
}

