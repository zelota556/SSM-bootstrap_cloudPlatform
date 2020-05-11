package com.zelot.dao;

import com.zelot.ModelDo.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeviceDao {
    boolean deleteByPrimaryKey(Integer id);

    boolean insert(Device record);

    boolean insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    List<Device> selectAll();

    //分页查询
    List<Device> selectByLimit(@Param("offset")Integer offset,@Param("limit")Integer limit);

    boolean updateByPrimaryKeySelective(Device record);

    boolean updateByPrimaryKey(Device record);
}