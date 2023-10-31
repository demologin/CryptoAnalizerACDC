package com.javarush.afanasenko;

import org.w3c.dom.Text;

import java.util.HashMap;

public class Encoder {
TextHandler text;
int key;


    public Encoder(TextHandler text, int key) {
        this.text = text;
        this.key = key;
    }

    public void encode(){
        HashMap<Integer, Character> result = new HashMap<>();
        //делаем декодировку
    }
}
