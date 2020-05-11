package com.zelot.service;

import com.zelot.ModelDo.Device;
import com.zelot.dao.DeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevServiceImp implements DevService{

    @Autowired
    DeviceDao deviceDao;

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        if(deviceDao.deleteByPrimaryKey(id))
            return true;
        return false;
    }

    @Override
    public boolean insertSelective(Device record) {
        if(deviceDao.insertSelective(record))
            return true;
        return false;
    }

    @Override
    public Device selectByPrimaryKey(Integer id) {
        return deviceDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Device> selectAll() {
        return deviceDao.selectAll();
    }

    @Override
    public List<Device> selectByLimit(Integer page, Integer limit) {
        int offset=(page-1)*limit;
        return deviceDao.selectByLimit(offset,limit);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Device record) {
        if(deviceDao.updateByPrimaryKeySelective(record))
            return true;
        return false;
    }
}
