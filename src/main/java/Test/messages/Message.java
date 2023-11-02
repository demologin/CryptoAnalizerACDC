package Test.messages;

import Test.commands.FileActionEnum;

public class Message {
    public static final String FILE_EXCEPTION = "Problem with read/write txt file";
    public static final String INCORRECT_ACTION = "Not found this command";
    public static final String UNKNOWN_COMMAND = "Unknown command";

    public static final String CHOOSE_COMMAND = "Choose a command. Press next number";
    public static final String TYPE_SOURCE_FILE = "Type source txt file or push enter";
    public static final String TYPE_DESTINATION_FILE = "Type destination txt file or push enter";
    public static final String KEY = "Enter the key";
    public static final String ENCRYPT = "Encrypt";
    public static final String DECRYPT = "Decrypt";




    public String getMessageToAction(int action){
        return switch (action){
            case 0 -> CHOOSE_COMMAND;
            case 1 -> TYPE_SOURCE_FILE;
            case 2 -> TYPE_DESTINATION_FILE;
            case 3 -> KEY;
            default -> UNKNOWN_COMMAND;
        };
    }

    public void showActionsNamesInMenu(){
        String actionsMessage = """
               ___________
               %s - %d
               %s - %d
                """;
        System.out.printf(actionsMessage,ENCRYPT, 0, DECRYPT, 1);
    }
}
