package com.javarush.kuzmina.resources;

import static com.javarush.kuzmina.resources.ExtraMethods.*;

public class MethodsDecipher {
    public static char[] decipher(char[] textDecipher, int newTurn){
        char[] cipherArrTemp = new char[textDecipher.length];
        for (int i = 0; i < textDecipher.length; i++) {
            char tempo = textDecipher[i];
            boolean checkL = checkLow(tempo);
            boolean checkU = checkUpper(tempo);
            if (checkL) {
                int newInd = indexOfL(tempo);
                int diff = newInd - newTurn;
                int temp1 = rotateBackU(diff);
                cipherArrTemp[i] = lowCaseAlph[temp1];
            } else if (checkU){
                int newInd = indexOfU(tempo);
                int diff = newInd - newTurn;
                int temp1 = rotateBackL(diff);
                cipherArrTemp[i] = upperCaseAlph[temp1];
            } else {
                cipherArrTemp[i] = textDecipher[i];

            }
        } return cipherArrTemp;
        }
}
