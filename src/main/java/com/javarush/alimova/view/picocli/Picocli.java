package com.javarush.alimova.view.picocli;
import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.controller.MainController;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;
import com.javarush.alimova.dictionary.Const;

@Command(name = Const.APP_NAME, subcommands = {CommandLine.HelpCommand.class },
        description = Const.APP_DESCRIPTION, mixinStandardHelpOptions = true)
public class Picocli implements Runnable {
    @Spec CommandSpec spec;
    @Command(name = Const.ENCODE, description = Const.ENCODE_HELP)
    void encode(
            @Parameters(paramLabel = Const.SOURCE_FILE, description = Const.SOURCE_HELP) String src,
            @Parameters(paramLabel = Const.DEST_FILE, description = Const.DEST_ENCRYPTED_FILE_HELP) String dest,
            @Parameters(paramLabel = Const.KEY, description = Const.KEY_HELP) String key) {
            //добавить проверку валидности
            String[] parameter = {src, dest, key};
            MainController.giveCommand(CommandContainer.ENCODING.name(), parameter);
    }

    @Command(name = Const.DECODE, description = Const.DECODE_HELP) // |3|
    void decode(
            @Parameters(paramLabel = Const.SOURCE_FILE, description = Const.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = Const.DEST_FILE, description = Const.DEST_FILE_HELP) String dest,
            @Parameters(paramLabel = Const.KEY, description = Const.KEY_HELP) String key) {
        //добавить проверку валидности
            String[] parameter = {src, dest, key};
            MainController.giveCommand(CommandContainer.DECODING.name(), parameter);
    }

    @Command(name = Const.BRUTEFORCE, description = Const.BRUTEFORCE_HELP) // |3|
    void bruteforce(
            @Parameters(paramLabel = Const.SOURCE_FILE, description = Const.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = Const.DEST_FILE, description = Const.DEST_FILE_HELP) String dest) {
        //добавить проверку валидности
        String[] parameter = {src, dest};
        MainController.giveCommand(CommandContainer.BRUTEFORCE.name(), parameter);
    }


    @Command(name = Const.ANALYZE, description = Const.ANALYZE_HELP) // |3|
    void analyze(
            @Parameters(paramLabel = Const.SOURCE_FILE, description = Const.ENCRYPTED_SOURCE_HELP) String src,
            @Parameters(paramLabel = Const.DICT_FILE, description = Const.DICT_HELP) String dict,
            @Parameters(paramLabel = Const.DEST_FILE, description = Const.DEST_FILE_HELP) String dest) {
        //добавить проверку валидности
        String[] parameter = {src, dest, dict};
        MainController.giveCommand(CommandContainer.BRUTEFORCE.name(), parameter);

    }

    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), Const.SPECIFY_A_SUBCOMMAND);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Picocli()).execute(args);
        System.exit(exitCode);
    }
}
