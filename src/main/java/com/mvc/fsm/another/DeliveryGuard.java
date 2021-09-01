package com.mvc.fsm.another;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;

/**
 * @program: girl
 * @version:
 * @author: ling
 * @createTime: 2021-09-01 09:14
 **/
public class DeliveryGuard implements Guard {
    @Override
    public boolean evaluate(StateContext stateContext) {
        return false;
    }
}
