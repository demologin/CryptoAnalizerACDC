package Test.menu;

import Test.commands.DefineAction;
import Test.commands.FileActionEnum;
import Test.messages.Message;

import java.util.Scanner;

public class Menu {

    private Scanner console;
    private static final String[] parameters = new String[4];
    public static MenuValues parameterGetter;
    public DefineAction doAction;


    public Menu(Scanner console){
        this.console = console;
    }


    public void run() {
        setParametersForMenu();
        getParameters();
        doAction = new DefineAction();
        doAction.doAction();
    }

    public void setParametersForMenu(){
        Message message = new Message();

        for(int i = 0; i < parameters.length; i++){
            String number = null;
            if(i==0){///Checked entered number
                System.out.println(message.getMessageToAction(i));
                do {
                    message.showActionsNamesInMenu();
                    number = console.nextLine();
                    if (checkIsCommandNumber(number)) {
                        break;
                    }
                }
                while(true);
            }
            if(i>0){
                System.out.println(message.getMessageToAction(i));
                number = console.nextLine();
            }
            parameters[i] = number;

        }
    }

    public MenuValues getParameters(){
        return parameterGetter = new MenuValues(parameters);
    }

    private boolean checkIsCommandNumber(String number) {
        int checkedNumber;
        try{
            checkedNumber = Integer.parseInt(number);
            /// Compare with FileActionEnum array
            if(checkedNumber < FileActionEnum.getActionsArrayLength() && checkedNumber >= 0)
            {
                return true;
            }
            System.out.println(Message.INCORRECT_COMMAND_NUMBER);
        }
        catch (NumberFormatException e){
            System.out.println(Message.INCORRECT_COMMAND_TEXT);
        }
        return false;
    }
}
