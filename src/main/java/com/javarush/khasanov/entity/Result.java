package com.javarush.khasanov.entity;

public class Result {
    private final ResultCode code;
    private final String description;

    public Result(ResultCode code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
