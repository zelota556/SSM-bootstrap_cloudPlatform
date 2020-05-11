package com.zelot.controller;

import com.zelot.ModelDo.Contants;
import com.zelot.ModelDo.User;
import com.zelot.Result.Result;
import com.zelot.Result.ResultSupport;
import com.zelot.service.DevService;
import com.zelot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class MainController {
    //2个主页面

    @Autowired
    UserService userService;
    DevService devService;

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @RequestMapping("/login")
    public String login(){return "login";}


    @RequestMapping("/user/login")
    @ResponseBody
    //使用服务器session和cookie机制验证用户是否登录
    public Result<Void> login(@RequestParam(value = "userName",required = true)String userName,
                              @RequestParam(value = "password",required = true)String password,
                              HttpServletRequest request){
        User user = userService.userLogin(userName,password);
        System.out.println(userName+"  Login!");
        Result<Void> result= new ResultSupport<Void>(true);
        if(user == null){
            result.setSuccess(false);
            result.setMessage("用户名或密码有误");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute(Contants.USER_SESSION,user);
        }
        return  result;
    }

    @RequestMapping("/user/logout")
    public  String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //清除session
        request.getSession().removeAttribute(Contants.USER_SESSION);
        return "redirect:login";
    }

}
