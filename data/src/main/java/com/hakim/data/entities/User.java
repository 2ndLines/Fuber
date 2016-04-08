package com.hakim.data.entities;

import android.os.Parcelable;

import com.avos.avoscloud.AVUser;

/**
 * Author : Shi Haijun <br/>
 * Email : haijun@okline.cn<br/>
 * Date : 2016/4/8 21:21<br/>
 * Desc :
 */
public class User extends AVUser{
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 头像url
     */
    private String avatar;
    /**
     * 姓
     */
    private String firstName;
    /**
     * 名
     */
    private String lastName;

    public User() {
        super();
    }

    public String getPhone() {
        return getString("phone");
    }

    public String getAvatar() {
        return getString("avatar");
    }

    public String getFirstName() {
        return getString("firstName");
    }

    public String getLastName() {
        return getString("lastName");
    }

    public void setPhone(String phone) {
        this.put("phone", phone);
    }

    public void setAvatar(String avatar) {
        put("avatar",avatar);
    }

    public void setFirstName(String firstName) {
        put("firstname",firstName);
    }

    public void setLastName(String lastName) {
        put("lastname",lastName);
    }

    public static final Parcelable.Creator CREATOR = AVObjectCreator.instance;
}
