package Test.menu;

import Test.commands.DefineAction;
import Test.commands.FileActionEnum;
import Test.messages.Message;

import java.util.Scanner;

public class Menu {

    private Scanner console;
    private DefineAction doAction;

    public Menu(Scanner console){
        this.console = console;
    }

    public void run() {
        Message message = new Message();
        MenuCommands menuCommands = new MenuCommands(console, message); ///Вызываем меню выбора команд
        menuCommands.setParametersForMenu(); ///Записываем команды в массив параметров
        MenuValues menuValues = new MenuValues(menuCommands.getParameters()); ///Передаем массив строк в Меню_Значения
        ///Создаем новый объект DefineAction, который собирает значения введенных параметров
        // с необходимым enum (Encrypt or Decrypt)
        doAction = new DefineAction();
        doAction.doAction(menuValues); ///Запускаем действия с учетом выбранного enum
    }


}
