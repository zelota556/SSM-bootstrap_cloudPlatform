package com.zelot.controller;

import com.zelot.ModelDo.Device;
import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zelot.service.DevService;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Date;
import java.util.List;

@Controller
public class DevController {

    @Autowired
    private DevService devService;
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/device")
    public String GetDeviceList(String id,Model model){
        List<Device> devices = devService.selectAll();
        model.addAttribute("devlist",devices);
        System.out.println("get device list");
        return "device";
    }

    @RequestMapping("/device/add")
    public String insert(@Param("devNo") String devNo, @Param("devName")String devName,
                         @Param("devBuydate") Date devBuydate, @Param("devWarrantydate") Date devWarrantydate,
                         @Param("devStatus") boolean devStatus)
    {
        Device device=new Device();
        device.setDevNo(devNo);
        device.setDevName(devName);
        device.setDevBuydate(devBuydate);
        device.setDevWarrantydate(devWarrantydate);
        device.setDevStatus(devStatus);
        if(devService.insertSelective(device))
            System.out.println("add device id:"+device.getId());
        return "device";
    }


    @RequestMapping("/device/update")
    public String devUpdate(@Param("id") Integer id, @Param("devNo") String devNo, @Param("devName")String devName,
                            @Param("devStatus") boolean devStatus, @Param("devRepairdate") Date devRepairdate)
    {
        Device device = new Device();
        device.setId(id);
        device.setDevNo(devNo);
        device.setDevName(devName);
        device.setDevStatus(devStatus);
        device.setDevRepairdate(devRepairdate);
        devService.updateByPrimaryKeySelective(device);
        System.out.println("update device id:"+id);
        return "device";
    }

    @RequestMapping("/device/delete")
    public String devDelete(Integer id){
        Integer dev_id = new Integer(id);
        devService.deleteByPrimaryKey(dev_id);
        System.out.println("delete device id:"+dev_id);
        return "device";
    }

    @RequestMapping("/device/edit")
    @ResponseBody
    public Device edit(Integer id){
        System.out.println("get device id:"+id);
        return devService.selectByPrimaryKey(id);
    }
}
