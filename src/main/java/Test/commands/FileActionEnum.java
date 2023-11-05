package Test.commands;

import Test.exceptions.ConsoleException;
import Test.menu.Menu;
import Test.messages.Message;

public enum FileActionEnum {
    ENCRYPTED(new Encrypt()),
    DECRYPTED(new Decrypt());

    private final FileAction fileAction;
    private static int actionIndex;
    private static String actionName;
    private static FileActionEnum[] enums = FileActionEnum.values();

    FileActionEnum(FileAction fileAction) {
        this.fileAction = fileAction;
    }

    public static FileAction get() {
        actionName = Menu.parameterGetter.getFileAction();
        actionIndex = Integer.parseInt(actionName);
        try {
            FileActionEnum value = enums[actionIndex];
            return value.fileAction;
        } catch (IllegalArgumentException e) {
            throw new ConsoleException(Message.INCORRECT_ACTION);
        }
    }

    public static int getActionsArrayLength(){
        return enums.length;
    }

    public static int getActionIndex(){
        return actionIndex;
    }
}
