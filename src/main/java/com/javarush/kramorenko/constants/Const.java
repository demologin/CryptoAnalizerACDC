package com.javarush.kramorenko.constants;

import java.io.File;

public interface Const {
    String INVALID_INPUT = "Невернный ввод. Попробуте еще раз.";
    String NUMBER_IS_NOT_IN_LIST = "Вы ввели номер действия %d, такого нет в списке.";
    String ENCRYPTION_COMPLETE = "Шифрование завершено.";
    String DECRYPTION_COMPLETE = "Расшифровка завершена.";
    String APPLICATION_CLOSED = "Приложение закрыто.";
    String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator + "text.txt" + File.separator;
    String TXT_ENCRYPTED = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator + "encrypted.txt" + File.separator;
    String TXT_DECRYPTED = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator + "decrypted.txt" + File.separator;
}
