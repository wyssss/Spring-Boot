package com.example.demo.system.controller;

import com.example.demo.constants.BaseEnums;
import com.example.demo.constants.Constants;
import com.example.demo.base.BaseController;
import com.example.demo.base.BaseEnum;
import com.example.demo.base.Result;
import com.example.demo.system.dto.User;
import com.example.demo.util.Dates;
import com.example.demo.util.Results;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 *
 * @author bojiangzhou 2017-12-31
 * @version 1.0
 */
@RequestMapping("/sys/user")
@RestController
public class UserController extends BaseController {

    private static List<User> userList = new ArrayList<>();

    // 先静态模拟数据
    static {
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUsername("lufei");
        user1.setNickname("蒙奇D路飞");
        user1.setBirthday(Dates.parseDate("2000-05-05"));
        user1.setSex(Constants.Sex.MALE);
        user1.setEnabled(Constants.Flag.YES);
        userList.add(user1);

        User user2 = new User();
        user2.setUserId(2L);
        user2.setUsername("nami");
        user2.setNickname("娜美");
        user2.setBirthday(Dates.parseDate("2000/7/3"));
        user2.setSex(Constants.Sex.FEMALE);
        user2.setEnabled(Constants.Flag.YES);
        userList.add(user2);
    }

    @RequestMapping("/queryAll")
    public Result queryAll() {
        return Results.successWithData(userList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @RequestMapping("/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId) {
        User user = null;
        for (User u : userList) {
            if (u.getUserId().longValue() == userId) {
                user = u;
            }
        }
        return Results.successWithData(user);
    }
}