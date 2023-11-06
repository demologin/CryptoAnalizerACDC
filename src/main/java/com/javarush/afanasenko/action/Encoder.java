package com.javarush.afanasenko.action;

import com.javarush.afanasenko.exception.CryptoException;
import com.javarush.afanasenko.objects.TextHandler;

import java.util.HashMap;

public class Encoder {
    public static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-', '(',
            ')', '\n', ';', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private TextHandler text;
    private int key;

    public TextHandler getText() {
        return text;
    }

    public void setText(TextHandler text) {
        this.text = text;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Encoder(TextHandler text, int key) {
        this.text = text;
        this.key = key;
    }

    public StringBuilder encode(String typeOperation, String pathTo, boolean isWriteToFile) {
        if (key >= ALPHABET.length || key < 1)
            throw new CryptoException("Ключ должен быть не меньше единицы и не больше размера алфавита(" +
                    ALPHABET.length + ")");

        HashMap<Character, Character> code = new HashMap<>();
        for (int i = 0; i < ALPHABET.length; i++) {
            int k;
            if (typeOperation.equals("encode")) k = (i + key) % ALPHABET.length;
            else if (typeOperation.equals("decode")) k = (i < key) ? ALPHABET.length - key + i : i - key;
            else throw new CryptoException("неверная команда");
            code.put(ALPHABET[i], ALPHABET[k]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.getSymbolMap().size(); i++) {
            char symbol = Character.toLowerCase(text.getSymbolMap().get(i));
            if (code.containsKey(symbol)) sb.append(code.get(symbol));
        }
        if (isWriteToFile) text.textToFile(pathTo, sb);
        return sb;
    }
}
