package com.javarush.kuzmina.resources;

import static com.javarush.kuzmina.resources.MethodsCipher.*;

public class MethodsDecipher {
    public static char[] decipher(char[] textDecipher, int newTurn){
        char[] cipherArrTemp = new char[textDecipher.length];
        for (int i = 0; i < textDecipher.length; i++) {
            char tempo = textDecipher[i];
            boolean check = check(tempo);
            if (check == true) {
                int newInd = indexOf(tempo);
                int diff = newInd - newTurn;
                int temp1 = rotateBack(diff);
                cipherArrTemp[i] = lowCaseAlph[temp1];
            } else {
                cipherArrTemp[i] = textDecipher[i];

            }
        }return cipherArrTemp;
        }

        public static int rotateBack(int key2){
            int leng2 = lowCaseAlph.length - 1;
            int temp2 = 0;
            if (key2 >= 0){
                temp2 = key2;
            }else{
                temp2 = lowCaseAlph.length + key2;
            } return temp2;
    }
}
