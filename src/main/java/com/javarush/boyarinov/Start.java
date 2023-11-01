package com.javarush.boyarinov;


import com.javarush.boyarinov.comands.Decrypt;
import com.javarush.boyarinov.comands.Encrypt;

public class Start {
    public static void main(String[] args) {

        Encrypt encrypt = new Encrypt();
        encrypt.encode("text.txt", "encryptText.txt", 3);
        Decrypt decrypt = new Decrypt();
        decrypt.decode("encryptText.txt", "decrypt.txt", 3);
    }


}
