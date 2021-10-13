package com.mvc.fsm.another;

import com.google.common.util.concurrent.Monitor;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * @program: girl
 * @version:
 * @author: ling
 * @createTime: 2021-09-01 09:14
 **/
@Component
public class PayedGuard implements Guard {
    @Override
    public boolean evaluate(StateContext stateContext) {
        return false;
    }
}
