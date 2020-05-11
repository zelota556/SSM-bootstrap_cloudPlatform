package com.zelot.dao;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zelot.ModelDo.Device;

import java.io.IOException;
import java.sql.Date;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class DevDaoTest {

    @Autowired
    private DeviceDao deviceDao;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void insertSelectiveTest1(){
        Date buy_date = java.sql.Date.valueOf("2019-04-8");
        Date warranty_date = java.sql.Date.valueOf("2021-04-8");
        deviceDao.insertSelective(new Device(null,"NB_115423","NoteBook",buy_date,warranty_date
                ,false,null,null,null));
    }

    @Test
    public void insertSelectiveTest2(){
        Date buy_date = java.sql.Date.valueOf("2020-04-8");
        Date warranty_date = java.sql.Date.valueOf("2023-04-8");
        Device device=new Device();
        device.setDevNo("p_2223365");
        device.setDevName("Phone");
        device.setDevStatus(true);
        device.setDevBuydate(buy_date);
        device.setDevWarrantydate(warranty_date);
        deviceDao.insertSelective(device);
    }
    @Test
    public void updateTest2(){
        Device device=new Device();
        device.setId(4);
        device.setDevNo("P_2223365");
        deviceDao.updateByPrimaryKeySelective(device);
    }

    @Test
    public void selectTest(){
        try {
            System.out.println(mapper.writeValueAsString(deviceDao.selectByPrimaryKey(5)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAllTest() throws IOException {
        //list转json
        List<Device> list = deviceDao.selectAll();
        for (Device device : list) {
            String str = mapper.writeValueAsString(device);
            System.out.println(str);
        }
    }

    @Test
    public void selectByLimitTest(){
        try {
            System.out.println(mapper.writeValueAsString(deviceDao.selectByLimit(0,3)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTest(){
        deviceDao.deleteByPrimaryKey(null);
    }

    @Test
    public void updateTest(){
        Date buy_date = java.sql.Date.valueOf("2019-03-11");
        Date warranty_date = java.sql.Date.valueOf("2023-03-11");
        deviceDao.updateByPrimaryKeySelective(new Device(2,"EB_66512","ElectricBook",buy_date,warranty_date
                ,false,null,null,null));
    }

}
