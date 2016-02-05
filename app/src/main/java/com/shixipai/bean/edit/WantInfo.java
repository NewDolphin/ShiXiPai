package com.shixipai.bean.edit;

/**
 * Created by xiepeng on 16/2/5.
 */
public class WantInfo {
    private String scope;
    private String job;
    private String city;
    private String money;
    private String content;

    public WantInfo() {
    }

    public WantInfo(String scope, String job, String city, String money, String content) {
        this.scope = scope;
        this.job = job;
        this.city = city;
        this.money = money;
        this.content = content;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
