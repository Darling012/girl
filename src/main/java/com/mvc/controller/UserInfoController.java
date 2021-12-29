package com.mvc.controller;

import com.mvc.domain.UserInfo;
import com.mvc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class UserInfoController {

    @Autowired
    // @Qualifier("userInfoServiceByCaffeine")
    @Qualifier("userInfoServiceBySpring")
    private UserInfoService userInfoService;

    @GetMapping("/userInfo/{id}")
    public Object getUserInfo(@PathVariable Integer id) {
        UserInfo userInfo = userInfoService.getById(id);
        if (userInfo == null) {
            return "没有该用户";
        }
        return userInfo;
    }

    @PostMapping("/userInfo")
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.addUserInfo(userInfo);
        return userInfoService.getById(userInfo.getId());
    }

    @PutMapping("/userInfo")
    public Object updateUserInfo(@RequestBody UserInfo userInfo) {
        UserInfo newUserInfo = userInfoService.updateUserInfo(userInfo);
        if (newUserInfo == null) {
            return "不存在该用户";
        }
        return newUserInfo;
    }

    @DeleteMapping("/userInfo/{id}")
    public Object deleteUserInfo(@PathVariable Integer id) {
        userInfoService.deleteById(id);
        return "SUCCESS";
    }
}
