package com.mvc.service;

import com.mvc.domain.UserInfo;

public interface UserInfoService {

    /**
     * 增加用户信息
     *
     * @param userInfo 用户信息
     * @return
     */
    UserInfo addUserInfo(UserInfo userInfo);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserInfo getById(Integer id);

    /**
     * 修改用户信息
     *
     * @param userInfo 用户信息
     * @return 用户信息
     */
    UserInfo updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     */
    void deleteById(Integer id);

}
