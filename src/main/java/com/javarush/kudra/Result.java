package com.javarush.kudra;

public class Result {
    String message;
    public Result() {
    }
    public Result(String message){
        this.message = message;
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                '}';
    }
}
