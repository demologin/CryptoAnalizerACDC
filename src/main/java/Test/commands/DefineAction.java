package Test.commands;

public class DefineAction {
    FileAction fileAction;

    public void doAction(){
        fileAction = FileActionEnum.get();
        fileAction.runFile();
    }

}
