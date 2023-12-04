package com.javarush.krylov.src;

import Service.LanguageChecker;

import java.util.NoSuchElementException;

public class BruteForceCipher {

    private final CaesarCipher cc = new CaesarCipher();
    private final LanguageChecker lc = new LanguageChecker();

    public String getSimpleDecryptionResultAsString(String inputText) {
        String decryptedText;
        int offset = getOffsetValueForSpecChars(inputText);
        decryptedText = cc.decrypt(inputText, offset);
        return decryptedText;
    }

    public String getNoSpecCharsDecryptionResultAsString(String inputText) {
        String decryptedTextFragment = inputText.substring(0, Math.min(50, inputText.length()));
        String fragmentDecryptionResult = getSmallTextDecryptionResultAsString(decryptedTextFragment);
        int key = getEncryptionKey(fragmentDecryptionResult);
        String decryptedText = cc.decrypt(inputText, key);
        return "Key: " + key + "\n" + decryptedText;
    }

    public String getSmallTextDecryptionResultAsString(String inputText) {
        StringBuilder decryptedText = new StringBuilder();
        for (int key = 0; key < 256; key++) {
            StringBuilder decryptedAttempt = new StringBuilder();
            for (int i = 0; i < inputText.length(); i++) {
                char ch = inputText.charAt(i);
                int decryptedValue = ((int) ch - key + 256) % 256; //256 is the maximum value of ASCII symbols
                char decryptedChar = (char) decryptedValue;
                decryptedAttempt.append(decryptedChar);
            }
            String decryptedString = decryptedAttempt.toString();
            if (!lc.getLanguageByPattern(decryptedString).equals("")) {
                return decryptedString + "; " + key;
            }
            decryptedText.append(decryptedAttempt).append("\n");
        }
        return decryptedText.toString();
    }

    private boolean isDifferenceEqual(int firstValue, int secondValue, int thirdValue, int fourthValue) {
        int dif1 = secondValue - firstValue;
        int dif2 = fourthValue - thirdValue;
        return dif1 == dif2;
    }

    private int getOffsetValueForSpecChars(String text) {
        int offset = 0;
        for (int i = 0; i < text.length(); i++) {
            int firstValue = text.charAt(i);
            int secondValue = (i+1) == text.length() ? 0 : (int) text.charAt(i+1);
            int COMMA_VALUE = 44;
            int SPACE_VALUE = 32;
            int DOT_VALUE = 46;
            int EXCLAIM_SIGN_VALUE = 33;
            int DOUBLE_DOT_VALUE = 58;
            int COMMA_DOT_VALUE = 59;
            if(secondValue == 0 || secondValue == 10) {
                offset = (int) text.charAt(i) - DOT_VALUE;
            }
            if ((isDifferenceEqual(COMMA_VALUE, firstValue, SPACE_VALUE, secondValue) || (isDifferenceEqual(DOT_VALUE, firstValue, SPACE_VALUE, secondValue))) || (isDifferenceEqual(DOUBLE_DOT_VALUE, firstValue, SPACE_VALUE, secondValue) || (isDifferenceEqual(COMMA_DOT_VALUE, firstValue, SPACE_VALUE, secondValue)) || (isDifferenceEqual(EXCLAIM_SIGN_VALUE, firstValue, SPACE_VALUE, secondValue)) )) {
                offset = SPACE_VALUE - (int) text.charAt(i+1);
            }

        }
        return offset;
    }

    private Integer getEncryptionKey (String decryptedText) {
        int key;
        int separatorIndex = decryptedText.indexOf("; ");
        if(separatorIndex != -1) {
            key = Integer.parseInt(decryptedText.substring(separatorIndex + 2));
        }
        else {
            throw new NoSuchElementException("Separator char combination not found in input String object");
        }
        return key;
    }

}
