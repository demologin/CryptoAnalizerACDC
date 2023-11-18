package com.javarush.Alymov;



import com.javarush.Alymov.entity.Result;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}
