package com.javarush.krylov;

import Service.LanguageChecker;

public class BruteForceCipher {

    public String simpleDecryption (String inputText) {
        CaesarCipher cc = new CaesarCipher();
        String decryptedText;
        int offset = getOffset(inputText);
        decryptedText = cc.decrypt(inputText, offset);
        return decryptedText;
    }

    public String noSpecCharsDecryption (String inputText) {
        CaesarCipher cc = new CaesarCipher();
        LanguageChecker lc = new LanguageChecker();
        String decryptedText = null;
        for (int i = 1; i < 256; i++) {
            decryptedText = cc.decrypt(inputText, i);
            String languageByPattern = lc.getLanguageByPattern(decryptedText);
            if(!languageByPattern.isEmpty()) {
                return String.format("Decrypted text: %s", decryptedText);
            }
        }
        return decryptedText;
    }

    public String smallTextDecryption(String inputText) {
        LanguageChecker lc = new LanguageChecker();
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
                return decryptedString;
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

    private int getOffset(String text) {
        int offset = 0;
        for (int i = 0; i < text.length(); i++) {
            int firstValue = text.charAt(i);
            int secondValue = (i+1) == text.length() ? 0 : (int) text.charAt(i+1);
            int COMMA_VALUE = 44;
            int SPACE_VALUE = 32;
            int DOT_VALUE = 46;
            //int EXCLAM_SIGN_VALUE = 33;
            int DOUBLE_DOT_VALUE = 58;
            int COMMA_DOT_VALUE = 59;
            if(secondValue == 0 || secondValue == 10) {
                offset = (int) text.charAt(i) - DOT_VALUE;
            }
            if ((isDifferenceEqual(COMMA_VALUE, firstValue, SPACE_VALUE, secondValue) || (isDifferenceEqual(DOT_VALUE, firstValue, SPACE_VALUE, secondValue))) || (isDifferenceEqual(DOUBLE_DOT_VALUE, firstValue, SPACE_VALUE, secondValue) || (isDifferenceEqual(COMMA_DOT_VALUE, firstValue, SPACE_VALUE, secondValue)))) {
                offset = SPACE_VALUE - (int) text.charAt(i+1);
            }

        }
        return offset;
    }

//    private boolean isAbsolutePath(String inputPath) {
//        Path p = Paths.get(inputPath);
//        return !p.isAbsolute() || !Files.exists(p);
//    }
}
