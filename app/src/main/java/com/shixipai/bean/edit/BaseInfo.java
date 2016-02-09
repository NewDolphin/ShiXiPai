package com.shixipai.bean.edit;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by xiepeng on 16/2/5.
 */
public class BaseInfo implements Serializable {
    private String name;
    private String birthday;
    private String telephone;
    private String email;
    private String sex;

    public BaseInfo() {
    }

    public BaseInfo(String name, String birthday, String telephone, String email, String sex) {
        this.name = name;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
