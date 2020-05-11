package com.zelot.service;

import com.zelot.ModelDo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean deleteByPrimaryKey(Integer id);

    boolean insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User userLogin(String userName,String userPassword);

    List<User> selectAll();

    List<User> selectByLimit(Integer page,Integer limit);

    boolean updateByPrimaryKeySelective(User record);

}
