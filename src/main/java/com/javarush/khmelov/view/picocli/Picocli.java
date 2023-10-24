package com.javarush.khmelov.view.picocli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;
import com.javarush.khmelov.constant.Const;
import com.javarush.khmelov.entity.Result;

import static com.javarush.khmelov.view.picocli.Messages.*;

@SuppressWarnings("unused")
@Command(name = APP_NAME, subcommands = {CommandLine.HelpCommand.class},
        description = APP_DESCRIPTION)
public class Picocli implements Runnable {

    private final PicocliApp application;

    public Picocli(PicocliApp application) {
        this.application = application;
    }

    @Spec
    CommandSpec spec;

    @Command(name = Const.ENCODE, description = ENCODE_HELP)
    void encode(
            @Parameters(paramLabel = SOURCE_FILE, description = SOURCE_HELP) String src,
            @Parameters(paramLabel = DEST_FILE, description = DEST_ENCRYPTED_FILE_HELP) String dest,
            @Parameters(paramLabel = KEY, description = KEY_HELP) String key) {
        String[] args = {Const.ENCODE, src, dest, key};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = Const.DECODE, description = DECODE_HELP)
    void decode(
            @Parameters(paramLabel = SOURCE_FILE, description = ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = DEST_FILE, description = DEST_FILE_HELP) String dest,
            @Parameters(paramLabel = KEY, description = KEY_HELP) String key) {
        String[] args = {Const.DECODE, src, dest, key};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = Const.BRUTEFORCE, description = BRUTEFORCE_HELP)
    void bruteForce(
            @Parameters(paramLabel = SOURCE_FILE, description = ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = DEST_FILE, description = DEST_FILE_HELP) String dest) {
        String[] args = {Const.BRUTEFORCE, src, dest};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = Const.ANALYZE, description = ANALYZE_HELP)
    void analyze(
            @Parameters(paramLabel = SOURCE_FILE, description = ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = DICT_FILE, description = DICT_HELP) String dict,
            @Parameters(paramLabel = DEST_FILE, description = DEST_FILE_HELP) String dest) {
        String[] args = {Const.ANALYZE, src, dict, dest};
        Result result = application.run(args);
        System.out.println(result);
    }


    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), SPECIFY_A_SUBCOMMAND);
    }
}
























