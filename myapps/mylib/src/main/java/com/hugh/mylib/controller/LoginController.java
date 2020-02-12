package com.hugh.mylib.controller;

import com.hugh.mylib.pojo.Result;
import com.hugh.mylib.pojo.User;
import com.hugh.mylib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        //对html标签进行转义，防止XSS攻击
        String username=requestUser.getUsername();
        username= HtmlUtils.htmlEscape(username);

        User user=userService.get(username,requestUser.getPassword());
        if (user==null){
            return new Result(400);
        }else {
            return new Result(200);
        }
    }
}
