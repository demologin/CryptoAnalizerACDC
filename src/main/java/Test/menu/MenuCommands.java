package Test.menu;

import Test.commands.FileActionEnum;
import Test.messages.Message;

import java.util.Scanner;

public class MenuCommands {
    private static Message message;
    private static String[] parameters = new String[4];
    private static Scanner console;
    private static int commandNumber;

    public MenuCommands(Scanner console, Message message){
       MenuCommands.console = console;
       MenuCommands.message = message;
    }


    public void setParametersForMenu(){
        for(int i = 0; i < parameters.length; i++) {
            String number;
            if (i == 0) {
                System.out.println(message.getMessageToCommand());
                do {
                    message.showActionsNamesInMenu();
                    number = console.nextLine();
                }
                while (!checkIsCommandNumber(number));
            } else if (i == 3 && commandNumber != 2) {
                System.out.println(message.getMessagesToActions(i,commandNumber));
                ///Checked entered key
                do {
                    number = console.nextLine();
                }
                while (!checkIsKey(number));
            }
            else{
                System.out.println(message.getMessagesToActions(i,commandNumber));
                number = console.nextLine();
            }
            parameters[i] = number;
        }
    }
    public static int getCommandNumber(){
        return commandNumber;
    }

//    public void setParametersForMenu(){
//        for(int i = 0; i < parameters.length; i++){
//            String number;
//            System.out.println(message.getMessageToAction(i));
//            if(i==0){
//                ///Checked entered number
//                do {
//                    message.showActionsNamesInMenu();
//                    number = console.nextLine();
//                }
//                while(!checkIsCommandNumber(number));
//            }
//            else if(i == 3){
//                ///Checked entered key
//                do{
//                    number = console.nextLine();
//                }
//                while(!checkIsKey(number));
//            }
//            else{
//                number = console.nextLine();
//            }
//            parameters[i] = number;
//
//        }
//    }
    public String[] getParameters(){
        return parameters;
    }

    private boolean checkIsCommandNumber(String number) {
        int checkedNumber;
        try{
            checkedNumber = Integer.parseInt(number);
            /// Compare with FileActionEnum array
            if(checkedNumber < FileActionEnum.getActionsArrayLength() && checkedNumber >= 0)
            {
                commandNumber = checkedNumber;
                return true;
            }
            System.out.println(Message.INCORRECT_COMMAND_NUMBER);
        }
        catch (NumberFormatException e){
            System.out.println(Message.INCORRECT_COMMAND_TEXT);
        }
        return false;
    }
    private boolean checkIsKey(String number) {
        int checkedNumber;
        try{
            checkedNumber = Integer.parseInt(number);
            /// Compare with FileActionEnum array
            if(checkedNumber >= 0 && checkedNumber <= 50)
            {
                return true;
            }
            System.out.println(Message.INCORRECT_KEY_NUMBER);
        }
        catch (NumberFormatException e){
            System.out.println(Message.INCORRECT_KEY_TEXT);
        }
        return false;
    }
}
