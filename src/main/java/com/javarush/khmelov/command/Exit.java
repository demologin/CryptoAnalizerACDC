package com.javarush.khmelov.command;

import com.javarush.khmelov.constant.Const;
import com.javarush.khmelov.entity.Result;
import com.javarush.khmelov.entity.ResultCode;

public class Exit extends AbstractAction {

    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Const.APPLICATION_CLOSED);
    }
}
