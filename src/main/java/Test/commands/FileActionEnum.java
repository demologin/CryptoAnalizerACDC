package Test.commands;

import Test.exceptions.TextException;
import Test.menu.Menu;
import Test.menu.MenuValuesGetter;
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
        actionIndex = Integer.parseInt(Menu.parameterGetter.getFileAction());
        try {
            FileActionEnum value = enums[actionIndex];
            return value.fileAction;
        } catch (IllegalArgumentException e) {
            throw new TextException(Message.INCORRECT_ACTION);
        }
    }

}
