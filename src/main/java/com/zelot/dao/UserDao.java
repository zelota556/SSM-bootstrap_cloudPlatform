package com.zelot.dao;

import com.zelot.ModelDo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserDao {

    boolean deleteByPrimaryKey(Integer id);

    boolean insert(User record);

    boolean insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    User selectByNameAndPassword(Map<String, Object> map);

    //分页查询
    List<User> selectByLimit(@Param("offset")Integer offset, @Param("limit")Integer limit);

    boolean updateByPrimaryKeySelective(User record);

    boolean updateByPrimaryKey(User record);

}