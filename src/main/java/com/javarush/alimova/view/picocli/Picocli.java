package com.javarush.alimova.view.picocli;
import com.javarush.alimova.commands.Result;
import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.controller.MainController;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

@Command(name = PicocliConst.APP_NAME, subcommands = {CommandLine.HelpCommand.class },
        description = PicocliConst.APP_DESCRIPTION, mixinStandardHelpOptions = true)
public class Picocli implements Runnable {

    private final MainController mainController;

    public Picocli(MainController mainController) {
        this.mainController = mainController;
    }
    @Spec CommandSpec spec;
    @Command(name = PicocliConst.ENCODE, description = PicocliConst.ENCODE_HELP)
    void encode(
            @Parameters(paramLabel = PicocliConst.SOURCE_FILE, description = PicocliConst.SOURCE_HELP) String src,
            @Parameters(paramLabel = PicocliConst.DEST_FILE, description = PicocliConst.DEST_ENCRYPTED_FILE_HELP) String dest,
            @Parameters(paramLabel = PicocliConst.KEY, description = PicocliConst.KEY_HELP) String key) {
            String[] parameter = {src, dest, key};
            Result result = mainController.giveCommand(CommandContainer.ENCODING.name(), parameter);

            mainController.printResultCommand(result);
    }

    @Command(name = PicocliConst.DECODE, description = PicocliConst.DECODE_HELP)
    void decode(
            @Parameters(paramLabel = PicocliConst.SOURCE_FILE, description = PicocliConst.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = PicocliConst.DEST_FILE, description = PicocliConst.DEST_FILE_HELP) String dest,
            @Parameters(paramLabel = PicocliConst.KEY, description = PicocliConst.KEY_HELP) String key) {
            String[] parameter = {src, dest, key};
            Result result = mainController.giveCommand(CommandContainer.DECODING.name(), parameter);

            mainController.printResultCommand(result);
    }

    @Command(name = PicocliConst.BRUTEFORCE, description = PicocliConst.BRUTEFORCE_HELP)
    void bruteforce(
            @Parameters(paramLabel = PicocliConst.SOURCE_FILE, description = PicocliConst.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = PicocliConst.DEST_FILE, description = PicocliConst.DEST_FILE_HELP) String dest) {
            String[] parameter = {src, dest};
            Result result = mainController.giveCommand(CommandContainer.BRUTEFORCE.name(), parameter);

            mainController.printResultCommand(result);
    }


    @Command(name = PicocliConst.ANALYZE, description = PicocliConst.ANALYZE_HELP)
    void analyze(
            @Parameters(paramLabel = PicocliConst.SOURCE_FILE, description = PicocliConst.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = PicocliConst.DEST_FILE, description = PicocliConst.DEST_FILE_HELP) String dest,
            @Parameters(paramLabel = PicocliConst.DICT_FILE, description = PicocliConst.DICT_HELP) String dict)
             {
            String[] parameter = {src, dest, dict};
            Result result = mainController.giveCommand(CommandContainer.ANALYZER.name(), parameter);

            mainController.printResultCommand(result);

    }

    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), PicocliConst.SPECIFY_A_SUBCOMMAND);
    }
}
