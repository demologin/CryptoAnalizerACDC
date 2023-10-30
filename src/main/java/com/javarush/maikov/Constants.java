package com.javarush.maikov;

import java.io.File;

public interface Constants {
    char[] ALPHABET = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    char[] CAPITALLETTER = {'А','Б','В','Г','Д','Е', 'Ё','Ж','З','И','Й','К','Л',
            'М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
    String MENU = """
            =============================
            Выберите необходимое действие:
             1. Шифровка файла.
             2. Дешифровка файла.\s
             3. Выход из программы
            =============================""";
    String TXT_FOLDER = System.getProperty("C:") + File.separator + "OracleOpen" + File.separator + "CryptoAnalizerACDC"
            + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator +
            "com" + File.separator + "javarush" + File.separator + "maikov" + File.separator;
}
