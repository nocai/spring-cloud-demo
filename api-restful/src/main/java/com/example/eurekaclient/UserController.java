package com.example.eurekaclient;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liujun10
 * @date: 2018/6/27 15:39
 * @version: 1.0
 */
@RestController
public class UserController {
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping("/username")
    public String getUsername() {
        return "name";
    }

    @RequestMapping("/user")
    public User getUser() {
        User u = new User();
        u.setId(1);
        u.setUsername("name");
        u.setAge(1);
        return u;
    }
}

class User {
    private int id;
    private String username;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
