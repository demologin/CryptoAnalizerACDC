package com.javarush.khmelov.entity;

public class Result {
    public final ResultCode resultCode;
    public final String message;

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", resultFile='" + message + '\'' +
                '}';
    }
}
