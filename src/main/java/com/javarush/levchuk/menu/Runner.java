package com.javarush.levchuk.menu;

import com.javarush.levchuk.mods.BruteForce;
import com.javarush.levchuk.mods.Decode;
import com.javarush.levchuk.mods.Encode;

public class Runner {
    private static Encode encode;
    private static Decode decode;
    private static BruteForce bruteForce;

    public static synchronized Encode getEncode() {
        if (encode == null) {
            encode = new Encode();
        }
        return encode;
    }

    public static synchronized Decode getDecode() {
        if (decode == null) {
            decode = new Decode();
        }
        return decode;
    }

    public static synchronized BruteForce getBruteForce() {
        if (bruteForce == null) {
            bruteForce = new BruteForce();
        }
        return bruteForce;
    }
}


