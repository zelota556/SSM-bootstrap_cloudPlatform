package com.zelot.service;


import com.zelot.ModelDo.User;
import com.zelot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        if(userDao.deleteByPrimaryKey(id))
            return true;
        return false;
    }

    @Override
    public boolean insertSelective(User record) {
        if (userDao.insertSelective(record))
            return true;
        return false;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User userLogin(String userName, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        return userDao.selectByNameAndPassword(map);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public List<User> selectByLimit(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        return userDao.selectByLimit(offset, limit);
    }

    @Override
    public boolean updateByPrimaryKeySelective(User record) {
        if(userDao.updateByPrimaryKeySelective(record))
            return true;
        return false;
    }
}
