package com.shixipai.bean.edit;

/**
 * Created by xiepeng on 16/2/5.
 */
public class BaseInfo {
    private String name;
    private String birthday;
    private String telephone;
    private String email;

    public BaseInfo(String name, String school, String birthday, String telephone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
    }

    public BaseInfo() {
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
}
