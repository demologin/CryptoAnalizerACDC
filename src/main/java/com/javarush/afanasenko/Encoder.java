package com.javarush.afanasenko;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class Encoder {
    private static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е','ё', 'ж', 'з',
            'и','й' ,'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
TextHandler text;
int key;
    public Encoder(TextHandler text, int key) {
        this.text = text;
        this.key = key;
    }

    public void encode(String typeOperation, String pathTo){
        if(key>=ALPHABET.length||key<1)
            throw new CryptoException("Ключ должен быть не меньше единицы и не больше размера алфавита("+
                    ALPHABET.length+")");

        HashMap<Character, Character> code = new HashMap<>();
        for(int i = 0; i<ALPHABET.length; i++){
            int k;
            if(typeOperation.equals("encode"))   k = (i + key) % ALPHABET.length;
            else if (typeOperation.equals("decode")) k = (i < key)?ALPHABET.length - key + i:i - key;
            else throw new CryptoException("неверная команда");
            code.put(ALPHABET[i], ALPHABET[k]);
        }
        HashMap<Integer, Character> result = text.getSymbolMap();
        for(int i =0; i<result.size(); i++){
            char symbol= result.get(i);
            if(code.containsKey(symbol)) result.put(i, Character.toLowerCase(code.get(symbol)));
        }
        text.setSymbolMap(result);
        text.textToFile(pathTo);
    }
   /* public void decode(){
        if(key>=ALPHABET.length||key<1)
            throw new CryptoException("Ключ должен быть не меньше единицы и не больше размера алфавита("+
                    ALPHABET.length+")");

        HashMap<Character, Character> code = new HashMap<>();
        for(int i = 0; i<ALPHABET.length; i++){
            int k = (i < key)?ALPHABET.length - key + i:i - key;
            code.put(ALPHABET[i], ALPHABET[k]);
        }

        HashMap<Integer, Character> result = text.getSymbolMap();
        for(int i =0; i<result.size(); i++){
            char symbol= result.get(i);
            if(code.containsKey(symbol)) result.put(i, code.get(symbol));
        }
        text.setSymbolMap(result);

        text.textToFile("text\\decodedFile.txt");
    }*/
  }
