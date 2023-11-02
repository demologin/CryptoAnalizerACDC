package com.javarush.boyarinov.view;

public class Options {

    private String sourceTxt;
    private String targetTxt;
    private int key;

    public String getSourceTxt() {
        return sourceTxt;
    }

    public void setSourceTxt(String sourceTxt) {
        if (sourceTxt.isEmpty()) {
            this.sourceTxt = "text.txt";
        }
        this.sourceTxt = sourceTxt;
    }

    public String getTargetTxt() {
        return targetTxt;
    }

    public void setEncryptTxt(String targetTxt) {
        if (targetTxt.isEmpty()) {
            this.targetTxt = "encrypt.txt";
        }
        this.targetTxt = targetTxt;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
