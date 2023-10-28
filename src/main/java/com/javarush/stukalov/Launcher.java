package com.javarush.stukalov;

import com.javarush.stukalov.services.Decoder;
import com.javarush.stukalov.services.Encoder;

import java.nio.file.Path;

public class Launcher {
    public static void main(String[] args) {
        //Encoder.encode(Path.of("C:\\Users\\Артем\\OneDrive\\Рабочий стол\\Резюме\\Input.txt"), Path.of("C:\\Users\\Артем\\OneDrive\\Рабочий стол\\Резюме\\Output.txt"), 73);
        Decoder.decode(Path.of("C:\\Users\\Артем\\OneDrive\\Рабочий стол\\Резюме\\Input.txt"), Path.of("C:\\Users\\Артем\\OneDrive\\Рабочий стол\\Резюме\\Output.txt"), 73);

    }
}
