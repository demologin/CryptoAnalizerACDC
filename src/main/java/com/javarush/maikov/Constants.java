package com.javarush.maikov;

import java.io.File;

public class Constants {
    public static final char[] ALPHABET = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    public static final char[] CAPITALLETTER = {'А','Б','В','Г','Д','Е', 'Ё','Ж','З','И','Й','К','Л',
            'М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
    public static final String MENU = """
            =============================
            Выберите необходимое действие:
             1. Шифровка файла.
             2. Дешифровка файла.\s
             3. Выход из программы
            =============================""";
    public static final String TXT_FOLDER = System.getProperty("C:\\OracleOpen\\CryptoAnalizerACDC\\src\\main\\java\\com\\javarush\\maikov") +
            File.separator + "text" + File.separator;
}
