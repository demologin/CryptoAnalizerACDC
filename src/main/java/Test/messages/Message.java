package Test.messages;

import Test.commands.FileActionEnum;
import Test.constant.Constant;

public class Message {
    public static final String FILE_EXCEPTION = "Problem with read/write txt file";
    public static final String INCORRECT_ACTION = "Not found this command";
    public static final String UNKNOWN_COMMAND = "Unknown command";
    public static final String CHOOSE_COMMAND = "Choose a command. Press next number";
    public static final String TYPE_SOURCE_FILE = "Type source txt file or push enter";
    public static final String TYPE_DESTINATION_FILE = "Type destination txt file or push enter";
    public static final String TYPE_BRUTEFORCE_FILE = "Type destination bruteforce txt file or push enter";
    public static final String KEY = "Enter the key from 0 to %d".formatted(Constant.KEY);
    public static final String ENCRYPT = "Encrypt";
    public static final String DECRYPT = "Decrypt";
    public static final String BRUTEFORCE = "BruteForce";
    public static final String INCORRECT_COMMAND_TEXT = "Incorrect command. Please enter only numbers";
    public static final String INCORRECT_COMMAND_NUMBER = "Incorrect command number. Please enter the number under";
    public static final String INCORRECT_KEY_NUMBER = "Incorrect key. Please enter the key from 0 to 50";
    public static final String INCORRECT_KEY_TEXT = "Incorrect key. Please enter only numbers from 0 to 50";





    public String getMessageToAction(int action){
        return switch (action){
            case 0 -> CHOOSE_COMMAND;
            case 1 -> TYPE_SOURCE_FILE;
            case 2 -> TYPE_DESTINATION_FILE;
            case 3 -> KEY;
            default -> UNKNOWN_COMMAND;
        };
    }

    public String getMessageToCommand(){
        return CHOOSE_COMMAND;
    }

    public String getMessagesToActions(int action, int command){
        return switch(action){
            case 1 -> TYPE_SOURCE_FILE;
            case 2 -> TYPE_DESTINATION_FILE;
            case 3 -> {
                if(command == 2){
                    yield TYPE_BRUTEFORCE_FILE;
                }
                else{
                    yield KEY;
                }
            }
            default -> UNKNOWN_COMMAND;
        };
    }

    public void showActionsNamesInMenu(){
        String actionsMessage = """
               ___________
               %d - %s
               %d - %s
               %d - %s
                """;
        System.out.printf(actionsMessage,0, ENCRYPT, 1, DECRYPT, 2, BRUTEFORCE);
    }
}
