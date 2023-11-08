package com.javarush.miroshnyk.resorses;

public enum Operation {
    READ,
    ENCRYPT,
    DECRYPT,
    EXIT;

    public static void getAllowableOperation(Integer i){
        try{
            switch (i){
                case 1:
                    ReadCommand.execute();
                    break;
                case 2:
                    EncryptCommand.execute();
                    break;
                case 3:
                    DecryptCommand.execute();
                    break;
                case 4:
                    ExitCommand.execute();
                    break;
                default:
                    ConsoleHelper.print("Please, choose number of one of menu items");
            }
        }catch (IllegalArgumentException e){
            ConsoleHelper.print("Please, choose number of one of menu items");
        }

    }
}
