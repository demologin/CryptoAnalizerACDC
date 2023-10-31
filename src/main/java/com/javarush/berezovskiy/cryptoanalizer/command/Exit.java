package com.javarush.berezovskiy.cryptoanalizer.command;

import com.javarush.berezovskiy.cryptoanalizer.constant.Const;
import com.javarush.berezovskiy.cryptoanalizer.entity.Result;
import com.javarush.berezovskiy.cryptoanalizer.entity.ResultCode;

public class Exit extends AbstractAction {

    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Const.APPLICATION_CLOSED);
    }
}
