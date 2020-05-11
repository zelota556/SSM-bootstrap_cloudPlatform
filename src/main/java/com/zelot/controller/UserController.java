package com.zelot.controller;

import com.zelot.ModelDo.User;
import com.zelot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/user")
    public String GetUserList(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("userList",users);
        System.out.println("get user list");
        return "user";
    }

    @RequestMapping("/user/add")
    public String insert(@Param("userName")String userName, @Param("userPassword")String userPassword,@Param("userGender")boolean userGender,
                         @Param("userAge")Integer userAge, @Param("userBirthday")Date userBirthday,
                         @Param("userEmail")String userEmail,@Param("userPhone")String userPhone)
    {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserGender(userGender);
        user.setUserAge(userAge);
        user.setUserBirthday(userBirthday);
        user.setUserEmail(userEmail);
        user.setUserPhone(userPhone);
        if(userService.insertSelective(user))
            System.out.println("add user id"+user.getId());
        return "user";
    }

    @RequestMapping("/user/update")
    public String userUpdate(@Param("id")Integer id, @Param("userPassword")String userPassword,
                             @Param("userEmail")String userEmail, @Param("userPhone")String userPhone)
    {
        User user= new User();
        user.setId(id);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        user.setUserPhone(userPhone);
        try {
            System.out.println(mapper.writeValueAsString(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(userService.updateByPrimaryKeySelective(user))
            System.out.println("update user id"+user.getId());
        return "user";
    }

    @RequestMapping("/user/delete")
    public String userDelete(Integer id){
        Integer dev_id = new Integer(id);
        userService.deleteByPrimaryKey(dev_id);
        System.out.println("delete user id:"+dev_id);
        return "user";
    }

    @RequestMapping("/user/edit")
    @ResponseBody
    public User edit(Integer id){
        System.out.println("get user id:"+id);
        return userService.selectByPrimaryKey(id);
    }
}
