package com.zelot.ModelDo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;



/**
 * dev_manager
 * @author 
 */

//对象序列化接口
public class Device implements Serializable{
    private Integer id;

    /**
     * 设备号
     */
    private String devNo;

    /**
     * 设备名
     */
    private String devName;

    /**
     * 设备买入时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date devBuydate;

    /**
     * 设备保修日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date devWarrantydate;

    /**
     * 设备状态 0代表离线 1代表在线
     */
    private Boolean devStatus;

    /**
     * 设备信息创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Timestamp dateCreate;

    /**
     * 设备近次维护时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date devRepairdate;

    /**
     * 设备信息近次更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Timestamp dateUpdate;

    private static final long serialVersionUID = 1L;


    public Device(Integer id, String dev_no, String dev_name , Date buy_date,
                  Date warranty_date, boolean status, Timestamp create_date, Date repair_date, Timestamp update_date){
        this.id =id;
        this.dateCreate=create_date;
        this.dateUpdate=update_date;
        this.devBuydate=buy_date;
        this.devName=dev_name;
        this.devNo=dev_no;
        this.devRepairdate=repair_date;
        this.devStatus=status;
        this.devWarrantydate=warranty_date;
    }

    public Device() {}

    //getter
    public Integer getId() {
        return id;
    }
    public String getDevNo() {
        return devNo;
    }
    public String getDevName() {
        return devName;
    }
    public Date getDevBuydate() {
        return devBuydate;
    }
    public Date getDevWarrantydate() {
        return devWarrantydate;
    }
    public Boolean getDevStatus() {
        return devStatus;
    }
    public Timestamp getDateCreate() {
        return dateCreate;
    }
    public Date getDevRepairdate() {
        return devRepairdate;
    }
    public Timestamp getDateUpdate() {
        return dateUpdate;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    //setter
    public void setId(Integer id) {
        this.id = id;
    }
    public void setDevNo(String devNo) {
        this.devNo = devNo;
    }
    public void setDevName(String devName) {
        this.devName = devName;
    }
    public void setDevBuydate(Date devBuydate) {
        this.devBuydate = devBuydate;
    }
    public void setDevWarrantydate(Date devWarrantydate) {
        this.devWarrantydate = devWarrantydate;
    }
    public void setDevStatus(Boolean devStatus) {
        this.devStatus = devStatus;
    }
    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }
    public void setDevRepairdate(Date devRepairdate) {
        this.devRepairdate = devRepairdate;
    }
    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

}