package com.zelot.service;


import com.zelot.ModelDo.Device;

import java.util.List;

public interface DevService {

    boolean deleteByPrimaryKey(Integer id);

    boolean insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    List<Device> selectAll();

    List<Device> selectByLimit(Integer page, Integer limit);

    boolean updateByPrimaryKeySelective(Device record);

}
