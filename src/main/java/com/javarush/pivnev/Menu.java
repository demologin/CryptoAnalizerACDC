package com.javarush.pivnev;

import java.util.Scanner;

import static com.javarush.pivnev.Alphabet.ALPHABET;

public class Menu {
    Scanner console = new Scanner(System.in);
    private int auswahl;

    public Menu() {
        //this.auswahl = auswahl;
        System.out.println("Выберите действие:");
        System.out.println("Зашифровать файл - 1");
        System.out.println("Декодировать файл - 2");
        System.out.println("Выход - 3");

        this.auswahl = console.nextInt();
        select(auswahl);
    }

    public void select(int auswahl) {
        /*
        System.out.println("Выберите действие:");
        System.out.println("Зашифровать файл - 1");
        System.out.println("Декодировать файл - 2");
        System.out.println("Выход - 3");

         */

        //int auswahl = console.nextInt();

        //Encryption encryption = new Encryption();
        //Decoding decoding = new Decoding();

        switch (auswahl) {
            case (1):
                System.out.println("Напишите адрес файла с текстом который нужно зашифровать (text.txt): ");
                console.nextLine();
                String file_original = console.nextLine();
                System.out.println("Напишите адрес файла в который нужно записать зашифрованный текст (encrypted.txt): ");
                String file_encrypted = console.nextLine();
                System.out.println("Введите ключ для шифра: ");
                int shift_encrypted = console.nextInt();

                if (!(file_original.equals(".bash_profile.txt")) && !(file_original.equals("hosts.txt")) &&
                        !(file_encrypted.equals(".bash_profile.txt")) && !(file_encrypted.equals("hosts.txt")))
                {
                    if (shift_encrypted >= 0 && shift_encrypted <= ALPHABET.length - 1)
                    {
                        Encryption encryption = new Encryption();
                        encryption.reading_file(file_original, file_encrypted, shift_encrypted);
                    }
                    else System.out.println("Ключ должен быть от 0 до 39");
                }
                else System.out.println("Не допускаются имена '.bash_profile' или 'hosts' к файлам");
                break;
            case (2):
                System.out.println("Напишите адрес зашифрованного файла (encrypted.txt): ");
                console.nextLine();
                String file_decoding = console.nextLine();
                System.out.println("Напишите адрес файла в который нужно записать расшифрованный текст (descrypted.txt): ");
                String file_decoding_paste = console.nextLine();
                System.out.println("Введите ключ для шифра: ");
                int shift_decoding = console.nextInt();

                if (!(file_decoding.equals(".bash_profile.txt")) && !(file_decoding.equals("hosts.txt")) &&
                        !(file_decoding_paste.equals(".bash_profile.txt")) && !(file_decoding_paste.equals("hosts.txt")))
                {
                    if (shift_decoding >= 0 && shift_decoding <= ALPHABET.length - 1)
                    {
                        Decoding decoding = new Decoding();
                        decoding.reading_file(file_decoding, file_decoding_paste, shift_decoding);
                    }
                    else System.out.println("Ключ должен быть от 0 до 39");

                }
                else System.out.println("Не допускаются имена '.bash_profile' или 'hosts' к файлам");

                //decoding.reading_file(file_decoding, file_decoding_paste, shift_decoding);
                //System.out.println("Файл расшифрован");
                break;
            case (3):
                System.out.println("Завершение программы");
                System.exit(0);
                break;
            default:
                System.out.println("Нет такого варианта");
        }
    }
}
