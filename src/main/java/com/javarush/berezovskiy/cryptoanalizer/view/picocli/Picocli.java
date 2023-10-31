package com.javarush.berezovskiy.cryptoanalizer.view.picocli;

import com.javarush.berezovskiy.cryptoanalizer.constant.Const;
import com.javarush.berezovskiy.cryptoanalizer.entity.Result;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

@SuppressWarnings("unused")
@Command(name = Messages.APP_NAME, subcommands = {CommandLine.HelpCommand.class},
        description = Messages.APP_DESCRIPTION)
public class Picocli implements Runnable {

    private final PicocliApp application;

    public Picocli(PicocliApp application) {
        this.application = application;
    }

    @Spec
    CommandSpec spec;

    @Command(name = Const.ENCODE, description = Messages.ENCODE_HELP)
    void encode(
            @Parameters(paramLabel = Messages.SOURCE_FILE, description = Messages.SOURCE_HELP) String src,
            @Parameters(paramLabel = Messages.DEST_FILE, description = Messages.DEST_ENCRYPTED_FILE_HELP) String dest,
            @Parameters(paramLabel = Messages.KEY, description = Messages.KEY_HELP) String key) {
        String[] args = {Const.ENCODE, src, dest, key};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = Const.DECODE, description = Messages.DECODE_HELP)
    void decode(
            @Parameters(paramLabel = Messages.SOURCE_FILE, description = Messages.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = Messages.DEST_FILE, description = Messages.DEST_FILE_HELP) String dest,
            @Parameters(paramLabel = Messages.KEY, description = Messages.KEY_HELP) String key) {
        String[] args = {Const.DECODE, src, dest, key};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = Const.BRUTEFORCE, description = Messages.BRUTEFORCE_HELP)
    void bruteForce(
            @Parameters(paramLabel = Messages.SOURCE_FILE, description = Messages.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = Messages.DEST_FILE, description = Messages.DEST_FILE_HELP) String dest) {
        String[] args = {Const.BRUTEFORCE, src, dest};
        Result result = application.run(args);
        System.out.println(result);
    }

    @Command(name = Const.ANALYZE, description = Messages.ANALYZE_HELP)
    void analyze(
            @Parameters(paramLabel = Messages.SOURCE_FILE, description = Messages.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = Messages.DICT_FILE, description = Messages.DICT_HELP) String dict,
            @Parameters(paramLabel = Messages.DEST_FILE, description = Messages.DEST_FILE_HELP) String dest) {
        String[] args = {Const.ANALYZE, src, dict, dest};
        Result result = application.run(args);
        System.out.println(result);
    }


    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), Messages.SPECIFY_A_SUBCOMMAND);
    }
}
























