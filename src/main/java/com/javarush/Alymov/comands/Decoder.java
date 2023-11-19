package com.javarush.Alymov.comands;

import com.javarush.Alymov.entity.Result;
import com.javarush.Alymov.entity.ResultCode;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parametrs) {
        return new Result("decode all right", ResultCode.OK);
    }
}
