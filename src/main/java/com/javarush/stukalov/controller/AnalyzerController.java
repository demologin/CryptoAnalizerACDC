package com.javarush.stukalov.controller;

import com.javarush.stukalov.services.Analyzer;
import com.javarush.stukalov.services.BruteForcer;
import com.javarush.stukalov.services.Decoder;
import com.javarush.stukalov.services.Encoder;
import com.javarush.stukalov.utils.PathBuilder;

import java.util.List;

public class AnalyzerController {
    private final Encoder ENCODER = Encoder.getInstance();
    private final Decoder DECODER = Decoder.getInstance();
    private final BruteForcer BRUTE_FORCER = BruteForcer.getInstance();
    private final Analyzer ANALYZER = Analyzer.getInstance();

    public void run(int command, List<String> params) {
        switch (command) {
            case 1 -> ENCODER.encode(PathBuilder.get(params.get(0)), PathBuilder.get(params.get(1)), Integer.parseInt(params.get(2)));
            case 2 -> DECODER.decodeToFile(PathBuilder.get(params.get(0)), PathBuilder.get(params.get(1)), Integer.parseInt(params.get(2)));
            case 3 -> BRUTE_FORCER.bruteForce(PathBuilder.get(params.get(0)), PathBuilder.get(params.get(1)));
            case 4 -> ANALYZER.analyze(PathBuilder.get(params.get(0)), PathBuilder.get(params.get(1)));
            default -> System.out.println("There is no such an option");
        }
    }
}
