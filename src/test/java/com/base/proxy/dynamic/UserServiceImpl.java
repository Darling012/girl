package com.base.proxy.dynamic;

/**
 * 目标对象
 * @author zyb
 * @since 2012-8-9
 *
 */
public class UserServiceImpl implements UserService {

    /* (non-Javadoc)
     * @see com.darling.proxy.dynamic.UserService#add()
     */
    @Override
    public void add() {
        System.out.println("--------------------add---------------");
    }
}
