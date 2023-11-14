package com.javarush.kuzmina.resources;
import static com.javarush.kuzmina.resources.ExtraMethods.*;


public class MethodsCipher {

    public static char[] cipher(char[] textArr, int turn) {
        char[] textArrTemp = new char[textArr.length];
        for (int i = 0; i < textArr.length; i++) {
            char tempo = textArr[i];
            boolean checkL = checkLow(tempo);
            boolean checkU = checkUpper(tempo);
            if (checkL) {
                int ind = indexOfL(tempo);
                int sum = turn + ind;
                int temp = rotateL(sum);
                textArrTemp[i] = lowCaseAlph[temp];
            } else if (checkU) {
                int ind = indexOfU(tempo);
                int sum = turn + ind;
                int temp = rotateU(sum);
                textArrTemp[i] = upperCaseAlph[temp];
            } else {
                textArrTemp[i] = textArr[i];
            }
        } return textArrTemp;
    }
}

