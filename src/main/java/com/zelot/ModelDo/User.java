package com.zelot.ModelDo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;


/**
 * user_manager
 * @author 
 */

public class User implements Serializable {
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户性别 0表示女 1表示男
     */
    private Boolean userGender;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date userBirthday;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户电话号码
     */
    private String userPhone;

    private static final long serialVersionUID = 1L;


    User(int id, String name, String pwd , boolean gender, int age, Date birthday,String email, String phone){
        this.id =id;
        this.userName =name;
        this.userPassword =pwd;
        this.userGender = gender;
        this.userAge=age;
        this.userEmail=email;
        this.userPhone=phone;
        this.userBirthday=birthday;
    }

    public User() {}

    //getter
    public Integer getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public Boolean getUserGender() {
        return userGender;
    }
    public Integer getUserAge() {
        return userAge;
    }
    public Date getUserBirthday() {
        return userBirthday;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    //setter
    public void setId(Integer id) {
        this.id = id;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

}