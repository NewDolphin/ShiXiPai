package com.shixipai.bean.jobfeedback;

import java.io.Serializable;

/**
 * Created by xiepeng on 16/2/24.
 */
public class JobFeedBack implements Serializable{
    private int iid;
    private String state1_keyword;
    private String state1_title;
    private String state1_info;
    private String state2_keyword;
    private String state2_title;
    private String state2_info;
    private String state3_keyword;
    private String state3_title;
    private String state3_info;
    private String state1_time;
    private String state2_time;
    private String state3_time;
    private String start_time;
    private String intern_title;
    private String salary;
    private String area;
    private String company;
    private String company_image;

    public JobFeedBack() {
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getState1_keyword() {
        return state1_keyword;
    }

    public void setState1_keyword(String state1_keyword) {
        this.state1_keyword = state1_keyword;
    }

    public String getState1_title() {
        return state1_title;
    }

    public void setState1_title(String state1_title) {
        this.state1_title = state1_title;
    }

    public String getState1_info() {
        return state1_info;
    }

    public void setState1_info(String state1_info) {
        this.state1_info = state1_info;
    }

    public String getState2_keyword() {
        return state2_keyword;
    }

    public void setState2_keyword(String state2_keyword) {
        this.state2_keyword = state2_keyword;
    }

    public String getState2_title() {
        return state2_title;
    }

    public void setState2_title(String state2_title) {
        this.state2_title = state2_title;
    }

    public String getState2_info() {
        return state2_info;
    }

    public void setState2_info(String state2_info) {
        this.state2_info = state2_info;
    }

    public String getState3_keyword() {
        return state3_keyword;
    }

    public void setState3_keyword(String state3_keyword) {
        this.state3_keyword = state3_keyword;
    }

    public String getState3_title() {
        return state3_title;
    }

    public void setState3_title(String state3_title) {
        this.state3_title = state3_title;
    }

    public String getState3_info() {
        return state3_info;
    }

    public void setState3_info(String state3_info) {
        this.state3_info = state3_info;
    }

    public String getState1_time() {
        return state1_time;
    }

    public void setState1_time(String state1_time) {
        this.state1_time = state1_time;
    }

    public String getState2_time() {
        return state2_time;
    }

    public void setState2_time(String state2_time) {
        this.state2_time = state2_time;
    }

    public String getState3_time() {
        return state3_time;
    }

    public void setState3_time(String state3_time) {
        this.state3_time = state3_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getIntern_title() {
        return intern_title;
    }

    public void setIntern_title(String intern_title) {
        this.intern_title = intern_title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_image() {
        return company_image;
    }

    public void setCompany_image(String company_image) {
        this.company_image = company_image;
    }
}
