package com.javarush.cryptoAnalizer.menu;

public class MenuValues {

    private final String fileAction;
    private final String sourceFile;
    private final String destFile;
    private final String key;


    public MenuValues(String[] parameters) {
        fileAction = parameters[0];
        sourceFile = parameters[1];
        destFile = parameters[2];
        key = parameters[3];
    }
    public MenuValues getParameters(){
        return this;
    }


    public String getFileAction() {return fileAction;}
    public String getSourceFile() {return sourceFile;}
    public String getDestFile() {return destFile;}
    public String getKey(){return key;}

    @Override
    public String toString() {
        return "MenuValuesGetter{" +
                "fileAction='" + fileAction + '\'' +
                ", sourceFile='" + sourceFile + '\'' +
                ", destFile='" + destFile + '\'' +
                ", key=" + key +
                '}';
    }
}
