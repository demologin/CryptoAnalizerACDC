package Test.menu;

import Test.commands.DefineAction;
import Test.commands.FileAction;
import Test.messages.Message;

import java.util.Scanner;

public class Menu {

    private Scanner console;
    private static final String[] parameters = new String[4];
    public static MenuValuesGetter parameterGetter;
    public DefineAction doAction;


    public Menu(Scanner console){
        this.console = console;
    }


    public void setParameters(){
        Message message = new Message();
        for(int i = 0; i < parameters.length; i++){
            System.out.println(message.getMessageToAction(i));
            if(i==0){
                message.showActionsNamesInMenu();
            }
            parameters[i] = console.next();
        }
    }

    public void run() {
        setParameters();
        getParameters();
        doAction = new DefineAction();
        doAction.doAction();
    }

    public MenuValuesGetter getParameters(){
        return parameterGetter = new MenuValuesGetter(parameters);
    }
}
